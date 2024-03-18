public class Pizza {
    private String[] Topping;
    private double PriceOfJustPizza;
    private double TotalPrice;
    private double AmountForTip;

    // Variables
    public Pizza(String[] Topping, int numToppings) {
        this.Topping = new String[numToppings];
        for (int i = 0; i < numToppings; i++) {
            this.Topping[i] = Topping[i];
        }
        calculatePrice();
    }

    // Calculates the total price
    private void calculatePrice() {
        PriceOfJustPizza = 14.0;
        TotalPrice = PriceOfJustPizza + (Topping.length * 2.0);
    }

    // Calculates the total price including tip
    public double getPrice() {
        return TotalPrice + AmountForTip;
    }

    // Set tip amount
    public void setTipAmount(double TipAmount) {
        this.AmountForTip = TipAmount;
    }

    // sets the tip amount
    public String[] getToppings() {
        return Topping;
    }
    //returns the toppings


    @Override
    public String toString() {
        StringBuilder toppingsString = new StringBuilder();
        for (int i = 0; i < Topping.length; i++) {
            toppingsString.append(Topping[i]);
            if (i < Topping.length - 1) {
                toppingsString.append(", ");
            }
        }
        return " " + toppingsString + "\nTotal Price: $" + getPrice();
    }
}
        //


