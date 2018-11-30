package GIS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class layer extends ArrayList<element> {
	private static final long serialVersionUID = 1L;

	private Meta_data data;
	private Date date;


	@SuppressWarnings("deprecation")
	public layer() {
		date = new Date();
		String time = String.valueOf(date.getDate())+"/"+String.valueOf(date.getMonth())+"/"+String.valueOf(date.getYear())+" "+String.valueOf(date.getHours())+":"+String.valueOf(date.getMinutes())+":"+String.valueOf(date.getSeconds());
		data = new metaData(time);
	}

	public Meta_data get_Meta_data() {
		return data;
	}

	public void reader(String path) {
		String csvFile = path;
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{
			while ((line = br.readLine()) != null) 
			{
				String[] data = line.split(",");
				this.add(new element(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10]));	
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
