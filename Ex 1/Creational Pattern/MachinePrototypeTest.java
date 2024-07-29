import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Machine Interface
interface Machine extends Cloneable {
    Machine clone();
    void performOperation();
}

// Lathe Machine
class LatheMachine implements Machine {
    private String configuration;

    public LatheMachine(String configuration) {
        this.configuration = configuration;
    }

    @Override
    public Machine clone() {
        return new LatheMachine(this.configuration);
    }

    @Override
    public void performOperation() {
        System.out.println("Lathe Machine with configuration " + configuration + " is performing turning operation.");
    }
}

// Milling Machine
class MillingMachine implements Machine {
    private String configuration;

    public MillingMachine(String configuration) {
        this.configuration = configuration;
    }

    @Override
    public Machine clone() {
        return new MillingMachine(this.configuration);
    }

    @Override
    public void performOperation() {
        System.out.println("Milling Machine with configuration " + configuration + " is performing milling operation.");
    }
}

// Drilling Machine
class DrillingMachine implements Machine {
    private String configuration;

    public DrillingMachine(String configuration) {
        this.configuration = configuration;
    }

    @Override
    public Machine clone() {
        return new DrillingMachine(this.configuration);
    }

    @Override
    public void performOperation() {
        System.out.println("Drilling Machine with configuration " + configuration + " is performing drilling operation.");
    }
}

// MachineRegistry Class
class MachineRegistry {
    private Map<String, Machine> machineMap = new HashMap<>();

    public void addMachine(String type, Machine machine) {
        machineMap.put(type, machine);
    }

    public Machine getMachine(String type) {
        Machine prototype = machineMap.get(type);
        return prototype.clone();
    }
}

// MachinePrototypeTest Class
public class MachinePrototypeTest {
    public static void main(String[] args) {
        // Create prototypes
        LatheMachine lathePrototype = new LatheMachine("Config A");
        MillingMachine millingPrototype = new MillingMachine("Config B");
        DrillingMachine drillingPrototype = new DrillingMachine("Config C");

        // Register prototypes
        MachineRegistry registry = new MachineRegistry();
        registry.addMachine("lathe", lathePrototype);
        registry.addMachine("milling", millingPrototype);
        registry.addMachine("drilling", drillingPrototype);

        Scanner scanner = new Scanner(System.in);
        String machineType;

        while (true) {
            System.out.println("Enter machine type to clone (lathe, milling, drilling) or 'exit' to quit: ");
            machineType = scanner.nextLine();
            if (machineType.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                Machine machineClone = registry.getMachine(machineType);
                machineClone.performOperation();
            } catch (NullPointerException e) {
                System.out.println("Unknown machine type: " + machineType);
            }
        }

        scanner.close();
        System.out.println("Exiting...");
    }
}
