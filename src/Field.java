import java.util.ArrayList;

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Field {
	private ArrayList<Car> cars; //stores cars which are currently at this field
	
	public Field() {
		cars = new ArrayList<Car>();
	}
	
	public void putCar(Car c) {
		synchronized(cars) {
			for(Car lc : cars) {
				if(c.getOrientation() == Orientation.NORTH && lc.getOrientation() != Orientation.SOUTH) {
					//c(direction NORTH) crashes lc on other than front side =>
					//bonus point for c
					//minus point for lc
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.SOUTH && lc.getOrientation() != Orientation.NORTH) {
					//c(direction SOUTH) crashes lc on other than front side =>
					//bonus point for c
					//minus point for lc
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.EAST && lc.getOrientation() != Orientation.WEST) {
					//c(direction EAST) crashes lc on other than front side =>
					//bonus point for c
					//minus point for lc
					lc.scoreDown();
					c.scoreUp();
				} else if(c.getOrientation() == Orientation.WEST && lc.getOrientation() != Orientation.EAST) {
					//c(direction WEST) crashes lc on other than front side =>
					//bonus point for c
					//minus point for lc
					lc.scoreDown();
					c.scoreUp();
				} else { 
					//both nose => score both up
					lc.scoreUp();
					c.scoreUp();
				}
			}
			cars.add(c); //add c to list of cars which are currently at this field
		}
	}
	
	public void moveAway(Car c) {
		synchronized(cars) {
			cars.remove(c); //car c no longer at this field
		}
	}
}
