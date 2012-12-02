import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Map {
	Field[][] map;
	int h, w;
	ArrayList<Car> cars;

	public Map (int h, int w) {
		this.h = h;
		this.w = w;
		map = new Field[h][w];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				map[i][j] = new Field(); // 10 is the max number of cars on one field
		cars = new ArrayList<Car>();
		Test.addToLog("Map created(width: " + this.h + ", height: " + this.w + ")");
	}
	
	int getH() {
		return this.h;
	}
	
	int getW() {
		return this.w;
	}

	void stopGame() {
		synchronized (cars) {
			for(Car c : cars)
				c.stopGame();
		}
		Test.addToLog("Game stopped!");
	}
	
	Field[][] getMap() {
		return this.map;
	}

	void startGame() {
		for(Thread t : cars) {
			t.start();
		}
	}
	
	void registerCar(Car c) {
		synchronized (cars) {
			cars.add(c);
		}
		Random randomGenerator = new Random();
		int y = randomGenerator.nextInt(this.h);
		int x = randomGenerator.nextInt(this.w);
		c.setX(x);
		c.setY(y);
		c.setOrientation(Orientation.values()[randomGenerator.nextInt(Orientation.values().length)]);
		map[y][x].putCar(c);
		Test.addToLog("New Car: " + c.getCarName() + ", registered at x = " + x + ", y = " + y + "!");
	}
}
