package Button;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Mode.Mode;
import UML.CanvasArea;

public abstract class Button extends JButton implements ActionListener{
	
	public static Button Selected;
	
	Button(ImageIcon imageIcon){
		super(imageIcon);
	}
	
	void selected(Button btn){
		Selected = btn;
		btn.setBackground(Color.BLACK);
	}
	
	void unselected(Button btn){
		btn.setBackground(Color.WHITE);
	}
	
	void setMode(Mode m){
		CanvasArea.getInstance().setMode(m);
	//	CanvasArea.mode = m;
	}
	
}