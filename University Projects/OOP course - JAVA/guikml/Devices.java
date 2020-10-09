/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guikml;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Devices {
    
    private int devicescount;
    private String check;
    private ArrayList<Container>FILE = new ArrayList<Container>();
    
    public Devices  (ArrayList<Container> file){
        
        for(Container List : file) {this.FILE.add(List);}
        
                     for (int i=0;i<FILE.size();i++){
                    if (!check.contains(FILE.get(i).getIDList().get(0))){
                        check=check+FILE.get(i).getIDList().get(i);
                        devicescount++;
                    }
                }
    }

    public int getDevicescount() {
        return devicescount;
    }

    public void setDevicescount(int devicescount) {
        this.devicescount = devicescount;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public ArrayList<Container> getFILE() {
        return FILE;
    }

    public void setFILE(ArrayList<Container> FILE) {
        this.FILE = FILE;
    }
    
    
}
