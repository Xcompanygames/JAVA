package Tut.pakage;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	/////A game object will be every single object that we will use in this game
	
	protected float x,y;
	protected ID id;
	protected float velX, velY;
	
	public GameObject (float x, float y, ID id) {
		//This constractor will be used every time we create a new object
		this.x =x;
		this.y=y;
		this.id=id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x=x;
	}

		
	public void setY(int y) {
		this.y=y;
	}	
	
	
	public float getX() {
	return x;
	}	
	
	
	public float getY() {
	return y;
	}	
	
	public void setID(ID id) {
		this.id= id;
	}
	
	public ID getid() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY=velY;
	}
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}
	
	
	
	
}
