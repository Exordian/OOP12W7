
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	private static String log = "";
	
	public static void main(String[] args) {
		Map map = new Map(50,50);
		Strategy sp = new StrategyPattern(map);
		Strategy sr = new StrategyRandom(map);

		Car fc = new FastCar(map, "fastcar1", sp);
		Car ac = new AgileCar(map, "agilecar1", sr);

		map.registerCar(fc);
		map.registerCar(ac);

		System.out.println(log);
	}

	public static void addToLog(String s) {
		log += s + "\n";
	}
}
