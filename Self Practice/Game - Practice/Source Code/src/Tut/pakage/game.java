package Tut.pakage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 5722506384225806817L;
	///This serial is some kind of way to verify that the 
	//sender and receiver of a serialized object have 
	//loaded classes for that object that are compatible 
	//with respect to serialization. 
	
	public static final int WIDTH =640, HEIGHT = WIDTH / 12*9;
	
	private Thread thread; //This game will use One Thread
	//This isn't a common practice for games, but for a simple one
	//as this, this will be enough (Also this is for practicing sake)
	
	private boolean running =false; //We will use that at out coroutine function
	private Random r; //Just a random value for us to use
	private handler Handler; //The handler will handle all of our Game objects
	private HUD hud; ///The player HUD
	private Spawn spawner;
	
	public game() {
		
		Handler = new handler();
		
		this.addKeyListener(new keyInput(Handler)); //A listener that will initiate keyboard inputs
		
		r= new Random();
		
		new window(WIDTH,HEIGHT,"Our_Game",this); //New Jframe window with a title and size
		
		hud = new HUD(); //Initiating a new HUD
		//
		//Adding the player and enemies
		//
		spawner = new Spawn(Handler,hud); //Initiating a new HUD

		
		Handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,Handler));
		
		Handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.BasicEnemy,Handler));


	}
	
	///synchronized methods enable a simple strategy for 
	//preventing thread interference 
	//and memory consistency errors:
	
	//public synchronized void start(){
	//	thread = new Thread(this);
	//	thread.start();
	//	running=true;
	//}
	
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	
	///////////If we won't have more than 1 thread I will remove the
	//synchronized word
	
	public synchronized void stop(){
		try {
			thread.join();
			running=false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}	
	public void run() { ///Our coroutine function
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames=0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta --;
			}
			if(running) render();
			if (frames<60) {
				frames ++;
			}
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames =0;
			}
		}
		stop();
	}
	
	private void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Handler.render(g);
		hud.render(g);

		g.dispose();
		bs.show();
		
	}


	private void tick() {
		Handler.tick();
		hud.tick();
		spawner.tick();
	}

	////Setting a max and a min value to a range
	public static int clamp(int var, int min, int max) {
		if(var >= max)return var=max;
		else if(var<= min) return var=min;
		else return var;
	}
	public static float clamp(float var, int min, int max) {
		if(var >= max)return (var=max);
		else if(var<= min) return (var=min);
		else return  var;
	}	
	public static void main(String[] args) {
	new game();
}
	
	
	
}
