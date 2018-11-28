package GIS;

import java.util.Arrays;

import Geom.Point3D;

public class test {

	public static void main(String[] args) {
		String str0 ="Oranit ha hamuda!" ;
		String str1 = "sdsds";
		String str2 = "sdsds";
		String str3 = "sdsdsd";
		String str4 ="dsdssdsd" ;
		String str5 = "sdsdsddsds";
		String str6 = "34";
		String str7 = "23";
		String str8 = "20";
		String str9 = "fdghtgb";
		String str10 = "fghbfvds";
		layer l = new layer();
		l.add(new element(str0,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10));
		metaData md = (metaData) l.get(0).getData();
		Point3D p = (Point3D) l.get(0).getGeom();
		System.out.println(md.MAC()+"      "+p);
	}
}
