import java.util.ArrayList;


public class Field {
	private ArrayList<Car> cars;
	
	public Field() {
		cars = new ArrayList<Car>();
	}
	
	public void putCar(Car c) {
		synchronized(cars) {
			for(Car lc : cars) {
				if(c.getOrientation() == Orientation.NORTH && lc.getOrientation() != Orientation.SOUTH) {
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.SOUTH && lc.getOrientation() != Orientation.NORTH) {
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.EAST && lc.getOrientation() != Orientation.WEST) {
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.WEST && lc.getOrientation() != Orientation.EAST) {
					lc.scoreDown();
					c.scoreUp();
				} else { // both nose => score both up
					lc.scoreUp();
					c.scoreUp();
				}
			}
			cars.add(c);
		}
	}
	
	public void moveAway(Car c) {
		synchronized(cars) {
			cars.remove(c);
		}
	}
}
