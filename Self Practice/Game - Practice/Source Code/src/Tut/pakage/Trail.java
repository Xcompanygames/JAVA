package Tut.pakage;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private handler Handler;
	private Color color;
	private int WIDTH, HEIGHT;
	private float life;
	public Trail(int x, int y,ID id,Color color,float life,int WIDTH,int HEIGHT,handler Handler ) {
		super(x,y,id);
		this.color=color;
		this.Handler=Handler;
		this.WIDTH=WIDTH;
		this.HEIGHT=HEIGHT;
		this.life=life;
	}
	public void tick() {

if (alpha > life) {
     if ((alpha - 0.03f) <= 0.0f) {
          alpha = 0.0f;
     } else {
          alpha -= 0.03f;
     }
} else {
     Handler.removeObject(this);
}
	}

	public void render(Graphics g) {
		Graphics2D g2d= (Graphics2D)g;
		g2d.setComposite(makeTrasparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y,HEIGHT,WIDTH);
		
		g2d.setComposite(makeTrasparent(1));
	}
	
	private AlphaComposite makeTrasparent(float alpha) {
		int type= AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type,alpha);
		
	}

	public Rectangle getBounds() {
		return null;
	}

}
