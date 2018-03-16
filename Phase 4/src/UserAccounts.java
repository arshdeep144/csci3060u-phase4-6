/*
    This program creates a file holding information on the user accounts. The file will store account information on
    the user type, username and available credit.The program allows for quick changes
    and retrieval of the account information. The back end will apply the daily
    transactions from the daily transaction file to this file to create a new user account file for next day.
*/
public class UserAccounts {

    public String userType;
    public String userName;
    public float availableCredit;

    /*
        This constructor method sets variables based on the provided arguments.
        The variables store information on the username, user type and available credit.
    */
    public UserAccounts(String name, String type, float credit) {
        userName = name;
        userType = type;
        availableCredit = credit;
    }

    // This set method sets the user account's type.
    public void setUserType(String type) {
        userType = type;
    }

    // This set method sets the username.
    public void setUserName(String name) {
        userName = name;
    }

    // This set method sets the user's available credit.
    public void setAvailableCredit(float credit) {
        availableCredit = credit;
    }

    // This method decreases the available credit amount by the bid amount.
    public void bidItem(float bidAmount) {
        availableCredit -= bidAmount;
    }

    // This method increases the available credit amount by the bid amount.
    public void advertiseItem(float bidAmount) {
        availableCredit += bidAmount;
    }

    // This get method returns the user account's type.
    public String getUserType() {
        return userType;
    }

    // This get method returns the username.
    public String getUsername() {
        return userName;
    }

    // This get method returns the user's available credit.
    public double getAvailableCredit() {
        return availableCredit;
    }

    /*
        This method returns a string consisting of the user type, username and the
        available credit.
    */
    public String toString(){
        return userType + "," + userName + "," + String.valueOf(availableCredit);
    }
}
