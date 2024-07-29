import java.util.Scanner;

// Power Management Subsystem
class PowerManagement {
    public void powerOn() {
        System.out.println("Powering on the machine...");
    }

    public void powerOff() {
        System.out.println("Powering off the machine...");
    }
}

// Operational Control Subsystem
class OperationalControl {
    public void startOperation() {
        System.out.println("Starting machine operation...");
    }

    public void stopOperation() {
        System.out.println("Stopping machine operation...");
    }
}

// Safety Check Subsystem
class SafetyCheck {
    public void performSafetyCheck() {
        System.out.println("Performing safety checks...");
    }
}

// Maintenance Subsystem
class Maintenance {
    public void performMaintenance() {
        System.out.println("Performing maintenance tasks...");
    }
}

// Facade Class
class MachineControlFacade {
    private PowerManagement powerManagement;
    private OperationalControl operationalControl;
    private SafetyCheck safetyCheck;
    private Maintenance maintenance;

    public MachineControlFacade() {
        this.powerManagement = new PowerManagement();
        this.operationalControl = new OperationalControl();
        this.safetyCheck = new SafetyCheck();
        this.maintenance = new Maintenance();
    }

    public void startMachine() {
        powerManagement.powerOn();
        safetyCheck.performSafetyCheck();
        operationalControl.startOperation();
    }

    public void stopMachine() {
        operationalControl.stopOperation();
        powerManagement.powerOff();
    }

    public void performMaintenance() {
        stopMachine();
        maintenance.performMaintenance();
        startMachine();
    }
}

// Client
public class FacadePatternTest {
    public static void main(String[] args) {
        MachineControlFacade machineControl = new MachineControlFacade();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Start Machine");
            System.out.println("2. Stop Machine");
            System.out.println("3. Perform Maintenance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    machineControl.startMachine();
                    break;
                case "2":
                    machineControl.stopMachine();
                    break;
                case "3":
                    machineControl.performMaintenance();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
