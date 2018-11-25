package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{
	private static final double EarthR = 6371000;

	/** 
	 * computes a new point which is the gps point transformed by a 3D vector (in meters)
	 */
	@Override
	public Point3D add(Point3D gps, Point3D vector) {
		double y,x,z,lonNorm;
		lonNorm = Math.cos((gps.x()*Math.PI)/180);
		x = gps.x()+Math.toDegrees(Math.asin(vector.x()/EarthR));
		y = gps.y()+Math.toDegrees(Math.asin(vector.y()/(EarthR*lonNorm)));
		z = gps.z()+vector.z();
		Point3D gps2 = new Point3D(x,y,z);
		return gps2;
	}
	/**
	 * computes the 3D distance (in meters) between the two gps like points 
	 */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		Point3D vectorDis = new Point3D(this.vector3D(gps0, gps1));
		return vectorDis.distance3D(vectorDis);
	}
	/**
	 *  computes the 3D vector (in meters) between two gps like points
	 */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double xMeter,yMeter,zMeter,lonNorm;
		lonNorm = Math.cos((gps0.x()*Math.PI)/180);
		xMeter = Math.sin(Math.toRadians(gps1.x()-gps0.x()))*EarthR;
		yMeter = Math.sin(Math.toRadians(gps1.y()-gps0.y()))*EarthR*lonNorm;
		zMeter = gps0.z()-gps1.z();
		Point3D vector = new Point3D(xMeter,yMeter,zMeter); 
		return vector;
	}
	/**
	 * computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 */
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
		if(-90>p.x()||p.x()>90) return false;
		if(-180>p.y()||p.y()>190) return false;
		if(-450>p.z()) return false;
		return true;
	}
}
