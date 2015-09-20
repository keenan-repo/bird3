package com.img;



import java.io.IOException;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class ImageLoader {
    private Image image;
    
    public Image loadImage(String path) throws IOException{
        try {
			image = new Image(path);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return image;
        
    }
}
