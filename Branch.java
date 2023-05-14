import java.util.HashSet;
/**
 * @author Mental Illness
 * @version 1.0
 * 
 * creates the various brances of the marketplace holding different catergories of product
 */

public class Branch {

    //creates branch of store and catalogue of products

    private String name;
    private HashSet<Product> availableProducts;

    public Branch(String name){

        this.name = name;
        availableProducts = new HashSet<Product>();

    }

    public void addProduct(Product product){

        //adds product to hashset

        availableProducts.add(product);

    }

    public String getName(){

        //getter for branch name

        return name;

    }

    /**
     * prints all products in a branches catalougr to screen
     */
    public void listProducts(){

        System.out.println("\nListed below are all available products.\n");

        for (Product product: availableProducts) {

            System.out.println(product.getName() + ", " + product.getPrice() + "\n");

        }

    }

    public HashSet<Product> getAvailableProducts(){

        //getter for product hashset

        return availableProducts;

    }
    

    
}
