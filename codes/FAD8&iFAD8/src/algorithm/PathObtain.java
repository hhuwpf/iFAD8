package algorithm;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Use dialogs to obtain the path of DEM and the path to store drainage directions.
 * @author Pengfei Wu
 * @date 2020.8.21 
 */
public class PathObtain {
	
	/**
	 * To obtain the path of DEM txt.
	 */
	public static String importPath(){
		String path="";
		JFileChooser chooser=new JFileChooser();
		chooser.setMultiSelectionEnabled(false);  
		chooser.setDialogTitle("Choose ASCII DEM");  
		chooser.setAcceptAllFileFilterUsed(true); 
		TxtFileFilter txtfilefilter=new TxtFileFilter();
		chooser.addChoosableFileFilter(txtfilefilter);
		chooser.setFileFilter(txtfilefilter);
		int iwert = chooser.showOpenDialog(null);
	    if(iwert== chooser.APPROVE_OPTION){ //打开文件
	       path = chooser.getSelectedFile().getAbsolutePath();
	    }
		return path;		
	}
	
	/**
	 * To obtain the path to store drainage directions.
	 */
	public static String outputPath(){
		String path1="";
		JFileChooser fc = new JFileChooser();
		fc.setDialogType(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Choose the location to store the drainage direction file!");
		fc.setMultiSelectionEnabled(false);
		fc.showSaveDialog(fc);
		if (fc.getSelectedFile()==null) {
			System.exit(0);
		}
		path1=fc.getSelectedFile().getPath();
		path1=path1+".txt";		
		return path1;
	}

}

/**
 * Set the filefilter to return TXT files.
 * @author Pengfei Wu
 * @date 2019.8.8
 */
class TxtFileFilter extends FileFilter {  
    public String getDescription() {  
        return "*.txt";  
    }  
  
    public boolean accept(File file) {  
    	if (file.isDirectory())return true;
        String name = file.getName();  
        return name.toLowerCase().endsWith(".txt");  
    }  
}  
