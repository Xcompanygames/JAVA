package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	
	private handler Handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id,handler Handler) {
		super(x,y,id); //We will use the constractor from GameObject class
		this.Handler=Handler;
		
		for (int i = 0; i < Handler.object.size(); i++) {
			if (Handler.object.get(i).getid()==ID.Player) {
				player =Handler.object.get(i);
			}
		}
		
		
		
		
		//velX=5;
		//velY=5;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		float diffX=x-player.getX()-8;
		float diffY=y-player.getY()-8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
		
		velX = (float) (-1.0/distance *diffX);
		velY = (float) (-1.0/distance *diffY);

		if (y<=0 || y>=game.HEIGHT-32) {
			velY*=-1;
		}
		if (x<=0 || x>=game.WIDTH-16) {
			velX*=-1;
		}
		
		Handler.addObject(new Trail((int)x,(int)y,ID.Trail, Color.green,0.02f,16,16, Handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	
	
}
