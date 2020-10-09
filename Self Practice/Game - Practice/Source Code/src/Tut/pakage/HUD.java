package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	
	public static int HEALTH =100;
	
	public void tick() {
		HEALTH--; 
		HEALTH=game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.GRAY); //A "background" for the HP bar
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(Color.GREEN); //The HP bar itself
		g.fillRect(15, 15, HEALTH*2, 32); //Health is 100, so 100*2 = is the size of the grey rectangle
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32); //A border for the HP bar
	}
}
