package MivneMatala;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

	public class Kml3 extends MainMat{
		private static Integer ID=0;
		// Function to cast Double to string
	
			public static void ToKml(FileFiltered InfoByInput){	
				final Kml kml = new Kml();
				Document document = kml.createAndSetDocument();

				for (int i = 0; i < InfoByInput.getID().size(); i++) {
					ID++;
					TimeStamp t = new TimeStamp();
					t.setWhen(InfoByInput.getDatentime().get(i));
					document.createAndAddPlacemark().withName("Placemark"+i+" "+InfoByInput.getID().get(i)).withOpen(Boolean.TRUE)
					.withTimePrimitive(t).createAndSetPoint().
					addToCoordinates(InfoByInput.getLon().get(i),InfoByInput.getLat().get(i));
				}

				try {
					kml.marshal(new File("C:/Mivne/KML"+ID+".kml"));
					System.out.println("completed");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}


			
		
	

		}
	

