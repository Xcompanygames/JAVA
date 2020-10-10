package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	handler Handler;
	
	public Player(int x, int y, ID id,handler Handler) {
		super(x,y,id);
		this.Handler=Handler;
	}
	
	
	////We will use the tick function to initiate actions when refreshing the frame
	public void tick() {

		x+=velX;
		y+=velY;
		
		x=game.clamp((int)x,0, game.WIDTH-48);
		y=game.clamp((int)y,0, game.HEIGHT-71);
		
		collision();
		
		Handler.addObject(new Trail((int)x,(int)y,ID.Trail, Color.white,0.02f,30,30, Handler));


	}

	private void collision() {
		for (int i = 0; i < Handler.object.size(); i++) {
			GameObject tempObject = Handler.object.get(i);
			if (tempObject.getid()==ID.BasicEnemy||tempObject.getid()==ID.FastEnemy||tempObject.getid()==ID.SmartEnemy) { //Temp object is now basic enemy
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH-=2;
				}
			}
		}
	}


	////We will render the graphic of the player object in each render
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}


	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	
	
}
