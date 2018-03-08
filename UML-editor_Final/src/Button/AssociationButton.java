package Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.AssociationMode;

public class AssociationButton extends Button{

	public AssociationButton() {
		super(new ImageIcon("association.png"));
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
			setMode(new AssociationMode());
		}
		
	}
	
}
