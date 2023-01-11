import java.util.HashSet;
import java.util.Scanner;
/**
 * @author Poop@$$
 * version 1943
 * @main method store system
 */
public class StoreSystem{

    //all variables and methods are static as an object will never be made of this class

    private static String emailInput;
    private static String passwordInput;
    private static String paymentMethodInput; //strings for the user imputs
    private static String selectionInput;
    private static int quantityInput;
    private static HashSet<CustomerX> customerAccs;
    private static HashSet<Store> marketplace;
    static int temp;
    static int temp2;
    static String temp3, temp4; //creates temporary variables
    static boolean keepG;
    static boolean maybe;
    static CustomerX ActiveUser; //creates customer that takes on the role and attributes of active user
    static Invoice invoice0;
    static Scanner sc;

    public static void main(String[] args){

        //creates products, stores, customer accs, and adds objects to their respective sets

        sc = new Scanner(System.in); //creates scanner

        customerAccs = new HashSet<CustomerX>();

        marketplace = new HashSet<Store>(); //creates sets for customer accounts and stores in the market

        ProductX LivePerformance = new ProductX(499.99, "Live Performance(s)", "PER", "gig.youtube");
        ProductX SessionPerformance = new ProductX(249.99, "Session Performance(s)", "SES", "session.youtube");
        ProductX GhostProduction = new ProductX(399.99, "Entire Production(s)", "PRO", "ghost.youtube");

        ProductX Beat0 = new ProductX(99.99, "PLUGGNB2022", "PNB", "indvstry.ca");
        ProductX Beat1 = new ProductX(99.99, "XUUL III", "III", "indvstry.ca");
        ProductX Beat2 = new ProductX(99.99, "Custom Instrumental(s)", "CUS", "indvstry.ca");

        ProductX Mix = new ProductX(99.99, "Mix(es)", "MIX", "wellMixedSong.youtube");
        ProductX Print = new ProductX(29.99, "INDV$TRYsound Logo Print(s)", "LOG", "print.JPG");
        ProductX Stickers = new ProductX(19.99, "INDV$TRYsound Stickers (2)", "STK", "stickers.JPG");

        ProductX Beanie = new ProductX(39.99, "Solace Beanie(s)", "BIE", "beanie.jpg");
        ProductX Hoodie = new ProductX(59.99, "Solace Hoodie(s)", "HDI", "hoodie.jpg");
        ProductX Jeans = new ProductX(79.99, "Solace Jeans", "JNS", "jeans.jpg");

        CustomerX sudo = new CustomerX("sudo@ninemail.stink", "12345678");
        CustomerX guest = new CustomerX("cuddling@atyourplace.rn?", "onedeuxsanfourcinqrokusevenhuit");

        StoreSystem.addCustomerAcc(sudo);
        StoreSystem.addCustomerAcc(guest);

        Store XXX = new Store("nameTBD");
        Store Beats = new Store("INDV$TRYbeats");
        Store Sound = new Store("INDV$TRYsound");
        Store TSP = new Store("thesolaceproject");

        marketplace.add(XXX);
        marketplace.add(Beats);
        marketplace.add(Sound);
        marketplace.add(TSP);

        XXX.addProduct(LivePerformance);
        XXX.addProduct(SessionPerformance);
        XXX.addProduct(GhostProduction);

        Beats.addProduct(Beat0);
        Beats.addProduct(Beat1);
        Beats.addProduct(Beat2);

        Sound.addProduct(Mix);
        Sound.addProduct(Print);
        Sound.addProduct(Stickers);

        TSP.addProduct(Beanie);
        TSP.addProduct(Hoodie);
        TSP.addProduct(Jeans);

        StoreSystem.choice0(); //presents choice of logging in or registering

        if(temp2 == 0){

            StoreSystem.setEmailInput();
            StoreSystem.setPasswordInput(); 
            
            CustomerX NewUser = new CustomerX(emailInput, passwordInput); //creates user acc based off user input

            StoreSystem.addCustomerAcc(NewUser); //adds new user to acc set

            ActiveUser = NewUser; //sets newly created user to active user

        }

        else {

            StoreSystem.setEmailInput();
            StoreSystem.setPasswordInput(); //doesnt work due to novice code

            for(CustomerX customer: customerAccs){ //matches input to existing account if applicable

                if(emailInput.equals(customer.getEmail()) && customer.isPassword(passwordInput) == true){ //if email and passwords match

                    ActiveUser = customer; //sets match to active user

                    maybe = true;

                    System.out.println("\nWelcome back " + ActiveUser.getEmail() + "\n");

                }

            }

            if(!maybe){ //if account wasnt found, login as guest
                
                System.out.println("\nAccount does not exist.\n\nEntering marketplace as guest.");

                ActiveUser = guest;
            
            }

        }

        while(keepG == true){ //loops shopping until user is done

            temp2 = StoreSystem.choice1(); //picks which store to shop at

            switch(temp2){

                case 0: XXX.listContents(XXX); //main store 

                    StoreSystem.getXInput(XXX, ActiveUser); //gets selection

                    break;
                
                case 1: Beats.listContents(Beats); //beatstore

                    StoreSystem.getXInput(Beats, ActiveUser); //gets selection

                    break;
                
                case 2: Sound.listContents(Sound); //AE store

                    StoreSystem.getXInput(Sound, ActiveUser); //gets selection

                    break;

                case 3: TSP.listContents(TSP); //TSP

                    StoreSystem.getXInput(TSP, ActiveUser); //gets selection

                    break;
                
                default: System.out.println("\n*invalid entry*");

                    continue;

            }

             keepG = StoreSystem.choice2(); //asks user if they want to continue or checkout

             if(!keepG) break;

        }

        StoreSystem.setPaymentMethodInput(); 

        ActiveUser.setPaymentMethod(paymentMethodInput); //sets user pyment method

        ActiveUser.addDiscount(StoreSystem.setDiscountInput());

        ActiveUser.addTax();

        invoice0 = new Invoice(ActiveUser); //creates invoice

        invoice0.sendInvoice(ActiveUser.getEmail());

        invoice0.readInvoice();

        System.out.println("\nThanks for shopping at the 業界の音 marketplace.\n"); //bye

    }

    public static void choice0(){

        //presents choice to login or register

        keepG = true;

        System.out.println("\nHello user, please login or register to access the 業界の音 marketplace.\n");

        while(keepG == true){

            System.out.println("Enter 0 to register or enter 1 to login.\n");
                
            temp3 = sc.nextLine();

            try{

                temp = Integer.parseInt(temp3);

            } catch(Exception e){
                
                System.out.println("\n*invalid entry*\n");
                
                continue;

            }

            if(temp == 0){
                temp2 = 0;
                break;
            }

            else if(temp == 1){
                temp2 = 1;
                break;
            }
    
            else {
                System.out.println("\n*invalid entry*\n");
            }

        }

    }

    public static int choice1(){

        //presents options of which store to shop at

        System.out.println("\nWelcome to 業界の音.");

        keepG = true;

        while(keepG == true){

            System.out.println("\nEnter 0 for *nameTBD*.\n\nEnter 1 for INDV$TRYbeats.\n\nEnter 2 for INDV$TRYsound.\n\nEnter 3 for thesolaceproject.\n");

            temp3 = sc.nextLine();
            
            try{

                temp = Integer.parseInt(temp3);

            } catch(Exception e){

                System.out.println("\n*invalid entry*");

                continue;

            }

            break;
        
        }

        return temp;

    }

    public static boolean choice2(){

        //presents option to keep shopping or checkout

        System.out.println("\nEnter 4 to make another selection.\n\nEnter anything else to check out.\n");

        temp3 = sc.nextLine();

        if(temp3.equals("4")){

            return true;

        } else {

            return false;

        }


    }

    public static String setDiscountInput(){

        System.out.println("\nPlease enter a coupon code if you apply for one.\n");

        temp3 = sc.nextLine();

        return temp3;

    }

    public static void setEmailInput(){

        //gets input for user email

        System.out.println("\nPlease enter your email\n");

        emailInput = sc.nextLine();

    }

    public static void setPasswordInput(){

        //gets user input for passwrd

        System.out.println("\nPlease enter your password\n");

        passwordInput = sc.nextLine();

    }

    public static void setPaymentMethodInput(){

        //gets input for payment method

        System.out.println("\nPlease enter your desired method of payment.\n");

        paymentMethodInput = sc.nextLine();

    }

    public static void addCustomerAcc(CustomerX customer){

        //adds customer acc to set of customer accs

        customerAccs.add(customer);

    }

    public static HashSet<CustomerX> getCustomerAccs(){

        //retrieves set of customer accs

        return customerAccs;
        
    }

    public static void getXInput(Store store, CustomerX customer){

        //gets user selection and adds it to user cart

        maybe = false;

        System.out.println("Please enter the abbreviation of your selection\n");

        selectionInput = sc.nextLine();

        for(ProductX product: store.getProductXs()){

            if(selectionInput.toUpperCase().equals(product.getAbbreviation())){

                System.out.println("\nNow please enter the quantity of the item you'd like to purchase\n");

                temp4 = sc.nextLine();

                try{

                    quantityInput = Integer.parseInt(temp4);
    
                } catch(Exception e){
    
                    continue;
    
                }

                product.setQuantity(product.getQuantity() + quantityInput);
                customer.addSelection(product);
                maybe = true;
       
            }

        }

        if(!maybe) {
            
            System.out.println("\n*invalid entry*\n");

            StoreSystem.getXInput(store, customer);

        }

    }

}