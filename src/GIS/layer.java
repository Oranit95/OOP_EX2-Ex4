package GIS;

import java.util.LinkedHashSet;
import java.util.Date;

public class layer extends LinkedHashSet<GIS_element> {
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

}
