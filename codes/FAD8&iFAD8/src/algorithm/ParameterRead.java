package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Read the Parameter of a DEM,including ncols, nrows, xllcorner, yllcorner, cellsize, noData value.
 * @author Pengfei Wu
 * @date 2020.8.21 
 */
public class ParameterRead {
	
	/**
	 * Read the parameter of a DEM using the line of the parameter.
	 * 1-ncols, 2-nrows, 3-xllcorner, 4-yllcorner, 5-cellsize, 6-noData value
	 * @param parameterPath path to store parameters of a DEM.
	 * @param line The line number of the selected parameter.
	 * @return The value of the selected parameter.
	 * @throws FileNotFoundException
	 */
	public static double readData(String parameterPath,int line) throws FileNotFoundException{
		
		double data=0;
		
		Scanner in1=new Scanner(new File(parameterPath)); 
		
		String str="";
		
		for(int i=0;i<line;i++){
			str=in1.nextLine().trim();
		}
		in1.close();
		
		String[] str1=str.split("[\\p{Space}]+");
		data=Double.valueOf(str1[1]);
		
		return data;
	}

}
