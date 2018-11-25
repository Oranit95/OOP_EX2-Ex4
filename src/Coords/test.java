package Coords;

import Geom.Point3D;
public class test {

	public static void main(String[] args) {
	Point3D p0 = new Point3D(32.103315,35.209039,670);
	Point3D p1 = new Point3D(32.106352,35.205225,650);
	Point3D p2 = new Point3D(337.699,-359.249,-20);
	MyCoords test = new MyCoords();
	Point3D ptest=new Point3D( test.vector3D(p0, p1));
	System.out.println(test.distance3d(p0, p1));
	System.out.println(test.isValid_GPS_Point(p1));
	}

}
