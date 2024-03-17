import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> itemOrders;

    public ShoppingCart() {
        itemOrders = new ArrayList<>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
    }

    //adds item to the shopping cart list
    public void removeItemOrder(int index) {
        if (index >= 0 && index < itemOrders.size()) {
            itemOrders.remove(index);
        }
    }

    //removes item to the shopping cart list
    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;

        // shows how many items are in the cart
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder order : itemOrders) {
            totalPrice += order.getItem().getItemPrice() * order.getQuantity();
        }
        return totalPrice;

        //calculates total price
    }
}

