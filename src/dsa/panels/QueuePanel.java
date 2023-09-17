package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dsa.LinkedListTemplate;
import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;
import dsa.queue.QueueListComponent;

public class QueuePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	QueueComponent queueComponent;
	GraphicalArrayQueue arrayQueue;
	QueueListComponent listComponent;
	LinkedListTemplate linkedListTemplate;

	private JTabbedPane tabbedPane;
	private JSeparator jSeparator1, jSeparator2;
	private JPanel queueMainPanel;

	// array components
	private JButton arrayEnqueueButton, arrayDequeueButton, arrayResetButton, arraySizeButton;
	private JPanel arrayPanel;
	private JSlider arraySlider;
	private JTextField arrayInputTextField;
	private JLabel arraySizeLabel;
	private JTextField arraySizeText;
	private JPanel arraySouthPanel;
	private JPanel arrayNorthPanel;

	// linked list components
	private JButton listEnqueueButton, listDequeueButton;
	private JPanel listPanel;
	private JSlider listSlider;
	private JTextField listInputTextField;
	private JPanel listSouthPanel;
	private JPanel listNorthPanel;

	public QueuePanel() {
		initComponents();
		configureListComponent();
		disableArrayButtons();
	}
	
	void configureListComponent() {
		listComponent = new QueueListComponent();
		listPanel.add(listComponent, BorderLayout.CENTER);
		linkedListTemplate = new LinkedListTemplate();
		listComponent.setValues(linkedListTemplate, 0, 'n');
	}
	
	void disableArrayButtons() {
		arrayEnqueueButton.setEnabled(false);
		arrayDequeueButton.setEnabled(false);
		arrayResetButton.setEnabled(false);
		arrayInputTextField.setEnabled(false);
	}
	
	private void initComponents() {

		tabbedPane = new JTabbedPane();
		queueMainPanel = new JPanel();

		initArrayQueueComponents();
		initListQueueComponents();

		setLayout(new BorderLayout());

		queueMainPanel.setLayout(new BoxLayout(queueMainPanel, BoxLayout.LINE_AXIS));

		arrayPanel.setBackground(new Color(254, 254, 254));
		arrayPanel.setLayout(new BorderLayout());

		configureArrayEnqueueButton();
		configureArrayDequeueButton();
		configureArrayInputField();
		configureArraySizeButton();
		configureArraySizeText();
		configureArraySizeLabel();
		configureArrayResetButton();
		configureArrayPanelSeparators();
		configureArrayNorthPanel();
		configureArrayQueueView();	
		configureArraySlider();

		tabbedPane.addTab("Coada - Tablou de elemente", arrayPanel);

		listPanel.setBackground(Color.white);
		listPanel.setLayout(new BorderLayout());

		configureListEnqueueButton();
		configureListDequeueButton();	
		configureListInputField();
		configureListNorthPanel();
		configureListQueueView();
		configureListSlider();

		tabbedPane.addTab("Coada - Lista", listPanel);
		queueMainPanel.add(tabbedPane);
		add(queueMainPanel, BorderLayout.CENTER);
	}
	
	void initArrayQueueComponents() {
		arrayPanel = new JPanel();
		arrayNorthPanel = new JPanel();
		arrayEnqueueButton = new JButton();
		arrayDequeueButton = new JButton();
		arrayInputTextField = new JTextField();
		arraySizeButton = new JButton();
		arraySizeText = new JTextField();
		arraySizeLabel = new JLabel();
		arrayResetButton = new JButton();
		jSeparator1 = new JSeparator();
		jSeparator2 = new JSeparator();
		arraySouthPanel = new JPanel();
		arraySlider = new JSlider();
	}

	void initListQueueComponents() {
		listPanel = new JPanel();
		listNorthPanel = new JPanel();
		listEnqueueButton = new JButton();
		listDequeueButton = new JButton();
		listInputTextField = new JTextField();
		listSouthPanel = new JPanel();
		listSlider = new JSlider();
	}

	void configureArrayEnqueueButton() {
		arrayEnqueueButton.setText("Adauga element");
		arrayEnqueueButton.addActionListener(evt -> enqueueButtonActionPerformed(evt));
	}

	void configureArrayDequeueButton() {
		arrayDequeueButton.setText("Sterge element");
		arrayDequeueButton.addActionListener(evt -> dequeueButtonActionPerformed(evt));
	}

	void configureArrayInputField() {
		arrayInputTextField.setColumns(5);
		arrayInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				qinputTextKeyPressed(evt);
			}
		});
	}
	
	void configureArraySizeButton() {
		arraySizeButton.setText("Numar elemente");
		arraySizeButton.addActionListener(evt -> sizeButtonActionPerformed(evt));
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
	
	void configureArrayResetButton() {
		arrayResetButton.setText("Reseteaza");
		arrayResetButton.addActionListener(evt -> resetButtonActionPerformed(evt));
	}
	
	void configureArrayPanelSeparators() {
		jSeparator1.setOrientation(SwingConstants.VERTICAL);
		jSeparator2.setOrientation(SwingConstants.VERTICAL);
	}
	
	void configureArrayNorthPanel() {
		GroupLayout arrayQueueLayout = GroupLayoutUtil.createCustomLayoutForArrayNorthPanel(
			    arrayNorthPanel,
			    arrayInputTextField,
			    arrayEnqueueButton,
			    arrayDequeueButton,
			    jSeparator1,
			    arraySizeText,
			    arraySizeButton,
			    arraySizeLabel,
			    jSeparator2,
			    arrayResetButton
			);

		arrayNorthPanel.setLayout(arrayQueueLayout);
	}
	
	void configureArrayQueueView() {
		arrayPanel.add(arrayNorthPanel, BorderLayout.NORTH);
		arraySouthPanel.setBackground(new Color(255, 87, 51));
		arraySouthPanel.setPreferredSize(new Dimension(100, 100));
		arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);
	}
	
	void configureArraySlider() {
		arraySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed",
				TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N
	}
	
	void configureListSlider() {
		listSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed",
				TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Bitstream Charter", 0, 12),
				new Color(222, 29, 29))); // NOI18N
	}
	
	void configureListEnqueueButton() {
		listEnqueueButton.setText("Adauga element");
		listEnqueueButton.addActionListener(evt -> listEnqueueButtonActionPerformed(evt));
	}
	
	void configureListDequeueButton() {
		listDequeueButton.setText("Scoate element");
		listDequeueButton.addActionListener(evt -> dequeueButtonListActionPerformed(evt));
	}
	
	void configureListInputField() {
		listInputTextField.setColumns(5);
		listInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				qListinputTextKeyPressed(evt);
			}
		});
	}
	
	void configureListQueueView() {
		listPanel.add(listNorthPanel, BorderLayout.NORTH);
		listSouthPanel.setBackground(new Color(255, 87, 51));
		listSouthPanel.setPreferredSize(new Dimension(100, 100));
		listPanel.add(listSouthPanel, BorderLayout.SOUTH);
	}
	
	void configureListNorthPanel() {
		GroupLayout queueNorthLinkedPanelLayout = new GroupLayout(listNorthPanel);
		listNorthPanel.setLayout(queueNorthLinkedPanelLayout);
		queueNorthLinkedPanelLayout.setHorizontalGroup(queueNorthLinkedPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(queueNorthLinkedPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(listEnqueueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(listDequeueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
						.addGap(82, 82, 82)));
		queueNorthLinkedPanelLayout
				.setVerticalGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(queueNorthLinkedPanelLayout.createSequentialGroup().addContainerGap()
								.addGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(queueNorthLinkedPanelLayout
												.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(listEnqueueButton).addComponent(listDequeueButton)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}
	
	void enableArrayButtons() {
		arrayEnqueueButton.setEnabled(true);
		arrayDequeueButton.setEnabled(true);
		arrayResetButton.setEnabled(true);
		arrayInputTextField.setEnabled(true);
	}

	private void dequeueButtonActionPerformed(ActionEvent evt) {
		String s = arrayQueue.dequeue();
		if (s == null) {
			arrayDequeueButton.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Coada este goala.", "alert", JOptionPane.ERROR_MESSAGE);
		}
		arrayEnqueueButton.setEnabled(true);
		queueComponent.setValues(arrayQueue);
		arrayInputTextField.setText("");
	}

	private void sizeButtonActionPerformed(ActionEvent evt) {
		if (arraySizeText.getText().equals(""))
			return;

		if (queueComponent != null) {
			arrayPanel.remove(queueComponent);
		}
		if (arraySizeText.getText() != " ") {
			arraySizeLabel.setText("Numar elemente:  " + arraySizeText.getText());
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

	private void resetButtonActionPerformed(ActionEvent evt) {
		arraySizeLabel.setText("Numar elemente:   ");
		arraySizeButton.setEnabled(true);
		disableArrayButtons();
		arrayQueue.size = 0;
		queueComponent.setValues(arrayQueue);
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

	private void enqueueButtonActionPerformed(ActionEvent evt) {
		int a = arrayQueue.enqueue(arrayInputTextField.getText());
		if (a == -1) {
			JOptionPane.showMessageDialog(null, "Coada este plina.", "alert", JOptionPane.ERROR_MESSAGE);
			arrayEnqueueButton.setEnabled(false);
		}
		arrayDequeueButton.setEnabled(true);
		queueComponent.setValues(arrayQueue);
		arrayInputTextField.setText("");
	}

	private void dequeueButtonListActionPerformed(ActionEvent evt) {
		if (linkedListTemplate.firstNode == null)
			JOptionPane.showMessageDialog(null, "Nu sunt elemente in coada", "alert", JOptionPane.ERROR_MESSAGE);
		else
			linkedListTemplate.deleteElement(linkedListTemplate.firstNode.data);
		listComponent.setValues(linkedListTemplate, 0, 'n');
	}

	private void listEnqueueButtonActionPerformed(ActionEvent evt) {
		linkedListTemplate.insertElement(Integer.parseInt(listInputTextField.getText()));
		listComponent.setValues(linkedListTemplate, 1, 'n');
		listInputTextField.setText("");
	}

	private void qinputTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			int a = arrayQueue.enqueue(arrayInputTextField.getText());
			if (a == -1) {
				JOptionPane.showMessageDialog(null, "Coada este plina", "alert", JOptionPane.ERROR_MESSAGE);
				arrayEnqueueButton.setEnabled(false);
			}
			arrayDequeueButton.setEnabled(true);
			queueComponent.setValues(arrayQueue);
			arrayInputTextField.setText("");
		}
	}

	private void qListinputTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			linkedListTemplate.insertElement(Integer.parseInt(listInputTextField.getText()));
			listComponent.setValues(linkedListTemplate, 1, 'n');
			listInputTextField.setText("");
		}
	}
}
