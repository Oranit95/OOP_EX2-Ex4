package File_format;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csv2km {

    public static void main(String[] args) 
    {
        String csvFile = "WigleWifi_20171201110209.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            while ((line = br.readLine()) != null) 
            {
                String[] userInfo = line.split(cvsSplitBy);	
                System.out.println(line);
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

}
