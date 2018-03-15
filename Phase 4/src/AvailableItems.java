public class AvailableItems {

    public String itemName;
    public String sellerName;
    public String buyerName;
    public float minBid;
    public int numDays;

    public AvailableItems(String item, String sName, String bName, float bidAmount, int days){
        itemName = item;
        sellerName = sName;
        buyerName = bName;
        minBid = bidAmount;
        numDays = days;
    }

    public void setItemName(String item){
        itemName = item;
    }

    public void setSellerName(String sName){
        sellerName = sName;
    }

    public void setBuyerName(String bName){
        buyerName = bName;
    }

    public void setBidAmount(float bidAmount){
        minBid = bidAmount;
    }

    public void setNumDays(int days){
        numDays = days;
    }


    public String getItemName(){
        return itemName;
    }

    public String getSellerName(){
        return sellerName;
    }

    public String getBuyerName(){
        return buyerName;
    }

    public float getBidAmount(){
        return minBid;
    }

    public int getNumDays(){
        return numDays;
    }


    public String toString(){
        return itemName + "," + sellerName + "," + buyerName + "," + String.valueOf(numDays) + "," + String.valueOf(minBid);
    }
}
