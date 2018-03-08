package UML;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Button.*;
import Mode.SelectMode;

public class UMLGui extends JFrame{
	Button select_btn;
	Button associate_btn;
	Button generate_btn;
	Button compose_btn;
	Button class_btn;
	Button usecase_btn;
	JMenuItem mntmGroup;
	JMenuItem mntmUngroup;
	JMenuItem mntmChange;
	//CanvasArea drawArea;
	/**
	 * Create the application.
	 */
	public UMLGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 755, 646);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		menuBar.add(file);
		menuBar.add(edit);
		
		mntmGroup = new JMenuItem("Group");
	//	mntmGroup.setEnabled(false);
		edit.add(mntmGroup);
		
		mntmUngroup = new JMenuItem("UnGroup");
	//	mntmUngroup.setEnabled(false);
		edit.add(mntmUngroup);
		
		mntmChange = new JMenuItem("Change object name");
	//	mntmChange.setEnabled(false);
		edit.add(mntmChange);
		
		setJMenuBar(menuBar);
		
		add(CanvasArea.getInstance(),BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(103, 603));
		add(panel_1,BorderLayout.WEST);
		
		select_btn = new SelectButton();
		select_btn.setBackground(Color.BLACK); //default mode
		select_btn.setLocation(1, 0);
		panel_1.add(select_btn);
		
		associate_btn = new AssociationButton();
		associate_btn.setLocation(1, 100);
		panel_1.add(associate_btn);
		
		generate_btn = new GeneralizationButton();
		generate_btn.setLocation(1, 200);
		panel_1.add(generate_btn);
		
		compose_btn = new CompositionButton();
		compose_btn.setLocation(1, 300);
		panel_1.add(compose_btn);
		
		class_btn = new ClassButton();
		class_btn.setLocation(1, 400);
		panel_1.add(class_btn);

		usecase_btn = new UseCaseButton();
		usecase_btn.setLocation(1, 500);
		panel_1.add(usecase_btn);
		
		mntmGroup.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CanvasArea.getInstance().getMode().Group();
			}});
		
		mntmUngroup.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CanvasArea.getInstance().getMode().UnGroup();
			}});
		
		mntmChange.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CanvasArea.getInstance().getMode().changeName();
			}});
		
		Button.Selected = select_btn;
		//default mode
		
	}

}
