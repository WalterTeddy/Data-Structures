public class DeliveryPizza extends Pizza {
    private String AddressOfDelivery;

    // Varible for address
    public DeliveryPizza(String[] toppings, String AddressOfDelivery, int numToppings) {
        super(toppings, numToppings);
        this.AddressOfDelivery = AddressOfDelivery;
    }

    // returns the toppings decription and amount aswell as the address
    @Override
    public double getPrice() {
        double DeliveryCharge;
        if (super.getPrice() > 18.0) {
            DeliveryCharge = 3.0;
        } else {
            DeliveryCharge = 5.0;
        }
        return super.getPrice() + DeliveryCharge;
    }

    //returns the price and the delivery charge


    public String getAddressOfDelivery() {
        return AddressOfDelivery;

        //returns the delivery address
    }
}


