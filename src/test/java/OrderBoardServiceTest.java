import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderBoardServiceTest {

    OrderBoardService orderBoardService;

    @Before
    public void setUp() throws Exception {
        orderBoardService = new OrderBoardService();
    }

    @Test
    public void shouldPresentSummaryWithAllRegisteredOrders() {
        String expectedSummary = "SELL: \n5.5 kg for £306\n1.5 kg for £307\n1.2 kg for £310\n";
        assertEquals(expectedSummary, orderBoardService.getLiveOrderSummary());
    }

}