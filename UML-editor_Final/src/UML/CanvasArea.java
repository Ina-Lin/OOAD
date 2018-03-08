package UML;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Mode.Mode;
import Mode.SelectMode;
import Object.BasicObject;
import Object.Line;
import Object.Shape;

public class CanvasArea extends Canvas {
	
	private Mode Mode = new SelectMode();
	private static CanvasArea drawArea;
	private ArrayList<Line> Lines = new ArrayList<Line>();
	private ArrayList<BasicObject> Objects = new ArrayList<BasicObject>();
	
	CanvasArea() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseLis());
		addMouseMotionListener(new MouseLis());
	}
	
	public static CanvasArea getInstance() {
		if(drawArea == null) {
			drawArea = new CanvasArea();
		}
		return drawArea;
	}
	
	public void paint(Graphics g) {
		super.paint(g); //皜征��
		for(BasicObject X : Objects) {
			X.Draw(g);
		}
		for(Line X : Lines){
			X.Draw(g); //撠rrayList摮����靘�
		}
	}
	
	public void addLine(Line Comp) {
		Lines.add(Comp); //�憓隞嗉ArrayList
	}
	
	public void addObj(BasicObject Comp) {
		Objects.add(Comp);
	}
	
	public void removeObj(BasicObject Comp) {
		Objects.remove(Comp);
	}
	
	public void setMode(Mode m){
		Mode = m;
	}
	
	public Mode getMode() {
		return Mode;
	}
	
	public ArrayList<Line> getLines() {
		return Lines;
	}
	
	public ArrayList<BasicObject> getObjects() {
		return Objects;
	}
	
	class MouseLis implements MouseListener,MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseDragged(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseMoved(e);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseClicked(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			paint(CanvasArea.getInstance().getGraphics());
			Mode.mousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseReleased(e);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Mode.mouseExited(e);
		}
		
	}
	
}
