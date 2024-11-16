package dsa.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public abstract class StackOrQueueView extends BasePanel {
	protected JPanel mainPanel;
	
	public StackOrQueueView() {
		initComponents();
	}
	
	private void initComponents() { 
		tabbedPane = new JTabbedPane();
		mainPanel = new JPanel();
	}
	
	void initArrayComponents() {
		arrayAddButton = new JButton();
		arrayRemoveButton = new JButton();
		arrayInputTextField = new JTextField();
		arraySizeButton = new JButton();
		arraySizeText = new JTextField();
		arraySizeLabel = new JLabel();
		arrayResetButton = new JButton();
	}
	
	void initListComponents() {
		listPanel = new JPanel();
		listNorthPanel = new JPanel();
		listSouthPanel = new JPanel();
		listAddButton = new JButton();
		listRemoveButton = new JButton();
		listInputTextField = new JTextField();
	}
}
