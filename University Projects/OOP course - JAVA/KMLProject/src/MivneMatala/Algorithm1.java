package MivneMatala;

import java.util.ArrayList;

public class Algorithm1 {

	private ArrayList<Container> ALGO = new ArrayList<Container>();
	private ArrayList<Container> ALGOAFTER = new ArrayList<Container>();
	private double SIGNAL,SUMLATw,SUMLONw,SUMALTw,SUMWEIGHT;
	private ArrayList<Double> FINALAT = new ArrayList<Double>();
	private ArrayList<Double> FINALON = new ArrayList<Double>();
	private ArrayList<Double> FINALALT = new ArrayList<Double>();
	
	public Algorithm1(ArrayList<Container> file) {
		
		for(Container List : file) {this.ALGO.add(List);}
		
	}
	
	public void Algo1(){
		
		for (int i=0;i<ALGO.size();i++) {
			for (int j=0;j<ALGO.get(i).getALTList().size();j++) {
				
				SIGNAL =(double)(ALGO.get(i).getSIGNAList().get(j));
				SUMWEIGHT = SUMWEIGHT + (1/(SIGNAL*SIGNAL));
				SUMLATw = SUMLATw + ALGO.get(i).getLATList().get(j)*(1/(SIGNAL*SIGNAL));
				SUMLONw = SUMLONw + ALGO.get(i).getLONList().get(j)*(1/(SIGNAL*SIGNAL));
				SUMALTw = SUMALTw + ALGO.get(i).getALTList().get(j)*(1/(SIGNAL*SIGNAL));

			}
			
			FINALAT.add(SUMLATw/SUMWEIGHT);
			SUMLATw = 0;
			FINALON.add(SUMLONw/SUMWEIGHT);
			SUMLONw = 0;
			FINALALT.add(SUMALTw/SUMWEIGHT);
			SUMALTw = 0;
			SUMWEIGHT = 0;
			ArrayList<Double> copyLAT = new ArrayList<Double>();
			ArrayList<Double> copyLON = new ArrayList<Double>();
			ArrayList<Double> copyALT = new ArrayList<Double>();
			copyLAT.addAll(FINALAT);
			copyLON.addAll(FINALON);
			copyALT.addAll(FINALALT);
			ALGOAFTER.add(new Container(ALGO.get(i).getINDEXList(),
			    	ALGO.get(i).getSIGNAList(),
			        ALGO.get(i).getCHANNEList(),
			        ALGO.get(i).getTIMEList(),
			        ALGO.get(i).getIDList(),
			        ALGO.get(i).getMACList(),
			        ALGO.get(i).getSSIDList(),
			        copyLAT,
			        copyLON,
			       copyALT));
			FINALALT.clear();
			FINALON.clear();
			FINALALT.clear();
		}
		
	}

	public ArrayList<Container> getALGO() {
		return ALGO;
	}

	public void setALGO(ArrayList<Container> aLGO) {
		ALGO = aLGO;
	}

	public ArrayList<Container> getALGOAFTER() {
		return ALGOAFTER;
	}

	public void setALGOAFTER(ArrayList<Container> aLGOAFTER) {
		ALGOAFTER = aLGOAFTER;
	}

	public double getSIGNAL() {
		return SIGNAL;
	}

	public void setSIGNAL(double sIGNAL) {
		SIGNAL = sIGNAL;
	}

	public double getSUMLATw() {
		return SUMLATw;
	}

	public void setSUMLATw(double sUMLATw) {
		SUMLATw = sUMLATw;
	}

	public double getSUMLONw() {
		return SUMLONw;
	}

	public void setSUMLONw(double sUMLONw) {
		SUMLONw = sUMLONw;
	}

	public double getSUMALTw() {
		return SUMALTw;
	}

	public void setSUMALTw(double sUMALTw) {
		SUMALTw = sUMALTw;
	}

	public double getSUMWEIGHT() {
		return SUMWEIGHT;
	}

	public void setSUMWEIGHT(double sUMWEIGHT) {
		SUMWEIGHT = sUMWEIGHT;
	}

	public ArrayList<Double> getFINALAT() {
		return FINALAT;
	}

	public void setFINALAT(ArrayList<Double> fINALAT) {
		FINALAT = fINALAT;
	}

	public ArrayList<Double> getFINALON() {
		return FINALON;
	}

	public void setFINALON(ArrayList<Double> fINALON) {
		FINALON = fINALON;
	}

	public ArrayList<Double> getFINALALT() {
		return FINALALT;
	}

	public void setFINALALT(ArrayList<Double> fINALALT) {
		FINALALT = fINALALT;
	}
	
	
}
