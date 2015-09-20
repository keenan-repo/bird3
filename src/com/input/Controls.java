package com.input;

import org.newdawn.slick.Input;

import com.BirdGame;
import com.player.Player;

public class Controls {
	
	private BirdGame game;
	private Player p;
	private int spdL = 5, spdR = 5, spdD = 5, spdU = 5;
	
	public Controls(BirdGame game, Player p){
		this.game = game;
		this.p = p;
	}

	public void processInput() {
		
	
		
		//System.out.println(game.getKeys()[Input.KEY_UP]);
		    
	   // TODO This class needs to be cleaned up as well. We need to decide the range of motions we want for the bird
	// this will also change as we fix the collision detection
	// I was just adding things to make it work for now
	
	// TODO Make the screen scroll smooth. It should have an acceleration and deacceleration to it
	
	// If the up key is pressed move the bird up for 4 iterations. This is done to make the movement smooth
	// instead of moving up in 1 frame
	/*if(jump <= MAX_JUMP){ 
	    p.setVelY(-spdU);
		jump++;
	} else if (jump > MAX_JUMP) {
	    p.setVelY(spdD);
	}*/
	
	// If the w key or the up key is pressed, jump
	// If the up direction key is used
	if(game.getKeys()[Input.KEY_UP]){	  
		//playJump(); 	    	// Play the jump sound!
	// This is where we check to see if we're on the ground or a surface. 
	/*for(int i = 0 ; i < lenIn; i++){
	    if(p.getB().intersects(blocksOnScreen[i])) { // if it intersects with a block
	    jump = 0;
	    System.out.println("up");
	} else if (!p.getB().intersects(bounds)){ // if it intersects with the bottom of the map
	            jump = 0;                   
	        }
	    }     */
		p.setVelY(-1);
		//game.getKeys()[Input.KEY_UP]=false;
	
	}
	
	// We will only need this if the bird is going into a hole or some other reason to go down
	
	
	/*if(game.getKeys()[Input.KEY_DOWN]){
	    if(p.getX() < 100) {
	        screenx -= 3;
	        p.setVelX(0);
	    } else if (p.getX() > 100)            
	        p.setVelX(-spdL); 	                 
	    }   
		p.setVelY(-spdD);
	}
	
	// If the left direction key is used
	if(game.getKeys()[Input.KEY_LEFT]){
	    if(p.getX() < 100) {
	        screenx -= 3;
	        p.setVelX(0);
	    } else if (p.getX() > 100)            
	        p.setVelX(-spdL); 	                 
	    }    
		p.setVelY(-spdL);
	}
	
	// If the right direction key is used
	if(game.getKeys()[Input.KEY_RIGHT]){
	    swap=true;
	    if(p.getX() > 900) {
	        screenx += 3;
	        p.setVelX(0);
	    } else if (p.getX() < 900)            
	        p.setVelX(spdR);                    
	    }   
		p.setVelX(spdR);
	}
	
	 
	// Always set the birds speed to be downwards
	// TODO add a proper gravity. Maybe a floor or a check if they fall off a cliff
	
	for(int i = 0 ; i < lenIn; i++){
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
	}
}


