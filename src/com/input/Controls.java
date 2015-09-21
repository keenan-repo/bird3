package com.input;

import org.newdawn.slick.Input;
import com.BirdGame;
import com.map.Map;
import com.player.Player;

public class Controls {
	
	private BirdGame game;
	private Player p;
	private Map map;
	private float spdL, spdR, spdD, spdU;
	private int jump = 301;
	public Controls(BirdGame game, Player p, Map map){
		this.game = game;
		this.p = p;
		this.map = map;
	}

	public void processInput() {
		
	
		
		//System.out.println(game.getKeys()[Input.KEY_UP]);
		    
	   // TODO This class needs to be cleaned up as well. We need to decide the range of motions we want for the bird
	// this will also change as we fix the collision detection
	// I was just adding things to make it work for now
	
	// TODO Make the screen scroll smooth. It should have an acceleration and deacceleration to it
	
	int MAX_JUMP = 200;
	// If the up key is pressed move the bird up for 4 iterations. This is done to make the movement smooth
	// instead of moving up in 1 frame
	if(jump <= MAX_JUMP){ 
	    p.setVelY((float)(-(spdU*25/(jump))-0.5));
		jump++;
	} else if (jump > MAX_JUMP) {
	    p.setVelY(spdD*2);
	}
	
	// If the w key or the up key is pressed, jump
	
	if(game.getKeys()[Input.KEY_UP]){
		
		// This is where we check to see if we're on the ground or a surface. 
		for(int i = 0 ; i < map.getLen_IN(); i++){
		    if(p.getB().intersects(map.getBlocksOnScreen()[i])) { // if it intersects with a block
		    jump = 1;
		    } else if (!p.getB().intersects(map.getBounds())){ // if it intersects with the bottom of the map
		            jump = 1;      
		            
		    } else if (jump > MAX_JUMP-10){
		    	jump = 1;
		    }
		}     
		
		
		game.getKeys()[Input.KEY_UP]=false;	
	}
		
	
	
	// We will only need this if the bird is going into a hole or some other reason to go down
	
	
	if(game.getKeys()[Input.KEY_DOWN]){
	   if(p.getY() > 630) {
	        p.setVelY(0);
	    } else if (p.getX() > 100) {           
	        p.setVelY(-spdL); 	    
	    	}
		p.setVelY(spdD);
	    }   

	
	
	// If the left direction key is used
	if(game.getKeys()[Input.KEY_LEFT]){
	    if(p.getX() < 100) {
	        map.setScreenX((float)(map.getScreenX()-0.5));
	        p.setVelX(0);
	    } else if (p.getX() > 100){            
	        p.setVelX(-spdL); 	                 
	    }    
		p.setVelX(-spdL);
	}
	
	// If the right direction key is used
	if(game.getKeys()[Input.KEY_RIGHT]){

	    if(p.getX() > 900) {
	    	map.setScreenX((float)(map.getScreenX()+0.5));
	        p.setVelX(0);
	    } else if (p.getX() < 900){        
	        p.setVelX(spdR);                    
	    }   
		p.setVelX(spdR);
	}
	
	 
	// Always set the birds speed to be downwards
	// TODO add a proper gravity. Maybe a floor or a check if they fall off a cliff
	
	/*for(int i = 0 ; i < lenIn; i++){
	    if(!p.getB().intersects(squaresIn[i])) { // if it intersects with a block
	        p.setVelY(spdD);
	    } else if (p.getB().intersects(bounds)){ // if it intersects with the bottom of the map
	        spdD=0;                   
	    }
	} 
	    if (keys[KeyEvent.VK_SPACE] && !is_shooting){
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
	
	public float getSpdL() {
		return spdL;
	}

	public void setSpdL(float spdL) {
		this.spdL = spdL;
	}

	public float getSpdR() {
		return spdR;
	}

	public void setSpdR(float spdR) {
		this.spdR = spdR;
	}

	public float getSpdD() {
		return spdD;
	}

	public void setSpdD(float spdD) {
		this.spdD = spdD;
	}

	public float getSpdU() {
		return spdU;
	}

	public void setSpdU(float spdU) {
		this.spdU = spdU;
	}
}


