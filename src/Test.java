
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

		Car fastcar1 = new FastCar(map, "fastcar1", sp);
		Car agilecar1 = new AgileCar(map, "agilecar1", sr);

		map.registerCar(fastcar1);
		map.registerCar(agilecar1);
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar2", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar3", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar4", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar5", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar6", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar7", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar8", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar9", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar10", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar11", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar12", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar13", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar8", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar9", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar10", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar11", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar12", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar13", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar8", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar9", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar10", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar11", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar12", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar13", new StrategyRandom(map)));		
		map.registerCar(new FastCar(map, "fastcar8", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar9", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar10", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar11", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar12", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar13", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar8", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar9", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar10", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar11", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar12", new StrategyRandom(map)));
		map.registerCar(new FastCar(map, "fastcar13", new StrategyRandom(map)));
		
		map.startGame();
		
		//map.stopGame();
		//System.out.println(log);
	}

	public static void addToLog(String s) {
		log += s + "\n";
	}
}
