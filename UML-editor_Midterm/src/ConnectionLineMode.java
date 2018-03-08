import java.awt.Point;

abstract class ConnectionLineMode implements UMLMode{
	BasicObjectMode[] m;
	Point[] position = null; //紀錄press release 的 point
	int[][] points = null; //線的兩端point
	int[] P; //紀錄線兩端對到的物件的port
	
/*	
	public void showPorts(Graphics g){
		g.setColor(Color.BLACK);
		for(int i = 0 ; i < points.length; i++){
			g.fillRect((points[i][0] - (w / 2)), (points[i][1] - (h / 2)), w, h);
		}
	}
*/	
	
	//find the correct ports in object
	public	void setPorts() {
		for(int i = 0 ; i < m .length ; i++){
			double dis = Double.MAX_VALUE;
			//the number of ports of basic object //4
			for(int j = 0 ; j < m[i].ports.length ; j++){
				//a port has x and y
				double x = m[i].ports[j][0] - position[i].x;
				double y = m[i].ports[j][1] - position[i].y;
				double d = Math.pow(x, 2) + Math.pow(y, 2);
				if(d < dis){
					dis = d;
					for(int k = 0 ; k < points[0].length ; k++){
						points[i][k] = m[i].ports[j][k];
						P[i] = j;
					}
				}
			}
		}
	}
}
