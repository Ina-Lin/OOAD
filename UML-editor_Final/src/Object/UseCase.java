package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

public class UseCase extends BasicObject{
	
	public UseCase(Point position){
		input = "usecase";
		this.position = new Point(position);
		width = 100;
		height = 70;
		ports[0] = new Port(this,Direction.NORTH);
		ports[1] = new Port(this,Direction.SOUTH);
		ports[2] = new Port(this,Direction.WEST);
		ports[3] = new Port(this,Direction.EAST);
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(position.x, position.y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(position.x, position.y, width, height);
		drawName(g);
	}

	@Override
	public void drawName(Graphics g){
		Font font = new Font("calibri", Font.BOLD, 18);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics();
	    // Determine the X coordinate for the text
	    int x = ports[0].getPosition().x - (metrics.stringWidth(input)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ports[0].getPosition().y + (((height - metrics.getHeight()) / 2) + metrics.getAscent()) ;
	    g.setColor(Color.BLACK);
	    // Draw the String
	    g.drawString(input, x, y);
	}

	@Override
	public boolean isInside(Point position) {
		// TODO Auto-generated method stub
		double a = width / 2;
		double b = height / 2;
		double h = this.position.x + a;
		double k = this.position.y + b;
		double dis = ((Math.pow((position.x - h), 2) / Math.pow(a, 2)) + (Math.pow((position.y - k), 2) / Math.pow(b, 2)));//oval function
		if(dis <= 1){
			return true;
		}
		return false;
	}

	@Override
	public void initialLocation(Point position) {
		// TODO Auto-generated method stub
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
	}

	@Override
	public void setName(String input) {
		// TODO Auto-generated method stub
		this.input = input;
	}

	@Override
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
