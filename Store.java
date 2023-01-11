import java.util.ArrayList;
/**
 * @author @lb3r+ f1$h
 * @version 3
 * creates store object blueprint
 */
public class Store{

    //denotes instance variables such as store name and inventory

    private String name;
    private ArrayList<ProductX> products;

    public Store(String name){

        //creates store object

        this.name = name;
        products = new ArrayList<ProductX>();

    }

    public void listContents(Store store){

        //prints all products in stores inventory to the screen

        System.out.println("\nWelcome to " + store.getStoreName() + ".\n\nListed below are all available products.\n");

        for(ProductX product: products){

            System.out.println(product.getName() + " [" + product.getAbbreviation() + "], {" + product.getPrice() + "}\n");
            
        }



    }

    public String getStoreName(){

        //retrieves store name

        return name;

    }

    public void addProduct(ProductX product){

        //adds product to store inventory

        products.add(product);

    }

    public ArrayList<ProductX> getProductXs(){

        //retrieves inventory of store

        return products;

    }

}