package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{

	
	/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		
		return null;
	}
	/** computes the 3D distance (in meters) between the two gps like points */

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		return 0;
	}
	/** computes the 3D vector (in meters) between two gps like points */

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		return null;
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		return null;
	}
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		return false;
	}

}
