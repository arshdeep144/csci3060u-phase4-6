/*
    Saijeeshan Ketheeswaran
    Arshdeep Benipal
    Norman Lo

    The purpose of this Back End program is to keep the available items file and user accounts file updated, as well as
    create a merged daily transaction file that will append all the transactions from each of the daily transaction
    files that were produced at the end of the Front End.

    This program will read in from the daily transaction file, each of the transactions, then apply the transactions
    line by line and update the previous available items file and user accounts file to create the new available items
    file and user accounts file that will be used for the next day.

    The AvailableItems and UserAccounts class will be used to update information on the user and item.

    These file will be read in before the beginning of the Back End.
    Input files: old available items file(availableitems.txt),
                 old user accounts file(useraccounts.txt),
                 daily transaction file(dailytransaction.txt)

    These files will be produced at the end of the Back End.
    Output files: new available items file(newavailableitems.txt),
                  new user accounts file(newuseraccounts.txt),
                  merged daily transaction file(mergedtransaction.txt)
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BackEnd {


    /*Each item and user that is read from the useraccounts.txt and availableitems.txt files will be added to an array
    list.
    */

    public static List<UserAccounts> users = new ArrayList<>();
    public static List<AvailableItems> items = new ArrayList<>();


    /**
     * The entry point of the Back End program. Will begin by reading in the daily transaction file that is produced
     * from the Front End. (Calls the readDTF() method)
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        readUAF();
        readAIF();
        readDTF();
        writeUAF();
        writeAIF();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
       This readDTF() method reads each of the transactions from the daily transaction file that is
       produced from the front end at the end of each day.
	*/
    public static void readDTF() {

        String transFile = "src/dailytransaction.txt";

        try {

            FileReader fileReader = new FileReader(transFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> lines = new ArrayList<>();

            String line;

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            bufferedReader.close();

            String transaction;
            String[] transList = lines.toArray(new String[lines.size()]);

            int i = 0;

            //Loops through each transaction in the daily transaction file
            while(i < transList.length) {

                transaction = transList[i];

                //Determines the transaction based on the transaction code.
                String transCode = transaction.substring(0, 2);

                // Conditional if statement that will execute a transaction based on the transaction code.
                if (transCode.equals("01")){
                    createUser(transaction);
                }
                else if (transCode.equals("02")) {
                    deleteUser(transaction);
                }
                else if (transCode.equals("03")) {
                    advertise(transaction);
                }
                else if (transCode.equals("04")) {
                    bid(transaction);
                }
                else if (transCode.equals("05")) {
                    refund(transaction);
                }
                else if (transCode.equals("06")) {
                    addCredit(transaction);
                }

                //Appends the transaction into the daily merged transactions
                mergeDTF(transaction);

                i++;
            }
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + transFile + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + transFile + "'");
        }
    }

    /*
       This readUAF() method reads in each user, line by line, from the useraccounts.txt file. This file will be updated
       to a new user accounts file.
	*/
    public static void readUAF() {
        String userFile = "src/useraccounts.txt";

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(userFile));

            String line;

            ArrayList<String> lines = new ArrayList<>();

            while ((line = bufferReader.readLine()) != null) {
                lines.add(line);
            }

            bufferReader.close();

            String[] userArray = lines.toArray(new String[lines.size()]);

            for (int i = 0; i < userArray.length; i++) {
                String[] transVal = userArray[i].split("\\s+");

                String name = transVal[0];
                String type = transVal[1];
                double updateCredit = Double.parseDouble(transVal[2]);

                UserAccounts addedUser = new UserAccounts(name, type, (float)updateCredit);
                users.add(addedUser);
            }
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + userFile + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + userFile + "'");
        }
    }

    /*
       This readAIF() method reads in each auction item, line by line, from the availableitems.txt file. This file will
       be updated to a new available items file.
	*/
    public static void readAIF() {
        String itemFile = "src/availableitems.txt";

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(itemFile));

            String line;

            ArrayList<String> lines = new ArrayList<>();

            while ((line = bufferReader.readLine()) != null) {
                lines.add(line);
            }

            bufferReader.close();

            String[] itemArray = lines.toArray(new String[lines.size()]);

            for (int i = 0; i < itemArray.length; i++) {
                String[] transVal = itemArray[i].split("\\s+");

                String itemName = transVal[0];
                String sName = transVal[1];
                String bName = transVal[2];
                int days = Integer.parseInt(transVal[3]);
                double bidAmount = Double.parseDouble(transVal[4]);

                AvailableItems newItem = new AvailableItems(itemName, sName, bName, days, (float)bidAmount);

                items.add(newItem);
            }
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + itemFile + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + itemFile + "'");
        }
    }

    public static void writeUAF() throws IOException {

        String userFile = "src/newuseraccounts.txt";

        try {

            FileWriter fw = new FileWriter(userFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String writeUser = "";

            for (UserAccounts user : users) {
                writeUser += user.toString() + System.lineSeparator();
            }

            bw.write(writeUser);

            bw.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + userFile + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + userFile + "'");
        }

    }

    public static void writeAIF() throws IOException {
        String itemFile = "src/newavailableitems.txt";

        try {

            FileWriter fw = new FileWriter(itemFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String writeItem = "";

            for (AvailableItems item : items) {
                writeItem += item.toString() + System.lineSeparator();
            }

            bw.write(writeItem);

            bw.close();

        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + itemFile + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + itemFile + "'");
        }
    }

    /**
     * The mergeDTF() method appends each transaction from every line in the dailytransaction.txt to the
     * newly created mergedtransaction.txt file
     *
     * @param transaction - the transaction from the dailytransactions.txt file is appended to the mergedtransaction.txt
     * file.
     */
    public static void mergeDTF(String transaction) throws IOException {

        String fileName2 = "src/mergedDailyTransactions.txt";

        try {

            FileWriter fw = new FileWriter(fileName2, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(transaction);
            bw.newLine();

            bw.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName2 + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName2 + "'");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static UserAccounts getUser(String username) {

        for(UserAccounts user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static int getUserPos(String username) {
        int count = 0;

        for(UserAccounts user : users) {
            if(user.getUsername().equals(username)) {
                return count;
            }
            else {
                count ++;
            }
        }
        return 0;
    }

    public static AvailableItems getItem(String itemName) {

        for(AvailableItems item : items) {
            if(item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static int getItemPos(String itemName) {
        int count = 0;

        for(AvailableItems item : items) {
            if(item.getItemName().equals(itemName)) {
                return count;
            }
            else {
                count++;
            }
        }
        return -1;

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method retrieves bid transaction outputs from the daily transaction file.
     *
     * @param transaction - the bid transaction from the daily transaction file
     */
    public static void bid(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");

        String item = transVal[1];
        String sName = transVal[2];
        String bName = transVal[3];
        double bidAmount = Double.parseDouble(transVal[4]);

        items.get(getItemPos(item)).setSellerName(sName);
        items.get(getItemPos(item)).setBuyerName(bName);
        items.get(getItemPos(item)).setBidAmount((float)bidAmount);
        items.get(getItemPos(item)).setNumDays(000);
        users.get(getItemPos(item)).bidItem((float)bidAmount);
    }

    /**
     * This method retrieves advertise transaction outputs from the daily transaction file.
     *
     * @param transaction - the advertise transaction from the daily transaction file
     */
    public static void advertise(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");

        String item = transVal[1];
        String sName = transVal[2];
        int days = Integer.parseInt(transVal[3]);
        double bidAmount = Double.parseDouble(transVal[4]);

        AvailableItems addedItem = new AvailableItems(item, sName, "", days, (float)bidAmount);

        users.get(getUserPos(sName)).advertiseItem((float)bidAmount);
        items.add(addedItem);
    }

    /**
     * This method retrieves addCredit transaction outputs from the daily transaction file.
     *
     * @param transaction - the addCredit transaction from the daily transaction file
     */
    public static void addCredit(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");

        String name = transVal[1];
        String type = transVal[2];
        double addCreditAmount = Double.parseDouble(transVal[3]);
        double credit = users.get(getUserPos(name)).getAvailableCredit();
        double updateCredit = addCreditAmount + credit;
        users.get(getUserPos(name)).setAvailableCredit((float)updateCredit);
    }

    /**
     * This method retrieves deleteUser transaction outputs from the daily transaction file and executes it.
     *
     * @param transaction - the deleteUser transaction from the daily transaction file
     */
    public static void deleteUser(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");

        String name = transVal[1];

        users.remove(getUserPos(name));
    }

    /**
     * This method retrieves the createUser transaction outputs from the daily transaction file and executes it.
     *
     * @param transaction - the createUser transaction from the daily transaction file
     */
    public static void createUser(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");
        String name = transVal[1];
        String type = transVal[2];
        double updateCredit = Double.parseDouble(transVal[3]);

        UserAccounts addedUser = new UserAccounts(name, type, (float)updateCredit);

        users.add(addedUser);
    }

    /**
     * This method retrieves the refund transaction outputs from the daily transaction file and executes it.
     *
     * @param transaction - the refund transaction from the daily transaction file
     */
    public static void refund(String transaction) {
        //Printing transaction for testing
        System.out.println("\n" + transaction);

        String[] transVal = transaction.split("\\s+");

        String bName = transVal[1];
        String sName = transVal[2];
        double updateCredit = Double.parseDouble(transVal[3]);

        //adding bName's updateCredit
        double buyerCredit = users.get(getUserPos(bName)).getAvailableCredit();
        double updateBuyerCredit = buyerCredit + updateCredit;
        users.get(getUserPos(bName)).setAvailableCredit((float)updateBuyerCredit);

        //reducing sName's updateCredit
        double sellerCredit = users.get(getUserPos(sName)).getAvailableCredit();
        double updateSellerCredit = sellerCredit - updateCredit;
        users.get(getUserPos(sName)).setAvailableCredit((float)updateSellerCredit);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
