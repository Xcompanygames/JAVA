package Tut.pakage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class game extends Canvas implements Runnable {
	private static final long serialVersionUID = 5722506384225806817L;
	
	public static final int WIDTH =640, HEIGHT = WIDTH / 12*9;
	private Thread thread;
	
	private boolean running =false;
	
	private handler Handler;
	
	public game() {
		
		Handler = new handler();
		
		this.addKeyListener(new keyInput(Handler));
		
		
		
		new window(WIDTH,HEIGHT,"Build game",this);
		Handler.addObject(new Player(100,100,ID.Player));
	}
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop(){
		try {
			thread.join();
			running=false;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	public void run() {
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
		g.dispose();
		bs.show();
		
	}


	private void tick() {
		Handler.tick();
	}


	public static void main(String[] args) {
	new game();
}
	
	
	
}
