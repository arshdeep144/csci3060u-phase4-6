/*
    The purpose of the BackEnd program is to keep the available items file and user accounts file updated.
    The program will read from the merged daily transaction file and
    apply the transactions to the previous available items file and user accounts file to create
    the next day's available items file and user accounts file. It will create a error
    log file that contains desciptions on any file or transaction based errors.
    Input files: old available items file, old user accounts file, merged daily transaction file
    Output files: new available items file, new user accounts file, error log file
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


public class BackEnd {

    public static List<UserAccount> user = new ArrayList<UserAccount>();
    public static List<AvailableItem> item = new ArrayList<AvailableItem>();

    public static void main(String[] args) throws IOException {


    }

    /*
       This readDTF() method reads each of the transactions from the daily transaction file that is
       produced from the front end.
	*/
    public static void readDTF() {

    }

    /*
       This readUAF() method reads from the useraccounts.txt file
	*/
    public static void readUAF() {

    }

    /*
       This readAIF() method reads from the availableitems.txt file.
	*/
    public static void readAIF() {

    }

    // This method merges the daily transaction files output from the front end.
    public static void mergeDTF(String transaction) {

    }

    // This method retrives bid transaction outputs from the daily transaction file.
    public static void bid(String transaction) {

    }

    // This method retrives advertise transaction outputs from the daily transaction file.
    public static void advertise(String transaction) {

    }

    // This method retrives addCredit transaction outputs from the daily transaction file.
    public static void addCredit(String transaction) {

    }

    // This method retrives deleteUser transaction outputs from the daily transaction file.
    public static void deleteUser(String transaction) {

    }

    // This method retrives the createUser transaction outputs from the daily transaction file.
    public static void createUser(String transaction){

    }

    // This method retrives the refund transaction outputs from the daily transaction file.
    public static void refund(String transaction){

    }

}
