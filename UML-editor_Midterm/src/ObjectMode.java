import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

abstract class ObjectMode implements Mode{
	
	ArrayList<Mode> Component = new ArrayList<Mode>();
	Point position = new Point();
	int dX;
	int dY;
	boolean isGroup = false;
	abstract boolean isContain(Point position);
	public abstract void initialLocation(Point position);
	abstract void showSelected(Graphics g);
	abstract int  getWidth();
	abstract int getHeight();
	
	void add(Mode m){
		Component.add(m);
	}
	
	void setDis(Point position){
		dX = position.x - this.position.x;
		dY = position.y - this.position.y;
	}
	
}
