package Module;

public class Ticket {
    private int price;
    private int quantity;

    public Ticket() {
    }

    public Ticket(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return price +"," + quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
