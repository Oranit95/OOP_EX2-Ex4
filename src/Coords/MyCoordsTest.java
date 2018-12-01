package Coords;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {

	@Test
	void addTest() {
		MyCoords mC = new MyCoords();
		Point3D p0 = new Point3D(32.103315,35.209039,670);
		Point3D p1 = new Point3D(337.6989921,-359.2492069,-20);
		Point3D pResult = new Point3D(32.10635200000035,35.20522500000041,650);
		Point3D pTest = mC.add(p0,p1);
		assertEquals(pTest.x(), pResult.x());
		assertEquals(pTest.y(), pResult.y());
		assertEquals(pTest.z(), pResult.z());

	}

	@Test
	void distance3dTest() {
		double distance = 493.05233183241336;
		Point3D p0 = new Point3D(32.103315,35.209039,670);
		Point3D p1 = new Point3D(32.106352,35.205225,650);
		MyCoords mC = new MyCoords();
		double  testDistance = mC.distance3d(p0, p1);
		assertEquals(distance,testDistance);
	}

	@Test
	void  vector3DTest() {
		Point3D p0 = new Point3D(32.103315,35.209039,670);
		Point3D p1 = new Point3D(32.106352,35.205225,650);
		MyCoords mC = new MyCoords();
		Point3D pTest= mC.vector3D(p0, p1);
		Point3D pResult = new Point3D(337.6989920612881, -359.24920693881893, -20);
		assertEquals(pTest.x(), pResult.x());
		assertEquals(pTest.y(), pResult.y());
		assertEquals(pTest.z(), pResult.z());
	}

	@Test
	void azimuth_elevation_distTest() {
		double[] result = {313.23042032646896, -2.3263427517266604, 493.05233183241336};
		Point3D p0 = new Point3D(32.103315,35.209039,670);
		Point3D p1 = new Point3D(32.106352,35.205225,650);
		MyCoords mC = new MyCoords();
		double[] test = mC.azimuth_elevation_dist(p0, p1);
		assertTrue(Arrays.equals(test, result));
	}

	@Test
	void isValid_GPS_PointTest() {
		MyCoords mC = new MyCoords();
		Point3D p0 = new Point3D(31.770810,35.197460,670);
		Point3D p1 = new Point3D(180, 400, -2000);
		assertTrue(mC.isValid_GPS_Point(p0));
		assertFalse(mC.isValid_GPS_Point(p1));
	}

}
