package Mode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import Object.BasicObject;
import Object.CompositionLine;
import Object.Line;
import Object.Port;
import UML.CanvasArea;

public class CompositionMode extends Mode {

	Point Press = null;
	Point Release = null;

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Press = e.getPoint();
		Release = null;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Release = e.getPoint();
		Graphics g = CanvasArea.getInstance().getGraphics();
		Port p1 = setPort(Press, g);
		Port p2 = setPort(Release, g);
		if((p1 != null) && (p2 != null) && (p1.obj != p2.obj)) {
			Line line = new CompositionLine(p1, p2);
			CanvasArea.getInstance().addLine(line);
			line.Draw(g);
		}
	}
	
	Port setPort(Point position,Graphics g) {
		CanvasArea can = CanvasArea.getInstance();
		can.paint(g);
		Port port = null;
		for(int i = can.getObjects().size() - 1 ; i >= 0; i--) {
			BasicObject obj = can.getObjects().get(i);
			if( obj.isInside(position)) {
				port = obj.getPort(position);
		
			}
		}
		return port;
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
