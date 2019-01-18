import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(userId, order.userId) &&
                type == order.type &&
                Objects.equals(pricePerKg, order.pricePerKg) &&
                Objects.equals(qty, order.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, type, pricePerKg, qty);
    }

    enum Type {
        BUY,
        SELL
    }
}
