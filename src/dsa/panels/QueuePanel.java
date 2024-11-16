package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import dsa.queue.GraphicalArrayQueue;
import dsa.queue.ArrayQueue;

public class QueuePanel extends StackOrQueueView {

	private static final long serialVersionUID = 1L;

	public QueuePanel() {
		initComponents();
		configureListComponent();
		disableArrayButtons();
	}
	
	private void initComponents() {
		initArrayComponents();
		initListComponents();
		
		setLayout(new BorderLayout());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		
		configureArrayPanelButtons();
		
		configureArrayInputField();
		configureArraySizeText();
		configureArraySizeLabel();	
		configureArrayNorthPanel();
		configureArrayView();	

		tabbedPane.addTab("Coada - Tablou de elemente", arrayPanel);

		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BorderLayout());
		
		

		configureButton(listAddButton, "Adauga element", evt -> listEnqueueButtonActionPerformed(evt));
		configureButton(listRemoveButton, "Sterge element", evt -> listDequeueButtonActionPerformed(evt));
		configureListInputField();
		configureListNorthPanel();
		setupListPanelLayout();

		tabbedPane.addTab("Coada - Lista", listPanel);
		mainPanel.add(tabbedPane);
		add(mainPanel, BorderLayout.CENTER);
	}
	
	void configureArrayPanelButtons() {
		configureButton(arrayAddButton, "Adauga element", evt -> arrayEnqueueButtonActionPerformed(evt));
		configureButton(arrayRemoveButton, "Sterge element", evt -> dequeueButtonActionPerformed(evt));
		configureButton(arrayResetButton, "Reseteaza", evt -> resetButtonActionPerformed(evt));
		configureButton(arraySizeButton, "Numar elemente", evt -> sizeButtonActionPerformed(evt));
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
	
	void configureListInputField() {
		listInputTextField.setColumns(5);
		listInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				listInputTextKeyPressed(evt);
			}
		});
	}

	private void setQueueSize() {
	    if (arraySizeText.getText().equals(""))
	        return;

	    if (queueComponent != null) {
	        arrayPanel.remove(queueComponent);
	    }

	    if (!arraySizeText.getText().trim().isEmpty()) {
	        arraySizeLabel.setText("Numar elemente: " + arraySizeText.getText());
	        arraySizeButton.setEnabled(false);
	        enableArrayButtons();
	    }

	    queueComponent = new ArrayQueue();
	    arrayPanel.add(queueComponent, BorderLayout.CENTER);

	    arrayQueue = new GraphicalArrayQueue(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(), arrayPanel.getHeight() / 2);
	    queueComponent.setValues(arrayQueue);
	    arrayPanel.revalidate();

	    arraySizeText.setText(null);
	}
	
	private void addElementToArray() {
	    int a = arrayQueue.enqueue(arrayInputTextField.getText());
	    if (a == -1) {
	        JOptionPane.showMessageDialog(null, "Coada este plina.", "alert", JOptionPane.ERROR_MESSAGE);
	        arrayAddButton.setEnabled(false);
	    }
	    arrayRemoveButton.setEnabled(true);
	    queueComponent.setValues(arrayQueue);
	    arrayInputTextField.setText("");
	}
	
	private void dequeueButtonActionPerformed(ActionEvent evt) {
		String s = arrayQueue.dequeue();
		if (s == null) {
			arrayRemoveButton.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Coada este goala.", "alert", JOptionPane.ERROR_MESSAGE);
		}
		arrayAddButton.setEnabled(true);
		queueComponent.setValues(arrayQueue);
		arrayInputTextField.setText("");
	}

	private void resetButtonActionPerformed(ActionEvent evt) {
		arraySizeLabel.setText("Numar elemente:   ");
		arraySizeButton.setEnabled(true);
		disableArrayButtons();
		arrayQueue.size = 0;
		queueComponent.setValues(arrayQueue);
	}

	private void listDequeueButtonActionPerformed(ActionEvent evt) {
		if (linkedListTemplate.firstNode == null)
			JOptionPane.showMessageDialog(null, "Nu sunt elemente in coada", "alert", JOptionPane.ERROR_MESSAGE);
		else
			linkedListTemplate.deleteElement(linkedListTemplate.firstNode.data);
		listQueueComponent.setValues(linkedListTemplate, 0);
	}

	private void addElementToList() {
	    int element = Integer.parseInt(listInputTextField.getText());
	    linkedListTemplate.insertElement(element);
	    listQueueComponent.setValues(linkedListTemplate, 1);
	    listInputTextField.setText("");
	}
	
	private void sizeButtonActionPerformed(ActionEvent evt) {
		setQueueSize();
	}

	private void sizeTextKeyPressed(KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	    	setQueueSize();
	    }
	}

	private void listEnqueueButtonActionPerformed(ActionEvent evt) {
		addElementToList();
	}
	
	private void listInputTextKeyPressed(KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	    	addElementToList();
	    }
	}
	
	private void arrayEnqueueButtonActionPerformed(ActionEvent evt) {
		addElementToArray();
	}
	
	private void arrayInputTextKeyPressed(KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	    	addElementToArray();
	    }
	}		
}
