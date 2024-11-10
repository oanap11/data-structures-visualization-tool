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

import dsa.LinkedListTemplate;
import dsa.queue.ListQueue;
import dsa.stack.GraphicalArrayStack;
import dsa.stack.ArrayStack;
import dsa.stack.ListStack;
import dsa.utils.GroupLayoutUtil;

public class StackPanel extends BasePanel {

	private static final long serialVersionUID = 1L;

	private JPanel stackMainPanel;

	public StackPanel() {
		initComponents();
		configureListStackComponent();
		disableArrayButtons();
	}

	private void initComponents() {

		tabbedPane = new JTabbedPane();
		stackMainPanel = new JPanel();

		initArrayStackComponents();
		initListStackComponents();

		setLayout(new BorderLayout());

		stackMainPanel.setLayout(new BoxLayout(stackMainPanel, BoxLayout.LINE_AXIS));

		configureButton(arrayAddButton, "Push", evt -> pushButtonActionPerformed(evt));
		configureButton(arrayRemoveButton, "Pop", evt -> popButtonActionPerformed(evt));
		configureButton(arraySizeButton, "Numar de elemente", evt -> stackSizeButtonActionPerformed(evt));
		configureButton(arrayResetButton, "Reseteaza", evt -> stackResetButtonActionPerformed(evt));

		configureArrayInputField();
		configureArraySizeText();
		configureArraySizeLabel();
		configureArrayPanelSeparators();
		configureArrayNorthPanel();
		configureArrayView();

		tabbedPane.addTab("Stiva - Tablou de elemente", arrayPanel);

		listPanel.setBackground(new Color(254, 254, 254));
		listPanel.setLayout(new BorderLayout());

		configureButton(listAddButton, "Push", evt -> listPushButtonActionPerformed(evt));
		configureButton(listRemoveButton, "Pop", evt -> listPopButtonActionPerformed(evt));

		configureListInputField();
		configureListNorthPanel();
		configureListView();

		tabbedPane.addTab("Stiva - lista inlantuita", listPanel);
		stackMainPanel.add(tabbedPane);
		add(stackMainPanel, BorderLayout.CENTER);
	}

	void configureListNorthPanel() {
		GroupLayout listStackLayout = GroupLayoutUtil.createCustomLayoutForListNorthPanel(listNorthPanel,
				listInputTextField, listAddButton, listRemoveButton);
		listNorthPanel.setLayout(listStackLayout);
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
				stackSizeTextKeyPressed(evt);
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
	
	void configureListStackComponent() {
		listStackComponent = new ListStack();
		listPanel.add(listStackComponent, BorderLayout.CENTER);
		linkedListTemplate = new LinkedListTemplate();
		listStackComponent.setValues(linkedListTemplate, 0, 'n');
	}

	void initArrayStackComponents() {
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

	void initListStackComponents() {
		listPanel = new JPanel();
		listNorthPanel = new JPanel();
		listSouthPanel = new JPanel();
		listAddButton = new JButton();
		listRemoveButton = new JButton();
		listInputTextField = new JTextField();
	}
	
	void addElementToArray() {
		if (arrayInputTextField.getText().equals("")) {
			return;
		}
		int temp = stackArray.push(arrayInputTextField.getText());

		if (temp == -1) {
			arrayAddButton.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Stiva este plina.", "alert", JOptionPane.ERROR_MESSAGE);
		}
		arrayRemoveButton.setEnabled(true);
		arrayStackComponent.setValues(stackArray);
		arrayInputTextField.setText("");
	}

	private void popButtonActionPerformed(ActionEvent evt) {
		String temp = stackArray.pop();
		if (temp == null) {
			arrayRemoveButton.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Stiva nu contine elemente", "alert", JOptionPane.ERROR_MESSAGE);
		}
		arrayAddButton.setEnabled(true);
		arrayStackComponent.setValues(stackArray);
		arrayInputTextField.setText("");
	}
	
	private void setStackSize() {
	    if (arraySizeText.getText().equals(""))
	        return;
	    if (arrayStackComponent != null) {
	        arrayPanel.remove(arrayStackComponent);
	    }
	    if (!arraySizeText.getText().trim().isEmpty()) {
	        arraySizeLabel.setText("Numar de elemente:   " + arraySizeText.getText());
	        arraySizeButton.setEnabled(false);
	        enableArrayButtons();
	    }
	    arrayStackComponent = new ArrayStack();
	    arrayPanel.add(arrayStackComponent, BorderLayout.CENTER);
	    stackArray = new GraphicalArrayStack(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(), arrayPanel.getHeight() / 2);
	    arrayStackComponent.setValues(stackArray);
	    arrayPanel.revalidate();
	    arraySizeText.setText(null);
	}
	
	private void addElementToList() {
	    int element = Integer.parseInt(listInputTextField.getText());
	    linkedListTemplate.insertElement(element);
	    listStackComponent.setValues(linkedListTemplate, 1, 'n');
	    listInputTextField.setText("");
	}

	private void stackSizeButtonActionPerformed(ActionEvent evt) {
		setStackSize();
	}

	private void stackSizeTextKeyPressed(KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	    	setStackSize();
	    }
	}
	
	private void pushButtonActionPerformed(ActionEvent evt) {
		addElementToArray();
	}
	
	private void arrayInputTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			addElementToArray();
		}
	}

	private void stackResetButtonActionPerformed(ActionEvent evt) {
		arraySizeLabel.setText("Numar de elemente in stiva:  ");
		arraySizeButton.setEnabled(true);
		stackArray.size = 0;
		arrayStackComponent.setValues(stackArray);
		disableArrayButtons();
	}

	private void listPushButtonActionPerformed(ActionEvent evt) {
		addElementToList();
	}

	private void listPopButtonActionPerformed(ActionEvent evt) {
		if (linkedListTemplate.firstNode == null) {
			JOptionPane.showMessageDialog(null, "Stiva nu contine elemente.", "alert", JOptionPane.ERROR_MESSAGE);
			listStackComponent.setValues(linkedListTemplate, 0, 'e');
		} else {
			linkedListTemplate.deleteElement(linkedListTemplate.lastNode.data);
			listStackComponent.setValues(linkedListTemplate, 0, 'n'); // n
		}
	}

	private void listInputTextKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			addElementToList();
		}
	}
}
