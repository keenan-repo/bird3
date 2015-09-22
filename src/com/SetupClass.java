package com;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.level1.Launch1;
import com.level2.Launch2;



public class SetupClass extends StateBasedGame {
	
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 3 * 2;

	public SetupClass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new SetupClass("Bird Game"));
			container.setDisplayMode(WIDTH, HEIGHT, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState((GameState) new Launch1());
		this.addState(new Menu());
		this.addState(new Launch2());
		
		
	}
	public void render(Graphics g) {
		System.out.println("this is on top");
	}

}
