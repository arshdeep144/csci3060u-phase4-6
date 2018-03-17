/*
    The AvailableItems class creates a file holding information on the ongoing auctions.

    The file will store auction information on the item name, seller username, bidder username, minimum bid, and number
    of days remaining.

    The program allows for quick changes and retrieval of the auction information.

    The back end will apply the daily transactions from the daily transaction file to this file
    to create a new available items file for next day.
*/

public class AvailableItems {

    public String itemName;
    public String sellerName;
    public String buyerName;
    public float minBid;
    public int numDays;

    /*
        This constructor method sets variables based on the provided arguments.
        The variables store information on the item name, seller username,
        bidder username, minimum bid, and number of days remaining.
    */
    public AvailableItems(String item, String sName, String bName, float bidAmount, int days){
        itemName = item;
        sellerName = sName;
        buyerName = bName;
        minBid = bidAmount;
        numDays = days;
    }

    /**
     * This set method sets the name of the item being auctioned.
     * @param item the item name
     */
    public void setItemName(String item){
        itemName = item;
    }

    /**
     * This set method sets the username of the item's seller.
     * @param sName the seller's name
     */
    public void setSellerName(String sName){
        sellerName = sName;
    }

    /**
     * This set method sets the username of the item's current highest bidder.
     * @param bName the buyer's name
     */
    public void setBuyerName(String bName){
        buyerName = bName;
    }

    /**
     * This set method sets the minimum bid required to bid for the item.
     * @param bidAmount the new bid amount
     */
    public void setBidAmount(float bidAmount){
        minBid = bidAmount;
    }

    /**
     * This set method sets the number of days that the auction will last for.
     * @param days the number of days left to auction item
     */
    public void setNumDays(int days){
        numDays = days;
    }

    /**
     * This get method returns the name of the item being auctioned.
     * @return returns the item name
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * This get method returns the username of the item's seller.
     * @return returns seller's name
     */
    public String getSellerName(){
        return sellerName;
    }

    /**
     * This get method returns the username of the item's current highest bidder.
     * @return returns buyer's name
     */
    public String getBuyerName(){
        return buyerName;
    }

    /**
     * This get method returns the minimum bid amount required for the item.
     * @return return's minimum bid amount
     */
    public float getBidAmount(){
        return minBid;
    }

    /**
     * This get method returns the number of remaining days of the bid.
     * @return returns number of days left in auction
     */
    public int getNumDays(){
        return numDays;
    }

    /*
        This method returns a string consisting of the item name, seller username,
        bidder username, number of days remaining, and minimum bid.
    */
    public String toString(){
        return itemName + " " + sellerName + " " + buyerName + " " + String.valueOf(numDays) + " " + String.valueOf(minBid);
    }
}