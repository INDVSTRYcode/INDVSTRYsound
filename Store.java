import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
/**
 * @author Radical Republican
 * @version 1.0
 * 
 * creates main store method performing all the djanky businessi
 */
public class Store {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)throws UnsupportedAudioFileException,
    IOException, LineUnavailableException{

        //buncha instance variables

        Customer activeUser = null;
        Branch instrumentals = new Branch("Instrumentals");
        Branch loops = new Branch("Loops");
        Branch lessons = new Branch("Lessons");
        Branch engineering = new Branch("Engineering");
        Branch sessions = new Branch("Sessions");
        Branch software = new Branch("Software");
        Branch merch = new Branch("Merchandise");
        Branch dropshippingCatalouge = new Branch("Gear");
        Product beginnerDrumLessons = new Product("Beginner Drum Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product intermediateDrumLessons = new Product("Intermediate Drum Lessons", 30.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product beginnerGuitarLessons = new Product("Beginner Guitar Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product beginnerPianoLessons = new Product("Beginner Piano Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product beginnerBassLessons = new Product("Beginner Bass Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product beginnerProductionLessons = new Product("Beginner Production Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product beginnerEngineeringLessons = new Product("Beginner Engineering Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product songwritingLessons = new Product("Songwriting Lessons", 20.00, "Pics/Screen Shot 2023-01-17 at 10.31.18 AM.png");
        Product dropshippedItem = new Product("Dropshipped Gear", 0.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        Product sxlxceHoodie = new Product("Sxlxce Hoodie", 60.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        Product sxlxceTee = new Product("Sxlxce Tee", 30.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        Product sxlxceBeanie = new Product("Sxlxce Beanie", 30.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        Product sxlxcePoster = new Product("Sxlxce Poster", 15.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        Product sxlxceStickers = new Product("Sxlxce Stickers", 5.00, "Pics/Screen Shot 2023-01-17 at 10.45.37 AM.png");
        AudioProduct livePerformance = new AudioProduct("Live Performance", 400.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct songLyrics = new AudioProduct("Song Lyrics", 50.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct sxlxceFilterApp = new AudioProduct("Sxlxce Filter", 0.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct XUULII = new AudioProduct("XUUL II", 40.00, "Pics/1-tondals-vision-hieronymus-bosch copy.jpg", "Tracks/XUUL II (DXNZY CUT) copy.wav");
        AudioProduct sxlxceLoopkit = new AudioProduct("Sxlxce Loopkit", 40.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct instrumentSession = new AudioProduct("Session Performance", 100.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct vocalSession = new AudioProduct("Vocal Feature", 100.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct mixMaster = new AudioProduct("Mix & Master", 100.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");
        AudioProduct customProduction = new AudioProduct("Custom Production", 300.00, "Pics/LogoX.png", "Tracks/bandalicious copy.wav");

        //hashsets holding customers and branches
        HashSet<Customer> userDatabase = new HashSet<Customer>();
        HashSet<Branch> marketplace = new HashSet<Branch>();

        //adds branches to store
        marketplace.add(dropshippingCatalouge);
        marketplace.add(loops);
        marketplace.add(instrumentals);
        marketplace.add(sessions);
        marketplace.add(software);
        marketplace.add(lessons);
        marketplace.add(merch);
        marketplace.add(engineering);

        //adds products to branches
        dropshippingCatalouge.addProduct(dropshippedItem);
        loops.addProduct(sxlxceLoopkit);
        instrumentals.addProduct(XUULII);
        sessions.addProduct(instrumentSession);
        sessions.addProduct(vocalSession);
        sessions.addProduct(customProduction);
        sessions.addProduct(livePerformance);
        sessions.addProduct(songLyrics);
        software.addProduct(sxlxceFilterApp);
        lessons.addProduct(beginnerBassLessons);
        lessons.addProduct(beginnerEngineeringLessons);
        lessons.addProduct(beginnerGuitarLessons);
        lessons.addProduct(beginnerPianoLessons);
        lessons.addProduct(beginnerProductionLessons);
        lessons.addProduct(beginnerDrumLessons);
        lessons.addProduct(intermediateDrumLessons);
        lessons.addProduct(songwritingLessons);
        merch.addProduct(sxlxceBeanie);
        merch.addProduct(sxlxceHoodie);
        merch.addProduct(sxlxceStickers);
        merch.addProduct(sxlxcePoster);
        merch.addProduct(sxlxceTee);
        engineering.addProduct(mixMaster);

        //instance variables for running main method

        String temp, temp2, temp3;

        int j = 2;

        boolean keepGoingLogin = true;

        boolean keepGoingBranchSelect, keepGoingProductSelect, keepGoingQuantitySelect;

        boolean keepGoingCheckOut = false;

        AccountManager.read(userDatabase);

        System.out.println("\nWelcome to the INDVSTRYsound Martketplace.");

        //iniates login loop

        login:

        while (keepGoingLogin) {

            System.out.println("\nPlease enter 'login' to login or 'register' to register.\n\nEnter anything else to continue as guest.\n");

            temp = sc.nextLine();

            keepGoingBranchSelect = true;

            if (temp.equalsIgnoreCase("login")) { 

                //attempts to login

                System.out.println("\nPlease enter your email or username\n");

                temp = sc.nextLine();

                for (Customer user: userDatabase) {

                    if (user.getEmail().equalsIgnoreCase(temp) || user.getUsername().equalsIgnoreCase(temp)){

                        //if input matches email in database, atempt password

                        j = 2;

                        for (j = 2; j != -1; j--){

                            //3 password attemps

                            System.out.println("\nPlease enter your password.\n");

                            temp = sc.nextLine();

                            if (user.getPassword().equals(temp)) {

                                //logs user in

                                activeUser = user;

                                System.out.println("\nWelcome back " + activeUser.getUsername());

                                break;
                            
                            } else {

                                System.out.println("\nIncorrect password. You have " + j + " attempts remaining.");

                            }

                        }

                        if (activeUser == null && j == -1){

                            //if user cant remember password

                            System.out.println("\nEntering marketplace as guest.");

                            for (Customer customer: userDatabase){

                                if (customer.getUsername().equalsIgnoreCase("guest")) activeUser = customer;
                            }

                        }

                    } 

                }

                if (activeUser == null && j == 2){

                    //if email was foriegn sign in as guest

                    System.out.println("\nEmail/Username not recognized.\n\nEntering marketplace as guest.");

                    for (Customer customer: userDatabase){

                        if (customer.getUsername().equalsIgnoreCase("guest")) activeUser = customer;
                    }

                }

            } else if (temp.equalsIgnoreCase("register")){

                //attemps to register

                System.out.println("\nPlease enter your email.\n");

                temp = sc.nextLine();

                for (Customer user: userDatabase) {

                    if (temp.equalsIgnoreCase(user.getEmail())) {

                        //if email input is already in database, reset

                        System.out.println("\nEmail already registered.");
                        
                        continue login;

                    }

                }

                System.out.println("\nPlease enter your password.\n");

                temp2 = sc.nextLine();

                System.out.println("\nPlease enter your username.\n");

                temp3 = sc.nextLine();

                Customer newUser = new Customer(temp, temp2, temp3);

                userDatabase.add(newUser);

                AccountManager.write(userDatabase);

                activeUser = newUser;

                //creates new user with given data
                
                System.out.println("\nWelcome " + activeUser.getUsername());

            } else {

                //user choice to assume guest

                System.out.println("\nEntering marketplace as guest");

                for (Customer customer: userDatabase){

                    if (customer.getUsername().equalsIgnoreCase("guest")) activeUser = customer;
                }

            }

            branchSelect:

            while (keepGoingBranchSelect){

                //iniates branch select loop

                keepGoingProductSelect = true;

                System.out.println("\nPlease enter the name of which branch you'd like to shop with today.\n\nOr enter 'Checkout' to checkout.\n");

                for (Branch branch: marketplace){

                    //lists branches

                    System.out.println(branch.getName() + "\n");

                } 
                
                temp = sc.nextLine();

                for (Branch branch: marketplace) {

                    if (temp.equalsIgnoreCase(branch.getName())){

                        //chooses branch based on input

                        System.out.println("\nWelcome to " + branch.getName());

                        productSelect:

                        while (keepGoingProductSelect) {

                            temp = "";

                            //initiates product select loop

                            keepGoingQuantitySelect = true;

                            branch.listProducts();

                            System.out.println("Please enter the name of your desired product to add to cart.\n\nEnter 'Preview ProductName' to preview product.\n\nEnter anything else to return to branch menu.\n");
                            
                            temp = sc.nextLine();

                            for (Product product: branch.getAvailableProducts()){

                                if(temp.equalsIgnoreCase("Preview " + product.getName())) {

                                    product.preview();

                                    System.out.println("\nRefreshing menu...");

                                    continue productSelect;
                                    
                                }

                               if (temp.equalsIgnoreCase(product.getName())) {

                                    //loops through products in branch attempting to match user input

                                    while(keepGoingQuantitySelect) {

                                        //initiates quantity select loop

                                        System.out.println("\nPlease enter the quantity of product you'd like to purchase.\n");

                                        temp = sc.nextLine();

                                        try {

                                            //attemps to convert user input into quantity selection

                                            j = Integer.parseInt(temp);

                                            product.setQuantity(j);

                                            activeUser.addSelection(product);

                                            keepGoingQuantitySelect = false;

                                            //adds selection and provides choices for continuation

                                            System.out.println("\nEnter YES to keep shopping with this branch.\n\nEnter CHECKOUT to check out.\n\nOr enter anything else to return to the menu.\n");

                                            temp = sc.nextLine();

                                            if (temp.equalsIgnoreCase("yes")) {

                                                //if user stays in branch, skip back to product select loop
                                                
                                                continue productSelect;

                                            } else if (temp.equalsIgnoreCase("checkout")) {

                                                //if user wants to check out, break product select loop and initiate checkout

                                                keepGoingProductSelect = false;

                                                keepGoingCheckOut = true;

                                                continue;

                                            } else {

                                                //else returns to branch select

                                                keepGoingProductSelect = false;

                                                continue branchSelect;

                                            }

                                        } catch  (Exception e) {

                                            //catches string input for quantity input

                                            System.out.println("\nInvalid Entry.");

                                        }
                                    
                                    }        

                                } 

                            } if (keepGoingQuantitySelect) {

                               continue branchSelect; //if user wanted to return to branch select
                            
                            }

                        }

                    }

                } if (keepGoingProductSelect && !temp.equalsIgnoreCase("checkout")) {
                    
                    System.out.println("\nInvalid entry"); //if user entered non-existent branch
                
                 } else if (temp.equalsIgnoreCase("checkout") && activeUser.getCart().isEmpty()){

                    System.out.println("\nCart is empty.");

                    continue branchSelect;

                 } else if (temp.equalsIgnoreCase("checkout") && !activeUser.getCart().isEmpty()) {

                    keepGoingCheckOut = true;

                }

                if (keepGoingCheckOut){

                    //initiates checkout
                    
                    activeUser.addTax();

                    System.out.println("\nIn your cart is:\n" + activeUser.getProductsInCart());

                    System.out.println("\nYour total comes to: " + activeUser.getTotal() + " after taxes.");  //lets user know just what precisely is happening in these streets

                    System.out.println("\nPlease enter your shipping address for physical products.\n");

                    temp = sc.nextLine();

                    activeUser.setShippingAddress(temp);

                    System.out.println("\nNow please enter you desired billing address.\n\nOr enter 'SAME' if it is the same as your billing address.\n");

                    temp = sc.nextLine();

                    if (temp.equalsIgnoreCase("same")){

                        activeUser.setBillingAddress(activeUser.getShippingAddress());

                    } else {

                        activeUser.setBillingAddress(temp);

                    }

                    System.out.println("\nNow please enter your postal code\n");

                    temp = sc.nextLine();

                    activeUser.setPostalCode(temp);

                    System.out.println("\nNow please enter your desired method of payment\n");

                    temp = sc.nextLine();

                    activeUser.setPaymentMethod(temp);

                    //gets all of user info

                    System.out.println("\nCard was declined.\n"); //troll

                    Customer.Invoice invoice0 = activeUser.new Invoice(); //creates invoice

                    invoice0.sendInvoice();

                    invoice0.readInvoice(); //prints invoice to screen

                    System.out.println("If you'd like to make another purchase, enter 'SHOP'.\n\nIf you'd like to sign out, enter 'OUT'.\n\nEnter anything else to exit.\n");

                    temp = sc.nextLine(); //presents options
                    
                    if (temp.equalsIgnoreCase("OUT")){

                        keepGoingBranchSelect = false;

                        activeUser.resetCart();

                        j = 2;

                        //breaks branch select loop returning to login loop, resets cart as well

                    } else if (temp.equalsIgnoreCase("shop")){

                        keepGoingCheckOut = false;

                        activeUser.resetCart();

                        j = 2;

                        continue;

                        //resets cart and returns to branch select loop

                    } else {

                        //quits

                        keepGoingBranchSelect = false;

                        keepGoingLogin = false;

                    }

                }

            }
        
        }   sc.close(); //byebye

    }

    public static int getChoice(){

        System.out.println("\n1. pause\n");
        System.out.println("2. resume\n");
        System.out.println("3. restart\n");
        System.out.println("4. stop\n");
        System.out.println("5. Jump to specific time\n");

        int tempInt = sc.nextInt();

        sc.nextLine();

        return tempInt;

    }

    public static void gotoChoice(int c, AudioProduct song)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException 
    {
        switch (c) 
        {
            case 1:
                song.pause();
                break;
            case 2:
                song.resumeAudio();
                break;
            case 3:
                song.restart();
                break;
            case 4:
                song.stop();
                break;
            case 5:
                System.out.println("Enter time (" + 0 + 
                ", " + song.getClip().getMicrosecondLength() + ")\n");
                long c1 = sc.nextLong();
                song.jump(c1);
                sc.close();
                break;
      
        }
      
    }
    
}