import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Select {
	
	Point Press = null;
	Point Release = null;
	ArrayList<ObjectMode> selectedArr = new ArrayList<ObjectMode>();
	
	void reset() {
		Press = null;
		Release = null;
		selectedArr.clear();
	}
	
	void add(ObjectMode b) {
		selectedArr.add(b);
	}
	
	void draw(Graphics g){
		int x = Math.min(Press.x, Release.x);
		int y = Math.min(Press.y, Release.y);
		int x1 = Math.max(Press.x, Release.x);
		int y1 = Math.max(Press.y, Release.y);
		g.setColor(Color.GRAY);
		g.drawRect(x, y, x1 - x, y1 - y);
	}
	
	void setPress(Point position) {
		Press = position;
	}
	
	void setRelease(Point position) {
		Release = position;
	}
	
	void showSelectd(Graphics g) {
		for(ObjectMode X : selectedArr) {
			X.showSelected(g);
		}
	}
	
	int arraySize() {
		return selectedArr.size();
	}
	
	Point getPress() {
		return Press;
	}
	
	Point getRelease() {
		return Release;
	}
	
}
