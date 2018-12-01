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
		reader("WigleWifi_20171201110209.csv", lay);
		kml("output.kml", lay);
		
	}
	public static void kml(String name, layer layer) {
		
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
		Iterator<element> it = layer.iterator();
		while(it.hasNext()) {
			element gis = it.next();
			metaData mD = (metaData) gis.getData();
			Point3D pD = (Point3D) gis.getGeom();
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "");
			sb.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style"
					+ " id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style "
					+ "id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style"
					+ " id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + "");
			sb.append("<Placemark>\n");
			sb.append("<name><![CDATA["+gis.getOtherData().SSID()+"]]></name>\n");	
			sb.append("<description><![CDATA[BSSID: <b>"+gis.getOtherData().MAC()+"</b><br/>");
			sb.append("Capabilities: <b>"+gis.getOtherData().AuthMode()+"</b><br/>");
			sb.append("Frequency: <b>"+gis.getOtherData().RSSI()+"</b><br/>");
			sb.append("Timestamp: <b>"+gis.getData().getUTC()+"</b><br/>");
			sb.append("Date: <b>"+mD.FirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n");
			sb.append("<Point>\n");
			sb.append("<coordinates>"+pD.x()+","+pD.y()+"</coordinates></Point>\n");
			sb.append("</Placemark\n");
			pw.write(sb.toString());
		}
		pw.close();
	}

	public static void reader(String path, layer layer) {
		String csvFile = path;
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{
			while ((line = br.readLine()) != null) 
			{
				String[] data = line.split(",");
				layer.add(new element(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10]));	
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}