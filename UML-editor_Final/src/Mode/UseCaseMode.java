package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Object.BasicObject;
import Object.UseCase;
import UML.CanvasArea;

public class UseCaseMode extends Mode {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("usecase");
		Point position = e.getPoint();
		BasicObject obj = new UseCase(position);
		CanvasArea.getInstance().addObj(obj);
		obj.Draw(CanvasArea.getInstance().getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
