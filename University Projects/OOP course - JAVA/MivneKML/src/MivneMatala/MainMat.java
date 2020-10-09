package MivneMatala;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainMat {
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		FolderReader Check = new FolderReader("C:\\Mivne\\","WigleWifi");
		File File = new File(Check.getFinalArray());
		ListFile Filtered = new ListFile(File.getContain().get(0),"SIGNAL",10);
		InputFilter Location = new InputFilter();
		Filter Testing = new Filter(Location,Filtered.getContainerMAC());
		RdyToPrint Printing = new RdyToPrint(Testing.getContainerFiltered());
		FileFiltered Prep = new FileFiltered(Printing.getTOPRINT());
		ListFile Done = new ListFile(Prep.getContain().get(0),"MAC",3);
		
	}
}


