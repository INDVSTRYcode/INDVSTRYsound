import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
/**
 * @author jinky
 * @version 1.0
 * creates csv class
 */
public class AccountManager{

    public static void read(HashSet<Customer> userDatabase)throws IOException{

    int x;

    final String COMMA_DELIMITER = ",";

    List<List<String>> csv = new ArrayList<>();

        //extract data from CSV
        
        try (BufferedReader br = new BufferedReader(new FileReader("CSV.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.replace("\"", "").split(COMMA_DELIMITER);
                csv.add(Arrays.asList(values));
            }

        }

        x = 0;

        while (csv.size() > x) {

            //input extracted csv data into User Database HashSet

            userDatabase.add(new Customer(csv.get(x).get(0), csv.get(x).get(1),csv.get(x).get(2)));

            x++;

        }

    }

    public static void write(HashSet<Customer> userDatabase)throws IOException{

        FileWriter fileWriter = new FileWriter("CSV.csv");

            ArrayList<String[]> customers = new ArrayList<String[]>();
            
            for(Customer user: userDatabase) {

                //extract data from User Data Userbase HashSet

                String[] tempArr = {user.getEmail(), user.getPassword(), user.getUsername()};
                    
                customers.add(tempArr);

            }

            for (String[] data : customers) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < data.length; i++) {
                    line.append("\"");
                    line.append(data[i].replaceAll("\"","\"\""));
                    line.append("\"");
                    if (i != data.length - 1) {
                        line.append(',');
                    }
                }

                //write data back to CSV

                line.append("\n");
                fileWriter.write(line.toString());

            }

            fileWriter.close();
    }
    

}