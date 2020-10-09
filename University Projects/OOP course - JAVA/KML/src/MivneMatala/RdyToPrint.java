package MivneMatala;


import java.util.ArrayList;

public class RdyToPrint {
	
	private ArrayList<Container> PRINT = new ArrayList<Container>();
	private ArrayList<String>TOPRINT = new ArrayList<String>();
	private ArrayList<Container> Contain = new ArrayList<Container>();
	int TITLE=0;
	
	public RdyToPrint(ArrayList<Container> print,int title) {
		
		for(Container List : print) {this.PRINT.add(List);}
		this.TITLE = title;
		
		ConvertionToPrint();
		ConvertionToUse();
		//Test();
		
	}
	
	public void Test() {
		for (int i=0 ; i< TOPRINT.size();i++) {
			System.out.println(TOPRINT.get(i));
		}
	}
	
	public void ConvertionToPrint() {
		String Container = "";
		if (TITLE == 0 ) {TOPRINT.add("Title");}
		for (int i=0;i<PRINT.size();i++) {
			
			Container = PRINT.get(i).getTIMEList().get(0)+","+PRINT.get(i).getIDList().get(0)+","+PRINT.get(i).getLATList().get(0)+","+
						PRINT.get(i).getLONList().get(0)+","+PRINT.get(i).getALTList().get(0)+","+PRINT.get(i).getSIGNAList().size();
			
			for (int j=0;j<PRINT.get(i).getSIGNAList().size();j++) {
				
				Container = Container +","+ PRINT.get(i).getSSIDList().get(j)+","+
							PRINT.get(i).getMACList().get(j)+","+PRINT.get(i).getCHANNEList().get(j)+","+
							PRINT.get(i).getSIGNAList().get(j);
				
			}
			
			TOPRINT.add(Container);
			Container = "";
			
		}
		
		
	}
	
	public void ConvertionToUse() {
		
		
		
	}

	public ArrayList<Container> getPRINT() {
		return PRINT;
	}

	public void setPRINT(ArrayList<Container> pRINT) {
		PRINT = pRINT;
	}

	public ArrayList<String> getTOPRINT() {
		return TOPRINT;
	}

	public void setTOPRINT(ArrayList<String> tOPRINT) {
		TOPRINT = tOPRINT;
	}

	public ArrayList<Container> getContain() {
		return Contain;
	}

	public void setContain(ArrayList<Container> contain) {
		Contain = contain;
	}
	
	
}
