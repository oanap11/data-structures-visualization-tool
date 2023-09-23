package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dsa.LinkedListTemplate;
import dsa.linked.list.SinglyListComponent;
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
		configureAddButton(singlyAddButton);
		configureDeleteNodeField(singlyDeleteNodeField);
		setupDeleteButton(singlyDeleteButton, evt -> singlyDeleteButtonActionPerformed(evt));
		setupNorthPanel(singlyListNorthPanel, singlyAddNodeField, singlyAddButton,
	            singlyDeleteNodeField, singlyDeleteButton);
		configureListView(singlyListMainPanel, singlyListNorthPanel, singlyListSouthPanel);
	}
	
	void configureCircularListSettings() {
		configureMainPanel(circularListMainPanel, new BorderLayout());
		configureAddNodeField(circularAddNodeField);
		configureAddButton(circularAddButton);
		configureDeleteNodeField(circularDeleteNodeField);
		setupDeleteButton(circularDeleteButton, evt -> circularDeleteButtonActionPerformed(evt));
		setupNorthPanel(circularListNorthPanel, circularAddNodeField, circularAddButton,
	            circularDeleteNodeField, circularDeleteButton);
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
	
	void configureAddButton(JButton addButton) {
		addButton.setText("Insereaza");
		addButton.addActionListener(evt -> {
		    if (addButton == singlyAddButton) {
		        singlyAddButtonActionPerformed(evt);
		    } else if (addButton == circularAddButton) {
		        circularAddButtonActionPerformed(evt);
		    } 
		});
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
	
	void setupNorthPanel(JPanel northPanel, JTextField addNodeField, JButton addButton,
	        JTextField deleteNodeField, JButton deleteButton) {
	    GroupLayout northPanelLayout = new GroupLayout(northPanel);
	    northPanel.setLayout(northPanelLayout);
	    northPanelLayout.setHorizontalGroup(northPanelLayout
	            .createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(northPanelLayout.createSequentialGroup().addContainerGap().addGap(18, 18, 18)
	                    .addComponent(addNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
	                    .addGap(18, 18, 18).addComponent(addButton, 0, GroupLayout.DEFAULT_SIZE, 200)
	                    .addGap(41, 41, 41)
	                    .addComponent(deleteNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                            GroupLayout.PREFERRED_SIZE)
	                    .addGap(18, 18, 18).addComponent(deleteButton, 0, GroupLayout.DEFAULT_SIZE, 200)
	                    .addContainerGap(298, Short.MAX_VALUE)));
	    northPanelLayout.setVerticalGroup(northPanelLayout
	            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
	                    .addGroup(northPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(northPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                                    .addComponent(addButton)
	                                    .addComponent(addNodeField, GroupLayout.PREFERRED_SIZE,
	                                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(deleteNodeField, GroupLayout.PREFERRED_SIZE,
	                                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                            .addComponent(deleteButton))
	                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
