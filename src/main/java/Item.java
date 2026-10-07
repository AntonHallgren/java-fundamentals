public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double totalPrice()
    {
        return quantity * price;
    }

    public static double totalCost(Item[] items)
    {
        double total = 0;
        for (Item item : items) {
            total += item.totalPrice();
        }
        return total;
    }

    private void print()
    {
        IO.println(name + "\t" + quantity + " x " + price + " = " + totalPrice() + " SEK");
    }

    private static void printReceipt(Item[] items)
    {
        IO.println("==================");
        IO.println("\t Receipt");
        IO.println("==================");
        for (Item item : items)
        {
            item.print();
        }
        IO.println("------------------");
        IO.println("Grand Total: \t " + totalCost(items) + " SEK");
        IO.println("==================");
    }

    public static void purchaseItemsDemo()
    {
        Item[] items = {
                new Item("Apple", 2, 15.0),
                new Item("Milk", 1, 22.0),
                new Item("Bread", 3, 18.0)
        };
        printReceipt(items);
    }
}
