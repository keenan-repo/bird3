package com.level1.img;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Textures {
    
    public Image playerL, missle, enemy, playerR, wood;
    

	private org.newdawn.slick.SpriteSheet ss;

	private Image sprites;


    public Textures(){

        try {
			sprites = new Image("sprite_sheet.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
        ss = new org.newdawn.slick.SpriteSheet(sprites , 32, 32);
        getTextures();
        
        
    }
    
    private void getTextures(){
        playerL = ss.getSprite(0, 0);
        playerR = ss.getSprite(0, 1);
        missle  = ss.getSprite(1, 0);
        enemy   = ss.getSprite(2, 0);
        wood    = ss.getSprite(3,0);
    }
}
