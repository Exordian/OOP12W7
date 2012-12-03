
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyRight implements Strategy {
	//always drive RIGHT => cycle
	
	@Override
	public Direction getNext() {
		return Direction.Right; // RIGHT RIGHT RIGHT...
	}
}
