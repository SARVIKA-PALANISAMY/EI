public class Rover {
    private Position position;
    private Direction direction;
    private Grid grid;
    private boolean encounteredObstacle;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.encounteredObstacle = false;
    }

    public void move() {
        Position newPosition = position.moveForward(direction);
        if (grid.isWithinBounds(newPosition) && !grid.isObstacle(newPosition)) {
            position = newPosition;
            encounteredObstacle = false;
        } else {
            encounteredObstacle = true;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
        encounteredObstacle = false; // Reset obstacle status when turning
    }

    public void turnRight() {
        direction = direction.turnRight();
        encounteredObstacle = false; // Reset obstacle status when turning
    }

    public String getStatus() {
        if (encounteredObstacle) {
            return "Rover is at " + position + " facing " + direction + ". Obstacle encountered, unable to move.";
        } else {
            return "Rover is at " + position + " facing " + direction + ".";
        }
    }
}
