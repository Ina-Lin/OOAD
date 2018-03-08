import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

@SuppressWarnings("serial")
class UMLGui extends JFrame {
	String mode = null;
	MouseLis moulis;
	JButton select_btn;
	JButton associate_btn;
	JButton generate_btn;
	JButton compose_btn;
	JButton class_btn;
	JButton usecase_btn;
	JMenuItem mntmGroup;
	JMenuItem mntmUngroup;
	JMenuItem mntmChange;
	CanvasArea drawArea;
	ArrayList<JButton> btn_arr = new ArrayList<JButton>();
	
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
		mode = "select";
		
		setBounds(100, 100, 755, 646);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		menuBar.add(file);
		menuBar.add(edit);
		
		mntmGroup = new JMenuItem("Group");
		mntmGroup.setEnabled(false);
		edit.add(mntmGroup);
		
		mntmUngroup = new JMenuItem("UnGroup");
		mntmUngroup.setEnabled(false);
		edit.add(mntmUngroup);
		
		mntmChange = new JMenuItem("Change object name");
		mntmChange.setEnabled(false);
		edit.add(mntmChange);
		
		setJMenuBar(menuBar);
		
		drawArea = new CanvasArea();
		drawArea.setBackground(Color.WHITE);
		add(drawArea,BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(103, 603));
		add(panel_1,BorderLayout.WEST);
		
		select_btn = new Button(new ImageIcon("selection.png"), new Select());
		select_btn.setBackground(Color.BLACK); //default choice is select
	//	select_btn.setBounds(1, 0, 100, 100);
		select_btn.setName("select");
		select_btn.setLocation(1, 0);
		panel_1.add(select_btn);
		
		associate_btn = new Button(new ImageIcon("association.png"), new AssociationLine());
	//	associate_btn.setBounds(1, 100, 100, 100);
		associate_btn.setName("associate");
		associate_btn.setLocation(1, 100);
		panel_1.add(associate_btn);
		
		generate_btn = new Button(new ImageIcon("generalization.png"), new GeneralizationLine());
	//	generate_btn.setBounds(1, 200, 100, 100);
		generate_btn.setName("generate");
		generate_btn.setLocation(1, 200);
		panel_1.add(generate_btn);
		
		compose_btn = new Button(new ImageIcon("composition.png"), new CompositionLine());
	//	compose_btn.setBounds(1, 300, 100, 100);
		compose_btn.setName("compose");
		compose_btn.setLocation(1, 300);
		panel_1.add(compose_btn);
		
		class_btn = new Button(new ImageIcon("class.png"), new Class());
	//	class_btn.setBounds(1, 400, 100, 100);
		class_btn.setName("class");
		class_btn.setLocation(1, 400);
		panel_1.add(class_btn);

		usecase_btn = new Button(new ImageIcon("usecase.png"), new Usecase());
	//	usecase_btn.setBounds(1, 500, 100, 100);
		usecase_btn.setName("usecase");
		usecase_btn.setLocation(1, 500);
		panel_1.add(usecase_btn);
		
	//	getAllBtn(this);
		
		btn_arr.add(associate_btn);
		btn_arr.add(compose_btn);
		btn_arr.add(generate_btn);
		btn_arr.add(select_btn);
		btn_arr.add(usecase_btn);
		btn_arr.add(class_btn);
		
		ActionLis actlis = new ActionLis(this);
		moulis = new MouseLis(this);
		
		drawArea.addMouseMotionListener(moulis);
		drawArea.addMouseListener(moulis);
		
		mntmGroup.addActionListener(actlis);
		mntmUngroup.addActionListener(actlis);
		mntmChange.addActionListener(actlis);
		
		for(JButton X : btn_arr){
			X.addActionListener(actlis);
		}
		
		/*
		mntmChange.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Graphics g = drawArea.getGraphics();
				String input=JOptionPane.showInputDialog(null,"Object name:","Change object name",JOptionPane.QUESTION_MESSAGE);
				if(input != null){
					for(Mode X : moulis.s.selectedArr){
						((BasicObjectMode) X).setName(input,g);
					}
				}
			}
		});
		*/
		
		/*
		select_btn.addActionListener(actlis);
		associate_btn.addActionListener(actlis);
		generate_btn.addActionListener(actlis);
		compose_btn.addActionListener(actlis);
		class_btn.addActionListener(actlis);
		usecase_btn.addActionListener(actlis);
		*/
	}
	
	void setMode(String mode) {
		this.mode = mode;
	}
	
	String getMode() {
		return mode;
	}
	
	/*
	void getAllBtn(Container contain) {
		Component[] comps = contain.getComponents();
	    for(Component comp : comps){
	        if(comp instanceof Container){
	        	getAllBtn((Container) comp);
	        }
	        if(comp instanceof Button){
	        	btn_arr.add((Button) comp);
	        }
	    }
	}
	*/
}
