
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public abstract class Car extends Thread {
	private static final int maxScore = 10;  //maximum scores a car can have
	private static final int maxMoves = 150; //maximum moves a car can make

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
		//returns car name
	}

	public void setX(int x) {
		this.x = x;
		//x-coordinate of car location has been set
	}

	public void setY(int y) {
		this.y = y;
		//y-coordinate of car location has been set
	}

	public void attachMap(Map m) {
		this.m = m;
		//map has been attached
	}

	// actually due to the state that the car can only be in one field and this list is syncronized, score shouldnt be a problem
	public void scoreUp() {
		//car has hit or got hit by another car from front side
		//=> add score up by one point
		synchronized(score) {score++;}
	}

	public void scoreDown() {
		//car has been hit (NOT from front side!) 
		//=> subtract one point from score
		synchronized(score) {score--;}
	}

	public void stopGame() {
		gameStopped = true;
	}

	public void setDirection(Direction dir) {
		this.d = dir;
		//direction has been set
	}

	public Direction getDirection() {
		return d;
		//returns direction
	}

	public void setOrientation(Orientation o) {
		this.o = o;
		//orientation has been set
	}

	public Orientation getOrientation() {
		return o;
		//returns orientation
	}

	private void changeOrientation() {
		//border handling
		//=> reverse orientation
		if (this.o == Orientation.NORTH) {
			this.o = Orientation.SOUTH;
		} else if (this.o == Orientation.SOUTH) {
			this.o = Orientation.NORTH;
		} else if (this.o == Orientation.WEST) {
			this.o = Orientation.EAST;
		} else if (this.o == Orientation.EAST) {
			this.o = Orientation.WEST;
		}
		//orientation has been changed
	}

	private void drive() {

		int tempX = this.x;
		int tempY = this.y;

		switch (this.getOrientation()) {
		//set new x,y-coordinates depending on current orientation and desired direction
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
			throw new RuntimeException("missing direction ! should never happen");
		}

		try {
			m.moveCar(this, this.y, this.x, tempY, tempX); //move car to another field
		} catch (CarWantsToEscapeException c) { //out of border
			changeOrientation(); //reverse orientation
		}
		//car has been driven to another field
	}

	protected abstract void update();

	@Override
	public void run() {
		int moves = 0;
		while(!gameStopped) { // or isInterrupted()
			update(); //change direction
			drive();  //drive to changed direction

			if(score >= maxScore || moves >= maxMoves) {
				//System.out.println("Game has ended!\n" + this.getCarName() + " has won! <------\n");
				m.stopGame();
			}

			moves++;
			try {
				Thread.sleep(speed); //agile car slower than fast car
			} catch (InterruptedException e) {
				this.stopGame(); // or just break / Thread.exit()
			}
		}
		if (score >= maxScore) {
			System.out.println(String.format("%1$25s | %2$5d | %3$5d ", this.getCarName().toUpperCase(), score, moves)); // Winner in Caps
		} else {
			System.out.println(String.format("%1$25s | %2$5d | %3$5d ", this.getCarName(), score, moves));
		}
	}
}
