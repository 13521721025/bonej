package org.doube.bonej;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.measure.ResultsTable;
import ij.plugin.filter.PlugInFilter;

/**
 * Receive results from analytic methods and insert them into the 
 * Results table in a sensible way.
 * 
 * <p>Each image gets a line; measurements of different types 
 * are added to the same line; repeat measurements on same image
 * go on a new line.</p>
 * 
 * @author Michael Doube
 *
 */
public class insertResults implements PlugInFilter{
    private ImagePlus imp;
    
    public int setup(String arg, ImagePlus imp){
	this.imp = imp;
	return DOES_ALL;
    }
    public void run(ImageProcessor ip){
	setResultInRow(imp, "Col 1", 78);
    }
    public void setResultInRow(ImagePlus imp, String colHeading, double value){
	ResultsTable rt = ResultsTable.getResultsTable();
	String title = imp.getTitle();
	
	//search for the first row that contains the image title
	//and contains no value for the heading
	for (int row = 0; row < rt.getCounter(); row++){
	    //TODO how to do a proper string comparison?
	    if (rt.getLabel(row) == title){
		double currentValue =  rt.getValue(colHeading, row);
		if(currentValue == 0){
		    rt.setValue(colHeading, row, value);
		    return;
		}
	    }
	}
	//we got to the end of the table without finding a space to insert
	//the value, so make a new row for it
	rt.setLabel(title, 0);
        rt.incrementCounter();
	rt.setValue(colHeading, 0, value);
	return;
    }
}
