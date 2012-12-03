
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	public static void main(String[] args) {
		Map map = new Map(50,50);

		map.registerCar(new FastCar("FastCar1", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar1", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar2", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar2", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar3", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar3", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar4", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar4", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar5", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar5", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar6", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar6", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar7", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar7", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar8", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar8", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar9", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar9", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar10", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar10", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar11", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar11", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar12", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar12", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar13", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar13", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar14", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar14", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar15", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar15", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar16", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar16", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar17", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar17", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar18", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar18", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar19", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar19", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar20", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar20", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar21", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar21", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar22", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar22", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar23", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar23", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar24", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar24", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar25", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar25", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar26", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar26", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar27", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar27", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar28", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar28", new StrategyRight()));
		
		map.registerCar(new FastCar("FastCar29", new StrategyRandom()));
		map.registerCar(new AgileCar("AgileCar29", new StrategyRandom()));
		
		map.registerCar(new FastCar("FastCar30", new StrategyPattern()));
		map.registerCar(new AgileCar("AgileCar30", new StrategyPattern()));
		
		map.registerCar(new FastCar("FastCar31", new StrategyRight()));
		map.registerCar(new AgileCar("AgileCar31", new StrategyRight()));
		
		map.startGame();
	}
}
