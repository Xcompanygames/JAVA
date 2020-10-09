package MivneMatala;

import java.io.File;
import java.util.ArrayList;

public class FileNames {
	String Filter;
	String Direct;
	ArrayList<String> Paths = new ArrayList<String>();
	FileNames(String DirectoryPath,String FilterWord){
		Direct = DirectoryPath+"";
		Filter = FilterWord+"";
		Paths = ReadDirectory(Direct);
		FilterByWord();
	}
	
	public ArrayList<String> ReadDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		ArrayList
		<String> csvFiles = new ArrayList<String>();
		if (!directory.isDirectory()) {//
			System.out.println("directory is not exist");// 
			return null;// 
		}
		File[] fileNames = directory.listFiles();// 
		if (fileNames.length == 0)// 
		{
			System.out.println("directory is empty");//
			return null;
		}
		for (File file : fileNames) {// 
			if (!file.isDirectory() && file.getAbsolutePath().endsWith(".csv")) {
				csvFiles.add(file.getAbsolutePath());// 
														// 
			} else if (file.isDirectory()) {// 
				csvFiles.addAll(ReadDirectory(file.getAbsolutePath()));
			}
		}
		return csvFiles;//
	}
	
	public void FilterByWord() {
		for (int i=0;i<Paths.size();i++) {
			if (!Paths.get(i).contains(Filter)) {
				Paths.remove(i);
				i--;
			}
		}
		
	}

	public String getFilter() {
		return Filter;
	}

	public void setFilter(String filter) {
		Filter = filter;
	}

	public String getDirect() {
		return Direct;
	}

	public void setDirect(String direct) {
		Direct = direct;
	}

	public ArrayList<String> getPaths() {
		return Paths;
	}

	public void setPaths(ArrayList<String> paths) {
		Paths = paths;
	}
	
	
	
}
