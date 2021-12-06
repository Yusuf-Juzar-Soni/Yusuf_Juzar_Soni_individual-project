package DataModels;

public class InvoiceItems {
    private String invoiceItemName;
    private int itemQuantity;
    private String creditCardInfo;
    private double price;

    public InvoiceItems(String invoiceItemName, int itemQuantity, String creditCardInfo) {
        this.invoiceItemName = invoiceItemName;
        this.itemQuantity = itemQuantity;
        this.creditCardInfo = creditCardInfo;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInvoiceItemName() {
        return invoiceItemName;
    }

    public void setInvoiceItemName(String invoiceItemName) {
        this.invoiceItemName = invoiceItemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }


    @Override
    public String toString() {
        return "invoiceItems{" +
                "invoiceItemName='" + invoiceItemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", creditCardInfo='" + creditCardInfo + '\'' +
                '}';
    }
}
