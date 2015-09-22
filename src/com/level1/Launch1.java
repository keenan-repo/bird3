package com.level1;

import java.io.IOException;


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
import com.level1.img.Controller;
import com.level1.img.ImageLoader;
import com.level1.img.Textures;
import com.level1.input.Controls;
import com.level1.map.Map1;
import com.level1.player.Player;

import physics.CollisionDetect;

public class Launch1 extends BasicGameState {


	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 3 * 2;
	private Image spriteSheet, wood, Level_1;
	private Player p;
	private Textures tex;
	private Controls c;
	private Map1 map;
	private CollisionDetect collision;
	private boolean keys[] = new boolean[300];
	private Controller controller;

	public void init(GameContainer container, StateBasedGame arg1) throws SlickException {
		ImageLoader loader = new ImageLoader();
		try {
			spriteSheet = loader.loadImage("sprite_sheet.png");
			Level_1 = loader.loadImage("BackGround.png");
			// wood = loader.loadImage("wood.png");

		} catch (IOException e) {
			e.printStackTrace();
		}

		tex = new Textures();
		map = new Map1(tex);
		p = new Player(150, 500, tex);
		controller = new Controller(tex);
		c = new Controls(this, p, map);
		collision = new CollisionDetect(p);

	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

		c.processInput(collision.check(map.getBlocksOnScreen(), map.getBounds(), map.getLen_IN()));
		p.tick();
	       System.out.println(p.getX()+map.getScreenX() + " , " + p.getY()+map.getScreenY());
		
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			Menu.previousState = getID();
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
			
		}
		if(p.getX()+map.getScreenX() > 2586 && p.getY()+map.getScreenY() > 629){			
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
			
		}

	}

	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		map.render(g, WIDTH, HEIGHT);
		p.render(g);
		controller.render(g);

	}
	

	public void keyReleased(int key, char code) {
		keys[key] = false;
		p.setVelY(0);
		p.setVelX(0);

	}

	public void keyPressed(int key, char code) {
		keys[key] = true;
	}

	
	public int getID() {
		return 1;
	}
	

	public Image getSpriteSheet() {
		return spriteSheet;
	}

	public boolean[] getKeys() {
		return keys;
	}

	public Image getLevel_1() {
		return Level_1;
	}


}
