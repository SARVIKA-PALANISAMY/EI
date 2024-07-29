import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer Interface
interface Observer {
    void update(String status);
}

// Observable (Subject) Class
class Machine {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}

// Concrete Observers
class PowerMonitor implements Observer {
    @Override
    public void update(String status) {
        System.out.println("PowerMonitor: Machine status updated to " + status);
    }
}

class TemperatureMonitor implements Observer {
    @Override
    public void update(String status) {
        System.out.println("TemperatureMonitor: Machine status updated to " + status);
    }
}

class OperationalMonitor implements Observer {
    @Override
    public void update(String status) {
        System.out.println("OperationalMonitor: Machine status updated to " + status);
    }
}

// Client
public class ObserverPatternTest {
    public static void main(String[] args) {
        Machine machine = new Machine();

        PowerMonitor powerMonitor = new PowerMonitor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
        OperationalMonitor operationalMonitor = new OperationalMonitor();

        machine.addObserver(powerMonitor);
        machine.addObserver(temperatureMonitor);
        machine.addObserver(operationalMonitor);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter new machine status (or type 'exit' to quit): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            machine.setStatus(input);
        }
        scanner.close();
    }
}
