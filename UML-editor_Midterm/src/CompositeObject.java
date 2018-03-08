import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

class CompositeObject extends ObjectMode{
	private int width;
	private int height;
	
	void initial(){
		int right = 0;
		int bottom = 0;
		int left = Integer.MAX_VALUE;
		int top = Integer.MAX_VALUE;
		for(Mode X : Component){
			int x = ((ObjectMode) X).position.x;
			int y = ((ObjectMode) X).position.y;
			int x1 = ((ObjectMode) X).position.x + ((ObjectMode) X).getWidth();
			int y1 = ((ObjectMode) X).position.y + ((ObjectMode) X).getHeight();
		//	System.out.println(x+" "+y+" "+x1+" "+y1);
			if(x < left){left = x;}
			if(x1 > right){right = x1;}
			if(y < top){top = y;}
			if(y1 > bottom){bottom = y1;}
		}
		position.setLocation(left, top);
		width = right - left;
		height = bottom - top;
	//	System.out.println(top +" "+bottom+" "+left+" "+right);
	}
	
	@Override
	public void initialLocation(Point position){
		this.position.x = position.x - dX;
		this.position.y = position.y - dY;
		for(Mode X : Component){
			X.initialLocation(position);
		}
	}
	
	@Override
	//��
	boolean isContain(Point position) {
		for(Mode X : Component){
			if(((ObjectMode)X).isContain(position)){
				System.out.println("com.iscontian");
				return true; //only one is selected, all of objects in the compositeObject are selected.
			}
		}
		return false;
	}
	/*
	void add(Mode m){
		groupArr.add(m);
	}
	*/
	@Override
	void showSelected(Graphics g){
		g.setColor(Color.BLACK);
	//	System.out.println("show");
	//	g.drawRect(position.x, position.y, width, height);
		for(Mode X : Component){
			((ObjectMode)X).showSelected(g);
		//	System.out.println("eeeee");
		}
	}
	
	@Override
	void setDis(Point position){
		dX = position.x - this.position.x;
		dY = position.y - this.position.y;
		for(Mode X : Component){
			((ObjectMode)X).setDis(position);
		}
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

//���票���
