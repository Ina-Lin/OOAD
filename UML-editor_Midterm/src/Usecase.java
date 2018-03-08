import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

class Usecase extends BasicObjectMode{
	
	private int width;
	private int height;
	
	Usecase() {}
	
	Usecase(Point position){
		this.position.x = position.x;
		this.position.y = position.y;
		width = 100;
		height = 70;
		setPorts();
	}

	@Override
	public void initialLocation(Point position) {
		// TODO Auto-generated method stub
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
		setPorts();
		for(Mode X : Component){
			if(X instanceof ConnectionLineMode){
				((ConnectionLineMode) X).initialLocation(position);
			}
		}
	}
	
	@Override
	public void setPorts(){
		// TODO Auto-generated method stub
		//4 center ports of side
		ports[0] = new int[]{(position.x + (width / 2)), (position.y)}; //top
		ports[1] = new int[]{(position.x + (width / 2)), (position.y + height)}; //bottom
		ports[2] = new int[]{(position.x), (position.y + (height / 2))}; //left
		ports[3] = new int[]{(position.x + width), (position.y + (height / 2))}; //right
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(position.x, position.y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(position.x, position.y, width, height);
	}

	@Override
	void drawName(String input,Graphics g){
		Font font = new Font("calibri", Font.BOLD, 18);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics();
	    // Determine the X coordinate for the text
	    int x = ports[0][0] - (metrics.stringWidth(input)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ports[0][1] + (((height - metrics.getHeight()) / 2) + metrics.getAscent()) ;
	    g.setColor(Color.BLACK);
	    // Draw the String
	    g.drawString(input, x, y);
	}
	
	@Override
	public boolean isContain(Point position) {
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
	int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

}
