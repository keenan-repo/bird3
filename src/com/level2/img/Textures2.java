package com.level2.img;

import org.newdawn.slick.Image;

import com.level2.Launch2;


public class Textures2 {
    
    public Image player, wood, missle, enemy;
    
    private SpriteSheet ss;

	Launch2 game;

    public Textures2(Launch2 game){
    	this.game = game;

        ss = new SpriteSheet(game.getSpriteSheet());
        //Image player = ss.getSubImage(1, 1, 32, 32);
        getTextures();
        
        
    }
    
    private void getTextures(){

        player = ss.grabImage(1, 1, 32, 32);
        wood = ss.grabImage(4, 1, 32, 32);
        missle = ss.grabImage(2, 1, 32, 32);
        enemy = ss.grabImage(3, 1, 32, 32);
    }
}
