import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BackEndTest extends BackEnd {

    @Test
    public void testReadDTF() throws Exception {
        readDTF();
    }

    @Test
    public void testReadUAF() throws Exception {
        readUAF();
        assertNotNull(users);
    }

    @Test
    public void testReadAIF() throws Exception {
        readAIF();
        assertNotNull(items);
    }

    @Test
    public void testWriteUAF() throws Exception {
        readUAF();
        readAIF();
        readDTF();
        writeUAF();
        writeAIF();

        File actualFile = new File("src/newuseraccounts.txt");
        BufferedReader bufferReader = new BufferedReader(new FileReader(actualFile));

        String line;
        ArrayList<String> lines = new ArrayList<>();

        while ((line = bufferReader.readLine()) != null) {
            lines.add(line);
        }

        bufferReader.close();

        File expectedFile = new File("src/expecteduseraccounts.txt");
        BufferedReader bufferReader2 = new BufferedReader(new FileReader(expectedFile));

        String line2;

        ArrayList<String> lines2 = new ArrayList<>();

        while ((line2 = bufferReader2.readLine()) != null) {
            lines2.add(line2);
        }
        bufferReader2.close();

        //Compare contents of expected and actual new user accounts file
        assertEquals(lines2, lines);
    }

    @Test
    public void testWriteAIF() throws Exception {
        readUAF();
        readAIF();
        readDTF();
        writeUAF();
        writeAIF();

        File actualFile = new File("src/newavailableitems.txt");
        BufferedReader bufferReader = new BufferedReader(new FileReader(actualFile));

        String line;
        ArrayList<String> lines = new ArrayList<>();

        while ((line = bufferReader.readLine()) != null) {
            lines.add(line);
        }

        bufferReader.close();

        File expectedFile = new File("src/expectedavailableitems.txt");
        BufferedReader bufferReader2 = new BufferedReader(new FileReader(expectedFile));

        String line2;
        ArrayList<String> lines2 = new ArrayList<>();

        while ((line2 = bufferReader2.readLine()) != null) {
            lines2.add(line2);
        }

        bufferReader2.close();

        //Compare contents of expected and actual new user accounts file
        assertEquals(lines2, lines);
    }

    @Test
    public void testGetUser() throws Exception {
        UserAccounts test = new UserAccounts("TestUser", "AA", (float)1000.00);

        users.add(test);

        assertEquals("TestUser", getUser("TestUser").getUsername());
    }

    @Test
    public void testGetUserPos() throws Exception {
        UserAccounts test = new UserAccounts("TestUser", "AA", (float)1000.00);

        users.add(test);

        assertEquals("Position",0, getUserPos("TestUser"));
    }

    @Test
    public void testGetItem() throws Exception {
        UserAccounts test = new UserAccounts("TestUser", "AA", (float)1000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "BS", (float)2000.00);
        AvailableItems testItem = new AvailableItems("TV", "TestUser1", "TestUser2", 2,11);

        readUAF();
        readAIF();

        users.add(test);
        users.add(test2);
        items.add(testItem);

        assertEquals("TV", getItem("TV").getItemName());
    }

    @Test
    public void testGetItemPos() throws Exception {
        UserAccounts test = new UserAccounts("TestUser", "AA", (float)1000.00);
        UserAccounts test2 = new UserAccounts("TestUser2", "BS", (float)2000.00);

        AvailableItems testItem = new AvailableItems("TV", "TestUser1", "TestUser2", 2,11);

        users.add(test);
        users.add(test2);
        items.add(testItem);

        assertEquals("Position", 0, getItemPos("TV"));
    }

    @Test
    public void testBid() throws Exception {
        bid("04 Computer            arshdeep      saijeeshan       500.00");
    }

    @Test
    public void testAdvertise() throws Exception {
        advertise("03 Computer            arshdeep    061 123.00");
    }

    @Test
    public void testAddCredit() throws Exception {
        addCredit("06 saijeeshan      arshdeep        000023.00");
    }

    @Test
    public void testDeleteUser() throws Exception {
        deleteUser("02 norman          AA 002000.00");
    }

    @Test
    public void testCreateUser() throws Exception {
        createUser("01 saijeeshan      AA 001000.00");
    }

    @Test
    public void testRefund() throws Exception {
        refund("05 arshdeep        saijeeshan      000033.00");
    }
}