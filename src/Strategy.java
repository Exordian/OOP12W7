
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public abstract class Strategy {
	protected Direction[] strategyList;
	protected int maxH = 0;
	protected int maxW = 0;
	
	public Strategy(Map m) {
		this.strategyList = makeStrategy();
		this.maxH = m.getH();
		this.maxW = m.getW();
	}
	
	protected abstract Direction[] makeStrategy();
	
	public Direction getDirectionFromStrategy(int round) {
		return this.strategyList[round % strategyList.length];
	}
}
