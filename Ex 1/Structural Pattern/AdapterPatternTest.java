import java.util.Scanner;

// Existing Machine Interface
interface OldMachineInterface {
    void start();
    void stop();
    void runDiagnostics();
}

// New Machine Interface
interface NewMachineInterface {
    void powerOn();
    void powerOff();
    void performSelfCheck();
}

// Existing Machine
class OldMachine implements OldMachineInterface {
    @Override
    public void start() {
        System.out.println("Old Machine: Starting...");
    }

    @Override
    public void stop() {
        System.out.println("Old Machine: Stopping...");
    }

    @Override
    public void runDiagnostics() {
        System.out.println("Old Machine: Running diagnostics...");
    }
}

// Adapter Class
class MachineAdapter implements NewMachineInterface {
    private OldMachineInterface oldMachine;

    public MachineAdapter(OldMachineInterface oldMachine) {
        this.oldMachine = oldMachine;
    }

    @Override
    public void powerOn() {
        oldMachine.start();
    }

    @Override
    public void powerOff() {
        oldMachine.stop();
    }

    @Override
    public void performSelfCheck() {
        oldMachine.runDiagnostics();
    }
}

// Client
public class AdapterPatternTest {
    public static void main(String[] args) {
        OldMachine oldMachine = new OldMachine();
        NewMachineInterface adaptedMachine = new MachineAdapter(oldMachine);

        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Enter command (poweron, poweroff, selfcheck, exit): ");
            command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "poweron":
                    adaptedMachine.powerOn();
                    break;
                case "poweroff":
                    adaptedMachine.powerOff();
                    break;
                case "selfcheck":
                    adaptedMachine.performSelfCheck();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command. Please enter 'poweron', 'poweroff', 'selfcheck', or 'exit'.");
            }
        }
    }
}
