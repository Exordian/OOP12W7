
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public abstract class Car extends Thread {
	private Integer score;
	private int speed; // sleep in ms
	protected Map m;
	private boolean gameStopped;
	private Orientation o;
	private Direction d;

	protected int x = 0;
	protected int y = 0;

	public Car(Map m, int speed) {
		this.m = m;
		gameStopped = false;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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
	
	public Direction getDirection() {
		synchronized(d) { return d; }
	}

	public Orientation getOrientation() {
		synchronized(o) { return o; }
	}

	public void changeOrientation() {
		synchronized(o) { 
			if (this.o == Orientation.NORTH) {
				this.o = Orientation.SOUTH;
			} else if (this.o == Orientation.SOUTH) {
				this.o = Orientation.NORTH;
			} else if (this.o == Orientation.WEST) {
				this.o = Orientation.EAST;
			} else if (this.o == Orientation.EAST) {
				this.o = Orientation.WEST;
			}
		}
	}

	protected abstract void drive();

	@Override
	public void run() {
		int round = 0;
		while(!gameStopped) {

			drive();

			if(score >= 10 || round >= 150)
				m.stopGame();

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			round++;
		}

	}
}
