package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

public class Class extends BasicObject{

	private int x1;
	private int y1;
	
	public Class(Point position) {		
		input = "class";
		this.position = new Point(position);
		width = 100;
		height = 108;
		x1 = position.x + width;
		y1 = position.y + height;
		ports[0] = new Port(this,Direction.NORTH);
		ports[1] = new Port(this,Direction.SOUTH);
		ports[2] = new Port(this,Direction.WEST);
		ports[3] = new Port(this,Direction.EAST);
	}
	
	@Override
	public void Draw(Graphics g) {
		g.setColor(Color.LIGHT_GRAY); //閮剖�蝑�
		g.fillRect(position.x, position.y, width, height); //��甇��敶�
		g.setColor(Color.BLACK);
		g.drawRect(position.x, position.y, width, height);
		g.drawLine(position.x, position.y + (height / 3), position.x + width , position.y + (height / 3));
		g.drawLine(position.x, position.y + (2 * height / 3), position.x + width, position.y + (2 * height / 3));
		drawName(g);
	}
	
	@Override
	public void drawName(Graphics g){
		Font font = new Font("calibri", Font.BOLD, 18);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics();
	    // Determine the X coordinate for the text
	    int x = ports[0].getPosition().x  - (metrics.stringWidth(input)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ports[0].getPosition().y + (height / 3) - ((metrics.getHeight()) / 2) ;
	    g.setColor(Color.BLACK);
	    // Draw the String
	    g.drawString(input, x, y);
	}

	@Override
	public boolean isInside(Point position) {
		// TODO Auto-generated method stub
		if((position.x >= this.position.x ) && (position.x <= x1) && (position.y >= this.position.y) && (position.y <= y1)){
			return true;
		}
		return false;
	}

	@Override
	public void initialLocation(Point position) {
		// TODO Auto-generated method stub
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
		x1 = this.position.x + width;
		y1 = this.position.y + height;
	}

	@Override
	public void setName(String input) {
		// TODO Auto-generated method stub
		this.input = input;
	}
	
	public Port getPort(Point position) {
		// TODO Auto-generated method stub
		double dis = Double.MAX_VALUE;
		Port port = null;
		for(int j = 0 ; j < ports.length ; j++){
			//a port has x and y
			double x = ports[j].getPosition().x - position.x;
			double y = ports[j].getPosition().y - position.y;
			double d = Math.pow(x, 2) + Math.pow(y, 2);
			if(d < dis){
				dis = d;
				port = ports[j];
			}
		}
		return port;
	}
}
