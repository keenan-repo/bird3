package com.level1.img;



import java.io.IOException;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ImageLoader {
    private Image image;
    
    public Image loadImage(String path) throws IOException{
        try {
			image = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
        return image;
        
    }
}
