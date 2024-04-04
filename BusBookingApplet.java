import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

    public boolean bookSeat(String passengerName) {
        if (passengers.size() < capacity) {
            passengers.add(passengerName);
            return true;
        } else {
            return false;
        }
    }
}

public class BusBookingApplet extends JApplet {
    private JTextField passengerNameField;
    private JLabel statusLabel;
    private JLabel bus1Label;
    private JLabel bus2Label;

    private final Bus bus1 = new Bus(101, 50);
    private final Bus bus2 = new Bus(102, 40);

    public void init() {
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

        ImageIcon bus1Image = new ImageIcon("bus1.jpeg"); // Replace "bus1.png" with the actual path to your bus image
        bus1Label = new JLabel(bus1Image);
        bus1Label.setBounds(30, 150, 200, 100);
        panel.add(bus1Label);

        ImageIcon bus2Image = new ImageIcon("bus2.png"); // Replace "bus2.png" with the actual path to your bus image
        bus2Label = new JLabel(bus2Image);
        bus2Label.setBounds(250, 150, 200, 100);
        panel.add(bus2Label);

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
}
