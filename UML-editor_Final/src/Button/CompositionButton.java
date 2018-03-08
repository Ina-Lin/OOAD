package Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.CompositionMode;

public class CompositionButton extends Button{
	
	public CompositionButton() {
		super(new ImageIcon("composition.png"));
		setOpaque(true);//change button color in MAC
		setBackground(Color.WHITE);
		setSize(100, 100);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Selected != null){
			unselected(Selected);
			selected(this);
			setMode(new CompositionMode());
		}
	}
}
