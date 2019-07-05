public abstract class Dock {
    String name;
    String product;
    int quantity;

    public Dock(String name, String product, int quantity){
        this.name = name;
        this.product = product;
        this.quantity = quantity;

        // TODO добавить проверку на отрицательную емкость и количетво
    }

    public Dock(String name, String product){
        this.name = name;
        this.product = product;

        // TODO добавить проверку на отрицательную емкость и количетво
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
