import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AssociationLine extends ConnectionLineMode {
	
	AssociationLine() {}
	
	AssociationLine(BasicObjectMode m1,BasicObjectMode m2,Point press,Point release) {
		m = new BasicObjectMode[]{m1, m2};
		position = new Point[]{press,release};
		points = new int[2][2];
		P = new int[2];
		setPorts();
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawLine(points[0][0], points[0][1], points[1][0], points[1][1]);
	}

	@Override
	public void initialLocation(Point position) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < m.length ; i++){
			for(int j = 0; j < points.length ; j++){
				points[i][j] = m[i].ports[P[i]][j];
			}
		}
	}
	
}
