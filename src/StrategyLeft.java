
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyLeft implements Strategy {
	//always drive LEFT => cycle
	
	@Override
	public Direction getNext() {
		return Direction.Left; //LEFT LEFT LEFT...
	}
}