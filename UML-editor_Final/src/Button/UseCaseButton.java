package Button;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Mode.UseCaseMode;

public class UseCaseButton extends Button{
	
	public UseCaseButton() {
		super(new ImageIcon("usecase.png"));
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
			setMode(new UseCaseMode());
		}
	}
}
