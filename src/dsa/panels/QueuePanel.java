package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;

public class QueuePanel extends BasePanel {

	private static final long serialVersionUID = 1L;

	private JPanel queueMainPanel;

	public QueuePanel() {
		initComponents();
		configureListComponent();
		disableArrayButtons();
	}
	
	private void initComponents() {

		tabbedPane = new JTabbedPane();
		queueMainPanel = new JPanel();

		initArrayQueueComponents();
		initListQueueComponents();

		setLayout(new BorderLayout());

		queueMainPanel.setLayout(new BoxLayout(queueMainPanel, BoxLayout.LINE_AXIS));

		configureButton(arrayAddButton, "Adauga element", evt -> arrayEnqueueButtonActionPerformed(evt));
		configureButton(arrayRemoveButton, "Sterge element", evt -> dequeueButtonActionPerformed(evt));
		configureButton(arrayResetButton, "Reseteaza", evt -> resetButtonActionPerformed(evt));
		configureButton(arraySizeButton, "Numar elemente", evt -> sizeButtonActionPerformed(evt));
		
		configureArrayInputField();
		configureArraySizeText();
		configureArraySizeLabel();	
		configureArrayPanelSeparators();
		configureArrayNorthPanel();
		configureArrayView();	

		tabbedPane.addTab("Coada - Tablou de elemente", arrayPanel);

		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BorderLayout());

		configureButton(listAddButton, "Adauga element", evt -> listEnqueueButtonActionPerformed(evt));
		configureButton(listRemoveButton, "Sterge element", evt -> listDequeueButtonActionPerformed(evt));
		configureListInputField();
		configureListNorthPanel();
		configureListView();

		tabbedPane.addTab("Coada - Lista", listPanel);
		queueMainPanel.add(tabbedPane);
		add(queueMainPanel, BorderLayout.CENTER);
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
	
	void initArrayQueueComponents() {
		arrayAddButton = new JButton();
		arrayRemoveButton = new JButton();
		arrayInputTextField = new JTextField();
		arraySizeButton = new JButton();
		arraySizeText = new JTextField();
		arraySizeLabel = new JLabel();
		arrayResetButton = new JButton();
		jSeparator1 = new JSeparator();
		jSeparator2 = new JSeparator();
	}

	void initListQueueComponents() {
		listPanel = new JPanel();
		listNorthPanel = new JPanel();
		listAddButton = new JButton();
		listRemoveButton = new JButton();
		listInputTextField = new JTextField();
		listSouthPanel = new JPanel();
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
	
	void configureListNorthPanel() {
		GroupLayout listQueueLayout = GroupLayoutUtil.createCustomLayoutForListNorthPanel(listNorthPanel, listInputTextField, listAddButton, listRemoveButton);
		listNorthPanel.setLayout(listQueueLayout);
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

	    queueComponent = new QueueComponent();
	    arrayPanel.add(queueComponent, BorderLayout.CENTER);

	    arrayQueue = new GraphicalArrayQueue(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(), arrayPanel.getHeight());
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
		listComponent.setValues(linkedListTemplate, 0, 'n');
	}

	private void addElementToList() {
	    int element = Integer.parseInt(listInputTextField.getText());
	    linkedListTemplate.insertElement(element);
	    listComponent.setValues(linkedListTemplate, 1, 'n');
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
