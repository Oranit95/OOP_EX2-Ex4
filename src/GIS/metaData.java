package GIS;

import Geom.Point3D;

public class metaData implements Meta_data {
	private String FirstSeen;
	
	public metaData(String ftSeen) {
		FirstSeen = ftSeen;
	}
	
	public String MAC() {
		return MAC;
	}
	public String SSID() {
		return SSID;
	}
	public String AuthMode() {
		return AuthMode;
	}
	public String FirstSeen() {
		return FirstSeen;
	}
	public String Channel() {
		return Channel;
	}
	public String RSSI() {
		return RSSI;
	}
	public String AccuracyMeters() {
		return AccuracyMeters;
	}
	public String Type() {
		return Type;
	}
	
	/**
	 *  returns the Universal Time Clock associated with this data; 
	 */
	@Override
	public long getUTC() {
		
		return 0;
	}
	
	public String toString() {
		return this.MAC()+" "+this.SSID()+" "+this.AuthMode()+" "+this.FirstSeen()+" "+this.Channel()+" "+this.RSSI()+" "+this.AccuracyMeters()+" "+this.Type();
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
