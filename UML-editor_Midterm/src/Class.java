import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

class Class extends BasicObjectMode{
	
	private int x1;
	private int y1;
	private int width;
	private int height;
	
	Class() {}
	
	Class(Point position) {		
		this.position.x = position.x;
		this.position.y = position.y;
		width = 100;
		height = 108;
		x1 = position.x + width;
		y1 = position.y + height;
		setPorts();
	}

	@Override
	public void initialLocation (Point position) {
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
		x1 = this.position.x + width;
		y1 = this.position.y + height;
		setPorts();
		for(Mode X : Component){
			if(X instanceof ConnectionLineMode){
				((ConnectionLineMode) X).initialLocation(position);
			}
		}
	}
	
	@Override
	public void setPorts() {
		// TODO Auto-generated method stub
		ports[0] = new int[]{(position.x + (width / 2)), (position.y)}; //top
		ports[1] = new int[]{(position.x + (width / 2)), (position.y + height)}; //bottom
		ports[2] = new int[]{(position.x), (position.y + (height / 2))}; //left
		ports[3] = new int[]{(position.x + width), (position.y + (height / 2))}; //right
	}
	
	@Override
	public void Draw(Graphics g) {
		g.setColor(Color.LIGHT_GRAY); //閮剖�蝑�
		g.fillRect(position.x, position.y, width, height); //��甇��敶�
		g.setColor(Color.BLACK);
		g.drawRect(position.x, position.y, width, height);
		g.drawLine(position.x, position.y + (height / 3), x1 , position.y + (height / 3));
		g.drawLine(position.x, position.y + (2 * height / 3), x1, position.y + (2 * height / 3));
		drawName(name,g);
	}

	@Override
	void drawName(String input,Graphics g){
		Font font = new Font("calibri", Font.BOLD, 18);
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics();
	    // Determine the X coordinate for the text
	    int x = ports[0][0]  - (metrics.stringWidth(input)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = ports[0][1] + (height / 3) - ((metrics.getHeight()) / 2) ;
	    g.setColor(Color.BLACK);
	    // Draw the String
	    g.drawString(name, x, y);
	}
	
	@Override
	public boolean isContain(Point position) {
		if((position.x >= this.position.x ) && (position.x <= x1) && (position.y >= this.position.y) && (position.y <= y1)){
			return true;
		}
		return false;
	}

	@Override
	int getWidth() {
		return width;
	}

	@Override
	int getHeight() {
		return height;
	}

}
