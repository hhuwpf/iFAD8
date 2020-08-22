package algorithm;


import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

/**
 * Calculate drainage directions with the FAD8 or iFAD8 method.
 * @author Pengfei Wu
 * @date 2020.8.21 
 */
public class MainClass {

	public static void main(String[] args) throws IOException {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("start!"+df.format(System.currentTimeMillis()));
		
		String demPath=PathObtain.importPath();  //get the path of DEM
		String directionPath=PathObtain.outputPath();  //get the path to store drainage directions
		String parameterPath=System.getProperty("user.dir")+"//sysData//parameters.txt"; //path to store six parameters of ASCII DEM
		
		double[][] dem=DemImport.dem(demPath, parameterPath);
		
		System.out.println("Import DEM finished!"+df.format(System.currentTimeMillis()));
		
		FillSink.fill(dem,parameterPath);
		
		System.out.println("Filling depressions finished!"+df.format(System.currentTimeMillis()));
		
		//calculate drainage directions, next two sentence uses the iFAD8 and FAD8,respectively.
		short[][] dir=iFAD8.direction(dem,parameterPath);  //calculate drainage directions with iFAD8
		//short[][] dir=FAD8.direction(dem,parameterPath);  //calculate drainage directions with FAD8
				
		System.out.println("Calculating directions finished!"+df.format(System.currentTimeMillis()));
				
		DirectionSave.save(dir, directionPath, parameterPath);
				
		//JOptionPane.showMessageDialog(null, "Calculation has finished!");
		JOptionPane.showMessageDialog(null, "Calculation has finished!"+df.format(System.currentTimeMillis()));
		

	}

}
