package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import GIS.*;

public class csv2km {

    public static void main(String[] args) 
    {
    	element gis = new element();
    	ArrayList<String> metaDeta = new ArrayList<String>();
        String csvFile = "WigleWifi_20171201110209.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            while ((line = br.readLine()) != null) 
            {
                String[] userInfo = line.split(cvsSplitBy);	
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
