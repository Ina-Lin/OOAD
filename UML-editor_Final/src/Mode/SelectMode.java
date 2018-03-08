package Mode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Object.BasicObject;
import Object.Group;
import UML.CanvasArea;

public class SelectMode extends Mode {
	
	ArrayList<BasicObject> selectedArr = new ArrayList<BasicObject>();
	Point start = null;
	Point end = null;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point position = e.getPoint();
		Graphics g = CanvasArea.getInstance().getGraphics();
		if(selectedArr.size() != 0){ // one selected
			for(BasicObject X : selectedArr){
				X.initialLocation(position);
				CanvasArea.getInstance().paint(g);	
				X.showPorts(g);
			}
		}
		else {
			end = position;
	//		System.out.println(s.Press +" "+s.Release);
			CanvasArea.getInstance().paint(g);
			draw(g);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		start = null;
		end = null;
		Point position = e.getPoint();
		Graphics g = CanvasArea.getInstance().getGraphics();
		clearSelected();
		if(isSingleSelect(position)) {
			showSelect(g);
		}
		else {
			start = new Point(position);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(start != null) {
			Point position = e.getPoint();
			Graphics g = CanvasArea.getInstance().getGraphics();
			CanvasArea.getInstance().paint(g);
			end = new Point(position);
			selectAll(start,end);	
			showSelect(g);
		}
	}
	
	private boolean isSingleSelect(Point position) {
		ArrayList<BasicObject> arr = CanvasArea.getInstance().getObjects();
		for(int i = arr.size()-1 ; i>= 0 ; i--) {
			if(arr.get(i).isInside(position)) {
				arr.get(i).setDis(position);
				selectedArr.add(arr.get(i));
				return true;
			}
		}
		return false;
	}
	
	private void selectAll(Point position, Point position1) {
		for(BasicObject X : CanvasArea.getInstance().getObjects()) {
			int x = X.position.x;
			int w = X.getWidth();
			int y = X.position.y;
			int h = X.getHeight();
			
			if(/*(((ObjectMode) X).isGroup == false)
			 &&*/ (((position.x <= x ) && ((x + w) <= position1.x) && (position.y <= y) && ((y + h) <= position1.y)) //left-top to right-bottom
			 ||  ((position.x <= x ) && ((x + w) <= position1.x) && (position1.y <= y) && ((y + h) <= position.y)) //left-bottom to right-top
			 ||  ((position1.x <= x ) && ((x + w) <= position.x) && (position.y <= y) && ((y + h) <= position1.y)) //right-top to left-bottom
			 ||  ((position1.x <= x ) && ((x + w) <= position.x) && (position1.y <= y) && ((y + h) <= position.y))//right-bottom to left-top
			)) {
			//	((ObjectMode) X).setDis(position);
				selectedArr.add(X);
		//		gui.mntmChange.setEnabled(true);
				//�閬���◤selected撠望�true
			}
		}
	}
	
	private void showSelect(Graphics g) {
		// TODO Auto-generated method stub
		for(BasicObject X : selectedArr) {
			X.showPorts(g);
		}
	}
	
	private void clearSelected() {
		selectedArr.clear();
	}
	
	void draw(Graphics g){
		g.setColor(Color.GRAY);
		int x = Math.min(start.x, end.x);
		int y = Math.min(start.y, end.y);
		int w = Math.max(start.x, end.x) - Math.min(start.x, end.x);
		int h = Math.max(start.y, end.y) - Math.min(start.y, end.y);
		g.drawRect(x, y, w, h);
	}
	
	public void Group() {
		if(selectedArr.size() > 1) {
			BasicObject group = new Group(selectedArr);
			group.addObj(selectedArr);
			for(BasicObject X : selectedArr) {
				CanvasArea.getInstance().removeObj(X);
			}
			CanvasArea.getInstance().addObj(group);
			selectedArr.clear();
			selectedArr.add(group);
			
		}
	}
	
	public void UnGroup() {
		if(selectedArr.size() == 1) {
			if(selectedArr.get(0).getObj() != null) {
				System.out.println("ungroup");
				for(BasicObject X : selectedArr.get(0).getObj()) { 
					CanvasArea.getInstance().addObj(X);
					selectedArr.add(X);
				}
				CanvasArea.getInstance().removeObj(selectedArr.get(0));
			}
		}
	}
	
	public void changeName() {
		if(selectedArr.size() == 1) {
			String input=JOptionPane.showInputDialog(null,"Object name:","Change object name",JOptionPane.QUESTION_MESSAGE);
			if(input != null){
				CanvasArea.getInstance().paint(CanvasArea.getInstance().getGraphics());
				for(BasicObject X : selectedArr){
					X.setName(input);
				}
			}
			CanvasArea.getInstance().paint(CanvasArea.getInstance().getGraphics());
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
