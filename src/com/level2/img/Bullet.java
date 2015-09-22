package com.level2.img;

import org.newdawn.slick.Graphics;
public class Bullet {
    
    private double x;
    private double y;
    
    private Textures2 tex;
    
    public Bullet(double x, double y, Textures2 tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
        
    }
    
    public void tick(){
        x -= 5;
    }
    
    public void render(Graphics g){
        g.drawImage(tex.missle, (int)x, (int)y, null);
    }

    public double getY() {
        return y;
    }
    

    public double getX() {
        return x;
    }
    
}
