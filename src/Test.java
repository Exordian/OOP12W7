
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	public static void main(String[] args) {
		Map map = new Map(50,50);
		
		Strategy sp = new StrategyPattern(map);
		Strategy sr = new StrategyRandom(map);
		
		Car fc = new FastCar(map, sp);
		Car ac = new AgileCar(map, sr);
		
		map.registerCar(fc);
		map.registerCar(ac);
	}
}
