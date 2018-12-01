package GIS;

import java.util.ArrayList;
import java.util.Date;

public class project extends ArrayList<layer> implements GIS_project {
	private Meta_data data;
	private Date date;
	private layer layer;


	@SuppressWarnings("deprecation")
	public project() {
		date = new Date();
		String time = String.valueOf(date.getDate())+"/"+String.valueOf(date.getMonth())+"/"+String.valueOf(date.getYear())+" "+String.valueOf(date.getHours())+":"+String.valueOf(date.getMinutes())+":"+String.valueOf(date.getSeconds());
		data = new metaData(time);
		layer = new layer();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Meta_data get_Meta_data() {
		return data;
	}

	public layer getLayer() {
		return layer;
	}

}
