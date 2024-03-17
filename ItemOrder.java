class ItemOrder {
    private Item PickedItem;
    private int QuantityOfItem;

    public ItemOrder(Item ChosenItem, int ItemQuantity) {
        PickedItem = ChosenItem;
        QuantityOfItem = ItemQuantity;

        //item that is chosen and the quantity
    }

    public Item getItem() {
        return PickedItem;
    }

    public int getQuantity() {
        return QuantityOfItem;
    }
}

