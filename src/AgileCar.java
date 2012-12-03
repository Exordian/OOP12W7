
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class AgileCar extends Car {
	/*
	 * from the 8 adjacent fields an agile car can drive to fields:
	 * 3 (same direction)
	 * 1,2 (change direction by 90 degrees to left) 
	 * 5,4 (change direction by 90 degrees to right)
	 * 
	 * 6,7,8 NOT possible! (therefore no reversing allowed)
	 
	  	8 1 2
		7 > 3
		6 5 4
		
	 */
	
	public AgileCar(String name, Strategy strategy) {
		//agile car is slower than fast car => agile car "sleeps" longer than fast car
		// 45 Fields per Second
		super(name, 45, strategy);
	}
	
	protected void update(){
		setDirection(strategy.getNext());
		//direction has been set
	}	
}
