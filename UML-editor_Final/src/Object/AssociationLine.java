package Object;

import java.awt.Color;
import java.awt.Graphics;

public class AssociationLine extends Line {
	
	public AssociationLine(Port s, Port e) {
		startPort = s;
		endPort = e;
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawLine(startPort.getPosition().x, startPort.getPosition().y, endPort.getPosition().x, endPort.getPosition().y);
	}
	
}
