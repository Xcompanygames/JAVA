package MivneMatala;
import java.util.ArrayList;

public class TempContain implements Comparable<TempContain> {

	private int CHANNEL,SIGNAL;
	private String SSID,MAC;
	
	public TempContain(String ssid,String mac,int channel,int signal) {
		
		this.SSID = ssid + "";
		this.MAC = mac + "";
		this.CHANNEL = channel;
		this.SIGNAL = signal;
		
	}
	
    public int compareTo(TempContain o) {

        return this.SIGNAL-o.SIGNAL;
        
    }

	public int getCHANNEL() {
		return CHANNEL;
	}

	public void setCHANNEL(int cHANNEL) {
		CHANNEL = cHANNEL;
	}

	public int getSIGNAL() {
		return SIGNAL;
	}

	public void setSIGNAL(int sIGNAL) {
		SIGNAL = sIGNAL;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}
    
    
    
}
