package com.level1.player;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.level1.img.Textures;


public class Player {
    
    private float x, velX = 0;
    private float y, velY = 0;
    private Rectangle T, L, R;
	Shape B;
    
    private Textures tex;
	
	public static enum Direction{
	      LEFT, RIGHT
	}
	public Direction direction = Direction.RIGHT;

    
    
    public Player(float x, float y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
               
        T = new Rectangle(x, y - 2, 32, 2);
        B = new Rectangle(x, y + 32, 32, 2);
        R = new Rectangle(x+32, y, 2, 32);
        L = new Rectangle(x-2, y, 2, 32);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        T.setLocation(x, y-2);
        B.setLocation(x, y+33);
        R.setLocation(x+32, y);
        L.setLocation(x-2, y);

    }
    
    public void render(Graphics g){
        
        //Graphics2D g2d = (Graphics2D)g;
    	g.setColor(Color.white);

    			
		switch(direction){	    
	    case LEFT:
	    	g.drawImage(tex.playerL, (float)x, (float)y, null);
	    	
	        break;
	    case RIGHT:
	    	g.drawImage(tex.playerR, (float)x, (float)y, null);
	        break;
		}
        
        /*g.draw(B);
        g.draw(T);
        g.draw(R);
        g.draw(L);*/
    }
    /* Start getters and setters */
    public Shape getT(){return T;}
    public Shape getB(){return B;}
    public Shape getL(){return L;}
    public Shape getR(){return R;}
    
    public float getY(){return y;}
    public void setY(float y){this.y = y;}
    
    public float getX(){return x;}
    public void setX(float x){this.x = x;}
    
    public void setVelY(float velY){this.velY = velY;}
    
    public void setVelX(float velX){this.velX = velX;}
    
}
