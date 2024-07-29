import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get grid size from the user
        System.out.println("Enter grid size (width height):");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        Grid grid = new Grid(width, height);

        // Get obstacle positions from the user
        System.out.println("Enter number of obstacles:");
        int obstacleCount = scanner.nextInt();
        for (int i = 0; i < obstacleCount; i++) {
            System.out.println("Enter obstacle " + (i + 1) + " position (x y):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            grid.addObstacle(new Position(x, y));
        }

        // Get initial position and direction of the rover
        System.out.println("Enter rover's initial position (x y):");
        int initialX = scanner.nextInt();
        int initialY = scanner.nextInt();
        System.out.println("Enter rover's initial direction (N, E, S, W):");
        String initialDirectionStr = scanner.next().toUpperCase();
        Direction initialDirection = Direction.valueOf(initialDirectionStr);

        Rover rover = new Rover(new Position(initialX, initialY), initialDirection, grid);

        // Continuously get commands from the user
        scanner.nextLine(); // Consume the remaining newline
        System.out.println("Enter commands (M for move, L for turn left, R for turn right) or type 'exit' to quit:");
        while (true) {
            String commandStr = scanner.nextLine().toUpperCase();
            if (commandStr.equals("EXIT")) {
                break;
            }

            List<Command> commands = new ArrayList<>();
            for (char commandChar : commandStr.toCharArray()) {
                switch (commandChar) {
                    case 'M':
                        commands.add(new MoveCommand());
                        break;
                    case 'L':
                        commands.add(new TurnLeftCommand());
                        break;
                    case 'R':
                        commands.add(new TurnRightCommand());
                        break;
                    default:
                        System.out.println("Invalid command: " + commandChar);
                }
            }

            // Execute commands and print the rover's status after each command
            for (Command command : commands) {
                command.execute(rover);
                System.out.println(rover.getStatus());
            }
        }

        scanner.close();
    }
}
