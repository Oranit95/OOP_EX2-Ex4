package GIS;

import java.util.LinkedHashSet;
import java.util.Date;

public class layer extends LinkedHashSet<GIS_element> {
	private static final long serialVersionUID = 1L;
	
	private Meta_data data;
	private Date date;


	public layer() {
		date = new Date();
		data = new metaData("not yet complete");
	}
	
	public Meta_data get_Meta_data() {
		return data;
	}

}
