import java.util.HashSet;
import java.time.LocalDate;
/**
 * @author Durag Magnet
 * @version 1.0
 * 
 * creates customer class containing all customer and cart information
 */
public class Customer{

    //declares all customer variables

    private String userName;
    private String email;
    private String password;
    private String paymentMethod;
    private String shippingAddress;
    private String postalCode;
    private String billingAddress;
    private double total;
    private double savings;
    private double hst;
    private HashSet<Product> cart;
    private String cartContents = "";

    /**
     * creates inner class for customer invoice
     */
    public class Invoice{

        private String invoiceContents;

        public Invoice(){

            invoiceContents = "On " + LocalDate.now() + ", " + email + " ordered \n" + cartContents + "\n\nfrom INDVSTRYsound2.\n\n" + total + " is to be paid by " + paymentMethod + ".\n\nAll physical products will be shipped to " + shippingAddress + ".\n";

        }

        public void sendInvoice(){

            //mock send invoice to customer email
    
            System.out.println("Invoice sent to: " + email + ".\n");
    
        }
    
        public void readInvoice(){
    
            //prints invoice
    
            System.out.println(invoiceContents);
    
        }

    }

    public Customer(String email, String password, String userName){

        //creates customer account and cart

        this.userName = userName;
        this.email = email;
        this.password = password;
        cart = new HashSet<Product>();

    }

    //buncha getters and setters

    public String getUsername(){

        return userName;
        
    }

    public String getEmail(){

        return email;

    }

    public String getPassword(){

        return password;

    }

    public String getPaymentMethod(){

        return paymentMethod;

    }

    public void setPaymentMethod(String input){

        paymentMethod = input;

    }

    public String getShippingAddress(){

        return shippingAddress;

    }

    public void setShippingAddress(String input){

        shippingAddress = input;

    }

    public String getPostalCode(){

        return postalCode;

    }

    public void setPostalCode(String input){

        postalCode = input;

    }

    public String getBillingAddress(){

        return billingAddress;

    }

    public void setBillingAddress(String input){

        billingAddress = input;

    }

    public double getTotal(){

        //gets total but also rounds it

        total = Math.round(total * 100.00) / 100.00;

        return total;

    }

    public double getSavings(){

        return savings;

    }

    public double getHst(){

        return hst;

    }

    public HashSet<Product> getCart(){

        return cart;

    }

    public void addTax(){

        //adds tax to total

        hst = total * 0.15;
        total = total * 1.15;

    }

    public void resetCart(){

        //resets customers cart

        cart.removeAll(cart);
        total = 0;
        hst = 0;
        cartContents = "";

    }
    
    /**
     * passes in discount code attempts to apply it
    */
    public void applyDiscount(String promoCode){

        if(promoCode.equalsIgnoreCase("PROMO50")){

            total /= 2;
            savings = this.getTotal();

            System.out.println("You saved: " + savings + "!");
    

        } else if (promoCode.equalsIgnoreCase("HOMIE90")){

            savings = this.getTotal() * 0.9;
            total *= 0.1;

            System.out.println("You saved: " + savings + "!");

        } else {

            System.out.println("No discount applied.");

        }

    }

    /**
     * adds user selection to user cart
     * @param product
     */
    public void addSelection(Product product){

        cart.add(product);

        total += product.getPrice() * product.getQuantity();

        System.out.println("\n" + product.getQuantity() + " " + product.getName() + " added to cart!\n");

        System.out.println("Your total is now: " + this.getTotal());

    }

    public boolean isPassword(String password){

        //checks password

        return this.password.equals(password);

    }

    /**
     * adds all products in cart to string and returns string
     * @return
     */
    public String getProductsInCart(){

        for(Product product: cart){

            cartContents += "\n" + product.getQuantity() + " " + product.getName() + "(s)";

        }

        return cartContents;

    }

    public String getCartContents(){

        //retrieves cart contents string

        return cartContents;

    }




    
}
