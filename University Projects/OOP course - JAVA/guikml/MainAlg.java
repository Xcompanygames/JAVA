package guikml;
/**
 * 
 */

/**
 * @author Moshe
 *
 */
public class MainAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
                GuiKMLBase test = new GuiKMLBase();
                test.setVisible(true);
		ReaderFiltered DATA = new ReaderFiltered ("C:\\Mivne\\_comb_all_BM2_.csv");
		ReaderFiltered CHECK = new ReaderFiltered ("C:\\Mivne\\_comb_no_gps_ts2_.csv");
		
		FilteredContain CHECKContain = new FilteredContain (CHECK.getFileList());
		FilteredContain DATAContain = new FilteredContain (DATA.getFileList());
		
		Algorithm2 a  = new Algorithm2 (CHECKContain.getContain(),DATAContain.getContain());
		RdyToPrint test2 = new RdyToPrint(a.getALGOAFTER(),0);
		
		Writer FilteredFirst2 = new Writer("C:\\Mivne\\NewDay.csv",test2.getTOPRINT());
		
	}
}
	
	
