/**
 * @author Jakey McStinkinOnIt
 * @version 420.69
 * creates product superclass
 */
public class ProductX{

    //instance variables denoting price, name, abbreviation, and link

    private double price;
    private String name;
    private String abbreviation;
    private String filePath;
    private int quantity;

    public ProductX(double price, String name, String abbreviation, String filePath){

            //constructor for product, assigns input to instance variables
            
            this.price = price;
            this.name = name;
            this.abbreviation = abbreviation;
            this.filePath = filePath;
            quantity = 0;

    }

    public double getPrice(){

        //retrieves price of product

        return price;

    }

    public String getName(){

        //retrieves products name

        return name;

    }

    public String getAbbreviation(){

        //retrieves products abbreviation

        return abbreviation;

    }

    public String getFilePath(){

        //retrieves products link

        return filePath;

    }

    public void setQuantity(int quan){

        //sets products quantity

        quantity = quan;

    }

    public int getQuantity(){

        //retrieves items quantity

        return quantity;

    }
    
}
