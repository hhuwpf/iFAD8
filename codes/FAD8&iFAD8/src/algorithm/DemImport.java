package algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * import the DEM
 * For the simple calculation of drainage directions, here we add two rows and two columns at the border of the DEM.
 * Cells in the new rows or columns are noData cell with values equal to -9999.
 * The two rows and columns will be removed when directions are calculated by FAD8 or iFAD8.
 * @author Pengfei Wu
 * @date 2019.8.8
 */
public class DemImport {
	/**
	 * @param demPath - path of ASCII DEM
	 * @return DEM - DEM data
	 * @throws IOException 
	 */
	public static double[][] dem(String demPath) throws IOException{
		
		String parameterPath=System.getProperty("user.dir")+"//sysData//parameters.txt"; //path to store six parameters of ASCII DEM
		
		int ncols=0,nrows=0;
		
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
		
		for(int i=0;i<=nrows+1;i++){
			demData[i][0]=-9999;
			demData[i][ncols+1]=-9999;
		}
		
		for(int j=1;j<=ncols;j++){
			demData[0][j]=-9999;
			demData[nrows+1][j]=-9999;
		}
		
		return demData;
		
	}
}
