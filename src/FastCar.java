
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class FastCar extends Car {

	public FastCar(String name, Strategy strategy) {
		super(name, 10, strategy);
	}

	protected void update(){
		switch (strategy.getNext()) {
		case Right:
			setDirection(Direction.RightForward);
			break;
		case Left:
			setDirection(Direction.LeftForward);
			break;
		default:
			setDirection(strategy.getNext());	
		}
	}
}
