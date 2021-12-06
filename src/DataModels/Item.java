package DataModels;

public class Item {
    private String category;
    private String itemName;
    private double itemPrice;
    private int quantityInInventory;

    public Item(String category, String itemName, double itemPrice, int quantityInInventory) {
        this.category = category;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantityInInventory = quantityInInventory;
    }
    public Item(String name,int quantity){
        this.itemName=name;
        this.quantityInInventory=quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(int quantityInInventory) {
        this.quantityInInventory = quantityInInventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", quantityInInventory=" + quantityInInventory +
                '}';
    }
}

