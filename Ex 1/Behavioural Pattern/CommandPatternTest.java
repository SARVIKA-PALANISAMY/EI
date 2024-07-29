import java.util.Scanner;

// Command Interface
interface Command {
    void execute();
}

// Receiver Class
class Machine {
    public void start() {
        System.out.println("Machine started.");
    }

    public void stop() {
        System.out.println("Machine stopped.");
    }

    public void performMaintenance() {
        System.out.println("Machine maintenance performed.");
    }
}

// Concrete Commands
class StartCommand implements Command {
    private Machine machine;

    public StartCommand(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.start();
    }
}

class StopCommand implements Command {
    private Machine machine;

    public StopCommand(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.stop();
    }
}

class MaintenanceCommand implements Command {
    private Machine machine;

    public MaintenanceCommand(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.performMaintenance();
    }
}

// Invoker Class
class MachineControl {
    private Command startCommand;
    private Command stopCommand;
    private Command maintenanceCommand;

    public MachineControl(Command start, Command stop, Command maintenance) {
        this.startCommand = start;
        this.stopCommand = stop;
        this.maintenanceCommand = maintenance;
    }

    public void startMachine() {
        startCommand.execute();
    }

    public void stopMachine() {
        stopCommand.execute();
    }

    public void performMaintenance() {
        maintenanceCommand.execute();
    }
}

// Client
public class CommandPatternTest {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Command start = new StartCommand(machine);
        Command stop = new StopCommand(machine);
        Command maintenance = new MaintenanceCommand(machine);

        MachineControl control = new MachineControl(start, stop, maintenance);

        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Enter command (start, stop, maintenance, exit): ");
            command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "start":
                    control.startMachine();
                    break;
                case "stop":
                    control.stopMachine();
                    break;
                case "maintenance":
                    control.performMaintenance();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command. Please enter 'start', 'stop', 'maintenance', or 'exit'.");
            }
        }
    }
}
