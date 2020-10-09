package guikml;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

	public class Kml3 {
		private static Integer ID=0;
		private ArrayList<Container> InfoByInput = new ArrayList<Container>();
                private String LOC;
		// Function to cast Double to string
		public Kml3(ArrayList<Container> infobyinput,String loc) {
			
			for(Container List : infobyinput) {this.InfoByInput.add(List);}
			ToKml();
                        this.LOC = loc+"";
		}	
	
			public void ToKml(){	
				final Kml kml = new Kml();
				Document document = kml.createAndSetDocument();

				for (int i = 0; i < InfoByInput.size(); i++) {
					ID++;
					String time=InfoByInput.get(i).getTIMEList().get(0);
					Timestamp t=Timestamp.valueOf(time);
					Placemark p=KmlFactory.createPlacemark().withName("Placemark"+i+" "+InfoByInput.get(i).getIDList().get(0));
					p.createAndSetTimeStamp().addToTimeStampSimpleExtension(t);
					document.createAndAddPlacemark().withOpen(Boolean.TRUE).withTimePrimitive(p.getTimePrimitive()).createAndSetPoint()
					.addToCoordinates(InfoByInput.get(i).getLONList().get(0),InfoByInput.get(i).getLATList().get(0));
				}

				try {
					kml.marshal(new File(LOC));
					System.out.println("completed");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		}
	
