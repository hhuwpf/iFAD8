package algorithm;

import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @Description Provide the main class of FAD8 or iFAD8
 * @author Pengfei Wu
 * @date 2019.8.8
 */
public class MainAlgorithm {
    /**
     * The main class for run the FAD8 or iFAD8 program.
     */
	public static void main(String[] args) throws IOException {
		
		String demPath=PathObtain.importPath();  //get the path of DEM
		String directionPath=PathObtain.outputPath();  //get the path to store drainage directions
		double[][] dem=DemImport.dem(demPath);  //import DEM
		double[][] newDem=fillSink.fill(dem);
		
		//calculate drainage directions, next two sentence uses the iFAD8 and FAD8,respectively.
		short[][] dir=iFAD8.direction(newDem);  //calculate drainage directions with iFAD8
		//short[][] dir=FAD8.direction(newDem);  //calculate drainage directions with FAD8
		
		DirectionSave.save(dir, directionPath);
		
		JOptionPane.showMessageDialog(null, "Calculation has finished!");
	}

}
