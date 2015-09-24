package com.level1.img;
import java.util.LinkedList;

import org.newdawn.slick.Graphics;

import com.level1.Launch1;
import com.level1.map.Map1;
import com.level1.units.Enemy;


public class Controller {

    private LinkedList<Bullet> b = new LinkedList<Bullet>();
    private LinkedList<Enemy> e = new LinkedList<Enemy>();
    
    Bullet TempBullet;
    Enemy TempEnemy;
    
    Launch1 game;
    Textures tex;
	Map1 map;
    
    public Controller( Textures tex, Map1 map){
        this.tex = tex;
        this.map = map;
 
        addEnemy(new Enemy(650, 368, tex, map));
    }
    


    public void tick() {
        for(int i = 0; i < b.size(); i++){
            TempBullet = b.get(i);
        
            if(TempBullet.getY() < 0)
                removeBullet(TempBullet);
            
            TempBullet.tick();
        }
        
        for(int i = 0; i < e.size(); i++){
            TempEnemy = e.get(i);;
            
            TempEnemy.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < b.size(); i++){
            TempBullet = b.get(i);
            
            if (TempBullet.getX() > 1500){
            	b.remove(i);
            } else if (TempBullet.getX() < -10){
            	b.remove(i);
            }
            
            TempBullet.render(g);
        }
        
        for(int i = 0; i < e.size(); i++){
            TempEnemy = e.get(i);
            TempEnemy.render(g);
            
            
            
        }
        
    }
        
        public void addBullet(Bullet block){
            b.add(block);
        }
        
        private void addEnemy(Enemy enemy) {
            e.add(enemy);        
        }
        
        
        public void removeBullet(Bullet block){
            b.remove(block);
        }
        
        
        public void removeEnemy(Enemy enemy){
            b.remove(enemy);
        }
    
}
