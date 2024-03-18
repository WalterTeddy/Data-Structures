public class DeliveryPizza extends Pizza {
    private String AddressOfDelivery;

    public DeliveryPizza(String[] toppings, String AddressOfDelivery, int numToppings) {
        super(toppings, numToppings);
        this.AddressOfDelivery = AddressOfDelivery;
    }

    public double getTotalPrice() {
        final double PriceOfPizza = 14.0;
        final double PriceOfTopping = 2.0;
        final double HighestPriceOfPizza = 18.0;
        final double LowestPriceOfDelivery = 3.0;
        final double HighestPriceOfDelivery = 5.0;

        int numToppings = getToppings().length;
        double totalPrice = PriceOfPizza + numToppings * PriceOfTopping;

        double deliveryFee;
        if (totalPrice > HighestPriceOfPizza) {
            deliveryFee = LowestPriceOfDelivery;
        } else {
            deliveryFee = HighestPriceOfDelivery;
        }

        return totalPrice + deliveryFee;


    }

    public String getAddressOfDelivery() {
        return AddressOfDelivery;
    }
}
