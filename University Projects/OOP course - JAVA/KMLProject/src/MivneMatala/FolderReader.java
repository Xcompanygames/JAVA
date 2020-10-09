package MivneMatala;

import java.util.ArrayList;

public class FolderReader {
	
	private ArrayList<String> FinalArray = new ArrayList<String>();
	private ArrayList<Reader> FileArr = new ArrayList<Reader>();
	private String FOLDERNAME,FILTERWORD;
	
	public FolderReader(String foldername,String filterword) {
		
		this.FOLDERNAME=foldername;
		this.FILTERWORD=filterword;
		
		FileNames Folder = new FileNames(foldername,filterword);
		
		for (int i=0;i<Folder.getPaths().size();i++) {
			FileArr.add(new Reader(Folder.getPaths().get(i))); // Insert one file at a time into FileArr.
			FinalArray.addAll(FileArr.get(i).getFileList()); //Adds Read Materials to an ArrayList.
		}
	}

	public ArrayList<String> getFinalArray() {
		return FinalArray;
	}

	public void setFinalArray(ArrayList<String> finalArray) {
		FinalArray = finalArray;
	}

	public ArrayList<Reader> getFileArr() {
		return FileArr;
	}

	public void setFileArr(ArrayList<Reader> fileArr) {
		FileArr = fileArr;
	}

	public String getFOLDERNAME() {
		return FOLDERNAME;
	}

	public void setFOLDERNAME(String fOLDERNAME) {
		FOLDERNAME = fOLDERNAME;
	}

	public String getFILTERWORD() {
		return FILTERWORD;
	}

	public void setFILTERWORD(String fILTERWORD) {
		FILTERWORD = fILTERWORD;
	}

}
