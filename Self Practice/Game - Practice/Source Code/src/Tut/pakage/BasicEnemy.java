package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	
	private handler Handler;
	
	public BasicEnemy(int x, int y, ID id,handler Handler) {
		super(x,y,id); //We will use the constractor from GameObject class
		this.Handler=Handler;
		velX=5;
		velY=5;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		if (y<=0 || y>=game.HEIGHT-32) {
			velY*=-1;
		}
		if (x<=0 || x>=game.WIDTH-16) {
			velX*=-1;
		}
		
		Handler.addObject(new Trail((int)x,(int)y,ID.Trail, Color.red,0.02f,16,16, Handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	
	
}
