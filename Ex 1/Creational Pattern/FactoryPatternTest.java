import java.util.Scanner;

// Machine Interface
interface Machine {
    void performOperation();
}

// Concrete Machine Implementations
class LatheMachine implements Machine {
    @Override
    public void performOperation() {
        System.out.println("Lathe Machine is performing operation.");
    }
}

class MillingMachine implements Machine {
    @Override
    public void performOperation() {
        System.out.println("Milling Machine is performing operation.");
    }
}

class DrillingMachine implements Machine {
    @Override
    public void performOperation() {
        System.out.println("Drilling Machine is performing operation.");
    }
}

// Factory Class
class MachineFactory {
    public Machine createMachine(String type) {
        switch (type) {
            case "lathe":
                return new LatheMachine();
            case "milling":
                return new MillingMachine();
            case "drilling":
                return new DrillingMachine();
            default:
                throw new IllegalArgumentException("Unknown machine type: " + type);
        }
    }
}

// Client
public class FactoryPatternTest {
    public static void main(String[] args) {
        MachineFactory factory = new MachineFactory();
        Scanner scanner = new Scanner(System.in);
        String machineType;

        while (true) {
            System.out.println("Enter machine type (lathe, milling, drilling) or 'exit' to quit: ");
            machineType = scanner.nextLine();
            if (machineType.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                Machine machine = factory.createMachine(machineType);
                machine.performOperation();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Exiting...");
    }
}
