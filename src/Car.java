
public abstract class Car extends Thread {
	private Integer score;
	private int speed; // sleep in ms
	private Map m;
	private boolean gameStopped;
	private Orientation o;
	
	public Car(Map m, int speed) {
		this.m = m;
		gameStopped = false;
	}
	
	// actually due to the state that the car can only be in one field and this list is syncronized, score shouldnt be a problem
	public void scoreUp() {
		synchronized(score) {score++;}
	}

	public void scoreDown() {
		synchronized(score) {score--;}
	}
	
	public void stopGame() {
		gameStopped = true;
	}
	
	public Orientation getOrientation() {
		synchronized(o) { return o; } // needed?
	}
	
	protected abstract void drive();
	
	@Override
	public void run() {
		while(!gameStopped) {
			
			drive();
			
			if(score >= 10) // bzw maxrunden
				m.stopGame();

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
