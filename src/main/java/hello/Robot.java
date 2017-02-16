package hello;

public class Robot {
	private int x = 0;
	private int y = 0;
	private Orientation orientation = Orientation.N;

	public String move(String instructions) {
		String[] steps = instructions.split("");

		for (String step : steps) {
			switch (step) {
				case "M":
					this.goForward();
					break;
				case "L":
					this.turnLeft();
					break;
				case "R":
					this.turnRight();
					break;
				default:
					throw new IllegalArgumentException("Invalid instruction");
			}
		}

		return this.getPosition();
	}
	
	private void goForward() {
		switch (String.valueOf(this.orientation)) {
			case "N":
				if (!this.canMove(this.x, this.y + 1)) {
					throw new IllegalArgumentException("Invalid moviment");
				} 
				this.y += 1;
				break;
			case "W":
				if (this.canMove(this.x -1, this.y)) {
					throw new IllegalArgumentException("Invalid moviment");
				}
				this.x -= 1;
				break;
			case "S":
				if (!this.canMove(this.x, this.y - 1)) {
					throw new IllegalArgumentException("Invalid moviment");
				}
				this.y -= 1;
				break;
			case "E":
				if (!this.canMove(this.x + 1, this.y)) {
					throw new IllegalArgumentException("Invalid moviment");
				}
				this.x += 1;
				break;
			default:
				throw new IllegalArgumentException("Invalid orientation");
		}
	}

	private void turnLeft() {
		switch (this.orientation) {
			case N:
				this.orientation = Orientation.W;
				break;
			case W:
				this.orientation = Orientation.S;
				break;
			case S:
				this.orientation = Orientation.E;
				break;
			case E:
				this.orientation = Orientation.N;
				break;
			default:
				throw new IllegalArgumentException("Invalid orientation");
		}
	}

	private void turnRight() {
		switch (this.orientation) {
			case N:
				this.orientation = Orientation.E;
				break;
			case E:
				this.orientation = Orientation.S;
				break;
			case S:
				this.orientation = Orientation.W;
				break;
			case W:
				this.orientation = Orientation.N;
				break;
			default:
				throw new IllegalArgumentException("Invalid orientation");
		}
	}

	private String getPosition() {
		return String.format("(%1$d, %2$d, %3$s)", this.x, this.y, this.orientation); 
	}

	private boolean canMove(int nextX, int nextY) {
		return (this.canMoveX(nextX) && this.canMoveY(nextY));
	}

	private boolean canMoveX(int next) {
		return (next <= Map.maximumX && next >= Map.minimumX);
	}

	private boolean canMoveY(int next) {
		return (next <= Map.maximumY && next >= Map.minimumY);	
	}
}