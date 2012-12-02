import java.util.Random;


/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyRandom extends Strategy {

	public StrategyRandom(Map m) {
		super(m);
	}

	protected Direction[] makeStrategy() {
		Direction[] list = new Direction[50];
		Random randomGenerator = new Random();
		int i = 0;
		while (i <= 50) {
			list[i] = Direction.values()[randomGenerator.nextInt(4)];
		}
		return list;
	}	
}
