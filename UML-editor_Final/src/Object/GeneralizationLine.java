package Object;

import java.awt.Color;
import java.awt.Graphics;

public class GeneralizationLine extends Line {

	public GeneralizationLine(Port s, Port e) {
		startPort = s;
		endPort = e;
	}
	
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawLine(startPort.getPosition().x, startPort.getPosition().y, endPort.getPosition().x, endPort.getPosition().y);
		g.setColor(Color.WHITE);
		
		int dX = startPort.getPosition().x - endPort.getPosition().x;
		int dY = startPort.getPosition().y - endPort.getPosition().y;
		double sin = dY / Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		double cos = dX / Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		int[] x = new int[]{0, -15, -15};
		int[] y = new int[]{0, -10, 10};
		int[] xx = new int[x.length];
		int[] yy = new int[y.length];
		for(int i = 0 ; i < x.length ; i++){
			xx[i] = ((int) ((x[i] * cos) - (y[i] * sin)) + startPort.getPosition().x);
			yy[i] = ((int) ((y[i] * cos) + (x[i] * sin)) + startPort.getPosition().y);
		}
		g.fillPolygon(xx, yy, xx.length);
		g.setColor(Color.BLACK);
		g.drawPolygon(xx, yy, xx.length);
	}
	
	
}
