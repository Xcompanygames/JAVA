package Tut.pakage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter{

	private handler Handler;
	private boolean uP = false; //UP
	private boolean dP = false; //DOWN
	private boolean lP = false; //LEFT
	private boolean rP = false; //RIGHT

	public keyInput(handler Handler) {
		this.Handler = Handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < Handler.object.size(); i++) {
		
		GameObject tempObject = Handler.object.get(i);
		if(tempObject.getid() == ID.Player) {
			

          if(key == KeyEvent.VK_W ){
            uP = true;
            tempObject.setVelY(-5);
            }
          if(key == KeyEvent.VK_S){
            dP = true;
            tempObject.setVelY(5);
            }
          if(key == KeyEvent.VK_D){
            rP = true;
            tempObject.setVelX(5);
            }
          if(key == KeyEvent.VK_A){
            lP = true;
            tempObject.setVelX(-5);
            }

	}	
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1); //Exit the game
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < Handler.object.size(); i++) {
			
		GameObject tempObject = Handler.object.get(i);

    
		if(tempObject.getid() == ID.Player) {
            if(key == KeyEvent.VK_W){
                uP = false;
                if(dP){
                	tempObject.setVelY(5);
                }
                else{
                	tempObject.setVelY(0);
                }}
            
    		if(tempObject.getid() == ID.Player) {
                if(key == KeyEvent.VK_S){
                    dP = false;
                    if(uP){
                    	tempObject.setVelY(-5);
                    }
                    else{
                    	tempObject.setVelY(0);
                    }}}
                
        		if(tempObject.getid() == ID.Player) {
                    if(key == KeyEvent.VK_D){
                        rP = false;
                        if(lP){
                        	tempObject.setVelX(-5);
                        }
                        else{
                        	tempObject.setVelX(0);
                        }}}                
                
        		if(tempObject.getid() == ID.Player) {
                    if(key == KeyEvent.VK_A){
                        lP = false;
                        if(rP){
                        	tempObject.setVelX(5);
                        }
                        else{
                        	tempObject.setVelX(0);
                        }}}                  

	}	
		}
	}
}
