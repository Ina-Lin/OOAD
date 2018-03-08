package UML;
import javax.swing.JFrame;

public class UMLedit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UMLGui gui = new UMLGui();
		gui.setBounds(100, 100, 755, 664);
		gui.setVisible(true);
		gui.setTitle("UML editor");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
