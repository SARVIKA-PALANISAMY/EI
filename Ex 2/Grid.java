import java.util.HashSet;
import java.util.Set;

public class Grid {
    private int width;
    private int height;
    private Set<Position> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(Position position) {
        obstacles.add(position);
    }

    public boolean isObstacle(Position position) {
        return obstacles.contains(position);
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }
}
