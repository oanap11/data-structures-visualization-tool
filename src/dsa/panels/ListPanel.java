package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import dsa.SinglyLinkedList;
import dsa.linked.list.ListComponent;
import dsa.linked.list.SinglyCircular;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	ListComponent singlyLinked;
	SinglyCircular singlyCircular;
	SinglyLinkedList listSimple, listCircular;
	
	private JTabbedPane tabbedPane;
	
	// Components to create the singly list view
	private JButton singlyAddButton, singlyDeleteButton;
	private JTextField singlyAddNodeField, singlyDeleteNodeField;
	private JPanel singlyListMainPanel, singlyListSouthPanel, singlyListNorthPanel;
	private JSlider singlySlider;
	
	// Components to create the circular list view
	private JButton circularAddButton, circularDeleteButton;
	private JTextField circularAddNodeField, circularDeleteNodeField;
	private JPanel circularListMainPanel, circularListNorthPanel, circularListSouthPanel;
	private JSlider circularSlider;

	public ListPanel() {
		initComponents();

		singlyCircular = new SinglyCircular();
		singlyLinked = new ListComponent();

		singlyListMainPanel.add(singlyLinked, BorderLayout.CENTER);
		circularListMainPanel.add(singlyCircular, BorderLayout.CENTER);

		listSimple = new SinglyLinkedList();
		listCircular = new SinglyLinkedList();

		singlyLinked.setValues(listSimple, 0);
		singlyCircular.setValues(listCircular, 0);

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
		singlySlider = new JSlider();
	}

	void initCircularComponents() {
		circularListMainPanel = new JPanel();
		circularListNorthPanel = new JPanel();
		circularListSouthPanel = new JPanel();
		circularAddNodeField = new JTextField();
		circularAddButton = new JButton();
		circularDeleteNodeField = new JTextField();
		circularDeleteButton = new JButton();
		circularSlider = new JSlider();
	}
	
	void configureSinglyListSettings(){
		singlyListMainPanel.setBackground(Color.white);
		singlyListMainPanel.setLayout(new BorderLayout());

		singlyAddNodeField.setColumns(5);
		singlyAddNodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				singlyaddNodeTextKeyPressed(evt);
			}
		});

		singlyAddButton.setText("Insereaza");
		singlyAddButton.addActionListener(evt -> singlyaddButtonActionPerformed(evt));

		singlyDeleteNodeField.setColumns(5);
		singlyDeleteNodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				singlyListDelFieldKeyPressed(evt);
			}
		});
		
		setupDeleteButton(singlyDeleteButton, evt -> singlyDeleteButtonActionPerformed(evt));
		
		setupSinglyNorthPanel();

		configureSinglyView();

		configureSlider(singlySlider);
	}
	
	void configureSlider(JSlider slider) {
	    slider.setBorder(javax.swing.BorderFactory.createTitledBorder(
	            javax.swing.BorderFactory.createCompoundBorder(), 
	            "Animation Speed",
	            javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION,
	            new java.awt.Font("Bitstream Charter", 0, 12),
	            new java.awt.Color(222, 29, 29)
	    ));
	}
	
	void configureSinglyView() {
		singlyListMainPanel.add(singlyListNorthPanel, BorderLayout.NORTH);
		singlyListSouthPanel.setBackground(new Color(255, 87, 51));
		singlyListSouthPanel.setPreferredSize(new Dimension(100, 100));
		singlyListMainPanel.add(singlyListSouthPanel, BorderLayout.SOUTH);
	}

	void setupDeleteButton(JButton deleteButton, ActionListener actionListener) {
	    deleteButton.setBackground(Color.white);
	    deleteButton.setText("Sterge");
	    deleteButton.setFocusable(false);
	    deleteButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    deleteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    deleteButton.addActionListener(actionListener);
	}
	
	void setupSinglyNorthPanel() {
		GroupLayout singlyListNorthPanelLayout = new GroupLayout(singlyListNorthPanel);
		singlyListNorthPanel.setLayout(singlyListNorthPanelLayout);
		singlyListNorthPanelLayout.setHorizontalGroup(singlyListNorthPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(singlyListNorthPanelLayout.createSequentialGroup().addContainerGap().addGap(18, 18, 18)
						.addComponent(singlyAddNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(singlyAddButton, 0, GroupLayout.DEFAULT_SIZE, 150)
						.addGap(35, 35, 35)
						.addComponent(singlyDeleteNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(singlyDeleteButton).addContainerGap(304, Short.MAX_VALUE)));
		singlyListNorthPanelLayout.setVerticalGroup(singlyListNorthPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(singlyListNorthPanelLayout.createSequentialGroup()
						.addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(singlyAddButton)
										.addComponent(singlyAddNodeField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(singlyDeleteNodeField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(singlyDeleteButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}
	
	
	void configureCircularListSettings() {
		circularListMainPanel.setBackground(new Color(254, 254, 254));
		circularListMainPanel.setLayout(new BorderLayout());

		circularAddNodeField.setColumns(5);
		circularAddNodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				circularAddNodeFieldKeyPressed(evt);
			}
		});

		circularAddButton.setText("Adauga element");
		circularAddButton.addActionListener(evt -> singlyaddButton1ActionPerformed(evt));

		circularDeleteNodeField.setColumns(5);
		circularDeleteNodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				circularListDelFieldKeyPressed(evt);
			}
		});
		
		setupDeleteButton(circularDeleteButton, evt -> circularDeleteButtonActionPerformed(evt));
		
		setupCircularNorthPanel();

		circularListMainPanel.add(circularListNorthPanel, BorderLayout.NORTH);
		circularListSouthPanel.setBackground(new Color(255, 87, 51));
		circularListSouthPanel.setPreferredSize(new Dimension(100, 100));
		circularListMainPanel.add(circularListSouthPanel, BorderLayout.SOUTH);

		configureSlider(circularSlider);
	}
	
	void setupCircularNorthPanel() {
		GroupLayout singlyCircularNorthPanelLayout = new GroupLayout(circularListNorthPanel);
		circularListNorthPanel.setLayout(singlyCircularNorthPanelLayout);
		singlyCircularNorthPanelLayout.setHorizontalGroup(singlyCircularNorthPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(singlyCircularNorthPanelLayout.createSequentialGroup().addContainerGap().addGap(18, 18, 18)
						.addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(circularAddButton, 0, GroupLayout.DEFAULT_SIZE, 200)
						.addGap(41, 41, 41)
						.addComponent(circularDeleteNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(circularDeleteButton, 0, GroupLayout.DEFAULT_SIZE, 200)
						.addContainerGap(298, Short.MAX_VALUE)));
		singlyCircularNorthPanelLayout.setVerticalGroup(singlyCircularNorthPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, singlyCircularNorthPanelLayout.createSequentialGroup()
						.addGroup(singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(singlyCircularNorthPanelLayout
										.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(circularAddButton)
										.addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(circularDeleteNodeField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(circularDeleteButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	// eveniment la apasarea butonului de inserare pentru a adauga elemente lista
	// simplu inlantuita
	private void singlyaddButtonActionPerformed(ActionEvent evt) {
		listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
		singlyLinked.setValues(listSimple, 1);
		singlyAddNodeField.setText("");
	}

	// eveniment la apasarea butonului de inserare pentru a adauga elemente lista
	// circulara simplu inlantuita
	private void singlyaddButton1ActionPerformed(ActionEvent evt) {
		listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
		singlyCircular.setValues(listCircular, 1);
		circularAddNodeField.setText("");
	}

	// eveniment la apasarea butonului de stergere pentru a scoate elemente din
	// lista simplu inlantuita
	private void singlyDeleteButtonActionPerformed(ActionEvent evt) {
		if (listSimple.deleteElement(Integer.parseInt(singlyDeleteNodeField.getText())) == null) {
			JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
		} else {
			singlyDeleteNodeField.setText("");
		}
		singlyLinked.setValues(listSimple, 0);
	}

	// eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista
	// simplu inlantuita
	private void singlyaddNodeTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
			singlyLinked.setValues(listSimple, 1);
			singlyAddNodeField.setText("");
		}
	}

	// eveniment la apasarea butonului de stergere elemente in lista circulara
	// simplu inlantuita
	private void circularDeleteButtonActionPerformed(ActionEvent evt) {
		if (listCircular.deleteElement(Integer.parseInt(circularDeleteNodeField.getText())) == null) {
			JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
		} else {
			circularDeleteNodeField.setText("");
		}
		singlyCircular.setValues(listCircular, 0);
	}

	// eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista
	// circulara simplu inlantuita
	private void circularAddNodeFieldKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
			singlyCircular.setValues(listCircular, 1);
			circularAddNodeField.setText("");
		}
	}

	// eveniment la apasarea tastei Enter pentru stergerea de elemente in lista
	// circulara simplu inlantuita
	private void circularListDelFieldKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (listCircular.deleteElement(Integer.parseInt(circularDeleteNodeField.getText())) == null) {
				JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
			} else {
				circularDeleteNodeField.setText("");
			}
			singlyCircular.setValues(listCircular, 0);
		}

	}

	// eveniment la apasarea tastei Enter pentru stergerea de elemente in lista
	// simplu inlantuita
	private void singlyListDelFieldKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (listSimple.deleteElement(Integer.parseInt(singlyDeleteNodeField.getText())) == null) {
				JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
			} else {
				singlyDeleteNodeField.setText("");
			}
			singlyLinked.setValues(listSimple, 0);
		}
	}

}
