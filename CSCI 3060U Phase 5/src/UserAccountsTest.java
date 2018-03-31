import org.junit.Test;
import static org.junit.Assert.*;

public class UserAccountsTest {

    @Test
    public void testUserAccounts() {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals("TestUser1", test.userName);
        assertEquals("FS", test.userType);
        assertEquals((float)2000.00, test.availableCredit, 0);
    }

    @Test
    public void testSetUserType() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals("FS", test.userType);
    }

    @Test
    public void testSetUserName() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals("TestUser1", test.userName);
    }

    @Test
    public void testSetAvailableCredit() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals((float)2000.00, test.availableCredit, 0);
    }

    @Test
    public void testBidItem() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        test.bidItem((float)1000.00);

        assertEquals(1000.00, test.availableCredit, 0);
    }

    @Test
    public void testAdvertiseItem() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        test.advertiseItem((float)1000.00);

        assertEquals(3000.00, test.availableCredit, 0);
    }

    @Test
    public void testGetUserType() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals("FS", test.getUserType());
    }

    @Test
    public void testGetUsername() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1", "FS", (float)2000.00);

        assertEquals("TestUser1", test.getUsername());
    }

    @Test
    public void testGetAvailableCredit() throws Exception {
        UserAccounts test = new UserAccounts("TestUser1","FS", (float)2000.00);

        assertEquals((float)2000.00, test.getAvailableCredit(),0);
    }
}