package ecommerce;

public class Product{

    private int productId; //For setProductId
    private String productName; //For setName
    private double productCost; //For setCode
    private static double productTaxRate; //For setTaxRate
    private double productMarkUp; //For setMarkUp
    private double calculatedRPrice; //For getRetailPrice

    //Setter for the ID of the product
    public void setProductId(int givenId){
        productId = givenId;
    }

    //Setter for the name of the product
    public void setName(String givenName){
        productName = givenName.trim();
    }

    //Setter for the cost of the product
    public void setCost(double givenCost){
        productCost = givenCost;
    }

    /* parameter is between 0 and 1
     * values outside this range should be ignored and a default
     * value of .25 used */
    public void setMarkUp(double givenMarkUp){
        if(givenMarkUp > 0 && givenMarkUp < 1){
            productMarkUp = givenMarkUp;
        }else{
            productMarkUp = 0.25;
        }
    }

    /* parameter is between 0 and 1.
     * values outside this range should be ignored and a default
     * value of .13 used */
    static void setTaxRate(double givenRate){
        if(givenRate > 0 && givenRate < 1){
            productTaxRate = givenRate;
        }else{
            productTaxRate = 0.13;
        }
    }

    //Getter for the ID of the product
    public int getProductId(){
        return productId;
    }

    //Getter for the name of the product
    public String getName(){
        return productName;
    }
    
    //Getter for the wholesale cost of the item
    public double getCost(){
        return productCost;
    }

    //Getter for the markup as a decimal between 0 and 1
    public double getMarkupRate(){
        return productMarkUp;
    }
    
    /* returns the retail price for the item
     * retail price = (wholesaleCost * (1 + markup)) * (1 + taxRate) */
    public double getRetailPrice(){
        calculatedRPrice = (productCost * (1 + productMarkUp) * (1 + productTaxRate));
        return calculatedRPrice;
    }

    /* static method to return the tax rate
     * returns the tax rate as a decimal between 0 and 1 */
    public static double getTaxRate(){
        return productTaxRate;
    }

    /* returns a string consisting of the item name, a colon, 
     * a space, and the retail price of the item 
     * rounded to 2 decimal points */
    public String toString(){
        String formattedPrice = String.format("%.2f", calculatedRPrice);
        return productName + ": " + formattedPrice;
    }
}
