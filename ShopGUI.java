import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShopGUI extends JFrame {
    private JLabel label = new JLabel("Welcome to the Big Y Store!:");
    private JLabel informationLabel = new JLabel("Please enter any item and its price:");
    private JTextField itemNameField = new JTextField(21);
    private JTextField itemPriceField = new JTextField(7);
    private JTextField itemQuantityField = new JTextField(7);
    private JButton addButton = new JButton("Add to Cart");
    private JButton removeButton = new JButton("Remove Selected Item");
    private JLabel totalPriceLabel = new JLabel("Total Price: $0.00");
    private ShoppingCart shoppingCart = new ShoppingCart();

    //labels and texts that welcome and guide the user
    private JList<String> cartList = new JList<>();
    private DefaultListModel<String> cartListModel = new DefaultListModel<>();

    //arrays or lists of the shopping cart and specifically their quantity, name, and price of the item

    public ShopGUI() {
        super("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new FlowLayout());
        label.setFont(new Font("Arial", Font.BOLD, 21));
        informationLabel.setFont(new Font("Arial", Font.BOLD, 21));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToCart();

                //makes a item added to the shopping list
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedItem();
                //makes a item removed to the shopping list
            }
        });

        add(label);
        add(informationLabel);
        add(new JLabel("Item Name:"));
        add(itemNameField);
        add(new JLabel("Price:"));
        add(itemPriceField);
        add(new JLabel("Quantity:"));
        add(itemQuantityField);
        add(addButton);
        add(removeButton);
        add(new JScrollPane(cartList));
        add(totalPriceLabel);
        //adds the labels and buttons to the GUI

    }

    private void addItemToCart() {
        String itemName = itemNameField.getText();
        int itemPrice = Integer.parseInt(itemPriceField.getText());
        int itemQuantity = Integer.parseInt(itemQuantityField.getText());

        Item item = new Item(itemName, itemPrice);
        ItemOrder itemOrder = new ItemOrder(item, itemQuantity);
        shoppingCart.addItemOrder(itemOrder);

        updateCartList();
        calculateTotalPrice();

        //updates the shopping cart list and price when an item is added
    }

    private void removeSelectedItem() {
        int selectedIndex = cartList.getSelectedIndex();
        if (selectedIndex != -1) {
            shoppingCart.removeItemOrder(selectedIndex);
            updateCartList();
            calculateTotalPrice();

            //updates the shopping cart list and price when an item is removed
        } else {
            JOptionPane.showMessageDialog(this, "Please select any item that you want to remove.", "No items were selected", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCartList() {
        cartListModel.clear();
        for (ItemOrder order : shoppingCart.getItemOrders()) {
            cartListModel.addElement(order.getItem().getItemName() + " : $" +
                    order.getItem().getItemPrice() + " each and " + order.getQuantity() + " selected");
        }
        cartList.setModel(cartListModel);

        //updates the GUI by adding or removing an item from user actions
    }

    private void calculateTotalPrice() {
        double totalPrice = shoppingCart.calculateTotalPrice();
        totalPriceLabel.setText("Total Price: $" + (int)totalPrice);
    }
    //calculates total price

    public static void main(String[] args) {
        ShopGUI frame = new ShopGUI();
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.RED);

        //specific setting for the GUI such as color and size
            }
        }