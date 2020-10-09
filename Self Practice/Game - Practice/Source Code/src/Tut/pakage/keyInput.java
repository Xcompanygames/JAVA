package Tut.pakage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter{

	private handler Handler;
	
	public keyInput(handler Handler) {
		this.Handler = Handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < Handler.object.size(); i++) {
		
		GameObject tempObject = Handler.object.get(i);
		if(tempObject.getid() == ID.Player) {
		if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
		if(key == KeyEvent.VK_S) tempObject.setVelY(5);
		if(key == KeyEvent.VK_D) tempObject.setVelX(5);
		if(key == KeyEvent.VK_A) tempObject.setVelX(-5);

	}	
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1); //Exit the game
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < Handler.object.size(); i++) {
			
		GameObject tempObject = Handler.object.get(i);

		if(tempObject.getid() == ID.Player) {
		
		if(key == KeyEvent.VK_W) tempObject.setVelY(0);
		if(key == KeyEvent.VK_S) tempObject.setVelY(0);
		if(key == KeyEvent.VK_D) tempObject.setVelX(0);
		if(key == KeyEvent.VK_A) tempObject.setVelX(0);

	}	
		}
	}
}
