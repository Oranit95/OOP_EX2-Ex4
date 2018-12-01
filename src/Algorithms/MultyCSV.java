package Algorithms;
import GIS.*;
import java.io.File;

import File_format.csv2kml;

public class MultyCSV {
		project project;
	
	public File findFile(File dir) {
		  File result = null; 
		  File[] dirlist = dir.listFiles();
		  for(int i = 0; i < dirlist.length; i++) { 
		    if(dirlist[i].isDirectory()) {
		      result = findFile(dirlist[i]);
		      if (result!=null) break; // recursive call found the file; terminate the loop
		    } else if(dirlist[i].getName().endsWith(".csv")) {
		    	layer layer = new layer();
		    	csv2kml csv2kml = new csv2kml();
		    	csv2kml.csvReader(dirlist[i].getParent()+"\\"+dirlist[i].getName(), layer);
		    	int j = dirlist[i].getName().indexOf(".csv");
		    	csv2kml.kmlWriter(dirlist[i].getName().substring(0, j), layer);
		    	project.add(layer);
		    }
		  }
		  return result; // will return null if we didn't find anything
		}
	project getProject() {
		return project;
	}

}
