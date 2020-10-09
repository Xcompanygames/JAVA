package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	
	
	public Player(int x, int y, ID id) {
		super(x,y,id);
	}
	
	
	////We will use the tick function to initiate actions when refreshing the frame
	public void tick() {
		x+=velX;
		y+=velY;
		
		x=game.clamp(x,0, game.WIDTH-48);
		y=game.clamp(y,0, game.HEIGHT-71);

	}

	////We will render the graphic of the player object in each render
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	
	
}
