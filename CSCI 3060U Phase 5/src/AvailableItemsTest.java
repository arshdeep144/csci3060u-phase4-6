import org.junit.Test;
import static org.junit.Assert.*;

public class AvailableItemsTest {

    @Test
    public void testAvailableItems(){
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals("Computer" , itemTest.itemName);
        assertEquals(test.userName, itemTest.sellerName);
        assertEquals(test2.userName, itemTest.buyerName);
        assertEquals(2, itemTest.numDays);
        assertEquals((float)123.00, itemTest.minBid,0);
    }

    @Test
    public void setItemName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals("Computer" , itemTest.itemName);
    }

    @Test
    public void setSellerName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(test.userName, itemTest.sellerName);
    }

    @Test
    public void setBuyerName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(test2.userName, itemTest.buyerName);
    }

    @Test
    public void setBidAmount() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals((float)123.00, itemTest.minBid,0);
    }

    @Test
    public void setNumDays() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(2, itemTest.numDays);
    }

    @Test
    public void getItemName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals("Computer" , itemTest.getItemName());
    }

    @Test
    public void getSellerName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(test.userName, itemTest.getSellerName());
    }

    @Test
    public void getBuyerName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(test2.userName, itemTest.getBuyerName());
    }

    @Test
    public void getBidAmount() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals((float)123.00, itemTest.getBidAmount(),0);
    }

    @Test
    public void getNumDays() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "AA", (float)4000.00);

        AvailableItems itemTest = new AvailableItems("Computer", test.userName, test2.userName, 2, (float)123.00);

        assertEquals(2, itemTest.getNumDays(),0);
    }

}