public class UserAccounts {

    public String userType;
    public String userName;
    public float availableCredit;

    public UserAccounts(String name, String type, float credit) {
        userName = name;
        userType = type;
        availableCredit = credit;
    }

    public void setUserType(String type) {
        userType = type;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public void setAvailableCredit(float credit) {
        availableCredit = credit;
    }

    public void bidItem(float bidAmount) {
        availableCredit -= bidAmount;
    }

    public void advertiseItem(float bidAmount) {
        availableCredit += bidAmount;
    }

    public String getUserType() {
        return userType;
    }

    public String getUsername() {
        return userName;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public String toString(){
        return userType + "," + userName + "," + String.valueOf(availableCredit);
    }
}
