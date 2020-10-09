package MivneMatala;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		FolderReader Check = new FolderReader("C:\\Mivne\\","WigleWifi");
		File File = new File(Check.getFinalArray());
		ListFile Filtered = new ListFile(File.getContain().get(0),"SIGNAL",10);
		InputFilter Location = new InputFilter();
		Filter Testing = new Filter(Location,Filtered.getContainerMAC());
		Kml3 KML = new Kml3(Filtered.getContainerMAC());
		Kml3 KML2 = new Kml3(Testing.getContainerFiltered());
		RdyToPrint Printing = new RdyToPrint(Testing.getContainerFiltered(),1);
		Writer FilteredFirst = new Writer("C:\\Mivne\\FilteredTest.csv",Printing.getTOPRINT());
		
		
		/*ReaderAlg CHECK = new ReaderAlg ("C:\\Mivne\\_comb_no_gps_ts2_.csv");
		ReaderAlg DATA = new ReaderAlg ("C:\\Mivne\\FileFiltered.csv");
		FilteredContain CHECK2 = new FilteredContain (CHECK.getFileList());
		FilteredContain DATA2 = new FilteredContain (DATA.getFileList());
		Algorithm2 Test = new Algorithm2(CHECK2.getContain(),DATA2.getContain());
		RdyToPrint test2 = new RdyToPrint(Test.getALGOAFTER(),0);
		Writer FilteredFirst2 = new Writer("C:\\Mivne\\FilteredTest2.csv",test2.getTOPRINT());*/
		
		
		/*InputFilter Location = new InputFilter();
		Filter Testing = new Filter(Location,Filtered.getContainerMAC());
		RdyToPrint Printing = new RdyToPrint(Testing.getContainerFiltered(),1);
		Writer FilteredFirst = new Writer("C:\\Mivne\\FilteredTest.csv",Printing.getTOPRINT());
		FileFiltered Prep = new FileFiltered(Printing.getTOPRINT());
		ListFile Done = new ListFile(Prep.getContain().get(0),"MAC",3);*/
		
	}
}


