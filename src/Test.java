
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	public static void main(String[] args) {
		Map smallMap = new Map(10,10);
		Map medMap = new Map(50,50);
		Map largeMap = new Map(150,150);
		
		for(int i = 0; i < 3; i++) {
			smallMap.registerCar(new FastCar("Fast Car Random " + i, new StrategyRandom()));
			smallMap.registerCar(new AgileCar("Agile Car Random " + i, new StrategyRandom()));
			
			smallMap.registerCar(new FastCar("Fast Car Pattern " + i, new StrategyPattern()));
			smallMap.registerCar(new AgileCar("Agile Car Pattern " + i, new StrategyPattern()));
			
			smallMap.registerCar(new FastCar("Fast Car Right " + i, new StrategyRight()));
			smallMap.registerCar(new AgileCar("Agile Car Left " + i, new StrategyLeft()));
		}
		for(int i = 3; i < 7; i++) {
			medMap.registerCar(new FastCar("Fast Car Random " + i, new StrategyRandom()));
			medMap.registerCar(new AgileCar("Agile Car Random " + i, new StrategyRandom()));
			
			medMap.registerCar(new FastCar("Fast Car Pattern " + i, new StrategyPattern()));
			medMap.registerCar(new AgileCar("Agile Car Pattern " + i, new StrategyPattern()));
			
			medMap.registerCar(new FastCar("Fast Car Right " + i, new StrategyRight()));
			medMap.registerCar(new AgileCar("Agile Car Left " + i, new StrategyLeft()));
		}
		for(int i = 7; i < 1000; i++) {
			largeMap.registerCar(new FastCar("Fast Car Random " + i, new StrategyRandom()));
			largeMap.registerCar(new AgileCar("Agile Car Random " + i, new StrategyRandom()));
			
			largeMap.registerCar(new FastCar("Fast Car Pattern " + i, new StrategyPattern()));
			largeMap.registerCar(new AgileCar("Agile Car Pattern " + i, new StrategyPattern()));
			
			largeMap.registerCar(new FastCar("Fast Car Right " + i, new StrategyRight()));
			largeMap.registerCar(new AgileCar("Agile Car Left " + i, new StrategyLeft()));
		}
		
		// blocking
		System.out.println("______________________________________________________________\nStarting Test with small Map 10x10:\n______________________________________________________________\n");
		System.out.println(String.format("%1$25s | %2$5s | %3$5s ", "Car Name", "Score", "Moves")); // Winner in Caps
		smallMap.startGame();
		System.out.println("Game Ended.\n\n______________________________________________________________\nStarting Test with medium Map 50x50:\n______________________________________________________________\n");
		System.out.println(String.format("%1$25s | %2$5s | %3$5s ", "Car Name", "Score", "Moves")); // Winner in Caps
		medMap.startGame();
		System.out.println("Game Ended.\n\n______________________________________________________________\nStarting Test with large Map 150x150:\n______________________________________________________________\n");
		System.out.println(String.format("%1$25s | %2$5s | %3$5s ", "Car Name", "Score", "Moves")); // Winner in Caps
		largeMap.startGame();

		// Test Map Reuse
		for(int i = 10; i <= 12; i++) {
			medMap.registerCar(new FastCar("Fast Car Random " + i, new StrategyRandom()));
			medMap.registerCar(new AgileCar("Agile Car Random " + i, new StrategyRandom()));
			
			medMap.registerCar(new FastCar("Fast Car Pattern " + i, new StrategyPattern()));
			medMap.registerCar(new AgileCar("Agile Car Pattern " + i, new StrategyPattern()));
			
			medMap.registerCar(new FastCar("Fast Car Right " + i, new StrategyRight()));
			medMap.registerCar(new AgileCar("Agile Car Left " + i, new StrategyLeft()));
		}
		System.out.println("Game Ended.\n\n______________________________________________________________\nStarting Test with reused medium Map 50x50:\n______________________________________________________________\n");
		System.out.println(String.format("%1$25s | %2$5s | %3$5s ", "Car Name", "Score", "Moves")); // Winner in Caps
		medMap.startGame();
		System.out.println("Game Ended.");
	}
}
