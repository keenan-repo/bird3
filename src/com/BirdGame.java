package com;


import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.SlickException;

import com.img.ImageLoader;
import com.img.Textures;
import com.input.Controls;
import com.map.Map;
import com.player.Player;

import physics.CollisionDetect;

public class BirdGame extends BasicGame {
    
	
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 3 * 2;
	private Image spriteSheet, wood, Level_1;
	private Player p;
	private Textures tex;
	private Controls c;
	private Map map;
	private CollisionDetect collision;
	private boolean keys[] = new boolean[300];

	public BirdGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer container) throws SlickException {		
		ImageLoader loader = new ImageLoader();
        try{            
            spriteSheet = loader.loadImage("sprite_sheet.png");
           // Level_1 = loader.loadImage("BackGround.png");
            //wood = loader.loadImage("wood.png");
     
        }catch(IOException e){
            e.printStackTrace();
        }
        
		tex = new Textures(this);
		map = new Map();
		p = new Player(150, 500, tex);
		c = new Controls(this, p, map);
		collision = new CollisionDetect(p, c, map);


	}

	public void update(GameContainer container, int delta) throws SlickException {

		collision.check();
		/*c.setSpdD(1);
		c.setSpdL(1);
		c.setSpdR(1);
		c.setSpdU(1);*/
		
		c.processInput();
		p.tick();
		//System.out.println(keys[Input.KEY_UP]);
		
	}
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.render(g, WIDTH, HEIGHT);
		p.render(g);
		//g.drawImage(getSpriteSheet(), 100,100, null);

	}

	
	public void keyReleased(int key, char code){
		 keys[key] = false;
		 p.setVelY(0);
		 p.setVelX(0);

	}
	
	public void keyPressed(int key, char code){
		keys[key] = true;
		// System.out.println("code " + key + " input " + Input.KEY_RIGHT + " Array " + keys[key]);
			/*if(getKeys()[Input.KEY_RIGHT]){
				p.setVelX(5);
			}*/
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new BirdGame("Bird Game"));
			container.setDisplayMode(WIDTH,HEIGHT,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}


	}

	public Image getSpriteSheet() {
		return spriteSheet;
	}

	public boolean[] getKeys(){
		return keys;
	}
}
