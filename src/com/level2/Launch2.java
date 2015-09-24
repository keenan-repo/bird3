package com.level2;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.Menu;
import com.level1.img.Textures;
import com.level1.player.Player;
import com.level1.player.Player.Direction;
import com.level2.input.Controls2;
import com.level2.map.Map2;

import physics.CollisionDetect;

public class Launch2 extends BasicGameState {

	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 3 * 2;
	private Image spriteSheet, Level_2;
	private Player p;
	private Textures tex;
	private Controls2 c;
	private Map2 map;
	private CollisionDetect collision;
	private boolean keys[] = new boolean[300];


	public void init(GameContainer container, StateBasedGame arg1) throws SlickException {
		spriteSheet = new Image("sprite_sheet.png");
		Level_2 = new Image("Level2.png");
		
		tex = new Textures();
		map = new Map2(tex, this);
		p = new Player(150, 500, tex);
		c = new Controls2(this, p, map);
		collision = new CollisionDetect(p);


	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

		
		c.processInput(collision.check(map.getBlocksOnScreen(), map.getBounds(), map.getLen_IN()));
		p.tick();


		
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			Menu.previousState = getID();
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());				
		}
		if(p.getY()+map.getScreenY() > 800 ){			
			sbg.enterState(1, new FadeOutTransition(), null);
			p.setX(150); p.setY(500); map.setScreenX(0); map.setScreenY(0);
			
		}

	}

	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		map.render(g, WIDTH, HEIGHT);
		p.render(g);

	}


	public void keyReleased(int key, char code) {
		keys[key] = false;
		p.setVelY(0);
		p.setVelX(0);

	}

	public void keyPressed(int key, char code) {
		keys[key] = true;
		if(keys[Input.KEY_LEFT]){
			p.direction = Direction.LEFT;
		}
		if(keys[Input.KEY_RIGHT]){
			p.direction = Direction.RIGHT;
		}
	}
	
	public int getID() {
		return 2;
	}


	public Image getSpriteSheet() {
		return spriteSheet;
	}

	public boolean[] getKeys() {
		return keys;
	}

	public Image getLevel_2() {
		return Level_2;
	}


}
