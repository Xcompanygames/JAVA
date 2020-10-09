package MivneMatala;

//Not mine = all good.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Input : FileName .
 * Return : Array of Strings containing the file index.
 */
public class Reader {
	static ArrayList<String> id = new ArrayList<String>();
	private String Filename;
	private String Source [] = new String [0];
	private ArrayList<String> FileList = new ArrayList<String>();
	
	public Reader(String Filename) {
		this.Filename=Filename+"";
		Read(Filename);
	}

	public void Read(String fileName) {//Method that Reads a File and Stores it within an String Array.
    	
        // The name of the file to open.
        //filename 2 = Reader
         //filename 1 = Writer

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            int i=0;
            
            while((line = bufferedReader.readLine()) != null) {
            	Source = Arrays.copyOf(Source,Source.length+1);
            	Source[i]=line;
            	FileList.add(line);
            	id.add(FileList.get(0).substring(FileList.get(0).indexOf("device=")+7, FileList.get(0).indexOf(',',FileList.get(0).indexOf("device="))));
            	i++;
            }   
            id.remove(0);
            id.remove(0);
            FileList.remove(0);
            FileList.remove(0);
            // Always close files.
            bufferedReader.close();         


        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}

	public ArrayList<String> getFileList() {
		return FileList;
	}

	public void setFileList(ArrayList<String> fileList) {
		FileList = fileList;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public String[] getSource() {
		return Source;
	}

	public void setSource(String[] source) {
		Source = source;
	}

	@Override
	public String toString() {
		return "Reader [Filename=" + Filename + ", Source=" + Arrays.toString(Source) + "]";
	}
	
	
}
