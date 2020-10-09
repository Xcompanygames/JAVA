package MivneMatala;


import java.util.ArrayList;

import javax.sound.sampled.Line;

public class Algorithm2 {

	private ArrayList<Container> CHECK = new ArrayList<Container>();
	private ArrayList<Container> DATA = new ArrayList<Container>();
	private ArrayList<Double> PIList  = new ArrayList<Double>();
	private ArrayList<Integer> LINEList  = new ArrayList<Integer>();
	private double PI=1;
	private ArrayList<PIContainer> PIContain = new ArrayList<PIContainer>();
	private final int X = 3;
	private final int Y = -120;
	private final int Z = 100;
	private final int J = 10000;
	private final double I = 0.4;
	private final int P = 2;
	private int DIFF = 0;
	private double WEIGHT,SUMLATw,SUMLONw,SUMALTw,SUMWEIGHT;
	private ArrayList<Double> FINALAT = new ArrayList<Double>();
	private ArrayList<Double> FINALON = new ArrayList<Double>();
	private ArrayList<Double> FINALALT = new ArrayList<Double>();
	private ArrayList<Container> ALGOAFTER = new ArrayList<Container>();
	
	public Algorithm2(ArrayList<Container> check, ArrayList<Container> data) {
		
		for(Container List : check) {this.CHECK.add(List);}
		for(Container List : data) {this.DATA.add(List);}
		
		Checker();
		Algo1();
	//	Test();
		
	}
	
	public void Test() {
		for (int i=0;i<ALGOAFTER.size();i++) {
			System.out.println("index - "+ALGOAFTER.get(i).getINDEXList()+"Date - "+ ALGOAFTER.get(i).getTIMEList()+"ID - "
					+ALGOAFTER.get(i).getIDList()+"Lat - "+ALGOAFTER.get(i).getLATList().toString()+"Lon - "+ALGOAFTER.get(i).getLONList().toString()+"Alt - "
					+ALGOAFTER.get(i).getALTList().toString()+"SSID -"
					+ALGOAFTER.get(i).getSSIDList()+"MAC - "+ALGOAFTER.get(i).getMACList()+"Channel -"+ALGOAFTER.get(i).getCHANNEList()+"Signal -"+ALGOAFTER.get(i).getSIGNAList());
			}
		
	}
	
	public void Checker() {
		
		for (int i=0;i<CHECK.size();i++) {
			
			for (int j=0;j<DATA.size();j++) {
				
				for (int s=0; s<Math.min(3, CHECK.get(i).getSIGNAList().size());s++) {
					
					for  (int k=0; k<Math.min(3, DATA.get(j).getSIGNAList().size()); k++) {
					PIE(i,j,s,k);
					
					}
					
					LINEList.add(j);
					PIList.add(PI);
					PI = 1;
					
				}
			
			}
						
			ArrayList<Double> copyPI  = new ArrayList<Double>();
			ArrayList<Integer> copyLINE  = new ArrayList<Integer>();
			copyPI.addAll(PIList);
			copyLINE.addAll(LINEList);
			PIContain.add(new PIContainer (copyLINE,copyPI));
			//System.out.println("PI = " + PIContain.get(i).getSorterPI().get(0).getPI());
			//System.out.println("LINE = " + PIContain.get(i).getSorterPI().get(0).getLINE());
			LINEList.clear();
			PIList.clear();
		}
		
	}
	
	public void PIE(int i,int j,int s,int k) {
		
		if (DATA.get(j).getSIGNAList().get(k).equals(Y)) {
			
			DIFF = Z;
			
		} else { DIFF = Math.max(Math.abs(CHECK.get(i).getSIGNAList().get(s)-DATA.get(j).getSIGNAList().get(k)), X);}
		
		PI = PI*(J / (Math.pow(DIFF, I)*Math.pow((double)(CHECK.get(i).getSIGNAList().get(s)),P)));
		
	}
	
	public void Algo1(){
		
		for (int i=0;i<PIContain.size();i++) {
			for (int j=0;j<PIContain.get(i).getSorterPI().size();j++) {
				
				WEIGHT = PIContain.get(i).getSorterPI().get(j).getPI();
				SUMWEIGHT = SUMWEIGHT + WEIGHT;
				SUMLATw = SUMLATw + DATA.get(PIContain.get(i).getSorterPI().get(j).getLINE()).getLATList().get(0)*WEIGHT;
				SUMLONw = SUMLONw + DATA.get(PIContain.get(i).getSorterPI().get(j).getLINE()).getLONList().get(0)*WEIGHT;
				SUMALTw = SUMALTw + DATA.get(PIContain.get(i).getSorterPI().get(j).getLINE()).getALTList().get(0)*WEIGHT;

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
			ALGOAFTER.add(new Container(CHECK.get(i).getINDEXList(),
					CHECK.get(i).getSIGNAList(),
					CHECK.get(i).getCHANNEList(),
					CHECK.get(i).getTIMEList(),
					CHECK.get(i).getIDList(),
					CHECK.get(i).getMACList(),
					CHECK.get(i).getSSIDList(),
			        copyLAT,
			        copyLON,
			       copyALT));
			FINALAT.clear();
			FINALON.clear();
			FINALALT.clear();
		}
		
	}

	public ArrayList<Container> getCHECK() {
		return CHECK;
	}

	public void setCHECK(ArrayList<Container> cHECK) {
		CHECK = cHECK;
	}

	public ArrayList<Container> getDATA() {
		return DATA;
	}

	public void setDATA(ArrayList<Container> dATA) {
		DATA = dATA;
	}

	public ArrayList<Double> getPIList() {
		return PIList;
	}

	public void setPIList(ArrayList<Double> pIList) {
		PIList = pIList;
	}

	public ArrayList<Integer> getLINEList() {
		return LINEList;
	}

	public void setLINEList(ArrayList<Integer> lINEList) {
		LINEList = lINEList;
	}

	public double getPI() {
		return PI;
	}

	public void setPI(double pI) {
		PI = pI;
	}

	public ArrayList<PIContainer> getPIContain() {
		return PIContain;
	}

	public void setPIContain(ArrayList<PIContainer> pIContain) {
		PIContain = pIContain;
	}

	public int getDIFF() {
		return DIFF;
	}

	public void setDIFF(int dIFF) {
		DIFF = dIFF;
	}

	public double getWEIGHT() {
		return WEIGHT;
	}

	public void setWEIGHT(double wEIGHT) {
		WEIGHT = wEIGHT;
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

	public ArrayList<Container> getALGOAFTER() {
		return ALGOAFTER;
	}

	public void setALGOAFTER(ArrayList<Container> aLGOAFTER) {
		ALGOAFTER = aLGOAFTER;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getZ() {
		return Z;
	}

	public int getJ() {
		return J;
	}

	public double getI() {
		return I;
	}

	public int getP() {
		return P;
	}
	
	
	
}
