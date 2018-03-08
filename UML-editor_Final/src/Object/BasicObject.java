package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public abstract class BasicObject extends Shape{
	
	public Point position = null;
	public Port[] ports = new Port[4];
	int width;
	int height;
	int dX;
	int dY;
	String input;
	final int w = 10;
	final int h = 10;
	
	public abstract void initialLocation(Point position);
	public abstract void setName(String input);
	public abstract boolean isInside(Point position);
	public abstract void drawName(Graphics g);
	public abstract Port getPort(Point position);
	
	public void showPorts(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		for(int i = 0 ; i < ports.length; i++){
			g.fillRect((ports[i].getPosition().x - (w / 2)), (ports[i].getPosition().y - (h / 2)), w, h);
		}
	}
	
	public void setDis(Point position){
		dX = position.x - this.position.x;
		dY = position.y - this.position.y;
	}
	
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
	
	public void addObj(ArrayList<BasicObject> selectedArr) {}
	
	public ArrayList<BasicObject> getObj(){
		return null;
	}

}