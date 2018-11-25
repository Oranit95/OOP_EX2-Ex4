package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{

	@Override
	public Point3D add(Point3D gps, Point3D vector) {
		double y,x,z,lonNorm,EarthR;
		EarthR = 6371000;
		lonNorm = Math.cos((gps.x()*Math.PI)/180);
		x = gps.x()+Math.toDegrees(Math.asin(vector.x()/EarthR));
		y = gps.y()+Math.toDegrees(Math.asin(vector.y()/(EarthR*lonNorm)));
		z = gps.z()+vector.z();
		Point3D gps2 = new Point3D(x,y,z);
		return gps2;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		
		return 0;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}

}
