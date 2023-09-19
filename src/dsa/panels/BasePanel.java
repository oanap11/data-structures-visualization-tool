package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dsa.LinkedListTemplate;
import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;
import dsa.queue.QueueListComponent;

public class BasePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	QueueComponent queueComponent;
	GraphicalArrayQueue arrayQueue;
	QueueListComponent listComponent;
	LinkedListTemplate linkedListTemplate;
	
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
	
	void configureArrayInputField() {
		arrayInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				arrayInputTextKeyPressed(evt);
			}
		});
	}
	
	void configureArraySizeText() {
		arraySizeText.setColumns(5);
		arraySizeText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				sizeTextKeyPressed(evt);
			}
		});
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
	
	private void sizeTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (arraySizeText.getText().equals(""))
				return;

			if (queueComponent != null) {
				arrayPanel.remove(queueComponent);
			}
			if (arraySizeText.getText() != " ") {
				arraySizeLabel.setText("Numar elemenete: " + arraySizeText.getText());

				arraySizeButton.setEnabled(false);
				enableArrayButtons();
				
			}
			queueComponent = new QueueComponent();

			arrayPanel.add(queueComponent, BorderLayout.CENTER);

			arrayQueue = new GraphicalArrayQueue(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(),
					arrayPanel.getHeight());
			queueComponent.setValues(arrayQueue);
			arrayPanel.revalidate();

			arraySizeText.setText(null);

		}
	}
		
	private void arrayInputTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			int a = arrayQueue.enqueue(arrayInputTextField.getText());
			if (a == -1) {
				JOptionPane.showMessageDialog(null, "Coada este plina", "alert", JOptionPane.ERROR_MESSAGE);
				arrayAddButton.setEnabled(false);
			}
			arrayRemoveButton.setEnabled(true);
			queueComponent.setValues(arrayQueue);
			arrayInputTextField.setText("");
		}
	}
	
}
