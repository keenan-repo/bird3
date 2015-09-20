package com.img;

import org.newdawn.slick.Image;

import com.BirdGame;


public class Textures {
    
    public Image player;
    
    private SpriteSheet ss;

	private BirdGame game;

    public Textures(BirdGame game){
    	this.game = game;

        ss = new SpriteSheet(game.getSpriteSheet());
        //Image player = ss.getSubImage(1, 1, 32, 32);
        getTextures();
        
        
    }
    
    private void getTextures(){

        player = ss.grabImage(1, 1, 32, 32);
        //missle = ss.grabImage(2, 1, 32, 32);
        //enemy = ss.grabImage(3, 1, 32, 32);
    }
}
