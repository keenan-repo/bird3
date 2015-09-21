package physics;

import org.newdawn.slick.geom.Rectangle;

import com.input.Controls;
import com.map.Map;
import com.player.Player;

public class CollisionDetect {
	private Player p;
	private Controls c;
	private Map map;
	
	public CollisionDetect(Player p, Controls c, Map map) {
		this.p = p;
		this.c = c;
		this.map = map;
		}
	
	 public void check() {	
			c.setSpdD((float) 0.5);
			c.setSpdL((float) 0.5);
			c.setSpdR((float) 0.5);
			c.setSpdU((float) 0.5);
			for (int i = 0; i < map.getLen_IN(); i++){
				if (p.getT().intersects(map.getBlocksOnScreen()[i])) 
				    c.setSpdU(0);
				if(p.getB().intersects(map.getBlocksOnScreen()[i])) {
				    c.setSpdD(0);
			}
				if(p.getR().intersects(map.getBlocksOnScreen()[i])) 
					c.setSpdR(0);       
				if(p.getL().intersects(map.getBlocksOnScreen()[i])) 
				    c.setSpdL(0);
			}
			
			
				if (!p.getT().intersects(map.getBounds())) 
				    c.setSpdU(0);
				if(!p.getB().intersects(map.getBounds())) {
				    c.setSpdD(0);
			}
				if(!p.getR().intersects(map.getBounds())) 
					c.setSpdR(0);       
				if(!p.getL().intersects(map.getBounds())) 
				    c.setSpdL(0);
			
			
	 }
}
