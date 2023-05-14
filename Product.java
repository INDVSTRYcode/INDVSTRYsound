import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * @author Abdominal Abomination
 * @version 1.0
 * creates class for product 
 */
public class Product{

    //creates instance variables

    protected int quantity;
    protected double price;
    protected String name;
    protected String imageFilePath;

    public Product(String name, double price, String imageFilePath){

        //constructs product and assigns variables

        this.name = name;
        this.price = price;
        this.imageFilePath = imageFilePath;

    }

    /**
     * displays image or product object
     */
    public void preview(){

        var frame = new JFrame();
        var icon = new ImageIcon(this.imageFilePath);
        var label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
            (JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public String getName(){

        //gets product name

        return name;

    }

    public double getPrice(){

        //gets product price

        return price;

    }

    public int getQuantity(){

        //gets customers desired quantity of object

        return quantity;

    }

    public void setQuantity(int quantity){

        //sets desired quantity from customer input

        this.quantity = quantity;

    }



}