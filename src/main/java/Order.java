public class Order {

    private String userId;
    private Type type;
    private Integer pricePerKg;
    private Double qty;

    public Order(String userId, Type type, Integer pricePerKg, Double qty) {
        this.userId = userId;
        this.type = type;
        this.pricePerKg = pricePerKg;
        this.qty = qty;
    }

    public Type getType() {
        return type;
    }

    public Integer getPricePerKg() {
        return pricePerKg;
    }

    public Double getQty() {
        return qty;
    }

    enum Type {
        BUY,
        SELL
    }
}
