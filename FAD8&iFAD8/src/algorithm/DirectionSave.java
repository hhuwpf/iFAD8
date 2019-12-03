package algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * save the drainage direction data
 * @author Pengfei Wu
 * @Date 2019.8.8
 */
public class DirectionSave {
	/**
	 * save drainage direction values
	 * @throws IOException 
	 */
	public static void save(short[][] direction,String outputPath) throws IOException{
		String parameterPath =System.getProperty("user.dir")+"//sysData//parameters.txt";
    	Scanner in1=new Scanner(new File(parameterPath));  
    	BufferedWriter pout=new BufferedWriter(new FileWriter(outputPath));
    	
    	for(int i=0;i<6;i++){  //write six parameters
			String str=in1.nextLine().trim();
			pout.write(str+"\r\n");
		}
    	in1.close();
    	
    	int p=direction.length;
    	int q=direction[1].length;
    	//write directions
    	for(int i=0;i<p;i++){
    		for(int j=0;j<q;j++){
    			pout.write(direction[i][j]+"\t");
    		}
    		pout.write("\r\n");
    	}
    	pout.close();
	}

}
