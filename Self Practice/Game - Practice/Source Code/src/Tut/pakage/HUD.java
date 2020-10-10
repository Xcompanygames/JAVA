package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	
	public static int HEALTH =100;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;

	
	public void tick() {
		HEALTH=game.clamp(HEALTH, 0, 100);
		greenValue=game.clamp(greenValue, 0, 255);
		greenValue = HEALTH*2;
		score++;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.GRAY); //A "background" for the HP bar
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(new Color(75,greenValue,0)); //The HP bar itself
		g.fillRect(15, 15, HEALTH*2, 32); //Health is 100, so 100*2 = is the size of the grey rectangle
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32); //A border for the HP bar
		
		g.drawString("Score: "+ score, 15, 64);
		g.drawString("Level: "+ level, 15, 84);

	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level=level;
	}
	
	
}
