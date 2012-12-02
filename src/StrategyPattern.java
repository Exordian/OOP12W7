
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class StrategyPattern extends Strategy {

	public StrategyPattern(Map m) {
		super(m);
	}

	protected Direction[] makeStrategy() {
		Direction[] list = new Direction[] {};
		int i = 0;
		while (i <= 44) {
			if (i == 22) {
				list[i] = Direction.Left;
				i++;
			} else {
				list[i] = Direction.Left;
				i++;
				list[i] = Direction.Left;
				i++;
				list[i] = Direction.Right;
				i++;
				list[i] = Direction.Right;
				i++;
				list[i] = Direction.Left;
				i++;
				list[i] = Direction.Right;
				i++;
				list[i] = Direction.Right;
				i++;
			}
		}
		return list;
	}	
}