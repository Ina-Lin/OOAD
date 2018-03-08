package Object;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Group extends BasicObject{

	private ArrayList<BasicObject> group = new ArrayList<BasicObject>();
	
	public Group(ArrayList<BasicObject> selectedArr) {
		int right = 0;
		int bottom = 0;
		int left = Integer.MAX_VALUE;
		int top = Integer.MAX_VALUE;
		for(BasicObject X : selectedArr){
			int x = X.position.x;
			int y = X.position.y;
			int x1 = X.position.x + X.getWidth();
			int y1 = X.position.y + X.getHeight();
			if(x < left){left = x;}
			if(x1 > right){right = x1;}
			if(y < top){top = y;}
			if(y1 > bottom){bottom = y1;}
		}
		position = new Point(left, top);
		width = right - left;
		height = bottom - top;
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		for(BasicObject X : group) {
			X.Draw(g);
		}
	//	g.drawRect(position.x, position.y, width, height);
	}
	
	@Override
	public void drawName(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInside(Point position) {
		// TODO Auto-generated method stub
		for(BasicObject obj : group) {
			if(obj.isInside(position)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addObj(ArrayList<BasicObject> selectedArr) {
		for(BasicObject X : selectedArr) {
			group.add(X);
		}
	}
	
	@Override
	public ArrayList<BasicObject> getObj(){
		return group;
	}
	
	@Override
	public void showPorts(Graphics g) {
		for(BasicObject obj : group) {
			obj.showPorts(g);
		}
	}
	
	@Override
	public void initialLocation(Point position) {
		// TODO Auto-generated method stub
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
		for(BasicObject obj : group) {
			obj.initialLocation(position);
		}
	}

	public void setDis(Point position){
		dX = position.x - this.position.x;
		dY = position.y - this.position.y;
		for(BasicObject obj : group) {
			obj.setDis(position);
		}
	}
	
	@Override
	public void setName(String input) {
		// TODO Auto-generated method stub
	}

	public Port getPort(Point position) {
		// TODO Auto-generated method stub
		Port port = null;
		for(int i = group.size()-1 ; i >= 0 ; i--) {
			if(group.get(i).isInside(position)) {
				return group.get(i).getPort(position);
			}
		}
		return port;
	}
}
