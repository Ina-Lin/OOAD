package Object;

import java.awt.Point;

public class Port {

	public BasicObject obj;
	Direction Dire;
	
	Port(BasicObject obj,Direction Dire){
		this.obj = obj;
		this.Dire = Dire;
	}
	
	public Point getPosition() {
		Point position = null;
		switch(Dire){
			case NORTH:
				position = new Point((obj.position.x + (obj.width / 2)), (obj.position.y)); //top
				break;
			case SOUTH:
				position = new Point((obj.position.x + (obj.width / 2)), (obj.position.y + obj.height)); //bottom
				break;
			case WEST:
				position = new Point((obj.position.x), (obj.position.y + (obj.height / 2))); //left
				break;
			case EAST:
				position = new Point((obj.position.x + obj.width), (obj.position.y + (obj.height / 2))); //right
				break;
		}
		return position;
	}
	
	//showport()
}
