import java.util.ArrayList;


/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyPattern implements Strategy {

	private ArrayList<Direction> strategy;
	private int state;
	
	public StrategyPattern() {
		//specific pattern for car to move around on map 
		strategy = new ArrayList<Direction>();
		strategy.add(Direction.Left);
		strategy.add(Direction.Left);
		strategy.add(Direction.Right);
		strategy.add(Direction.Right);
		strategy.add(Direction.Left);
		strategy.add(Direction.Right);
		strategy.add(Direction.Right);
		state = 0;
	}
	
	@Override
	public Direction getNext() {
		state = (state + 1) % strategy.size(); //if end reached => start again at beginning of strategy-list
		return strategy.get(state);
		//returns next direction of strategy-list
	}
}