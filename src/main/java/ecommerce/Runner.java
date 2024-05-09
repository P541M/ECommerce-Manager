package ecommerce;

public class Runner {
    public static void main(String[] args){
        // Creating some product instances
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();

        Product.setTaxRate(0.25); //Sets the tax rate to 25% for this whole cart

        product1.setProductId(1);
        product1.setName("Apple Juice");
        product1.setCost(7.99);
        product1.setMarkUp(0.15); // 15% markup
        product1.getRetailPrice(); //Must call to set the retail price

        product2.setProductId(2);
        product2.setName("Cheesecake");
        product2.setCost(12.75);
        product2.setMarkUp(0.20); // 20% markup
        product2.getRetailPrice(); //Must call to set the retail price

        product3.setProductId(225);
        product3.setName("Toothbrush");
        product3.setCost(5.99);
        product3.setMarkUp(0.10); // 10% markup
        product3.getRetailPrice(); //Must call to set the retail price

        product4.setProductId(4);
        product4.setName("Sponges");
        product4.setCost(3.99);
        product4.setMarkUp(0.05); // 5% markup
        product4.getRetailPrice(); //Must call to set the retail price

        product5.setProductId(50);
        product5.setName("Cups");
        product5.setCost(2.55);
        product5.setMarkUp(0.20); // 20% markup
        product5.getRetailPrice(); //Must call to set the retail price

        //Testing getters for Product.java
        System.out.println("Product 3 ID: " + product3.getProductId()); //getProductId (should return 225)
        System.out.println("Product 3 name: " + product3.getName()); //getName
        System.out.println("Product 3 cost: " + product3.getCost()); //getCost
        System.out.println("Product 3 markup rate: " + product3.getMarkupRate()); //getMarkupRate
        System.out.println("Tax rate: " + Product.getTaxRate()); //getTaxRate

        System.out.print("\n");

        //Creating cart instance
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1); //adding the products
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);
        //Not adding product 5 to test

        //Testing the getCartSize method
        System.out.println("Cart Size: " + cart.getCartSize());

        System.out.print("\n");

        //Testing the hasProduct method (Should print out false)
        System.out.println("Does this cart have product 5: " + cart.hasProduct(product5));

        //Now we add it
        cart.addProduct(product5);

        //Testing the hasProduct method (Should print out true)
        System.out.println("Does this cart have product 5 (After adding): " + cart.hasProduct(product5));

        System.out.print("\n");

        //Testing the toString method (with added 5)
        System.out.println("Cart Contents:");
        System.out.println(cart.toString());

        //Testing the removeProduct method
        cart.removeProduct(product5);

        //Testing the hasProduct method (Should print out false)
        System.out.println("Does this cart have product 5 (After removing): " + cart.hasProduct(product5));

        System.out.print("\n");

        //Testing the toString method (After removed 5)
        System.out.println("Cart Contents:");
        System.out.println(cart.toString());

        //Testing beforeTaxPrice & totalCartPrice method
        double totalBeforeTax = cart.beforeTaxPrice();
        double totalCartPrice = cart.totalCartPrice();

        //Testing checkout method
        double totalDue = cart.checkout();

        System.out.println("Total Before Tax: $" + totalBeforeTax);
        System.out.println("Total Cart Price (with tax): $" + totalCartPrice);
        System.out.println("Total Due (after checkout): $" + totalDue);

        System.out.print("\n");

        //Testing toString one more time (IT SHOULD BE EMPTY)
        System.out.println("Cart Contents:");
        System.out.println(cart.toString());
    }
}