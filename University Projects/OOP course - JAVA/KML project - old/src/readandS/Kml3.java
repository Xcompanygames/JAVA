package readandS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class Kml3 extends ReadFiles{
	



	// Function to cast Double to string
	public static String Dtostring(Double x){
		String DAsString = new Double(x).toString();
		return DAsString;
	}
		public static void ToKml(ArrayList<Wifidata> macs){	
			final Kml kml = new Kml();
			Document document = kml.createAndSetDocument();

			for (int i = 0; i < macs.size(); i++) {
				TimeStamp t = new TimeStamp();
				t.setWhen(ConvertTimeToKmlFormat(macs.get(i).getDATE()));
				document.createAndAddPlacemark().withName(macs.get(i).getID()).withOpen(Boolean.TRUE)
				.withDescription(" Mac: "+macs.get(i).getMAC()+" Signal: "+macs.get(i).getRSSI()+" SSID: "+macs.get(i).getID()+" Frequency: "+macs.get(i).getChannel())
				.withTimePrimitive(t).createAndSetPoint().
				addToCoordinates(macs.get(i).getCLitude(),macs.get(i).getCLatitude());
			}

			try {
				kml.marshal(new File("C:\\Users\\Xcompany\\Documents\\CSV\\KML.kml"));
				System.out.println("completed");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}


		public static String ConvertTimeToKmlFormat(String date){
			date= date.replace('-', '/');
			String[] finalTime=date.split(" ");
			String timeSt= "";
			String[] finalDate=finalTime[0].split("/");
			if(finalDate[0].length()==4){
				timeSt+= finalDate[0]+"-"+finalDate[1]+"-"+finalDate[2]+"T"+finalTime[1];
				return timeSt;
			}
			else{
				timeSt+= finalDate[2]+"-"+finalDate[1]+"-"+finalDate[0]+"T"+finalTime[1];
				return timeSt;
			}
		}
	
}
