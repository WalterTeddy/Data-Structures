import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame {
    private JTextField[] ToppingFields;
    private JTextArea ResultArea;
    private JButton OrderButton = new JButton("Place Order");
    private JButton TipButton = new JButton("Add Tip"); // New button for adding tip
    private JPanel InputPanel = new JPanel(new GridLayout(0, 2));
    private JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JScrollPane ScrollPane;

    // labels and buttons for the GUI
    private double TipAmount = 0.0;
//set tip amount in case they dont tip
    public DemoPizza() {
        setTitle("Pizza Shop Inc.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 240);
        setLocationRelativeTo(null);
        ToppingFields = new JTextField[10];
//properties such as size and close setting of the GUI
        for (int i = 0; i < 10; i++) {
            InputPanel.add(new JLabel("Topping " + (i + 1)));
            ToppingFields[i] = new JTextField();
            InputPanel.add(ToppingFields[i]);
            //turns string of a topping into a topping count
        }

        OrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
                //button to place the order
            }
        });

        // Action listener for the tip button
        TipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Tip = JOptionPane.showInputDialog(DemoPizza.this, "Please enter any tip amount:");
                try {
                    TipAmount = Double.parseDouble(Tip);
                    if (TipAmount < 0) {
                        JOptionPane.showMessageDialog(DemoPizza.this, "The tip can't be negative, please try again");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DemoPizza.this, "The tip has to be a number, please try again");

                    //tip button while also making sure the tip amount is a valid number
                }
            }
        });

        ButtonPanel.add(OrderButton);
        ButtonPanel.add(TipButton);
        ResultArea = new JTextArea(14, 32);

        ResultArea.setBackground(Color.YELLOW);
        ScrollPane = new JScrollPane(ResultArea);

        add(InputPanel, BorderLayout.NORTH);
        InputPanel.setBackground(Color.RED);
        add(ButtonPanel, BorderLayout.CENTER);
        add(ScrollPane, BorderLayout.SOUTH);

        //adds labels and areas of the GUI and sets their colors
    }

    private void placeOrder() {
        String[] toppings = new String[10];
        for (int i = 0; i < 10; i++) {
            toppings[i] = ToppingFields[i].getText();
        }
        //recieves up to 10 string toppings from the topping field

        String result = "Pizza Order Details Are Below:\n";
        Pizza pizza;
        String deliveryAddress = "";
        //shows the users input

        if (isDelivery()) {
            deliveryAddress = JOptionPane.showInputDialog(this, "Please enter a delivery address:");
            pizza = new DeliveryPizza(toppings, deliveryAddress, countToppings(toppings));
        } else {
            pizza = new Pizza(toppings, countToppings(toppings));

            //makes pizza into a new pizza with what toppings and the count of them while showing the delivery address
        }

        pizza.setTipAmount(TipAmount);
        //amount that is being tipped
        if (pizza instanceof DeliveryPizza) {
            DeliveryPizza deliveryPizza = (DeliveryPizza) pizza;
            result += "\nTotal Price : $" + deliveryPizza.getPrice();
            result += "\nDelivery Address: " + deliveryAddress;
        } else {
            result += "\nTotal Price: $" + pizza.getPrice();
        }
        //determines the total price depending on if the pizza is being delivered

        ResultArea.setText(result);
        //displays the results of the order to the user
    }

    private boolean isDelivery() {
        int option = JOptionPane.showConfirmDialog(this, "Do you want your pizza delivered?", "Delivery Option", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
        //returns the delivery option if the user selects so and if they don't the order isn't delivered
    }

    private int countToppings(String[] toppings) {
        int count = 0;
        for (String topping : toppings) {
            if (!topping.isEmpty()) {
                count++;
                //counts the strings of the toppings
            }
        }
        return count;
        //returns the count of the toppings
    }

    public static void main(String[] args) {
        DemoPizza frame = new DemoPizza();
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.YELLOW);
        //setting for the GUI such as color and size
    }
}