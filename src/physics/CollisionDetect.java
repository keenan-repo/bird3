package physics;


import org.newdawn.slick.geom.Rectangle;


import com.level1.player.Player;


public class CollisionDetect {
	private Player p;

	private float[] Speeds = new float[4]; //0 = up, 1 = right, 2 = down 3 = left
	
	public CollisionDetect(Player p) {
		this.p = p;	
		}
	

	public float[] check(Rectangle[] rectangles, Rectangle bounds, int Len_IN) {	
			Speeds[0] = ((float) 0.5);
			Speeds[1] =((float) 0.5);
			Speeds[2] =((float) 0.5);
			Speeds[3] =((float) 0.5);
			for (int i = 0; i < Len_IN; i++){
				if (p.getT().intersects(rectangles[i])) 
					Speeds[0] =  0;
				if(p.getB().intersects(rectangles[i])) {
					Speeds[2] = 0;
			}
				if(p.getR().intersects(rectangles[i])) 
					Speeds[1] = 0;       
				if(p.getL().intersects(rectangles[i])) 
					Speeds[3] = 0;
			}
					
				if (!p.getT().intersects(bounds)) 
					Speeds[0] = 0;
				if(!p.getB().intersects(bounds)) {
					Speeds[2] = 0;
			}
				if(!p.getR().intersects(bounds)) 
					Speeds[1] = 0;        
				if(!p.getL().intersects(bounds)) 
					Speeds[3] = 0;
				
				return Speeds;
			
	 }
}
