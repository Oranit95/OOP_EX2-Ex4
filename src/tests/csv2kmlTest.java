package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import File_format.csv2kml;
import GIS.*;
class csv2kmlTest {

	@Test
	void csvReadertest() {
		layer layer = new layer();
		csv2kml ck = new csv2kml();
		assertTrue(ck.csvReader("WigleWifi_20171201110209.csv", layer));
	}
	@Test 
	void kmlWriter() {
		layer layer = new layer();
		csv2kml ck = new csv2kml();
		assertTrue(ck.kmlWriter("WigleWifi_20171201110209.csv", layer));
	}
	
	
}
