package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import GIS.*;
import Geom.Point3D;

public class csv2kml 
{
	public static void main(String[] args) {
		layer lay = new layer();
		csvReader("WigleWifi_20171203085618.csv", lay);
		kmlWriter("3_out.kml", lay);
	}
	public static void kmlWriter(String name, layer layer) {

		String fileName = name;
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		
		StringBuilder sb0 = new StringBuilder();
		sb0.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "");
		sb0.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style"
				+ " id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style "
				+ "id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style"
				+ " id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + "");
		pw.write(sb0.toString());

		Iterator<element> it = layer.iterator();
		while(it.hasNext()) {
			element gis = it.next();
			metaData mD = (metaData) gis.getData();
			Point3D pD = (Point3D) gis.getGeom();
			StringBuilder sb1 = new StringBuilder();
			sb1.append("<Placemark>\n");
			sb1.append("<name><![CDATA["+gis.getOtherData().SSID()+"]]></name>\n");	
			sb1.append("<description><![CDATA[BSSID: <b>"+gis.getOtherData().MAC()+"</b><br/>");
			sb1.append("Capabilities: <b>"+gis.getOtherData().AuthMode()+"</b><br/>");
			sb1.append("Frequency: <b>"+gis.getOtherData().RSSI()+"</b><br/>");
			sb1.append("Timestamp: <b>"+gis.getData().getUTC()+"</b><br/>");
			sb1.append("Date: <b>"+mD.FirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n");
			sb1.append("<Point>\n");
			sb1.append("<coordinates>"+pD.x()+","+pD.y()+"</coordinates></Point>\n");
			sb1.append("</Placemark>\n");
			pw.write(sb1.toString());
		}
		StringBuilder sb2 = new StringBuilder();
		sb2.append("</Folder>\n");
		sb2.append("</Document></kml>");
		pw.write(sb2.toString());
		pw.close();
	}

	public static void csvReader(String name, layer layer) {
		String csvFile = name;
		String line = "";
		int row = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				row++;
				if(row>2) {
					String[] data = line.split(",");
					layer.add(new element(data[0],data[1],data[2],data[3],data[4],data[5],data[7],data[6],data[8],data[9],data[10]));	
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}