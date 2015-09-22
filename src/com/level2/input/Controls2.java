package com.level2.input;

import org.newdawn.slick.Input;


import com.level1.player.Player;
import com.level2.Launch2;
import com.level2.map.Map2;

public class Controls2 {
	
	private Launch2 game;
	private Player p;
	private Map2 map;
	private float[] Speeds = new float[3]; //0 = up, 1 = right, 2 = down 3 = left

	private int jump = 301;
	private boolean doubleJump = false;
	
	public Controls2(Launch2 game, Player p, Map2 map){
		this.game = game;
		this.p = p;
		this.map = map;
	}
	
	public void processInput(float[] Speeds) {
		
		    
	 // TODO This class needs to be cleaned up as well. We need to decide the range of motions we want for the bird
	// this will also change as we fix the collision detection
	// I was just adding things to make it work for now
	
	// TODO Make the screen scroll smooth. It should have an acceleration and deacceleration to it
	
	int MAX_JUMP = 200;
	// If the up key is pressed move the bird up for 4 iterations. This is done to make the movement smooth
	// instead of moving up in 1 frame
	if(jump <= MAX_JUMP){ 
	    p.setVelY((float)(-(Speeds[0]*25/(jump))-0.5));
		jump++;
	} else if (jump > MAX_JUMP) {
	    p.setVelY(Speeds[2]*2);
	    System.out.println(Speeds[2]);
	}
	
	// If the w key or the up key is pressed, jump
	
	if(game.getKeys()[Input.KEY_UP]){
		
		// This is where we check to see if we're on the ground or a surface. 
		for(int i = 0 ; i < map.getLen_IN(); i++){
		    if(p.getB().intersects(map.getBlocksOnScreen()[i])) { // if it intersects with a block
		    jump = 1;
		    doubleJump = true;
		    } else if (!p.getB().intersects(map.getBounds())){ // if it intersects with the bottom of the map
		            jump = 1;      
		            doubleJump = true;
		    } else if (jump > MAX_JUMP-50 && doubleJump){
		    	jump = 1;
		    	doubleJump = false;
		    }
		}     
		
		
		game.getKeys()[Input.KEY_UP]=false;	
	}
		
	
	
	// We will only need this if the bird is going into a hole or some other reason to go down	
	if(game.getKeys()[Input.KEY_DOWN]){
	    }   

	
	
	// If the left direction key is used
	if(game.getKeys()[Input.KEY_LEFT]){
	    if(p.getX() < 100) {
	        map.setScreenX((float)(map.getScreenX()-0.5));
	        p.setVelX(0);
	    } else if (p.getX() > 100){            
	        p.setVelX(-Speeds[3]); 	                 
	    }    
		p.setVelX(-Speeds[3]);
	}
	
	// If the right direction key is used
	if(game.getKeys()[Input.KEY_RIGHT]){

	    if(p.getX() > 900) {
	    	map.setScreenX((float)(map.getScreenX()+0.5));
	        p.setVelX(0);
	    } else if (p.getX() < 900){        
	        p.setVelX(Speeds[1]);                    
	    }   
		p.setVelX(Speeds[1]);
	}
	
	 
	    /*if (keys[KeyEvent.VK_SPACE] && !is_shooting){
	        c.addBullet(new Bullet(p.getX(), p.getY(), tex));
	        is_shooting = true;
	        keys[KeyEvent.VK_SPACE]=false;
	    }
	   */ 
	
		if (p.getY() > 630){
			p.setVelY((float)-0.5);
			map.setScreenY((float)(map.getScreenY()+0.5));
		}
		if (p.getY() < 60){
			p.setVelY((float)+0.5);
			map.setScreenY((float)(map.getScreenY()-0.5));
		}
	}
	
	public float[] getSpeeds() {
		return Speeds;
	}

	public void setSpeeds(float[] speeds) {
		Speeds = speeds;
	}
}


