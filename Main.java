import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bus {
    private int busNumber;
    private int capacity;
    private List<String> passengers;

    public Bus(int busNumber, int capacity) {
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public int getBusNumber() {
        return busNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public boolean bookSeat(String passengerName) {
        if (passengers.size() < capacity) {
            passengers.add(passengerName);
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating buses
        Bus bus1 = new Bus(101, 50);
        Bus bus2 = new Bus(102, 40);

        System.out.println("Welcome to Bus Booking App!");

        while (true) {
            System.out.println("\nSelect a bus to book a seat (1 for Bus 101, 2 for Bus 102, 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Thank you for using Bus Booking App. Goodbye!");
                break;
            }

            Bus selectedBus = choice == 1 ? bus1 : bus2;

            System.out.println("Enter passenger name: ");
            String passengerName = scanner.nextLine();

            if (selectedBus.bookSeat(passengerName)) {
                System.out.println(passengerName + " booked a seat on Bus " + selectedBus.getBusNumber());
            } else {
                System.out.println("Sorry, no available seats on Bus " + selectedBus.getBusNumber());
            }
        }

        scanner.close();
    }
}
