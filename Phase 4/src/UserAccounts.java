/**
	* Stores all information on user into a file 
	* and retrieves any required information on a user
    * This program creates a file holding information on the user accounts. The file will store account information on
    * the user type, username and available credit.The program allows for quick changes
    * and retrieval of the account information. The back end will apply the daily
    * transactions from the daily transaction file to this file to create a new user account file for next day.
*/
public class UserAccounts {

    public String userType;
    public String userName;
    public float availableCredit;
	
	/**
		* This constructor method sets variables based on the provided arguments.
        * The variables store information on the username, user type and available credit.
	*/
    public UserAccounts(String name, String type, float credit) {
        userName = name;
        userType = type;
        availableCredit = credit;
    }

    /**
    	* Sets the user type
    	* @param type the type the user is being set to
    */
    public void setUserType(String type) {
        userType = type;
    }

    /**
    	* Sets the user name
    	* @param name the name the user is being set to
    */
    public void setUserName(String name) {
        userName = name;
    }

    /**
    	* Sets the user available credit
    	* @param credit the credit the user will have
    */
    public void setAvailableCredit(float credit) {
        availableCredit = credit;
    }

    /**
    	* Removes amount of credit user used to bid on an item
    	* @param bidAmount the amount the user bid
    */
    public void bidItem(float bidAmount) {
        availableCredit -= bidAmount;
    }

    /**
    	* Adds credit to users account based on how much
    	* their item was auctioned for
    	* @param bidAmount the amount the user gets from an auctioned item
    */
    public void advertiseItem(float bidAmount) {
        availableCredit += bidAmount;
    }

<<<<<<< HEAD
    /**
    	* Gets the users type 
    	* @return userType returns user type
    */
=======
    // This get method returns the user account's type.
>>>>>>> 6e5c4eee4f5206bf9bad4561ae8ff567c4a31dc5
    public String getUserType() {
        return userType;
    }

    /**
    	* Gets the users name
    	* @return userName returns users name
    */
    public String getUsername() {
        return userName;
    }

    /**
    	* Gets the amount of credit a user has
    	* @return availableCredit returns credit user has
    */
    public double getAvailableCredit() {
        return availableCredit;
    }

    /**
    	* Converts the user data to a string representation of its self
    	* @return a string representation of the user
    */
    public String toString(){
        return userType + "," + userName + "," + String.valueOf(availableCredit);
    }
}
