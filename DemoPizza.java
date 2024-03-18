import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DemoPizza extends JFrame {
    private JTextField[] toppingFields;
    private JTextArea resultArea;
    private JPanel inputPanel = new JPanel(new GridLayout(0, 2));
    private JButton orderButton = new JButton("Place Order");
    private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JScrollPane scrollPane;
    private JPanel contentPane = new JPanel(new BorderLayout(10, 10));

    public DemoPizza() {
        setTitle("Pizza Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        toppingFields = new JTextField[10];

        for (int i = 0; i < 10; i++) {
            inputPanel.add(new JLabel("Topping " + (i + 1)));
            toppingFields[i] = new JTextField();
            inputPanel.add(toppingFields[i]);
        }

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        buttonPanel.add(orderButton);
        resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void placeOrder() {
        String[] toppings = new String[10];
        for (int i = 0; i < 10; i++) {
            toppings[i] = toppingFields[i].getText();
        }

        String result = "Your order details:\n";

        Pizza pizza;
        String deliveryAddress = "";

        if (isDelivery()) {
            deliveryAddress = JOptionPane.showInputDialog(this, "Please enter your delivery address:");
            pizza = new DeliveryPizza(toppings, deliveryAddress, countToppings(toppings));
        } else {
            pizza = new Pizza(toppings, countToppings(toppings));
        }

        if (pizza instanceof DeliveryPizza) {
            DeliveryPizza deliveryPizza = (DeliveryPizza) pizza;
            result += "\nTotal Price : $" + deliveryPizza.getTotalPrice();
            result += "\nDelivery Address: " + deliveryAddress;
        } else {
            result += "\nTotal Price: $" + pizza.getPrice();
        }

        resultArea.setText(result);
    }

    private boolean isDelivery() {
        int option = JOptionPane.showConfirmDialog(this, "Do you want delivery?", "Delivery", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    private int countToppings(String[] toppings) {
        int count = 0;
        for (String topping : toppings) {
            if (!topping.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DemoPizza frame = new DemoPizza();
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.YELLOW);
    }
}


//
//
//
//
//
//
//
//



//import javax.swing.*;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class DemoPizza extends JFrame {
//    private JTextField[] toppingFields;
//    private JTextArea resultArea;
//
//    public DemoPizza() {
//        setTitle("Pizza Ordering System");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 400);
//        setLocationRelativeTo(null); // Center the frame on the screen
//
//        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
//        toppingFields = new JTextField[10];
//        for (int i = 0; i < 10; i++) {
//            inputPanel.add(new JLabel("Topping " + (i + 1)));
//            toppingFields[i] = new JTextField();
//            inputPanel.add(toppingFields[i]);
//        }
//
//        JButton orderButton = new JButton("Place Order");
//        orderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                placeOrder();
//            }
//        });
//
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttonPanel.add(orderButton);
//
//        resultArea = new JTextArea(15, 30);
//        resultArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(resultArea);
//
//        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
//        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        contentPane.add(inputPanel, BorderLayout.NORTH);
//        contentPane.add(buttonPanel, BorderLayout.CENTER);
//        contentPane.add(scrollPane, BorderLayout.SOUTH);
//
//        setContentPane(contentPane);
//    }
//
//    private void placeOrder() {
//        String[] toppings = new String[10];
//        for (int i = 0; i < 10; i++) {
//            toppings[i] = toppingFields[i].getText();
//        }
//
//        StringBuilder result = new StringBuilder();
//        result.append("Your order details:\n");
//
//        Pizza pizza;
//        String deliveryAddress = "";
//
//        if (isDelivery()) {
//            deliveryAddress = JOptionPane.showInputDialog(this, "Please enter your delivery address:");
//            pizza = new DeliveryPizza(toppings, deliveryAddress, countToppings(toppings));
//        } else {
//            pizza = new Pizza(toppings, countToppings(toppings));
//        }
//
//        result.append(pizza.toString());
//
//        if (pizza instanceof DeliveryPizza) {
//            DeliveryPizza deliveryPizza = (DeliveryPizza) pizza;
//            result.append("\nTotal Price (including delivery): $").append(deliveryPizza.getTotalPrice());
//            result.append("\nDelivery Address: ").append(deliveryAddress);
//        }
//
//        resultArea.setText(result.toString());
//    }
//
//    private boolean isDelivery() {
//        int option = JOptionPane.showConfirmDialog(this, "Do you want delivery?", "Delivery", JOptionPane.YES_NO_OPTION);
//        return option == JOptionPane.YES_OPTION;
//    }
//
//    private int countToppings(String[] toppings) {
//        int count = 0;
//        for (String topping : toppings) {
//            if (!topping.isEmpty()) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                DemoPizza demo = new DemoPizza();
//                demo.setVisible(true);
//            }
//        });
//    }
//}

