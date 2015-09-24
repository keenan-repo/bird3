package com.level1.img;

import org.newdawn.slick.Graphics;


public class Bullet {
    
    private double x;
    private double y;
    
    private Textures tex;
	private boolean dir;
	
    
    
    public Bullet(double x, double y, Textures tex, boolean dir){
        this.x = x;
        this.y = y;
        this.tex = tex;
        this.dir = dir;
        
    }
    
    public void tick(){
    	if (!dir){
    		x += 0.8;
    	} else if (dir) {
    		x -= 0.6;
    	} else {
    		x += 0.8;
    	}
    	System.out.println(x + " , " + y);
    }
    
	public void render(Graphics g){
        g.drawImage(tex.missle, (int)x, (int)y, null);
    }


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


    
}
