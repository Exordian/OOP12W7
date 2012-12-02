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
		map = new Field[h][w]; // 10 is the max number of cars on one field
		cars = new ArrayList<Car>();
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
	}
	
	Field[][] getMap() {
		return this.map;
	}

	void registerCar(Car c) {
		synchronized (cars) {
			cars.add(c);
		}
		Random randomGenerator = new Random();
		int y = randomGenerator.nextInt(this.h + 1);
		int x = randomGenerator.nextInt(this.w + 1);
		c.setX(x);
		c.setY(y);
		c.setOrientation(Orientation.values()[randomGenerator.nextInt(3)]);
		map[y][x].putCar(c);
	}
}
