package Tut.pakage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {

	
	private handler Handler;
	private int timer=80;
	private int timer2=50;
	
	Random r = new Random();

	public EnemyBoss(int x, int y, ID id,handler Handler) {
		super(x,y,id); //We will use the constractor from GameObject class
		this.Handler=Handler;
		velX=0;
		velY=2;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,96,96);
	}
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		//if (y<=0 || y>=game.HEIGHT-32) {
		//	velY*=-1;
		//}
		if (x<=0 || x>=game.WIDTH-96) {
			velX*=-1;
		}
		if(timer<=0) {
			timer = 0;
			velY=0;
		}else {
			timer--;
		}
		if(timer<=0 && timer2>0)timer2--;	

		if(timer2==0) {
			if(velX==0)velX = 5;
			if(velX>0)velX+=0.005f;
			else if(velX<0)velX-=0.005f;
			System.out.println(velX);

			velX=game.clamp(velX, -10, 10);
			int spawn = r.nextInt(10);
			if(spawn==0) Handler.addObject(new EnemyBossBullet((int)x+48,(int)y+48, ID.BasicEnemy, Handler));

			
		}
		
		
		//Handler.addObject(new Trail((int)x,(int)y,ID.Trail, Color.red,0.008f,96,96, Handler));
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 96, 96);
	}
	
	
}
