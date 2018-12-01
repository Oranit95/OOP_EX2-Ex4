package Algorithms;
import GIS.*;
import java.io.File;

import File_format.csv2kml;
/**
 * A class that scanns a directory and all it's sub-directorys to find csv files,
 *than turn them into kml files. In addition, adding each csv file to a layer, and each layer to a project.
 *
 * @author Oranit
 *
 */
public class MultyCSV {
		project project;

	public MultyCSV() {
		project = new project();
	}
	/**
	 * in order to read multiple csv files, the user must create a file first with the requested directory,
	 *  and than send the file itself to findFile().
	 * @param dir
	 * @return the directory that was send
	 */
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
		    	//in case we got any unvalid csv files.
		    	if(!layer.isEmpty()) csv2kml.kmlWriter(dirlist[i].getName().substring(0, j), layer);
		    	project.add(layer);
		    }
		  }
		  return result; // will return null if we didn't find anything
		}
	project getProject() {
		return project;
	}

}
