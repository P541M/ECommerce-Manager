package ecommerce;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
    
    //A cart which is a List that holds Products
    private List<Product> cart = new ArrayList<>();

    //Public methods
    public void addProduct(Product item){  //adds a single object of the product to the cart
        cart.add(item);
    }

    public void removeProduct(Product item){
        cart.remove(item);
    }

    //returns true if product is in cart already, false otherwise
    public boolean hasProduct(Product item){
        return (cart.contains(item));
    }

    //returns the total retail cost of the products in the cart, including tax
    public double totalCartPrice(){
        double totalPriceTax = 0;
        for(Product item : cart){
            totalPriceTax += item.getRetailPrice(); //Calls method from Product.java
        }
        return totalPriceTax;
    }

    //returns the total retail cost of products in the cart without tax
    public double beforeTaxPrice(){
        double totalPrice = 0;
        for(Product item : cart){
            totalPrice += item.getCost(); //Calls method from Product.java
        }
        return totalPrice;
    }

    //returns the total cost of the products in the cart, including tax, empties the cart
    public double checkout(){
        double totalDue = totalCartPrice(); //Must save the value before clearing
        cart.clear(); //Clears
        return totalDue; //Returns total
    }

    //returns the number of items in the cart
    public int getCartSize(){
        return cart.size();
    }
    
    /* returns a single String that contains every item in the cart, each on its own line.
     * Product lines must be the same format as specified in the Product to String () method. */
    public String toString(){
        StringBuilder cartContents = new StringBuilder(); //Using SB to alter the string
        for (Product item : cart) {
            cartContents.append(item.toString()).append("\n"); //Calling method from Product.java
        }
        return cartContents.toString(); //Return newly formed string
    }
}

