import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Map {
	private Field[][] map;
	private int h, w;
	private ArrayList<Car> cars;
	private boolean gameInProgress;

	public Map (int h, int w) {
		this.h = h;
		this.w = w;
		gameInProgress = false;
		// INIT MAP
		map = new Field[h][w];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				map[i][j] = new Field();
		cars = new ArrayList<Car>();
	}

	public void stopGame() {
		if(!gameInProgress)
			return;

		synchronized (cars) {
			for(Thread t : cars) {
				t.interrupt();
			}
		}
	}
	
	public void startGame() {
		if(gameInProgress)
			return;
		gameInProgress = true;
		for(Thread t : cars) {
			t.start();
		}
		// BLOCKING
		for(Thread t : cars) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// game stopped
			}
		}
		// SAFE, all threads are gone now
		cars.clear(); // for map reuse
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				map[i][j] = new Field();
		gameInProgress = false;

	}
	
	public void moveCar(Car c, int formerY, int formerX, int yNow, int xNow) throws CarWantsToEscapeException {
		if(xNow <= 0 || xNow >= this.w || yNow >= this.h || yNow <= 0) {
			throw new CarWantsToEscapeException(c.getCarName() + " wants to escape the map!");
		}
		map[formerY][formerX].moveAway(c);
		map[yNow][xNow].putCar(c);
		c.setX(xNow);
		c.setY(yNow);
	}
	
	public void registerCar(Car c) {
		if(gameInProgress)
			return; // do not add cars to running games
		synchronized (cars) {
			cars.add(c);
		}
		Random randomGenerator = new Random();
		int y = randomGenerator.nextInt(this.h);
		int x = randomGenerator.nextInt(this.w);
		c.setX(x);
		c.setY(y);
		c.setOrientation(Orientation.values()[randomGenerator.nextInt(Orientation.values().length)]);
		c.attachMap(this);
		map[y][x].putCar(c);
	}
}
