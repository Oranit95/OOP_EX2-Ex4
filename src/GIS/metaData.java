package GIS;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Geom.Point3D;

public class metaData implements Meta_data {
	private String FirstSeen;
	
	public metaData(String ftSeen) {
		FirstSeen = ftSeen;
	}
	public String FirstSeen() {
		return FirstSeen;
	}
	
	/**
	 *  returns the Universal Time Clock associated with this data; 
	 */
	@Override
	public long getUTC() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		long milliseconds = 0;
		try {
			Date d = format.parse(this.FirstSeen);
			format.getCalendar().getTime();
		    milliseconds = d.getTime();
			} catch (ParseException e) {
			e.printStackTrace();
		}
		return milliseconds;
		
	}
	
	public String toString() {
		return FirstSeen;
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}

}
