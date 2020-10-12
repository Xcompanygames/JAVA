package Tut.pakage;

import java.util.Random;

public class Spawn {
	private handler Handler;
	private HUD hud;
	private int scoreKeep=0;
	
	private Random r = new Random();
	
	public Spawn(handler Handler, HUD hud) {
		this.Handler=Handler;
		this.hud=hud;
	}
	
	public void tick() {
		scoreKeep++;
		if(scoreKeep>=100) {
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			
			if (hud.getLevel()==2) {
			Handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.BasicEnemy,Handler));
			}
			if (hud.getLevel()==3) {
				Handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.BasicEnemy,Handler));
			}
			if (hud.getLevel()==4) {
				Handler.addObject(new FastEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.FastEnemy,Handler));
			}
			if (hud.getLevel()==5) {
				Handler.addObject(new SmartEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.SmartEnemy,Handler));
			}
			if (hud.getLevel()==6) {
				Handler.addObject(new SmartEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.SmartEnemy,Handler));
			}
			if (hud.getLevel()==7) {
				Handler.addObject(new SmartEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50),ID.SmartEnemy,Handler));
			}
			if (hud.getLevel()==10) {
				Handler.clearEnemies();
				Handler.addObject(new EnemyBoss((game.WIDTH/2)-48,-120,ID.EnemyBoss,Handler));
			}
		}
	}
	
}
