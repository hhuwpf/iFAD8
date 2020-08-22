package algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Import DEM data and save the parameters.
 * @author Pengfei Wu
 * @date 2020.8.21 
 */
public class DemImport {
	
	/**
	 * Import DEM and save the parameters.
	 * For the convenience of subsequent calculations,two columns and two rows with nodata cells are added to the DEM border.
	 * And these new cells will be removed when saved into files.
	 * @param demPath The path of the DEM txt file.
	 * @param parameterPath path to store parameters of a DEM.
	 * @return A matrix of DEM data.
	 * @throws IOException
	 */
	public static double[][] dem(String demPath,String parameterPath) throws IOException{
		
        int ncols=0,nrows=0;
        double noData=-9999;
		
		Scanner in1=new Scanner(new File(demPath));  
		BufferedWriter pout=new BufferedWriter(new FileWriter(parameterPath)); 
		
		for(int i=0;i<6;i++){  //read six parameters
			String str=in1.nextLine().trim();
			pout.write(str+"\r\n");
			if(i==0){
				String[] str1=str.split("[\\p{Space}]+");
				ncols=Integer.valueOf(str1[1]);
			}else if(i==1){
				String[] str1=str.split("[\\p{Space}]+");
				nrows=Integer.valueOf(str1[1]);
			}else if(i==5){
				String[] str1=str.split("[\\p{Space}]+");
				noData=Double.valueOf(str1[1]);
			}
		}
		
		double[][] demData=new double[nrows+2][ncols+2];
		
		for(int i=1;i<=nrows;i++){  //read DEM values
			String str[]=in1.nextLine().trim().split("[\\p{Space}]+");
			for(int j=1;j<=ncols;j++){
				demData[i][j]=Double.valueOf(str[j-1]);
			}
		}
		
		in1.close();
		pout.close();
		
		for(int i=0;i<=nrows+1;i++){  //add two extra rows and columns.
			demData[i][0]=noData;
			demData[i][ncols+1]=noData;
		}
		
		for(int j=1;j<=ncols;j++){
			demData[0][j]=noData;
			demData[nrows+1][j]=noData;
		}
		
		return demData;
		
		
	}
	
}
