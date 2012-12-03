
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class AgileCar extends Car {

	public AgileCar(String name, Strategy strategy) {
		super(name, 50, strategy);
	}
	
	protected void update(){
		setDirection(strategy.getNext());
	}	
}
