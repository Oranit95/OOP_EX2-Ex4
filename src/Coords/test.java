package Coords;

import Geom.Point3D;

public class test {

	public static void main(String[] args) {
	Point3D p = new Point3D(32.103315,35.209039,670);
	Point3D p2 = new Point3D(337.699,-359.249,-20);
	MyCoords test = new MyCoords();
	Point3D ptest=new Point3D( test.add(p, p2));
	System.out.println(ptest);
	}

}
