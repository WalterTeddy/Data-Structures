public class Pizza {
    private String[] toppings;
    private double price;

    public Pizza(String[] toppings, int numToppings) {
        this.toppings = toppings;
        calculatePrice();
    }

    private void calculatePrice() {
        price = 14;
        for (int i = 0; i < toppings.length; i++) {
            price += 2;
        }
    }

    public double getPrice() {
        return price;
    }

    public String[] getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        String toppingsString = "Pizza with toppings: ";
        for (int i = 0; i < toppings.length; i++) {
            toppingsString += toppings[i];
            if (i < toppings.length - 1) {
                toppingsString += ", ";
            }
        }
        return toppingsString + "\nTotal Price: $" + price;
    }
}
