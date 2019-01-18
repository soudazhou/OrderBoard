import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class OrderBoardService {

    private List<Order> orders;
    private TreeMap<Integer, Double> buySummary, sellSummary;

    public OrderBoardService() {
        orders = new ArrayList<>();
        buySummary = new TreeMap<>();
        sellSummary = new TreeMap<>();
    }

    public String getLiveOrderSummary() {
        StringBuilder sb = new StringBuilder();
        if (!sellSummary.isEmpty()) {
            sb.append("\nSELL:\n");
            sellSummary.forEach((price, qty) -> sb.append(qty).append(" kg for £").append(price).append("\n"));
        }

        if (!buySummary.isEmpty()) {
            sb.append("\nBUY:\n");
            for (Integer price : buySummary.descendingKeySet()) {
                sb.append(buySummary.get(price)).append(" kg for £").append(price).append("\n");
            }
        }

        return sb.toString();
    }

    public void addOrder(Order order) {
        orders.add(order);
        updateSummaryFromOrder(order, true);
    }

    public void removeOrder(Order order) {
        //only update summary if order exist (can be removed from the list)
        if (orders.remove(order)) {
            updateSummaryFromOrder(order, false);
        }
    }

    private void updateSummaryFromOrder(Order order, boolean addOrder) {
        if (order.getType() == Order.Type.BUY) {
            updateSummary(order, buySummary, addOrder);
        } else if (order.getType() == Order.Type.SELL) {
            updateSummary(order, sellSummary, addOrder);
        }
    }

    private void updateSummary(Order order, TreeMap<Integer, Double> summary, boolean addOrder) {
        if (addOrder) {
            if (!summary.containsKey(order.getPricePerKg())) {
                summary.put(order.getPricePerKg(), order.getQty());
            } else {
                summary.put(order.getPricePerKg(), summary.get(order.getPricePerKg()) + order.getQty());
            }
        } else {
            summary.put(order.getPricePerKg(), summary.get(order.getPricePerKg()) - order.getQty());
            if (summary.get(order.getPricePerKg()).equals(0.0)) {
                summary.remove(order.getPricePerKg());
            }
        }
    }
}
