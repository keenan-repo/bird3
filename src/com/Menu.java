package com;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState {
	public static int previousState = -1;


	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("this is the menu lol", 400, 400);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			if (previousState >= 0) {
				game.enterState(previousState, new FadeOutTransition(), new FadeInTransition());
				} else {
				   System.out.println("ERROR: previousState not initialized.");
				// whatever other error handling is intelligent for your game.
				}
			
			
		}
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
