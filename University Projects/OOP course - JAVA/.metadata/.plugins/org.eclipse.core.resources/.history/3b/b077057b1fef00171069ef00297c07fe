package MivneMatala;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//Done
public class Filter {

	private Date BDATE,EDATE;
	private String ID,BEGINDATE,ENDDATE;
	private double LAT,LON,ALT,RADIUS,RADIUS2;
	private int RESULTS=0;
	private ArrayList<Container> ContainerFiltered = new ArrayList<Container>();
	
	public Filter (InputFilter filter, ArrayList<Container> file) throws ParseException {
		
		for(Container List : file) {this.ContainerFiltered.add(List);}
		
		if (filter.getFilterstatus().equals("ID")) {
			this.ID = filter.getID() +"";
			IDFilter();
		}
		
		if (filter.getFilterstatus().equals("T")) {
			BEGINDATE = filter.getDatenTime()+"";
			ENDDATE = filter.getDatenTime2()+"";
			StringToDate(); 
		}
		
		if (filter.getFilterstatus().equals("L")) {
			this.LAT = filter.getLat();
			this.LON = filter.getLon();
			this.ALT = filter.getAlt();
			this.RADIUS = filter.getRadius();
			radiuscheckfilter();
		}
		
		if (RESULTS==0) {
			System.out.println("No results found.");
			System.exit(0);
		}
		else System.out.println("Number of results for the search parameter : "+RESULTS);
		//Test();
	}
	
	public void Test() {
		for (int i=0;i<ContainerFiltered.size();i++) {
		System.out.println("index - "+ContainerFiltered.get(i).getINDEXList()+"Date - "+ ContainerFiltered.get(i).getTIMEList()+"ID - "
				+ContainerFiltered.get(i).getIDList()+"Lat - "+ContainerFiltered.get(i).getLATList().toString()+"Lon - "+ContainerFiltered.get(i).getLONList().toString()+"Alt - "
				+ContainerFiltered.get(i).getALTList().toString()+"SSID -"
				+ContainerFiltered.get(i).getSSIDList()+"MAC - "+ContainerFiltered.get(i).getMACList()+"Channel -"+ContainerFiltered.get(i).getCHANNEList()+"Signal -"+ContainerFiltered.get(i).getSIGNAList());
		}
	}
	
	public void IDFilter() {
		for (int i=0;i<ContainerFiltered.size();i++) {
			if (!ID.equals(ContainerFiltered.get(i).getIDList().get(0))) {
				ContainerFiltered.remove(i);
				i--;
			}
			else RESULTS++;
		}
	}
	
	public void StringToDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		BDATE=sdf.parse(BEGINDATE);
		EDATE=sdf.parse(ENDDATE);
		for (int i=0;i<ContainerFiltered.size();i++) {
		if(!((BDATE.compareTo(sdf.parse(ContainerFiltered.get(i).getTIMEList().get(0))) * sdf.parse(ContainerFiltered.get(i).getTIMEList().get(0)).compareTo(EDATE) >= 0))){
			ContainerFiltered.remove(i);
			i--;
		}
		else RESULTS++;
		}
	}
	
	public void radiuscheckfilter() {
		for (int i=0;i<ContainerFiltered.size();i++) {
			RADIUS2=(Math.sqrt((LAT-ContainerFiltered.get(i).getLATList().get(0))*(LAT-ContainerFiltered.get(i).getLATList().get(0))+(LON-ContainerFiltered.get(i).getLONList().get(0))*(LON-ContainerFiltered.get(i).getLONList().get(0))+(ALT-ContainerFiltered.get(i).getALTList().get(0))*(ALT-ContainerFiltered.get(i).getALTList().get(0))));
			if (!(RADIUS2<RADIUS)) {
				ContainerFiltered.remove(i);
				i--;
			}
			else RESULTS++;
		}
	}

	public Date getBDATE() {
		return BDATE;
	}

	public void setBDATE(Date bDATE) {
		BDATE = bDATE;
	}

	public Date getEDATE() {
		return EDATE;
	}

	public void setEDATE(Date eDATE) {
		EDATE = eDATE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getBEGINDATE() {
		return BEGINDATE;
	}

	public void setBEGINDATE(String bEGINDATE) {
		BEGINDATE = bEGINDATE;
	}

	public String getENDDATE() {
		return ENDDATE;
	}

	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}

	public double getLAT() {
		return LAT;
	}

	public void setLAT(double lAT) {
		LAT = lAT;
	}

	public double getLON() {
		return LON;
	}

	public void setLON(double lON) {
		LON = lON;
	}

	public double getALT() {
		return ALT;
	}

	public void setALT(double aLT) {
		ALT = aLT;
	}

	public double getRADIUS() {
		return RADIUS;
	}

	public void setRADIUS(double rADIUS) {
		RADIUS = rADIUS;
	}

	public double getRADIUS2() {
		return RADIUS2;
	}

	public void setRADIUS2(double rADIUS2) {
		RADIUS2 = rADIUS2;
	}

	public int getRESULTS() {
		return RESULTS;
	}

	public void setRESULTS(int rESULTS) {
		RESULTS = rESULTS;
	}

	public ArrayList<Container> getContainerFiltered() {
		return ContainerFiltered;
	}

	public void setContainerFiltered(ArrayList<Container> containerFiltered) {
		ContainerFiltered = containerFiltered;
	}	
	
}