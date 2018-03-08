package Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.SelectMode;

public class SelectButton extends Button{

	public SelectButton(){
		super(new ImageIcon("selection.png"));
		setOpaque(true);//change button color in MAC
		setBackground(Color.BLACK);
		setSize(100, 100);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Selected != null){
			unselected(Selected);
			selected(this);
			setMode(new SelectMode());
		}
	}
}
