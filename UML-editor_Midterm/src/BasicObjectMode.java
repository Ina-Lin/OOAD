import java.awt.Color;
import java.awt.Graphics;

abstract class BasicObjectMode extends ObjectMode implements UMLMode{
	
	final int w = 10;
	final int h = 10;
//	int dX;
//	int dY;
	String name = "";
	int[][] ports = new int[4][2]; //top bottom left right //x y
//	Point position = new Point();
//	ArrayList<Mode> connectionLineArr = new ArrayList<Mode>();
	
//	abstract void initialLocation(Point position);
	abstract void drawName(String input, Graphics g);
//	abstract boolean isContain(Point position);
	
	void showSelected(Graphics g){
		g.setColor(Color.BLACK);
		for(int i = 0 ; i < ports.length; i++){
			g.fillRect((ports[i][0] - (w / 2)), (ports[i][1] - (h / 2)), w, h);
		}
	}
	
	void setName(String input) {
		name = input;
	}
	
	/*
	void setDis(Point position){
		dX = position.x - this.position.x;
		dY = position.y - this.position.y;
	}
	
	void add(Mode m){
		Component.add(m);
	}
	*/
}
	
	
	
