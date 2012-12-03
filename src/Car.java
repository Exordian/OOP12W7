
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public abstract class Car extends Thread {
	private String name;
	private int speed; // sleep in ms
	private Integer score;
	private Map m;
	private boolean gameStopped;
	private Orientation o;
	private Direction d;
	
	protected Strategy strategy;
	protected int x = 0;
	protected int y = 0;

	public Car(String name, int speed, Strategy strategy) {
		this.strategy = strategy;
		this.speed = speed;
		this.name = name;
		gameStopped = false;
		score = 0;
	}

	public String getCarName() {
		return this.name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void attachMap(Map m) {
		this.m = m;
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
	
	public void setDirection(Direction dir) {
		this.d = dir;
	}

	public Direction getDirection() {
		return d;
	}

	public void setOrientation(Orientation o) {
		this.o = o;
	}

	public Orientation getOrientation() {
		synchronized(o) { return o; }
	}

	private void changeOrientation() {
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

	private void drive() {

		int tempX = this.x;
		int tempY = this.y;

		switch (this.getOrientation()) {
		case EAST:
			if (this.getDirection() == Direction.Forward) {
				tempX += 1;
			} else if (this.getDirection() == Direction.Left) {
				tempY -= 1;
			} else if (this.getDirection() == Direction.Right) {
				tempY += 1;
			} else if (this.getDirection() == Direction.LeftForward) {
				tempY -= 1;
				tempX += 1;
			} else if (this.getDirection() == Direction.RightForward) {
				tempY += 1;
				tempX += 1;
			}	
			break;
		case NORTH:
			if (this.getDirection() == Direction.Forward) {
				tempY -= 1;
			} else if (this.getDirection() == Direction.Left) {
				tempX -= 1;
			} else if (this.getDirection() == Direction.Right) {
				tempX += 1;
			} else if (this.getDirection() == Direction.LeftForward) {
				tempX -= 1;
				tempY += 1;
			} else if (this.getDirection() == Direction.RightForward) {
				tempX += 1;
				tempY += 1;
			}
			break;
		case WEST:
			if (this.getDirection() == Direction.Forward) {
				tempX -= 1;
			} else if (this.getDirection() == Direction.Left) {
				tempY += 1;
			} else if (this.getDirection() == Direction.Right) {
				tempY -= 1;
			} else if (this.getDirection() == Direction.LeftForward) {
				tempX -= 1;
				tempY += 1;
			} else if (this.getDirection() == Direction.RightForward) {
				tempX -= 1;
				tempY -= 1;
			}
			break;
		case SOUTH:
			if (this.getDirection() == Direction.Forward) {
				tempY += 1;
			} else if (this.getDirection() == Direction.Left) {
				tempX += 1;
			} else if (this.getDirection() == Direction.Right) {
				tempX -= 1;
			} else if (this.getDirection() == Direction.LeftForward) {
				tempX += 1;
				tempY += 1;
			} else if (this.getDirection() == Direction.RightForward) {
				tempX -= 1;
				tempY += 1;
			}
			break;
		default:
			//troll hard
		}
		
		try {
			m.moveCar(this, this.y, this.x, tempY, tempX);
		} catch (CarWantsToEscapeException c) {
			changeOrientation();
		}
	}

	protected abstract void update();

	@Override
	public void run() {
		int round = 0;
		while(!gameStopped) {
			update();
			drive();

			if(score >= 10 || round >= 150) {
				System.out.println("Game has ended!\n" + this.getCarName() + " has won!\n");
				m.stopGame();
			}

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				this.stopGame(); // or just break
			}
			round++;
		}
		System.out.println(this.getCarName() + "has scored " + score + " points with " + round + " rounds.");
	}
}
