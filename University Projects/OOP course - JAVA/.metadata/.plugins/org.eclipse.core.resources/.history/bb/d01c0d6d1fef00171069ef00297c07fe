package MivneMatala;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Timestamp;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
	public class Kml3 {
		private static Integer ID=0;
		private ArrayList<Container> InfoByInput = new ArrayList<Container>();
		// Function to cast Double to string
		public Kml3(ArrayList<Container> infobyinput) {
			
			for(Container List : infobyinput) {this.InfoByInput.add(List);}
			ToKml();
		}	
	


		// CSV to KML function using JAK API.
		public void ToKml() {
			try {
				final Kml kml = new Kml();
				Document document = kml.createAndSetDocument();

				for (int i = 0; i < InfoByInput.size(); i++){ // looping all elements in ArrayList.
					try {
						ID++;
						String time=InfoByInput.get(i).getTIMEList().get(0);
						Timestamp t=Timestamp.valueOf(time);
						Placemark p=KmlFactory.createPlacemark().withName("Placemark"+i+" "+InfoByInput.get(i).getIDList().get(0));
						p.createAndSetTimeStamp().addToTimeStampSimpleExtension(t);
						document.createAndAddPlacemark().withOpen(Boolean.TRUE).withTimePrimitive(p.getTimePrimitive()).createAndSetPoint()
						.addToCoordinates(InfoByInput.get(i).getLONList().get(0),InfoByInput.get(i).getLATList().get(0));
					} 		
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				kml.marshal(new File("C:/Mivne/KML"+ID+".kml"));
				System.out.println("completed");
			}
			
			
			
			
			catch (IOException e) {
				e.printStackTrace();
			}
		}


		}
	
	
