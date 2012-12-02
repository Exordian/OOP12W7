import java.util.ArrayList;

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
	
	void stopGame() {
		synchronized (cars) {
			 for(Car c : cars)
				 c.stopGame();
		}
	}
	
	
}
