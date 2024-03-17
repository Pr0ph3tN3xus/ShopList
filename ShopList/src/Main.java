import java.util.ArrayList;

// Items
class Item {
    private final String name;
    private final double price;
    private final int bulkQuantity;
    private final double bulkPrice;

    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double calculatePrice(int quantity) {
        int bulkCount = quantity / bulkQuantity;
        int remainder = quantity % bulkQuantity;
        return bulkCount * bulkPrice + remainder * price;
    }
}

// Order List
class ItemOrder {
    private final Item item;
    private final int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() {
        return item.calculatePrice(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}

// Class representing a shopping cart
class ShoppingCart {
    private final ArrayList<ItemOrder> itemOrders;

    public ShoppingCart() {
        itemOrders = new ArrayList<>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
    }

    public void removeItemOrder(ItemOrder itemOrder) {
        itemOrders.remove(itemOrder);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder itemOrder : itemOrders) {
            totalPrice += itemOrder.getPrice();
        }
        return totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating grocery items with bulk discount
        Item tissues = new Item("Tissues", 3.0, 2, 4.0);
        Item socks = new Item("Socks", 5.0, 1, 5.0);

        // Creating item orders
        ItemOrder order1 = new ItemOrder(tissues, 5);
        ItemOrder order2 = new ItemOrder(socks, 2);

        // Creating shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Adding item orders to cart
        cart.addItemOrder(order1);
        cart.addItemOrder(order2);

        // Printing total price
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}