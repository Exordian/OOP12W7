
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class FastCar extends Car {

	public FastCar(Map m) {
		super(m, 100);
	}

	@Override
	protected void drive() {
		Field[][] field = m.getMap();
		field[this.y][this.x].moveAway(this);
				
		if (this.getOrientation() == Orientation.EAST) {
			if (this.getDirection() == Direction.Forward) {
				this.x += 1;
			} else if (this.getDirection() == Direction.Left) {
				this.y -= 1;
			} else if (this.getDirection() == Direction.Right) {
				this.y += 1;
			}
		} else if (this.getOrientation() == Orientation.NORTH) {
			if (this.getDirection() == Direction.Forward) {
				this.y -= 1;
			} else if (this.getDirection() == Direction.Left) {
				this.x -= 1;
			} else if (this.getDirection() == Direction.Right) {
				this.x += 1;
			}
		} else if (this.getOrientation() == Orientation.WEST) {
			if (this.getDirection() == Direction.Forward) {
				this.x -= 1;
			} else if (this.getDirection() == Direction.Left) {
				this.y += 1;
			} else if (this.getDirection() == Direction.Right) {
				this.y -= 1;
			}
		} else if (this.getOrientation() == Orientation.SOUTH) {
			if (this.getDirection() == Direction.Forward) {
				this.y += 1;
			} else if (this.getDirection() == Direction.Left) {
				this.x += 1;
			} else if (this.getDirection() == Direction.Right) {
				this.x -= 1;
			}
		}

		if (this.x >= m.getW() || this.x <= 0 || this.y >= m.getH() || this.y <= 0) {
			this.changeOrientation();
		}		
		field[this.y][this.x].putCar(this);		
	}
}
