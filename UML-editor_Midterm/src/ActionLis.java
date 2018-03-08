import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActionLis implements ActionListener{
	
	UMLGui gui;

	ActionLis(UMLGui gui){
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = gui.drawArea.getGraphics();
		if(e.getSource() == gui.mntmGroup){
			Mode com = new CompositeObject();
			for(ObjectMode X : gui.moulis.s.selectedArr){
				((ObjectMode)com).add(X);	
				X.isGroup = true;
			}
			((CompositeObject)com).initial();
			((ObjectMode)com).showSelected(gui.drawArea.getGraphics());
			gui.moulis.s.selectedArr.add(0, (ObjectMode) com);
			gui.drawArea.Component.add(com);
			gui.mntmUngroup.setEnabled(true);
			gui.mntmGroup.setEnabled(false);
		}
		else if(e.getSource() == gui.mntmUngroup){
			for(Mode X : gui.moulis.s.selectedArr.get(0).Component) {
				((ObjectMode)X).isGroup = false;
			}
			gui.drawArea.Component.remove(gui.moulis.s.selectedArr.get(0));	
			gui.drawArea.paint(g);
			gui.mntmUngroup.setEnabled(false);
		}
		else if(e.getSource() == gui.mntmChange){
			String input=JOptionPane.showInputDialog(null,"Object name:","Change object name",JOptionPane.QUESTION_MESSAGE);
			if(input != null){
				for(Mode X : gui.moulis.s.selectedArr){
					if(X instanceof BasicObjectMode){
						((BasicObjectMode) X).setName(input);
					}
				}
				gui.drawArea.paint(g);
			}
		}
		else{
			for(JButton X : gui.btn_arr) {
				if(e.getSource() == X) {
					X.setBackground(Color.BLACK);
					gui.setMode(X.getName());
					System.out.println(gui.mode);
				}
				else{
					X.setBackground(Color.WHITE);
				}
			}
		}
	}

}
