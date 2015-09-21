package com.map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Map {

	private Rectangle[][] blocks = new Rectangle[2][100];
	private float screenX=0, screenY=0;
	private Rectangle[] blocksOnScreen = new Rectangle[100];
	private int len_IN = 0;
	private Rectangle outerScreen;
	private Rectangle bounds = new Rectangle(50, 50, 950, 620);


	public Map() {
		
	    for (int i = 1; i < 100; i++){
	        double r = Math.random()*50;
	        blocks[0][i]=new Rectangle(100*i, (int)(600+r), 0, 0 ); 
	    }
		
	    blocks[0][0]=new Rectangle(0, 600, 500, 25); // lower
	    blocks[0][1]=new Rectangle(620, 530, 500, 25); //top
	    blocks[0][4]=new Rectangle(620, 400, 250, 25); //topest
	    blocks[0][3]=new Rectangle(620, 700, 2000, 75); // lowest
	    blocks[0][5]=new Rectangle(2620, 530, 2000, 25); //top
	}
	
	
	public void render(Graphics g, int width, int height){
		outerScreen = new Rectangle(-50, -50, width+50, height+50);
        len_IN = 0;         
        for(int i=0; i < 100 ; i++){
            Rectangle test = new Rectangle(blocks[0][i].getMinX() - screenX, blocks[0][i].getMinY() -screenY, blocks[0][i].getWidth(), blocks[0][i].getHeight());       
            //System.out.println("test " + test + " OS " + outerScreen);
            if(test.intersects(outerScreen)){                                 
				blocksOnScreen[len_IN] = test; 
				g.draw(test);
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
