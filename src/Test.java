
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
		Strategy sp = new StrategyPattern();
		Strategy sr = new StrategyRandom();

		Car fastcar1 = new FastCar(map, "fastcar1", sp);
		Car agilecar1 = new AgileCar(map, "agilecar1", sr);

		map.registerCar(fastcar1);
		map.registerCar(agilecar1);
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		
		map.registerCar(new FastCar(map, "fastcar", new StrategyRandom()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRandom()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyPattern()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyPattern()));
		map.registerCar(new FastCar(map, "fastcar", new StrategyRight()));
		map.registerCar(new AgileCar(map, "fastcar2", new StrategyRight()));
		

		map.startGame();
		
		//map.stopGame();
		//System.out.println(log);
	}

	public static void addToLog(String s) {
		log += s + "\n";
	}
}
