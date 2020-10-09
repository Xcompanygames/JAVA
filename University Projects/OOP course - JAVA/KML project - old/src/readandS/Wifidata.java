package readandS;

public class Wifidata 
{
    private String MAC;
    private String ID ;
    private String AuthMode ;
    private String DATE;
    private int Channel;
    private double CLatitude ;
    private double CLitude ;
    private double ALMeters  ;
    private double ACMETERES  ;
    private int RSSI  ;
    private String Type;
    
    
    public Wifidata(String MAC, String ID, String AuthMode,String DATE,int Channel, int RSSI, double CLatitude, double CLitude, double ALMeters, double ACMETERES, String Type) {
        super();
        this.MAC = MAC;
        this.DATE = DATE;
        this.Channel = Channel;
        this.CLatitude = CLatitude;
        this.CLitude = CLitude;
        this.ALMeters = ALMeters;
        this.ACMETERES = ACMETERES;
        this.Type = Type;
        this.ID = ID;
        this.AuthMode = AuthMode;
        this.RSSI = RSSI;


    }


	

	@Override
	public String toString() {
		return "Wifidata [MAC=" + MAC + ", ID=" + ID + ", AuthMode=" + AuthMode + ", DATE=" + DATE + ", Channel="
				+ Channel + ", CLatitude=" + CLatitude + ", CLitude=" + CLitude + ", ALMeters=" + ALMeters
				+ ", ACMETERES=" + ACMETERES + ", RSSI=" + RSSI + ", Type=" + Type + "]";
	}




	public String getMAC() {
		return MAC;
	}




	public void setMAC(String mAC) {
		MAC = mAC;
	}




	public String getID() {
		if (ID.equals("")){
			return "null";
		}else
			return ID;
		}




	public void setID(String iD) {
		ID = iD;
	}




	public String getAuthMode() {
		return AuthMode;
	}




	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}




	public String getDATE() {
		return DATE;
	}




	public void setDATE(String dATE) {
		DATE = dATE;
	}




	public int getChannel() {
		return Channel;
	}




	public void setChannel(int channel) {
		Channel = channel;
	}




	public double getCLatitude() {
		return CLatitude;
	}




	public void setCLatitude(double cLatitude) {
		CLatitude = cLatitude;
	}




	public double getCLitude() {
		return CLitude;
	}




	public void setCLitude(double cLitude) {
		CLitude = cLitude;
	}




	public double getALMeters() {
		return ALMeters;
	}




	public void setALMeters(int aLMeters) {
		ALMeters = aLMeters;
	}




	public double getACMETERES() {
		return ACMETERES;
	}




	public void setACMETERES(int aCMETERES) {
		ACMETERES = aCMETERES;
	}




	public int getRSSI() {
		return RSSI;
	}




	public void setRSSI(int rSSI) {
		RSSI = rSSI;
	}



/**
 * 
 * @return 
 */
	public String getType() {
		return Type;
	}



	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		Type = type;
	}









}
