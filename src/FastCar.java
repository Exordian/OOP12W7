
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class FastCar extends Car {
	/*
	 * from the 8 adjacent fields a fast car can drive to fields:
	 * 3 (same direction)
	 * 2 (change direction by 90 degrees to left) 
	 * 4 (change direction by 90 degrees to right)
	 * 
	 * 1,5, 6,7,8 NOT possible!
	 
	  	8 1 2
		7 > 3
		6 5 4
		
	 */

	public FastCar(String name, Strategy strategy) {
		//fast car quicklier than agile car --> fast car "sleeps" less than agile car
		// 60 Fields per Second
		super(name, 60, strategy);
	}

	protected void update(){
		switch (strategy.getNext()) {
		//turn Left to LeftForward and Right to RightForward
		//due to lack of ability of a fast car to drive to fields 1/5 while changing direction by 90 degrees to left/right(see above)
		case Right:
			setDirection(Direction.RightForward);
			break;
		case Left:
			setDirection(Direction.LeftForward);
			break;
		default:
			setDirection(strategy.getNext());	
		}
		//direction has been set
	}
}
