package com.level1.map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.geom.TexCoordGenerator;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tests.TexturePaintTest;

import com.level1.Launch1;
import com.level1.img.Textures;

public class Map1 {

	private Rectangle[][] blocks = new Rectangle[2][100];
	private float screenX=0, screenY=0;
	private Rectangle[] blocksOnScreen = new Rectangle[100];
	private int len_IN = 0;
	private Rectangle outerScreen;
	private Rectangle bounds = new Rectangle(50, 50, 950, 620);
	private Textures tex;
	private TexCoordGenerator texPaint;
	protected Shape texRect = new Rectangle(0, 0, 10, 10);
	private Image background;


	public Map1(Textures tex) {
		this.tex = tex;
	    for (int i = 1; i < 100; i++){
	        double r = Math.random()*50;
	        blocks[0][i]=new Rectangle(100*i, (int)(600+r), 0, 0 ); 
	    }
		
	    blocks[0][0]=new Rectangle(0, 600, 500, 25); // lower
	    blocks[0][1]=new Rectangle(620, 530, 500, 25); //top
	    blocks[0][4]=new Rectangle(620, 400, 250, 25); //topest
	    blocks[0][3]=new Rectangle(620, 700, 2000, 75); // lowest
	    blocks[0][5]=new Rectangle(2620, 400, 60, 300); //top

	    
	    try {
			background = new Image("BackGround.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	    
	    texPaint = new TexCoordGenerator() {
			public Vector2f getCoordFor(float x, float y) {
				float tx = (texRect.getX() - x) / texRect.getWidth();
				float ty = (texRect.getY() - y) / texRect.getHeight();
				
				return new Vector2f(tx,ty);
			}
		};
	}
	
	
	public void render(Graphics g, int width, int height){
		outerScreen = new Rectangle(-50, -50, width+50, height+50);

        len_IN = 0;       
        g.drawImage(background, -screenX, -screenY);
        
	       if(screenX < width){
	    	   g.drawImage(background, -screenX, -screenY);
	       }   if(screenX > 0){
	    	   g.drawImage(background, -screenX+width, -screenY);
           }  if (screenX > width) {
        	   g.drawImage(background, -screenX+width*2, -screenY);
           } if (screenX > width*2) {
        	   g.drawImage(background, -screenX+width*3, -screenY);
           }
        
        
        for(int i=0; i < 100 ; i++){
            Rectangle test = new Rectangle(blocks[0][i].getMinX() - screenX, blocks[0][i].getMinY() -screenY, blocks[0][i].getWidth(), blocks[0][i].getHeight());       
            //System.out.println("test " + test + " OS " + outerScreen);
            if(test.intersects(outerScreen)){                                 
				blocksOnScreen[len_IN] = test; 
				g.setColor(Color.white);
				g.texture(test, tex.wood);
				ShapeRenderer.texture(test, tex.wood, texPaint);
				
				g.fill(test);
                len_IN++;                  
            }
        }
        g.draw(bounds);
        g.draw(outerScreen);
        

	}
	

	
	public float getScreenY() {
		return screenY;
	}


	public void setScreenY(float screenY) {
		this.screenY = screenY;
	}


	public float getScreenX() {
		return screenX;
	}


	public void setScreenX(float screenX) {
		this.screenX = screenX;
	}


	public Rectangle getOuterScreen() {
		return outerScreen;
	}


	public int getLen_IN() {
		return len_IN;
	}


	public Rectangle[] getBlocksOnScreen() {
		return blocksOnScreen;
	}


	public Rectangle getBounds() {
		return bounds;
	}

	
}
