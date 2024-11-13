package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dsa.LinkedListTemplate;
import dsa.linked.list.SinglyListComponent;
import dsa.utils.GroupLayoutUtil;
import dsa.linked.list.SinglyCircular;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	SinglyListComponent singlySimpleList;
	SinglyCircular singlyCircularList;
	
	LinkedListTemplate listSimple, listCircular;
	
	private JTabbedPane tabbedPane;
	
	// Components to create the singly list view
	private JButton singlyAddButton, singlyDeleteButton;
	private JTextField singlyAddNodeField, singlyDeleteNodeField;
	private JPanel singlyListMainPanel, singlyListSouthPanel, singlyListNorthPanel;
	
	// Components to create the circular list view
	private JButton circularAddButton, circularDeleteButton;
	private JTextField circularAddNodeField, circularDeleteNodeField;
	private JPanel circularListMainPanel, circularListNorthPanel, circularListSouthPanel;

	public ListPanel() {
		initComponents();

		singlyCircularList = new SinglyCircular();
		singlySimpleList = new SinglyListComponent();

		singlyListMainPanel.add(singlySimpleList, BorderLayout.CENTER);
		circularListMainPanel.add(singlyCircularList, BorderLayout.CENTER);

		listSimple = new LinkedListTemplate();
		listCircular = new LinkedListTemplate();

		singlySimpleList.setValues(listSimple, 0);
		singlyCircularList.setValues(listCircular, 0);

		singlyListMainPanel.revalidate();
		circularListMainPanel.revalidate();
	}

	private void initComponents() {
		tabbedPane = new JTabbedPane();
		initSinglyComponents();
		initCircularComponents();
		setLayout(new BorderLayout());

		tabbedPane.addTab("Lista simplu inlantuita", singlyListMainPanel);
		tabbedPane.addTab("Lista circulara simplu inlantuita", circularListMainPanel);
		
		configureCircularListSettings();
		configureSinglyListSettings();

		add(tabbedPane, BorderLayout.CENTER);
	}

	void initSinglyComponents() {
		singlyListMainPanel = new JPanel();
		singlyListNorthPanel = new JPanel();
		singlyListSouthPanel = new JPanel();
		singlyAddNodeField = new JTextField();
		singlyAddButton = new JButton();
		singlyDeleteNodeField = new JTextField();
		singlyDeleteButton = new JButton();
	}

	void initCircularComponents() {
		circularListMainPanel = new JPanel();
		circularListNorthPanel = new JPanel();
		circularListSouthPanel = new JPanel();
		circularAddNodeField = new JTextField();
		circularAddButton = new JButton();
		circularDeleteNodeField = new JTextField();
		circularDeleteButton = new JButton();
	}
	
	void configureSinglyListSettings(){
		configureMainPanel(singlyListMainPanel, new BorderLayout());
		configureAddNodeField(singlyAddNodeField);
		configureDeleteNodeField(singlyDeleteNodeField);
		
		setupButton(singlyAddButton, "Insereaza", evt -> singlyAddButtonActionPerformed(evt));
		setupButton(singlyDeleteButton, "Sterge", evt -> singlyDeleteButtonActionPerformed(evt));
		
	    GroupLayout singlyListNorthPanelLayout = GroupLayoutUtil.createCustomLayoutForSinglyListNorthPanel(
	            singlyListNorthPanel, singlyAddNodeField, singlyAddButton, singlyDeleteNodeField, singlyDeleteButton);
	    singlyListNorthPanel.setLayout(singlyListNorthPanelLayout);
	    
		configureListView(singlyListMainPanel, singlyListNorthPanel, singlyListSouthPanel);
	}
	
	void configureCircularListSettings() {
		configureMainPanel(circularListMainPanel, new BorderLayout());
		configureAddNodeField(circularAddNodeField);
		
		setupButton(circularAddButton, "Insereaza", evt -> circularAddButtonActionPerformed(evt));
		setupButton(circularDeleteButton, "Sterge", evt -> circularDeleteButtonActionPerformed(evt));
		
		configureDeleteNodeField(circularDeleteNodeField);;

	    GroupLayout singlyListNorthPanelLayout = GroupLayoutUtil.createCustomLayoutForSinglyListNorthPanel(
	    		circularListNorthPanel, circularAddNodeField, circularAddButton, circularDeleteNodeField, circularDeleteButton);
	    singlyListNorthPanel.setLayout(singlyListNorthPanelLayout);
		configureListView(circularListMainPanel, circularListNorthPanel, circularListSouthPanel);
	}
	
	void configureListView(JPanel mainPanel, JPanel northPanel, JPanel southPanel) {
	    mainPanel.add(northPanel, BorderLayout.NORTH);
	    southPanel.setBackground(new Color(255, 87, 51));
	    southPanel.setPreferredSize(new Dimension(100, 100));
	    mainPanel.add(southPanel, BorderLayout.SOUTH);
	}
	
	void configureAddNodeField(JTextField addNodeField){
		addNodeField.setColumns(5);
	    addNodeField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent evt) {
	            if (addNodeField == singlyAddNodeField) {
	            	singlyAddNodeTextKeyPressed(evt);
			    } else if (addNodeField == circularAddNodeField) {
			    	circularAddNodeFieldKeyPressed(evt);
			    } 
	        }
	    });
	}
	
	void setupButton(JButton button, String text, ActionListener actionListener) {
	    button.setBackground(Color.white);
	    button.setText(text);
	    button.setFocusable(false);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	    button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.addActionListener(actionListener);
	}
	
	void configureDeleteNodeField(JTextField deleteNodeField){
		deleteNodeField.setColumns(5);
		deleteNodeField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent evt) {
	            if (deleteNodeField == singlyDeleteNodeField) {
	            	singlyDeleteNodeKeyPressed(evt);
			    } else if (deleteNodeField == circularDeleteNodeField) {
			    	circularDeleteNodeKeyPressed(evt);
			    } 
	        }
	    });
	}
	
	void configureMainPanel(JPanel mainPanel, LayoutManager layout) {
	    mainPanel.setBackground(Color.WHITE);
	    mainPanel.setLayout(layout);
	}

	void setupDeleteButton(JButton deleteButton, ActionListener actionListener) {
	    deleteButton.setBackground(Color.white);
	    deleteButton.setText("Sterge");
	    deleteButton.setFocusable(false);
	    deleteButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    deleteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    deleteButton.addActionListener(actionListener);
	}

	private void singlyAddButtonActionPerformed(ActionEvent evt) {
		listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
		singlySimpleList.setValues(listSimple, 1);
		singlyAddNodeField.setText("");
	}

	private void circularAddButtonActionPerformed(ActionEvent evt) {
		listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
		singlyCircularList.setValues(listCircular, 1);
		circularAddNodeField.setText("");
	}

	private void singlyDeleteButtonActionPerformed(ActionEvent evt) {
		if (listSimple.deleteElement(Integer.parseInt(singlyDeleteNodeField.getText())) == null) {
			JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
		} else {
			singlyDeleteNodeField.setText("");
		}
		singlySimpleList.setValues(listSimple, 0);
	}

	private void singlyAddNodeTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
			singlySimpleList.setValues(listSimple, 1);
			singlyAddNodeField.setText("");
		}
	}

	private void circularDeleteButtonActionPerformed(ActionEvent evt) {
		if (listCircular.deleteElement(Integer.parseInt(circularDeleteNodeField.getText())) == null) {
			JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
		} else {
			circularDeleteNodeField.setText("");
		}
		singlyCircularList.setValues(listCircular, 0);
	}

	private void circularAddNodeFieldKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
			singlyCircularList.setValues(listCircular, 1);
			circularAddNodeField.setText("");
		}
	}

	private void circularDeleteNodeKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (listCircular.deleteElement(Integer.parseInt(circularDeleteNodeField.getText())) == null) {
				JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
			} else {
				circularDeleteNodeField.setText("");
			}
			singlyCircularList.setValues(listCircular, 0);
		}

	}

	private void singlyDeleteNodeKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (listSimple.deleteElement(Integer.parseInt(singlyDeleteNodeField.getText())) == null) {
				JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
			} else {
				singlyDeleteNodeField.setText("");
			}
			singlySimpleList.setValues(listSimple, 0);
		}
	}

}
