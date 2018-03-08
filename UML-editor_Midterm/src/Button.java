import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton{
	
	private Object Obj;
	
	public Button(ImageIcon imageIcon,Object mode) {
		// TODO Auto-generated constructor stub
		super(imageIcon);
	//	this.mode = mode;
		this.Obj = mode;
		setOpaque(true);//change button color in MAC
		setBackground(Color.WHITE);
		setSize(100, 100);
	}
	
	Object getMode(){
		return Obj;
	}
	
}
