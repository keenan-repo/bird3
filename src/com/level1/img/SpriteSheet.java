package com.level1.img;

import org.newdawn.slick.Image;


public class SpriteSheet {
    private Image img;
    
    public SpriteSheet(Image img){
        this.img = img;
    }
    
    public Image grabImage(int col, int row, int width, int height){
        Image subimg = img.getSubImage((col * 32 )-32, (row * 32) - 32, width, height);
        return subimg; 
    }
    
}
