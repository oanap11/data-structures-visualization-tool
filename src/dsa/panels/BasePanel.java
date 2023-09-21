package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dsa.LinkedListTemplate;
import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;
import dsa.queue.QueueListComponent;
import dsa.stack.GraphicalArrayStack;
import dsa.stack.StackComponent;
import dsa.stack.StackListComponent;

public class BasePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	QueueComponent queueComponent;
	StackComponent arrayStackComponent;
	
	GraphicalArrayQueue arrayQueue;
	GraphicalArrayStack stackArray;
	
	QueueListComponent listComponent;
	StackListComponent listStackComponent;
	
	LinkedListTemplate linkedListTemplate;
	
	protected JTabbedPane tabbedPane;
	protected JPanel arrayPanel, arraySouthPanel, arrayNorthPanel;
	protected JButton arrayAddButton, arrayRemoveButton, arrayResetButton, arraySizeButton;
	protected JTextField arrayInputTextField;
	protected JLabel arraySizeLabel;
	protected JTextField arraySizeText;
	protected JSeparator jSeparator1, jSeparator2;
	
	protected JButton listAddButton, listRemoveButton;
	protected JPanel listPanel;
	protected JTextField listInputTextField;
	protected JPanel listSouthPanel;
	protected JPanel listNorthPanel;
	
	public BasePanel() {
        // Initialize the arrayPanel
        arrayPanel = new JPanel();
        arrayPanel.setBackground(new Color(254, 254, 254));
        arrayPanel.setLayout(new BorderLayout());
        arrayNorthPanel = new JPanel();
        arraySouthPanel = new JPanel();
    }
	
	void configureListComponent() {
		listComponent = new QueueListComponent();
		listPanel.add(listComponent, BorderLayout.CENTER);
		linkedListTemplate = new LinkedListTemplate();
		listComponent.setValues(linkedListTemplate, 0, 'n');
	}
	
	protected void configureArrayNorthPanel() {
		GroupLayout queueLayout = GroupLayoutUtil.createCustomLayoutForArrayNorthPanel(arrayNorthPanel, arrayInputTextField,
			    arrayAddButton, arrayRemoveButton, jSeparator1, arraySizeText, arraySizeButton, arraySizeLabel, jSeparator2,
			    arrayResetButton
			);

		arrayNorthPanel.setLayout(queueLayout);
	}
	
	protected void configureArrayView() {
		arrayPanel.add(arrayNorthPanel, BorderLayout.NORTH);
		arraySouthPanel.setBackground(new Color(255, 87, 51));
		arraySouthPanel.setPreferredSize(new Dimension(100, 100));
		arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);
	}
	
	void configureListView() {
		listPanel.add(listNorthPanel, BorderLayout.NORTH);
		listSouthPanel.setBackground(new Color(255, 87, 51));
		listSouthPanel.setPreferredSize(new Dimension(100, 100));
		listPanel.add(listSouthPanel, BorderLayout.SOUTH);
	}
	
	void configureArraySizeLabel() {
		arraySizeLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
		arraySizeLabel.setForeground(new Color(241, 19, 19));
		arraySizeLabel.setText("Numar de elemente:  ");
	}
	
	void enableArrayButtons() {
		arrayAddButton.setEnabled(true);
		arrayRemoveButton.setEnabled(true);
		arrayResetButton.setEnabled(true);
		arrayInputTextField.setEnabled(true);
	}
	
	void disableArrayButtons() {
		arrayAddButton.setEnabled(false);
		arrayRemoveButton.setEnabled(false);
		arrayResetButton.setEnabled(false);
		arrayInputTextField.setEnabled(false);
	}
	
	void configureArrayPanelSeparators() {
		jSeparator1.setOrientation(SwingConstants.VERTICAL);
		jSeparator2.setOrientation(SwingConstants.VERTICAL);
	}
	
	protected void configureButton(JButton button, String text, ActionListener listener) {
	    button.setText(text);
	    button.addActionListener(listener);
	}
	
}
