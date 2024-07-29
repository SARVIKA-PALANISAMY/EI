// Concrete Commands
public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}