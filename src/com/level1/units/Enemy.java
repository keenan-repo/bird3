package com.level1.units;


import org.newdawn.slick.Graphics;

import com.level1.img.Textures;
import com.level1.map.Map1;
import com.level1.player.Player;


public class Enemy {
    private double x, VelX, y; 
    


	private Textures tex;

	private Map1 map;

	private int i=1;
    
    public Enemy(double x, double y, Textures tex, Map1 map){
    	this.x = x;
    	this.y = y;
    			
        this.tex = tex;
        this.map = map;
    }
    
    public void tick(){
    		if (x <= 851){
    			x += 0.1*i;
    		} if (x >= 850){
    			i=i*-1;
    		} else if (x <=625 ){
    			i = i*-1;
    		}
    }
    
    public void render(Graphics g){
        g.drawImage(tex.enemy, (int)x-map.getScreenX(), (int)y-map.getScreenY(), null);
    }
    
    public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getVelX() {
		return VelX;
	}

	public void setVelX(double velX) {
		VelX = velX;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
