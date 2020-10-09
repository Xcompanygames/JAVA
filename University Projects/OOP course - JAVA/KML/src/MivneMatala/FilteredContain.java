package MivneMatala;


import java.util.ArrayList;
import java.util.Collections;

public class FilteredContain {
//done
	private ArrayList<Integer> SIGNAList2 = new ArrayList<Integer>();
	private ArrayList<Integer> CHANNEList2 = new ArrayList<Integer>();
	private ArrayList<String> MACList2 = new ArrayList<String>();
	private ArrayList<String> SSIDList2 = new ArrayList<String>();
	
	
	private ArrayList<Integer> INDEXList = new ArrayList<Integer>();
	private ArrayList<Integer> SIGNAList = new ArrayList<Integer>();
	private ArrayList<Integer> CHANNEList = new ArrayList<Integer>();
	private ArrayList<String> TIMEList = new ArrayList<String>();
	private ArrayList<String> IDList = new ArrayList<String>();
	private ArrayList<String> TYPEList = new ArrayList<String>();
	private ArrayList<String> AUTHMODEList = new ArrayList<String>();
	private ArrayList<Integer> WIFISUMList = new ArrayList<Integer>();
	private ArrayList<String> MACList = new ArrayList<String>();
	private ArrayList<String> SSIDList = new ArrayList<String>();
	private ArrayList<String> File = new ArrayList<String>();
	private ArrayList<Double> LATList = new ArrayList<Double>();
	private ArrayList<Double> LONList = new ArrayList<Double>();
	private ArrayList<Double> ALTList = new ArrayList<Double>();
	private ArrayList<Double> ACCList = new ArrayList<Double>();
	private ArrayList<Container> Contain = new ArrayList<Container>();
	ArrayList<TempContain> Test2 = new ArrayList<TempContain>(); 
	
	
	public FilteredContain(ArrayList<String> File) {
	    
		for(String List : File)
	    {   
	        this.File.add(List);
	    }
		
		for (int i = 0 ; i < File.size(); i++) {// changed to 0 original 1
		this.File.set(i, this.File.get(i)+",");
		TIMEListDivide(i);
		IDListDivide(i);
		LATListDivide(i);
		LONListDivide(i);
		ALTListDivide(i);
		WIFISUMListDivide(i);
		
			for (int j=0; j<WIFISUMList.get(i);j++) {//changed to i orginal i-1 on all of them
			if (j!=0) {
				LATList.add(LATList.get(0));
				LONList.add(LONList.get(0));
				ALTList.add(ALTList.get(0));
				TIMEList.add(TIMEList.get(0));
				IDList.add(IDList.get(0));}//till here
				INDEXList.add(i);
				SSIDListDivide(i);
				MACListDivide(i);
				CHANNEListDivide(i);
				SIGNALListDivide(i);
				Test2.add(new TempContain (SSIDList.get(j),MACList.get(j),CHANNEList.get(j),SIGNAList.get(j)));	
			}
			Collections.sort(Test2);
			Collections.reverse(Test2);

			for (int l=0;l<Test2.size();l++) {
				SSIDList2.add(Test2.get(l).getSSID());
				MACList2.add(Test2.get(l).getMAC());
				CHANNEList2.add(Test2.get(l).getCHANNEL());
				SIGNAList2.add(Test2.get(l).getSIGNAL());
			}
			
			
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
			copySIGNAL.addAll(SIGNAList2);
			copyCHANNEL.addAll(CHANNEList2);
			copyTIME.addAll(TIMEList);
			copyID.addAll(IDList);
			copyMAC.addAll(MACList2);
			copySSID.addAll(SSIDList2);
			copyLAT.addAll(LATList);
			copyLON.addAll(LONList);
			copyALT.addAll(ALTList);
			Contain.add(new Container(copyINDEX,copySIGNAL,copyCHANNEL,copyTIME,copyID,copyMAC,copySSID,copyLAT,copyLON,copyALT));
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
			SSIDList2.clear();
			MACList2.clear();
			SIGNAList2.clear();
			CHANNEList2.clear();
			Test2.clear();
		
		}
		
		System.out.println("Filtered Contain Test = ");
		//Test();
	}

	public void Test() {
		for (int i=0;i<Contain.size();i++) {
			System.out.println("index - "+Contain.get(i).getINDEXList()+"Date - "+ Contain.get(i).getTIMEList()+"ID - "
					+Contain.get(i).getIDList()+"Lat - "+Contain.get(i).getLATList().toString()+"Lon - "+Contain.get(i).getLONList().toString()+"Alt - "
					+Contain.get(i).getALTList().toString()+"SSID -"
					+Contain.get(i).getSSIDList()+"MAC - "+Contain.get(i).getMACList()+"Channel -"+Contain.get(i).getCHANNEList()+"Signal -"+Contain.get(i).getSIGNAList());
			}
	}
	
	public ArrayList<String> getFile() {
		return File;
	}

	public void setFile(ArrayList<String> file) {
		File = file;
	}

	public ArrayList<Container> getContain() {
		return Contain;
	}

	public void setContain(ArrayList<Container> contain) {
		Contain = contain;
	}

	public void TIMEListDivide(int i) {
			this.TIMEList.add(File.get(i).substring(0, File.get(i).indexOf(',')));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void IDListDivide(int i) {
			this.IDList.add((File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void LATListDivide(int i) {
			this.LATList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void LONListDivide(int i) {
			this.LONList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void ALTListDivide(int i) {
			this.ALTList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void WIFISUMListDivide(int i) {
			this.WIFISUMList.add(Integer.parseInt((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void SSIDListDivide(int i) {
			this.SSIDList.add((File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void MACListDivide(int i) {
			this.MACList.add((File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void CHANNEListDivide(int i) {
			this.CHANNEList.add(Integer.parseInt((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}
	
	public void SIGNALListDivide(int i) {
			this.SIGNAList.add((int)(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(','))))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
	}

	public ArrayList<Integer> getINDEXList() {
		return INDEXList;
	}
	public void setINDEXList(ArrayList<Integer> iNDEXList) {
		INDEXList = iNDEXList;
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
	public ArrayList<String> getIDList() {
		return IDList;
	}
	public void setIDList(ArrayList<String> iDList) {
		IDList = iDList;
	}
	public ArrayList<String> getTYPEList() {
		return TYPEList;
	}
	public void setTYPEList(ArrayList<String> tYPEList) {
		TYPEList = tYPEList;
	}
	public ArrayList<String> getAUTHMODEList() {
		return AUTHMODEList;
	}
	public void setAUTHMODEList(ArrayList<String> aUTHMODEList) {
		AUTHMODEList = aUTHMODEList;
	}
	public ArrayList<Integer> getWIFISUMList() {
		return WIFISUMList;
	}
	public void setWIFISUMList(ArrayList<Integer> wIFISUMList) {
		WIFISUMList = wIFISUMList;
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
	
}
