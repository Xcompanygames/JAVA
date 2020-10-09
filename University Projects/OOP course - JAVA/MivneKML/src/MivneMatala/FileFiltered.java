package MivneMatala;

import java.util.ArrayList;

public class FileFiltered {
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
	
	public FileFiltered(ArrayList<String> File) {
	    
		for(String List : File)
	    {   
	        this.File.add(List);
	    }
		
		for (int i = 1 ; i < File.size(); i++) {
		this.File.set(i, this.File.get(i)+",");
		TIMEListDivide(i);
		IDListDivide(i);
		LATListDivide(i);
		LONListDivide(i);
		ALTListDivide(i);
		WIFISUMListDivide(i);
		
			for (int j=0; j<WIFISUMList.get(i-1);j++) {
			
				LATList.add(LATList.get(i-1));
				LONList.add(LONList.get(i-1));
				ALTList.add(ALTList.get(i-1));
				TIMEList.add(TIMEList.get(i-1));
				IDList.add(IDList.get(i-1));
				SSIDListDivide(i);
				MACListDivide(i);
				CHANNEListDivide(i);
				SIGNALListDivide(i);
			
			}
		}
		
		Contain.add(new Container(INDEXList,SIGNAList,CHANNEList,TIMEList,IDList,MACList,
				SSIDList,LATList,LONList,ALTList));
		
		//Test();
	}

	public void Test() {
		for(int i=0;i<LATList.size();i++) {
			System.out.println(LATList.get(i));
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
			this.SIGNAList.add(Integer.parseInt((File.get(i).substring(0, File.get(i).indexOf(',')))));	
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
