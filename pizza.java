import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class pizza extends JFrame implements ItemListener {
    JLabel label = new JLabel("Welcome to the BigY Store!:");
    JLabel InformationLabel = new JLabel("Please select size of pizza and any toppings up to three toppings:");
    JCheckBox Small = new JCheckBox("Small ($5)", false);
    JCheckBox Medium = new JCheckBox("Medium ($10", false);
    JCheckBox Large = new JCheckBox("Large ($15)", false);
    JCheckBox Super = new JCheckBox("Super ($20)", false);
    JCheckBox ExtraCheese = new JCheckBox("Extra Cheese (No additional charge)", false);
    JCheckBox Peperoni = new JCheckBox("Peperoni ($0.50)", false);
    JCheckBox Sardines = new JCheckBox("Sardines ($0.50)", false);
    JCheckBox Mushrooms = new JCheckBox("Mushrooms ($0.50)", false);
    JCheckBox Spinach = new JCheckBox("Spinach ($0.50)", false);
    JLabel SpecialRequestsPrompt = new JLabel("Enter Any Special Requests:");
    JTextField SpecialRequests = new JTextField(12);
    JButton Confirm = new JButton("Click to  Confirm Purchase");
    JLabel RequestsLabel = new JLabel("");

    // Labels for sizes, toppings, and the special request button
    ButtonGroup PizzaSizes = new ButtonGroup();

    // makes the pizza sizes into a button group
    public pizza() {
        super("BigY Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label.setFont(new Font("Arial", Font.BOLD, 20));
        InformationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        Small.addItemListener(this);
        Medium.addItemListener(this);
        Large.addItemListener(this);
        Super.addItemListener(this);
        ExtraCheese.addItemListener(this);
        Peperoni.addItemListener(this);
        Sardines.addItemListener(this);
        Mushrooms.addItemListener(this);
        Spinach.addItemListener(this);
        add(label);
        add(InformationLabel);
        PizzaSizes.add(Small);
        PizzaSizes.add(Medium);
        PizzaSizes.add(Large);
        PizzaSizes.add(Super);
        add(Small);
        add(Medium);
        add(Large);
        add(Super);
        add(ExtraCheese);
        add(Peperoni);
        add(Sardines);
        add(Mushrooms);
        add(Spinach);
        add(SpecialRequestsPrompt);
        add(SpecialRequests);
        add(Confirm);
        add(RequestsLabel);
        // adds the labels to the GUI/content pane

        Confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String request = SpecialRequests.getText();
                String RequestSection = "Requests: " + request;
                RequestsLabel.setText(RequestSection);
                calculateTotalCost();
            }

            // adds functionality to the confirm purchase button


        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Confirm) {
            calculateTotalCost();
        }

    }
    // makes the confirm button work

    private void calculateTotalCost() {
        boolean smallSelected = Small.isSelected();
        boolean mediumSelected = Medium.isSelected();
        boolean largeSelected = Large.isSelected();
        boolean superSelected = Super.isSelected();
        boolean ExtraCheeseSelected = ExtraCheese.isSelected();
        boolean PepperoniSelected = Peperoni.isSelected();
        boolean MushroomsSelected = Mushrooms.isSelected();
        boolean SardinesSelected = Sardines.isSelected();
        boolean SpinachSelected = Spinach.isSelected();

        int SelectedToppingsCount = 0;

        if (ExtraCheeseSelected) {
            SelectedToppingsCount += 1;
        }
        if (PepperoniSelected) {
            SelectedToppingsCount += 1;
        }
        if (MushroomsSelected) {
            SelectedToppingsCount += 1;
        }
        if (SardinesSelected) {
            SelectedToppingsCount += 1;
        }
        if (SpinachSelected) {
            SelectedToppingsCount += 1;
        }

        // tells if a side or size of pizza is collected and counts the number of items selected

        double SizePrice = 0;
        if (smallSelected) {
            SizePrice = 5.0;
        } else if (mediumSelected) {
            SizePrice = 10.0;
        } else if (largeSelected) {
            SizePrice = 15.0;
        } else if (superSelected) {
            SizePrice = 20.0;
        }

        double ToppingCost;

        if (SelectedToppingsCount < 3) {
            if (ExtraCheeseSelected) {
                ToppingCost = 0.50;
            } else {
                ToppingCost = SelectedToppingsCount * 0.50;
            }
        } else if (SelectedToppingsCount == 3) {
            if (ExtraCheeseSelected) {
                ToppingCost = 1;
            } else {
                ToppingCost = 1.25;


            }
        } else {
            ToppingCost = 0;
        }

        // determines the price of the toppings and exceptions for the amount of toppings and or the selection of free extra cheese

        double TotalCost = SizePrice + ToppingCost;

        if (SelectedToppingsCount > 3)
            JOptionPane.showMessageDialog(null, "Please select only up to 3 toppings!");


        if (SelectedToppingsCount <= 3) {
            JOptionPane.showMessageDialog(this, "Total Cost: " + TotalCost, "Total Cost", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // displays specific messages that is determined on what the user selects such as costs and warning about topping max




        public static void main (String[]args){
            pizza frame = new pizza();
            frame.setSize(700, 500);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.YELLOW);
        }
    }

    // gives the content pane its characteristics such as size, color, and functionality