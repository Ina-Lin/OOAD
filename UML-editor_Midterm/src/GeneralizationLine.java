import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class GeneralizationLine  extends ConnectionLineMode {

	private int[] x;
	private int[] y;
	private int[] xx;
	private int[] yy;
	
	GeneralizationLine() {}
	
	GeneralizationLine(BasicObjectMode m1,BasicObjectMode m2, Point press, Point release) {
		// TODO Auto-generated constructor stub
		m = new BasicObjectMode[]{m1, m2};
		position = new Point[]{press,release};
		points = new int[2][2];
		P = new int[2];
		setPorts();
		trianglePoints();
	}
	
	@Override
	public void initialLocation(Point position) {
		for(int i = 0 ; i < m.length ; i++){
			for(int j = 0; j < points.length ; j++){
				points[i][j] = m[i].ports[P[i]][j];
			}
		}
		trianglePoints();
	}
	
	void trianglePoints(){
		x = new int[]{0, -15, -15};
		y = new int[]{0, -10, 10};
		updatePoints();
	}
	
	void updatePoints() {
		//press - release
		int dX = points[0][0] - points[1][0];
		int dY = points[0][1] - points[1][1];
		double sin = dY / Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		double cos = dX / Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		xx = new int[x.length];
		yy = new int[y.length];
		for(int i = 0 ; i < x.length ; i++){
			xx[i] = ((int) ((x[i] * cos) - (y[i] * sin)) + points[0][0]);
			yy[i] = ((int) ((y[i] * cos) + (x[i] * sin)) + points[0][1]);
		}	
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub	
		g.setColor(Color.BLACK);
		g.drawLine(points[0][0], points[0][1], points[1][0], points[1][1]);
		g.setColor(Color.WHITE);
		g.fillPolygon(xx, yy, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xx, yy, 3);
	}
}
