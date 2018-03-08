import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
class CanvasArea extends Canvas{
	
	ArrayList<Mode> Component=new ArrayList<Mode>();
	
	@Override
	public void paint(Graphics g){
		super.paint(g); //皜征��
		for(Mode X : Component){
			if(X instanceof UMLMode)
			((UMLMode) X).Draw(g); //撠rrayList摮����靘�
		}
	}
	
	@Override
	public void update(Graphics g) { 
        this.paint(g);  // 單純呼叫paint() 
    } 
	
	void add(Mode Comp){
		Component.add(Comp); //�憓隞嗉ArrayList
	}
	
	void remove(Mode Comp){
		Component.remove(Comp);
	}
	
}
