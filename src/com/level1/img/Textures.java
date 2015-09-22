package com.level1.img;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Textures {
    
    public Image player, wood, missle, enemy;
    
    private SpriteSheet ss;


    public Textures(){

        try {
			ss = new SpriteSheet(new Image("sprite_sheet.png"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
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
