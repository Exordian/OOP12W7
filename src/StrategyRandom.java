import java.util.Random;


/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyRandom implements Strategy {
	@Override
	public Direction getNext() {
		//generate random directions for car to move around
		return Direction.values()[new Random().nextInt(Direction.values().length)];
		//returns random direction
	}
}
