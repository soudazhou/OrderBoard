import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderBoardServiceTest {

    private OrderBoardService orderBoardService;

    @Before
    public void setUp() {
        orderBoardService = new OrderBoardService();
        orderBoardService.addOrder(new Order("user1", Order.Type.SELL,  306, 3.5));
        orderBoardService.addOrder(new Order("user2", Order.Type.SELL,  310, 1.2));
        orderBoardService.addOrder(new Order("user3", Order.Type.SELL,  307, 1.5));
        orderBoardService.addOrder(new Order("user4", Order.Type.SELL,  306, 2.0));

    }

    @Test
    public void shouldPresentSellSummaryWithAllRegisteredOrders() {
        String expectedSummary = "\nSELL:\n5.5 kg for £306\n1.5 kg for £307\n1.2 kg for £310\n";
        assertEquals(expectedSummary, orderBoardService.getLiveOrderSummary());
    }

    @Test
    public void shouldPresentBothSummaryWithAllRegisteredOrders() {
        String expectedSummary = "\nSELL:\n5.5 kg for £306\n1.5 kg for £307\n1.2 kg for £310\n"
                + "\nBUY:\n1.2 kg for £310\n1.5 kg for £307\n5.5 kg for £306\n";
        orderBoardService.addOrder(new Order("user1", Order.Type.BUY,  306, 3.5));
        orderBoardService.addOrder(new Order("user2", Order.Type.BUY,  310, 1.2));
        orderBoardService.addOrder(new Order("user3", Order.Type.BUY,  307, 1.5));
        orderBoardService.addOrder(new Order("user4", Order.Type.BUY,  306, 2.0));
        assertEquals(expectedSummary, orderBoardService.getLiveOrderSummary());
    }

    @Test
    public void shouldUpdateSummaryWhenOrdersAreCancelled() {
        String expectedSummary = "\nSELL:\n5.5 kg for £306\n1.5 kg for £307\n1.2 kg for £310\n"
                + "\nBUY:\n1.2 kg for £310\n3.5 kg for £306\n";
        orderBoardService.addOrder(new Order("user1", Order.Type.BUY,  306, 3.5));
        orderBoardService.addOrder(new Order("user2", Order.Type.BUY,  310, 1.2));
        orderBoardService.addOrder(new Order("user3", Order.Type.BUY,  307, 1.5));
        orderBoardService.addOrder(new Order("user4", Order.Type.BUY,  306, 2.0));

        orderBoardService.removeOrder(new Order("user4", Order.Type.BUY,  306, 1.0));//invalid removal since no such order exist, takes no effect
        orderBoardService.removeOrder(new Order("user4", Order.Type.BUY,  306, 2.0));//valid removal
        orderBoardService.removeOrder(new Order("user3", Order.Type.BUY,  307, 1.5));//valid removal which clear the entry for £307

        assertEquals(expectedSummary, orderBoardService.getLiveOrderSummary());
    }

}