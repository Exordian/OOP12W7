
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	public static void main(String[] args) {
		Map grmap = new Map(50,50);
		Map smallmap = new Map(10,10);
		
		for(int i = 0; i <= 10; i++) {
			grmap.registerCar(new FastCar("Fast Car Random "+i, new StrategyRandom()));
			grmap.registerCar(new AgileCar("Agile Car Random "+i, new StrategyRandom()));
			
			grmap.registerCar(new FastCar("Fast Car Pattern "+i, new StrategyPattern()));
			grmap.registerCar(new AgileCar("Agile Car Pattern "+i, new StrategyPattern()));
			
			grmap.registerCar(new FastCar("Fast Car Right "+i, new StrategyRight()));
			grmap.registerCar(new AgileCar("Agile Car Right "+i, new StrategyRight()));
		}


		for(int i = 0; i < 3; i++) {
			smallmap.registerCar(new FastCar("Fast Car Random "+i, new StrategyRandom()));
			smallmap.registerCar(new AgileCar("Agile Car Random "+i, new StrategyRandom()));
			
			smallmap.registerCar(new FastCar("Fast Car Pattern "+i, new StrategyPattern()));
			smallmap.registerCar(new AgileCar("Agile Car Pattern "+i, new StrategyPattern()));
			
			smallmap.registerCar(new FastCar("Fast Car Right "+i, new StrategyRight()));
			smallmap.registerCar(new AgileCar("Agile Car Right "+i, new StrategyRight()));
		}
		
		
		// blocking
		grmap.startGame();
		smallmap.startGame();

		// Test Map Reuse
		for(int i = 0; i <= 10; i++) {
			grmap.registerCar(new FastCar("Fast Car Random "+i, new StrategyRandom()));
			grmap.registerCar(new AgileCar("Agile Car Random "+i, new StrategyRandom()));
			
			grmap.registerCar(new FastCar("Fast Car Pattern "+i, new StrategyPattern()));
			grmap.registerCar(new AgileCar("Agile Car Pattern "+i, new StrategyPattern()));
			
			grmap.registerCar(new FastCar("Fast Car Right "+i, new StrategyRight()));
			grmap.registerCar(new AgileCar("Agile Car Right "+i, new StrategyRight()));
		}
		
		grmap.startGame();



	}
}
