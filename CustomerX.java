import java.util.HashSet;
import java.lang.Math;
/**
 * @author Jared KeepsFlippinEm
 * @version 69.42
 * makes a customer account class
 */
public class CustomerX{

    //creates instance variables for the customer account object

    private String email;
    private String password;
    private String paymentMethod;
    private HashSet<ProductX> cart;
    private double total;
    private double savings;
    private String cartContents;

    public CustomerX(String email, String password){

        //assigns input to it's respective instance variables
        //as well as creating a cart and total

        this.email = email;
        this.password = password;
        cart = new HashSet<ProductX>();
        total = 0;

    }

    public double getTotal(){

        //retrieves total 

        total = Math.round(total * 100.0) / 100.0;

        return total;

    }

    public void addTax(){

        total *= 1.15;

    }

    public void addDiscount(String discountInput){

        if(discountInput.equalsIgnoreCase("PROMO50")){

            savings = total / 2;

            total /= 2;

            System.out.println("\nYou saved " + savings + "!");

        } else if(discountInput.equalsIgnoreCase("HOMIE90")){

            savings = total * 0.9;

            total *= 0.1;

            System.out.println("\nYou saved " + savings + "!");

        } else {

            System.out.println("\nNo discount provided.");

        }

    }

    public void addSelection(ProductX product){

        //adds user selection the accounts cart
        //as well as adding the products price to the running total

        cart.add(product);

        total += product.getPrice() * product.getQuantity();

        System.out.println("\n" + product.getQuantity() + " " + product.getName() + " added to cart.\n");

        System.out.println("Your current total is at " + total);

    }

    public String getEmail(){
        
        //retrieves customer email

        return email;

    }

    public boolean isPassword(String passwordCheck){

        //checks if user input is equal to user password and returns a boolean value

        return password.equals(passwordCheck);

    }

    public String getPaymentMethod(){

        //retrieve payment method

        return paymentMethod;

    }

    public void setPaymentMethod(String input){

        //sets payment method

        paymentMethod = input;

    }

    public String getProductsinCart(){

        //returns a string containing the contents of a customers cart

        cartContents = "\n";

       for (ProductX product: cart){

            cartContents += product.getQuantity() + " " + product.getName() + "\n\n";

        }

        return cartContents;

    }



}