import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

class BusBookingApp extends JFrame {
    private JTextField passengerNameField;
    private JLabel statusLabel;

    private Bus bus1 = new Bus(101, 50);
    private Bus bus2 = new Bus(102, 40);

    public BusBookingApp() {
        setTitle("Bus Booking App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(30, 30, 120, 25);
        panel.add(nameLabel);

        passengerNameField = new JTextField();
        passengerNameField.setBounds(150, 30, 200, 25);
        panel.add(passengerNameField);

        JButton bookButton = new JButton("Book Seat");
        bookButton.setBounds(150, 70, 100, 25);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookSeat();
            }
        });
        panel.add(bookButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(30, 110, 320, 25);
        panel.add(statusLabel);

        add(panel);
    }

    private void bookSeat() {
        String passengerName = passengerNameField.getText();
        if (!passengerName.isEmpty()) {
            int choice = JOptionPane.showOptionDialog(null, "Select a bus to book a seat:",
                    "Bus Selection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Bus 101", "Bus 102"}, "Bus 101");

            Bus selectedBus = (choice == JOptionPane.YES_OPTION) ? bus1 : bus2;

            if (selectedBus.bookSeat(passengerName)) {
                statusLabel.setText(passengerName + " booked a seat on Bus " + selectedBus.getBusNumber());
            } else {
                statusLabel.setText("Sorry, no available seats on Bus " + selectedBus.getBusNumber());
            }
        } else {
            statusLabel.setText("Please enter passenger name!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BusBookingApp().setVisible(true);
            }
        });
    }
}
