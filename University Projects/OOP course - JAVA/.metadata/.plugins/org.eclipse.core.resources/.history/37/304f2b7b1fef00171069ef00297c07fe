package MivneMatala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

//can improve
public class ListFile {

    private ArrayList<Integer> SIGNAList = new ArrayList<Integer>();
    private ArrayList<Integer> CHANNEList = new ArrayList<Integer>();
    private ArrayList<String> TIMEList = new ArrayList<String>();
    private ArrayList<String> MACList = new ArrayList<String>();
    private ArrayList<String> SSIDList = new ArrayList<String>();
    private ArrayList<Double> LATList = new ArrayList<Double>();
    private ArrayList<Double> LONList = new ArrayList<Double>();
    private ArrayList<Double> ALTList = new ArrayList<Double>();
    private ArrayList<Double> ACCList = new ArrayList<Double>();
    private ArrayList<Integer> INDEXList = new ArrayList<Integer>();
    private ArrayList<String> IDList = new ArrayList<String>();
    private ArrayList<String> CHOICE = new ArrayList<String>();
    private ArrayList<Double> CHOICEDouble = new ArrayList<Double>();
    private ArrayList<Container> ContainerMAC = new ArrayList<Container>();
    private ArrayList<SorterIDLatLonAlt> SorterSignal = new ArrayList<SorterIDLatLonAlt>();
    private ArrayList<SorterMAC> SorterMAC = new ArrayList<SorterMAC>();
	

	public ListFile(Container file,String Option, int value) {
		//Copy Constructors.
		 
		 for(Integer List : file.getINDEXList())  {this.INDEXList.add(List);}
		 for(Integer List : file.getSIGNAList())  {this.SIGNAList.add(List);}
		 for(Integer List : file.getCHANNEList())  {this.CHANNEList.add(List);}
		 for(String List : file.getTIMEList())  {this.TIMEList.add(List);}
		 for(String List : file.getIDList())  {this.IDList.add(List);}
		 for(String List : file.getMACList())  {this.MACList.add(List);}
		 for(String List : file.getSSIDList())  {this.SSIDList.add(List);}
		 for(Double List : file.getLATList())  {this.LATList.add(List);}
		 for(Double List : file.getLONList())  {this.LONList.add(List);}
		 for(Double List : file.getALTList())  {this.ALTList.add(List);}
		 
		 String FilterWord; //SorterSignal.get(0).(insert filter option) Ex. SorterSignal.get(0).MAC
		 
			// Sort and print
			InsertSignal();// Inserts info into SorterSignal.
			InsertMAC();
			if (Option.equals("MAC")) {	//Checks Filter option chose
			Collections.sort(SorterMAC);	//Sort
			Collections.reverse(SorterMAC); //Reverse Sort
			FilterWord=SorterMAC.get(0).MAC;
			FilteredToValueMAC(value);//Filtered Sorted arraylist to have max value numbers from chosen index
			for (int i=0;i<SorterMAC.size();i++) {//Prepares an Arraylist to insert to Func : Preparing Container Based on Chosen FilterWord.
			CHOICE.add(SorterMAC.get(i).MAC);}
			PreparingForContainerString(CHOICE);}//PreparingForContainer prepares an Object Container ArrayList that contains all the info.
			
			if (Option.equals("SIGNAL")) {	//Checks Filter option chose
			Collections.sort(SorterSignal);	//Sort
			Collections.reverse(SorterSignal); //Reverse Sort
			FilteredToValueLatLonAlt(value);//Filtered Sorted arraylist to have max value numbers from chosen index
			for (int i=0;i<SorterSignal.size();i++) {//Prepares an Arraylist to insert to Func : Preparing Container Based on Chosen FilterWord.
			CHOICE.add(SorterSignal.get(i).ID+","+SorterSignal.get(i).LAT+","+SorterSignal.get(i).LON+","+SorterSignal.get(i).ALT);}
			PreparingForContainerString(CHOICE);}//PreparingForContainer prepares an Object Container ArrayList that contains all the info.
			
			System.out.println("Number of groups : " +ContainerMAC.size());
			Test();//Test option.
	}
	
	public void Test() {

			for (int i=0;i<ContainerMAC.size();i++) {
				System.out.println("index - "+ContainerMAC.get(i).getINDEXList()+"Date - "+ ContainerMAC.get(i).getTIMEList()+"ID - "
						+ContainerMAC.get(i).getIDList()+"Lat - "+ContainerMAC.get(i).getLATList().toString()+"Lon - "+ContainerMAC.get(i).getLONList().toString()+"Alt - "
						+ContainerMAC.get(i).getALTList().toString()+"SSID -"
						+ContainerMAC.get(i).getSSIDList()+"MAC - "+ContainerMAC.get(i).getMACList()+"Channel -"+ContainerMAC.get(i).getCHANNEList()+"Signal -"+ContainerMAC.get(i).getSIGNAList());
				}
	}
	
	public void InsertSignal() {
		for (int i = 0; i < MACList.size(); i++) {
		    SorterSignal.add(new SorterIDLatLonAlt(i,SIGNAList.get(i)
		    		,CHANNEList.get(i),LATList.get(i),LONList.get(i),ALTList.get(i), 
		    		TIMEList.get(i),IDList.get(i),MACList.get(i),SSIDList.get(i)));
		}
	}
	
	public void InsertMAC() {
		for (int i = 0; i < MACList.size(); i++) {
		    SorterMAC.add(new SorterMAC(i,SIGNAList.get(i)
		    		,CHANNEList.get(i),LATList.get(i),LONList.get(i),ALTList.get(i), 
		    		TIMEList.get(i), IDList.get(i),MACList.get(i),SSIDList.get(i)));
		}
	}
	
	public void FilteredToValueMAC(int Value) {//Gets Value - Amount wanted from FilteredWord , Ex. Top 10 Signals for each MAC - > MAC FilteredWord, 10 - Value.
		String Word = SorterSignal.get(0).MAC;
		int counter=0;
		for (int i=0;i<SorterSignal.size()-1;i++) {
			if (Word.equals(SorterSignal.get(i+1).MAC)){
				counter++;
			}
			if (!Word.equals(SorterSignal.get(i+1).MAC)) {
				counter=0;
				Word=SorterSignal.get(i+1).MAC;
			}
			if (counter>=Value) {
				SorterSignal.remove(i);
				i--;
			}
		}
	}
	
	public void FilteredToValueLatLonAlt(int Value) {//Gets Value - Amount wanted from FilteredWord , Ex. Top 10 Signals for each MAC - > MAC FilteredWord, 10 - Value.
		int counter=0;
		String word = SorterSignal.get(0).ID+","+SorterSignal.get(0).LAT+","+SorterSignal.get(0).LON+","+SorterSignal.get(0).ALT;
		for (int i=0;i<SorterSignal.size()-1;i++) {
			if (word.equals(SorterSignal.get(i+1).ID+","+SorterSignal.get(i+1).getLAT()+","+SorterSignal.get(i+1).getLON()+","+SorterSignal.get(i+1).ALT)){
				counter++;
			}
			if (!word.equals(SorterSignal.get(i+1).ID+","+SorterSignal.get(i+1).getLAT()+","+SorterSignal.get(i+1).getLON()+","+SorterSignal.get(i+1).ALT)) {
				counter=0;
				word=SorterSignal.get(i+1).ID+","+SorterSignal.get(i+1).getLAT()+","+SorterSignal.get(i+1).getLON()+","+SorterSignal.get(i+1).ALT;
			}
			if (counter>=Value) {
				SorterSignal.remove(i);
				i--;
			}
		}
	}
	
	public void PreparingForContainerString(ArrayList<String> FilteredIndex) {
		INDEXList.clear();
		SIGNAList.clear();
		CHANNEList.clear();
		TIMEList.clear();
		IDList.clear();
		MACList.clear();
		SSIDList.clear();
		LATList.clear();
		LONList.clear();
		ALTList.clear();
		
		INDEXList.add(SorterSignal.get(0).INDEX);
		SIGNAList.add(SorterSignal.get(0).SIGNAL);
		CHANNEList.add(SorterSignal.get(0).CHANNEL);
		TIMEList.add(SorterSignal.get(0).TIME);
		IDList.add(SorterSignal.get(0).ID);
		MACList.add(SorterSignal.get(0).MAC);
		SSIDList.add(SorterSignal.get(0).SSID);
		LATList.add(SorterSignal.get(0).LAT);
		LONList.add(SorterSignal.get(0).LON);
		ALTList.add(SorterSignal.get(0).ALT);
		
		for (int i=0;i<SorterSignal.size()-1;i++) {
			if (FilteredIndex.get(i).equals(FilteredIndex.get(i+1))){
				INDEXList.add(SorterSignal.get(i+1).INDEX);
				SIGNAList.add(SorterSignal.get(i+1).SIGNAL);
				CHANNEList.add(SorterSignal.get(i+1).CHANNEL);
				TIMEList.add(SorterSignal.get(i+1).TIME);
				IDList.add(SorterSignal.get(i+1).ID);
				MACList.add(SorterSignal.get(i+1).MAC);
				SSIDList.add(SorterSignal.get(i+1).SSID);
				LATList.add(SorterSignal.get(i+1).LAT);
				LONList.add(SorterSignal.get(i+1).LON);
				ALTList.add(SorterSignal.get(i+1).ALT);
			}
			
			if (!FilteredIndex.get(i).equals(FilteredIndex.get(i+1))){
				
				ArrayList<Integer> copyINDEX = new ArrayList<Integer>();
				ArrayList<Integer> copySIGNAL = new ArrayList<Integer>();
				ArrayList<Integer> copyCHANNEL = new ArrayList<Integer>();
				ArrayList<String> copyTIME = new ArrayList<String>();
				ArrayList<String> copyID = new ArrayList<String>();
				ArrayList<String> copyMAC = new ArrayList<String>();
				ArrayList<String> copySSID = new ArrayList<String>();
				ArrayList<Double> copyLAT = new ArrayList<Double>();
				ArrayList<Double> copyLON = new ArrayList<Double>();
				ArrayList<Double> copyALT = new ArrayList<Double>();
				copyINDEX.addAll(INDEXList);
				copySIGNAL.addAll(SIGNAList);
				copyCHANNEL.addAll(CHANNEList);
				copyTIME.addAll(TIMEList);
				copyID.addAll(IDList);
				copyMAC.addAll(MACList);
				copySSID.addAll(SSIDList);
				copyLAT.addAll(LATList);
				copyLON.addAll(LONList);
				copyALT.addAll(ALTList);
				ContainerMAC.add(new Container(copyINDEX,copySIGNAL,copyCHANNEL,copyTIME,copyID,copyMAC,copySSID,copyLAT,copyLON,copyALT));
				INDEXList.clear();
				SIGNAList.clear();
				CHANNEList.clear();
				TIMEList.clear();
				IDList.clear();
				MACList.clear();
				SSIDList.clear();
				LATList.clear();
				LONList.clear();
				ALTList.clear();
				
				INDEXList.add(SorterSignal.get(i+1).getINDEX());
				SIGNAList.add(SorterSignal.get(i+1).SIGNAL);
				CHANNEList.add(SorterSignal.get(i+1).CHANNEL);
				TIMEList.add(SorterSignal.get(i+1).TIME);
				IDList.add(SorterSignal.get(i+1).ID);
				MACList.add(SorterSignal.get(i+1).MAC);
				SSIDList.add(SorterSignal.get(i+1).SSID);
				LATList.add(SorterSignal.get(i+1).getLAT());
				LONList.add(SorterSignal.get(i+1).getLON());
				ALTList.add(SorterSignal.get(i+1).ALT);
			}
		}

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArrayList<Double> getCHOICEDouble() {
		return CHOICEDouble;
	}

	public void setCHOICEDouble(ArrayList<Double> cHOICEDouble) {
		CHOICEDouble = cHOICEDouble;
	}

	public ArrayList<SorterIDLatLonAlt> getSorterSignal() {
		return SorterSignal;
	}

	public void setSorterSignal(ArrayList<SorterIDLatLonAlt> sorterSignal) {
		SorterSignal = sorterSignal;
	}

	public ArrayList<Integer> getSIGNAList() {
		return SIGNAList;
	}

	public void setSIGNAList(ArrayList<Integer> sIGNAList) {
		SIGNAList = sIGNAList;
	}

	public ArrayList<Integer> getCHANNEList() {
		return CHANNEList;
	}

	public void setCHANNEList(ArrayList<Integer> cHANNEList) {
		CHANNEList = cHANNEList;
	}

	public ArrayList<String> getTIMEList() {
		return TIMEList;
	}

	public void setTIMEList(ArrayList<String> tIMEList) {
		TIMEList = tIMEList;
	}

	public ArrayList<String> getMACList() {
		return MACList;
	}

	public void setMACList(ArrayList<String> mACList) {
		MACList = mACList;
	}

	public ArrayList<String> getSSIDList() {
		return SSIDList;
	}

	public void setSSIDList(ArrayList<String> sSIDList) {
		SSIDList = sSIDList;
	}

	public ArrayList<Double> getLATList() {
		return LATList;
	}

	public void setLATList(ArrayList<Double> lATList) {
		LATList = lATList;
	}

	public ArrayList<Double> getLONList() {
		return LONList;
	}

	public void setLONList(ArrayList<Double> lONList) {
		LONList = lONList;
	}

	public ArrayList<Double> getALTList() {
		return ALTList;
	}

	public void setALTList(ArrayList<Double> aLTList) {
		ALTList = aLTList;
	}

	public ArrayList<Double> getACCList() {
		return ACCList;
	}

	public void setACCList(ArrayList<Double> aCCList) {
		ACCList = aCCList;
	}

	public ArrayList<Integer> getINDEXList() {
		return INDEXList;
	}

	public void setINDEXList(ArrayList<Integer> iNDEXList) {
		INDEXList = iNDEXList;
	}

	public ArrayList<String> getIDList() {
		return IDList;
	}

	public void setIDList(ArrayList<String> iDList) {
		IDList = iDList;
	}

	public ArrayList<String> getCHOICE() {
		return CHOICE;
	}

	public void setCHOICE(ArrayList<String> cHOICE) {
		CHOICE = cHOICE;
	}

	public ArrayList<Container> getContainerMAC() {
		return ContainerMAC;
	}

	public void setContainerMAC(ArrayList<Container> containerMAC) {
		ContainerMAC = containerMAC;
	}
		
}