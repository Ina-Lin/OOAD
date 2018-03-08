import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class MouseLis implements MouseListener,MouseMotionListener {
	
	UMLMode umlmode;
	UMLGui gui;
	Select s = new Select();
	
	MouseLis(UMLGui gui) {
		this.gui = gui;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point position = null;
		Graphics g=gui.drawArea.getGraphics();
		//while moving scene would shin;
		if(gui.drawArea.getMousePosition() != null){
			position = gui.drawArea.getMousePosition();
			if(s.selectedArr.size() != 0){ // selecte one or group
				for(ObjectMode X : s.selectedArr){
					X.initialLocation(position);
					gui.drawArea.paint(g);	
					X.showSelected(g);
				}
			}
			else if(gui.getMode().equals("select")){ //group select
				s.setRelease(position);
				gui.drawArea.paint(g);
				s.draw(g);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point position = null;
		Graphics g = gui.drawArea.getGraphics();
		if(gui.drawArea.getMousePosition() != null){
			position = gui.drawArea.getMousePosition();
			String m = gui.getMode();
			clearSelected(g);
			switch(m){
			case "select":
				//single choice
				ObjectMode obj = selectOne(position,g);
				if(obj != null){
					s.showSelectd(g);
					gui.mntmChange.setEnabled(true);
					if (obj instanceof CompositeObject){
						gui.mntmUngroup.setEnabled(true);
					}
				}
				else{
					s.setPress(position);
				}
				break;
			case "associate":
			case "generate":
			case "compose":
				s.setPress(position);
				break;
			}
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point position = null;
		Graphics g = gui.drawArea.getGraphics();
		if((gui.drawArea.getMousePosition() != null)){
			position = gui.drawArea.getMousePosition();
			//multiple choice
			String m = gui.getMode();
			if((gui.getMode().equals("select")) && (s.Press != null)){		
				gui.drawArea.paint(g);
				s.Release = position;
				selectAll(s.Press, s.Release, g);
				if(s.selectedArr.size() > 1){ //憭
					gui.mntmGroup.setEnabled(true);
					gui.mntmUngroup.setEnabled(false);
				}
				else if(s.selectedArr.size() == 1){ //��
					gui.mntmGroup.setEnabled(false);
					gui.mntmUngroup.setEnabled(true);
				}
			}
			else if(!gui.getMode().equals("select")){
				switch(m){
				case "class":
					umlmode = new Class(position);
					break;
				case "usecase":
					umlmode = new Usecase(position);
					break;	
				default:
					s.setRelease(position);
					ObjectMode m1 = selectOne(s.getPress(),g);
					ObjectMode m2 = selectOne(s.getRelease(),g);
					link(m1, m2, m);
					clearSelected(g);
				}
				if(umlmode != null){
				umlmode.Draw(g);
				gui.drawArea.add(umlmode);
				}
			}
		}
	}

	ObjectMode selectOne(Point position,Graphics g) {
		gui.drawArea.paint(g);
		for(int i = gui.drawArea.Component.size() - 1 ; i >= 0; i--) {
			Mode basic = gui.drawArea.Component.get(i);
			if( basic instanceof ObjectMode) {
				if((((ObjectMode) basic).isContain(position))) {
					((ObjectMode) basic).setDis(position);
					s.add((ObjectMode) basic);
					return (ObjectMode) basic;
				}
			}
		}
		return null;
	}
	
	void link(ObjectMode m1, ObjectMode m2 ,String m) {
		if(((m1 != null) && (m2 != null)) && (!m1.equals(m2)) && (m1 instanceof BasicObjectMode) && ( m2 instanceof BasicObjectMode)){
			switch(m){
			case "associate":
				umlmode = new AssociationLine(((BasicObjectMode)m1), ((BasicObjectMode)m2), s.Press, s.Release);
				break;
			case "generate":System.out.println("dd");
				umlmode = new GeneralizationLine(((BasicObjectMode)m1), ((BasicObjectMode)m2), s.Press, s.Release);
				break;
			case "compose":
				umlmode = new CompositionLine(((BasicObjectMode)m1), ((BasicObjectMode)m2), s.Press, s.Release);
				break;
			}
			m1.add(umlmode);
			m2.add(umlmode);
		}
	}
	
	void selectAll(Point position, Point position1, Graphics g) {
		for(Mode X : gui.drawArea.Component) {
			if(X instanceof ObjectMode) {
				int x = ((ObjectMode) X).position.x;
				int w = ((ObjectMode) X).getWidth();
				int y = ((ObjectMode) X).position.y;
				int h = ((ObjectMode) X).getHeight();
				
				if((((ObjectMode) X).isGroup == false)
				 && (((position.x <= x ) && ((x + w) <= position1.x) && (position.y <= y) && ((y + h) <= position1.y)) //left-top to right-bottom
				 ||  ((position.x <= x ) && ((x + w) <= position1.x) && (position1.y <= y) && ((y + h) <= position.y)) //left-bottom to right-top
				 ||  ((position1.x <= x ) && ((x + w) <= position.x) && (position.y <= y) && ((y + h) <= position1.y)) //right-top to left-bottom
				 ||  ((position1.x <= x ) && ((x + w) <= position.x) && (position1.y <= y) && ((y + h) <= position.y))//right-bottom to left-top
				)) {
					((ObjectMode) X).showSelected(g);
					((ObjectMode) X).setDis(position);
					s.add((ObjectMode) X);
					gui.mntmChange.setEnabled(true);
					//嚙踐�蹓潘蕭�嚙踝蕭��selected����蕭蹌負rue
				}
			}
		}
	}	
	
	void clearSelected(Graphics g) {
		gui.mntmChange.setEnabled(false);
		gui.mntmGroup.setEnabled(false);
		gui.mntmUngroup.setEnabled(false);
		gui.drawArea.paint(g);
		s.reset();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
