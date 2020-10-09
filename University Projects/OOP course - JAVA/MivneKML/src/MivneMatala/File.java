package MivneMatala;

import java.util.ArrayList;

public class File {
//done
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
    
	
	public File(ArrayList<String> file) {
		
		for(String List : file)
	    {   
	        this.File.add(List);
	    }
		
		for(String List : Reader.id)
	    {   
	        this.IDList.add(List);
	    }

		this.File.remove(0);
		this.File.remove(0);
		
		MacDivide();
		SSIDDivide();
		AuthModeDivide();
		DatenTimeDivide();
		ChannelDivide();
		SignalDivide();
		LatDivide();
		LonDivide();
		AltDivide();
		AccDivide();
		TypeDivide();
		
		Contain.add(new Container(INDEXList,SIGNAList,CHANNEList,TIMEList,IDList,MACList,
										SSIDList,LATList,LONList,ALTList));
		
		//Test();
	}
	
	public void Test() {
		//for(int i=0;i<Contain.size();i++) {

			
			
	//	}
	}
	
	public void MacDivide() {
		for (int i=0; i<File.size();i++) {
			INDEXList.add(i);
			MACList.add(File.get(i).substring(0, File.get(i).indexOf(',')));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void SSIDDivide() {
		for (int i=0; i<File.size();i++) {
			SSIDList.add(File.get(i).substring(0, File.get(i).indexOf(',')));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void AuthModeDivide() {
		for (int i=0; i<File.size();i++) {
			AUTHMODEList.add(File.get(i).substring(0, File.get(i).indexOf(',')));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void DatenTimeDivide() {
		for (int i=0; i<File.size();i++) {
			TIMEList.add(File.get(i).substring(0, File.get(i).indexOf(',')));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void ChannelDivide() {
		for (int i=0; i<File.size();i++) {
			CHANNEList.add(Integer.parseInt(File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void SignalDivide() {
		for (int i=0; i<File.size();i++) {
			SIGNAList.add(Integer.parseInt(File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void LatDivide() {
		for (int i=0; i<File.size();i++) {
			LATList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void LonDivide() {
		for (int i=0; i<File.size();i++) {
			LONList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void AltDivide() {
		for (int i=0; i<File.size();i++) {
			ALTList.add(Double.parseDouble((File.get(i).substring(0, File.get(i).indexOf(',')))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void AccDivide() {
		for (int i=0; i<File.size();i++) {
			ACCList.add(Double.parseDouble(File.get(i).substring(0, File.get(i).indexOf(','))));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public void TypeDivide() {

		for (int i=0; i<File.size();i++) {
			TYPEList.add(File.get(i).substring(0, File.get(i).length()));	
			File.set(i, File.get(i).substring(File.get(i).indexOf(',')+1, File.get(i).length()));
		}
	}
	
	public ArrayList<Container> getContain() {
		return Contain;
	}

	public void setContain(ArrayList<Container> contain) {
		Contain = contain;
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

	public ArrayList<String> getFile() {
		return File;
	}

	public void setFile(ArrayList<String> file) {
		File = file;
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
