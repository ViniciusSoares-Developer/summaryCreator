public class Product {
    private String Name;
    private Double Amount;
    private Integer Quantity;

    public Product(String name, Double amount, Integer quantity) {
        setName(name);
        setAmount(amount);
        setQuantity(quantity);
    }

    public String outPrintProduct() {
        return getName() + ";" + getAmount() + ";" + getQuantity() + ";" + total();
    }

    public Double total() {
        return getAmount() * getQuantity();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
