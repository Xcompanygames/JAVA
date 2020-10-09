package readandS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReadFiles

{		


	//Delimiters to separate the strings
	private static final String LINE_SEPARATOR = "\r\n";
	private static final String COMMA_DELIMITER = ",";	

	public static void printcata(){
		//Print categories 
		for (int i = 0; i < 10; i++) {
			System.out.print(""
					+ "MAC"+(i+1)+"             "
					+ "   SSID"+(i+1)+"          "
					+ " AuthMode"+(i+1)+"         "
					+ "FirstSeen"+(i+1)+"   "
					+ "   Channel"+(i+1)+"       "
					+ "  RSSI"+(i+1)+"             "
					+ " CurrLatitude"+(i+1)+"             "
					+ " CurrLongitude"+(i+1)+"             "
					+ " AltiMeters"+(i+1)+"             "
					+ " AccMeters"+(i+1)+"             "
					+ " Type"+(i+1)+"             ");
		}
		System.out.println("/n");


	}

	//Function to sort the arraylist
	public static void  sortdateandRSSI(List<Wifidata> WifiList) {
		Collections.sort(WifiList, new Comparator<Wifidata>() {
			public int compare(Wifidata z1, Wifidata z2) {
				String x1 = ((Wifidata) z1).getDATE();
				String x2 = ((Wifidata) z2).getDATE();
				int sComp = x1.compareTo(x2);
				if (sComp != 0) {
					return sComp;
				} else {
					Integer x11 = ((Wifidata) z1).getRSSI();
					Integer x22 = ((Wifidata) z2).getRSSI();
					return x11.compareTo(x22);
				}
			}
		});
	}



	//Removing values in order to have only 10 values per date
	public static void Remove10tovalues(List<Wifidata> WifiList) {
		int datelinecounter = 0;
		for (int i = 0; i < WifiList.size(); i++) {
			for (int j = 0; j < WifiList.size(); j++) {
				if ((WifiList.get(i).getDATE().equals(WifiList.get(j).getDATE()))) {
					datelinecounter++;
					if (datelinecounter>10) {
						WifiList.remove(j);

					}
				}else{
					datelinecounter=0;
				}

			}
		}
	}
	////Printing the arraylist
	public static void  Printarray(List<Wifidata> WifiList) {
		for(Wifidata e : WifiList)
		{
			System.out.println(e.getMAC()+"   "
					+e.getID()+"   "
					+e.getAuthMode()+"   "
					+e.getDATE()+"   "
					+e.getChannel()+"   "
					+e.getRSSI()+"   "
					+e.getCLitude()+"   "
					+e.getCLatitude()+"   "
					+e.getALMeters()+"   "
					+e.getACMETERES()+"   "
					+e.getType());
		}
	}

	// Function to cast int to string
	public static String inttostring(int x){
		String intAsString = new Integer(x).toString();
		return intAsString;
	}

	////Printing the arraylist
	public static void Printarraytofile(List<Wifidata> WifiList) {
		final String FILE_HEADER = "Time, Lat, Lon, Alt, SSID1, MAC1, Frequncy1, Signal1,"
				+ " SSID2, MAC2, Frequncy2, Signal2," + " SSID3, MAC3, Frequncy3, Signal3,"
				+ " SSID4, MAC4, Frequncy4, Signal4," + " SSID5, MAC5, Frequncy5, Signal5,"
				+ " SSID6, MAC6, Frequncy6, Signal6," + " SSID7, MAC7, Frequncy7, Signal7,"
				+ " SSID8, MAC8, Frequncy8, Signal8," + " SSID9, MAC9, Frequncy9, Signal9,"
				+ " SSID10, MAC10, Frequncy10, Signal10";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:\\Users\\Xcompany\\Documents\\CSV\\new.csv"); 
			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(LINE_SEPARATOR);
			String s = null; // string that compares the time strings in the loop
			double Lon = 0; // double that compares the Lon values in the loop
			double Lat = 0; // double that compares the Lan values in the loop
			double alt = 0;
			boolean delay=false; //delay the lineseparator 
			int datelinecounter = 0;
			for (int i = 0; i < WifiList.size(); i++) {
				for (int j = 0; j < WifiList.size(); j++) {
					if ((WifiList.get(i).getDATE().equals(WifiList.get(j).getDATE()))) {
						if (datelinecounter==0&&(!WifiList.get(i).getDATE().equals(s))) {
							s=WifiList.get(i).getDATE();
							Lat = WifiList.get(i).getCLatitude();
							Lon = WifiList.get(i).getCLitude();
							Lon = WifiList.get(i).getCLitude();
							alt = WifiList.get(i).getALMeters();
							if (delay==false) {
								delay=true;
							}else{
								fileWriter.append(LINE_SEPARATOR);
							}
							fileWriter.append(s+"   ");	
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(Lon+"   ");	
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(Lat+"   ");	
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(alt+"   ");	


						}
						
						if (datelinecounter==0) {
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(WifiList.get(i).getID());
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(WifiList.get(i).getMAC());
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(inttostring(WifiList.get(i).getChannel()));
							fileWriter.append(COMMA_DELIMITER);
							fileWriter.append(inttostring(WifiList.get(i).getRSSI()));

						}							

						datelinecounter++;

					}else{
						datelinecounter=0;

					}

				}
				
			
			}			


		} catch (IOException e) {
			System.out.println("File Writer error");
			e.printStackTrace();
		}		
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String args[])
	{
		List<Wifidata> WifiList = new ArrayList<Wifidata>();



		File path = new File("C:\\Users\\Xcompany\\Documents\\CSV"); //path to your folder. eg. C:\\P4logs
		for(File f: path.listFiles()) { // this loops through all the files + directories

			if(f.isFile()) { // checks if it is a file, not a directory.
				// most basic check. more checks will have to be added if 
				// you have other files you don't want read. (like non log files)
				// gets the full path of a file. so "C:\\P4logs\\out.log.2012-12-26"
				//do stuff
				try  
				{
					FileReader fr = new	FileReader(f.getAbsoluteFile()); 
					BufferedReader br = new	BufferedReader(fr);
					//List for Wifidata objects

					String line = "";
					//Read to skip the header and the categories
					br.readLine();
					br.readLine();
					//Reading from the second line

					while ((line = br.readLine()) != null) 
					{
						String[] WifidataDetails = line.split(COMMA_DELIMITER);

						if(WifidataDetails.length > 0 )
						{

							Wifidata address = new 
									Wifidata(WifidataDetails[0],
											WifidataDetails[1],
											WifidataDetails[2],
											WifidataDetails[3],
											Integer.parseInt(WifidataDetails[4]),
											Integer.parseInt(WifidataDetails[5]),
											Double.parseDouble (WifidataDetails[6]),
											Double.parseDouble (WifidataDetails[7]),
											Double.parseDouble(WifidataDetails[8]),
											Double.parseDouble(WifidataDetails[9]),
											WifidataDetails[10]);
							WifiList.add(address);
						}
					}

					int listsize=WifiList.size();}

				catch(Exception ee)
				{
					System.out.println("Error occured while closing the BufferedReader");
					ee.printStackTrace();
				}
				finally
				{


				}

			}


		}
		sortdateandRSSI(WifiList);
		//Sort by time 

		Remove10tovalues(WifiList);
		//filtering elements

		printcata();
		//Print categories 

		//	Printarray(WifiList);
		//Printing the array

		Printarraytofile(WifiList);
		Kml3.ToKml((ArrayList<Wifidata>) WifiList);

	}
}
