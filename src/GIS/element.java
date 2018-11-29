package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class element implements GIS_element {
	private Point3D Point;
	private metaData Data;
	private otherData other;

	public element(String mac, String ssid,String authMode, String ftSeen, String channel, String rssi, String lat, String lon, String alt, String accuMeters, String type) {
		Point = new Point3D(lat,lon,alt);
		Data = new metaData(ftSeen);
		other = new otherData(mac,ssid,authMode,channel,rssi,accuMeters,type);
	}
	
	
	@Override
	public Geom_element getGeom() {
		return Point;
	}

	@Override
	public Meta_data getData() {
		return Data;
	}
	
	public otherData getOtherData() {
		return other;
	}

	@Override
	public void translate(Point3D vec) {
		
	}

}
