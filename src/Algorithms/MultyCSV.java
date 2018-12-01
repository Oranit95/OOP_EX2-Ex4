package Algorithms;

import java.io.File;

import File_format.csv2kml;
import GIS.layer;

public class MultyCSV {
	public static void main(String[] args) {
//	   searchFile(new File("/tmp"), "10174");
		File file = new File("C:\\Users\\Oranit\\Documents\\לימודים\\שנה ב\\מונחה עצמים\\מטלה 2\\OOP_EX2-EX4-master\\‏‏תיקיה חדשה");
		File ff = findFile(file);
	}
	private static File findFile(File dir) {
		  File result = null; // no need to store result as String, you're returning File anyway
		  File[] dirlist = dir.listFiles();
		  for(int i = 0; i < dirlist.length; i++) { 
		    if(dirlist[i].isDirectory()) {
		      result = findFile(dirlist[i]);
		      if (result!=null) break; // recursive call found the file; terminate the loop
		    } else if(dirlist[i].getName().endsWith(".csv")) {
		    	layer layer = new layer();
		    	csv2kml csv2kml = new csv2kml();
		    	csv2kml.csvReader(dirlist[i].getName(), layer);
		    	int j = dirlist[i].getName().indexOf(".csv");
		    	csv2kml.kmlWriter(dirlist[i].getName().substring(0, j), layer);
		    }
		  }
		  return result; // will return null if we didn't find anything
		}
////	public void directorySearch (String target, String dirName) {
////	    File f = new File(dirName);
////	    String [] fileList = f.list();
////	    File aFile = new File(dirName + "\\" + fileList[1]);
////	    if (aFile.isDirectory()) {
////	    }
////	    else {
////	    }
////	}
//	private static void searchFile(File file, String search) {
//	    if (file.isDirectory()) {
//	        File[] files = file.listFiles();
//	        for (File f : files) {
//	            searchFile(f, search);
//	        }
//	    } 
//	    else {
//	        if (search.equals(file.getName().endsWith(".csv"))) {
//	        }
//	    }
//	}
}
