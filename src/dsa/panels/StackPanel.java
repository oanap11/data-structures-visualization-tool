package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;

import dsa.LinkedListTemplate;
import dsa.stack.GraphicalArrayStack;
import dsa.stack.StackComponent;
import dsa.stack.StackListComponent;

public class StackPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	StackComponent arrayStackComponent;
    GraphicalArrayStack stackArray;
    
    StackListComponent listStackComponent;
    LinkedListTemplate linkedListTemplate;
    
    private JTabbedPane tabbedPane;
    private JSeparator jSeparator1, jSeparator2;
    private JPanel stackMainPanel;

    private JPanel arrayPanel; 
    private JPanel arrayNorthPanel, arraySouthPanel;
    private JButton arrayPopButton, arrayPushButton, arrayResetButton, arraySizeButton;
    private JLabel arraySizeLabel;
    private JTextField arraySizeText;
    private JTextField arrayInputTextField;
    
    private JPanel listPanel;
    private JButton listPushButton, listPopButton;
    private JTextField listInputTextField;
    private JPanel listSouthPanel, listNorthPanel;
    
    public StackPanel() {
        initComponents();
        configureListComponent();
        disableArrayButtons();     
    }
    
    void configureListComponent() {
    	listStackComponent = new StackListComponent();
        listPanel.add(listStackComponent,BorderLayout.CENTER);
        linkedListTemplate = new LinkedListTemplate();
        listStackComponent.setValues(linkedListTemplate,0,'n');
	}
    
    void disableArrayButtons() {
    	arrayPushButton.setEnabled(false);
        arrayPopButton.setEnabled(false);
        arrayResetButton.setEnabled(false);
	}

    private void initComponents() {
    	
    	tabbedPane = new JTabbedPane();
        stackMainPanel = new JPanel();
        
    	initArrayStackComponents();
    	initListStackComponents();

        setLayout(new BorderLayout());

        stackMainPanel.setLayout(new BoxLayout(stackMainPanel, BoxLayout.LINE_AXIS));

        arrayPanel.setBackground(new Color(254, 254, 254));
        arrayPanel.setLayout(new BorderLayout());

        configureButton(arrayPushButton, "Push", evt -> pushButtonActionPerformed(evt));
        configureButton(arrayPopButton, "Pop", evt -> popButtonActionPerformed(evt));
        configureButton(arraySizeButton, "Numar de elemente", evt -> stackSizeButtonActionPerformed(evt));
        configureButton(arrayResetButton, "Reseteaza", evt -> stackResetButtonActionPerformed(evt));
        
        configureArrayInputField();
        configureArraySizeText();
        configureArraySizeLabel();
        configureArrayPanelSeparators();
        configureArrayNorthPanel();
       
        configureArrayStackView();

        tabbedPane.addTab("Stiva - Tablou de elemente", arrayPanel);

        listPanel.setBackground(new Color(254, 254, 254));
        listPanel.setLayout(new BorderLayout());

        configureButton(listPushButton, "Push", evt -> listPushButtonActionPerformed(evt));
        configureButton(listPopButton, "Pop", evt -> listPopButtonActionPerformed(evt));

        configureListInputField();
        configureListNorthPanel();
        configureListStackView();

        tabbedPane.addTab("Stiva - lista inlantuita", listPanel);
        stackMainPanel.add(tabbedPane);
        add(stackMainPanel, BorderLayout.CENTER);
    }
    
    void configureListStackView() {
		listPanel.add(listNorthPanel, BorderLayout.NORTH);
		listSouthPanel.setBackground(new Color(255, 87, 51));
		listSouthPanel.setPreferredSize(new Dimension(100, 100));
		listPanel.add(listSouthPanel, BorderLayout.SOUTH);
	}
    
    void configureListNorthPanel() {
    	GroupLayout listStackLayout = GroupLayoutUtil.createCustomLayoutForListNorthPanel(listNorthPanel, listInputTextField, listPushButton, listPopButton);
		listNorthPanel.setLayout(listStackLayout);
	}
    
    void configureArrayInputField() {
		arrayInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				sinputTextKeyPressed(evt);
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
    
    void configureArrayNorthPanel() {
		GroupLayout stackQueueLayout = GroupLayoutUtil.createCustomLayoutForArrayNorthPanel(arrayNorthPanel, arrayInputTextField,
			    arrayPushButton, arrayPopButton, jSeparator1, arraySizeText, arraySizeButton, arraySizeLabel, jSeparator2,
			    arrayResetButton
			);

		arrayNorthPanel.setLayout(stackQueueLayout);
	}
    
    void configureArrayStackView() {
		arrayPanel.add(arrayNorthPanel, BorderLayout.NORTH);
		arraySouthPanel.setBackground(new Color(255, 87, 51));
		arraySouthPanel.setPreferredSize(new Dimension(100, 100));
		arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);
	}
    
    void configureListInputField() {
		listInputTextField.setColumns(5);
		listInputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				sListInputTextKeyPressed(evt);
			}
		});
	}
    
    void initArrayStackComponents() {
        arrayPanel = new JPanel();
        arraySouthPanel = new JPanel();
        arrayNorthPanel = new JPanel();
        arrayPushButton = new JButton();
        arrayPopButton = new JButton();
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
        listPushButton = new JButton();
        listPopButton = new JButton();
        listInputTextField = new JTextField();
    }
    
    void configureArrayPanelSeparators() {
		jSeparator1.setOrientation(SwingConstants.VERTICAL);
		jSeparator2.setOrientation(SwingConstants.VERTICAL);
	}
    
    void configureArraySizeLabel() {
		arraySizeLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
		arraySizeLabel.setForeground(new Color(241, 19, 19));
		arraySizeLabel.setText("Numar de elemente:  ");
	}
    
    private void configureButton(JButton button, String text, ActionListener listener) {
	    button.setText(text);
	    button.addActionListener(listener);
	}

    private void pushButtonActionPerformed(ActionEvent evt) {
        if(arrayInputTextField.getText().equals("")){
            return;
        }
        int temp = stackArray.push(arrayInputTextField.getText());

        if(temp==-1) {
            arrayPushButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Stiva este plina.", "alert", JOptionPane.ERROR_MESSAGE);
        }
        arrayPopButton.setEnabled(true);
        arrayStackComponent.setValues(stackArray);
        arrayInputTextField.setText("");
    }

    private void popButtonActionPerformed(ActionEvent evt) {
        String temp = stackArray.pop();
        if(temp == null){
            arrayPopButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Stiva nu contine elemente", "alert", JOptionPane.ERROR_MESSAGE);
        }
        arrayPushButton.setEnabled(true);
        arrayStackComponent.setValues(stackArray);
        arrayInputTextField.setText("");
    }

    private void stackSizeButtonActionPerformed(ActionEvent evt) {
        if(arraySizeText.getText().equals(""))
                return;
        if(arrayStackComponent != null) {
            arrayPanel.remove(arrayStackComponent);
        }
        if(arraySizeText.getText() != " ") {
            arraySizeLabel.setText( "Numar de elemente in stiva:   "+ arraySizeText.getText());

            arraySizeButton.setEnabled(false);
            arrayPushButton.setEnabled(true);
            arrayPopButton.setEnabled(true);
            arrayResetButton.setEnabled(true);

        }
        arrayStackComponent = new StackComponent();

        arrayPanel.add(arrayStackComponent, BorderLayout.CENTER);

        stackArray = new GraphicalArrayStack(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(),arrayPanel.getHeight());
        arrayStackComponent.setValues(stackArray);
        arrayPanel.revalidate();

        arraySizeText.setText(null);
    }

    private void stackResetButtonActionPerformed(ActionEvent evt) {
        arraySizeLabel.setText( "Numar de elemente in stiva:  ");
        arraySizeButton.setEnabled(true);
        stackArray.size=0;
        arrayStackComponent.setValues(stackArray);
        arrayPushButton.setEnabled(false);
        arrayPopButton.setEnabled(false);
        arraySizeButton.setEnabled(true);
    }

    private void stackSizeTextKeyPressed(KeyEvent evt) {
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(arraySizeText.getText().equals(""))
                return;
            if(arrayStackComponent != null) {
                arrayPanel.remove(arrayStackComponent);
            }
            if(arraySizeText.getText() != " ") {
                arraySizeLabel.setText( "Numar de elemente in stiva:   " + arraySizeText.getText());

                arraySizeButton.setEnabled(false);
                arrayPushButton.setEnabled(true);
                arrayPopButton.setEnabled(true);
                arrayResetButton.setEnabled(true);

            }
            arrayStackComponent = new StackComponent();

            arrayPanel.add(arrayStackComponent, BorderLayout.CENTER);

            stackArray = new GraphicalArrayStack(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(),arrayPanel.getHeight());
            arrayStackComponent.setValues(stackArray);
            arrayPanel.revalidate();

            arraySizeText.setText(null);
        }
    }

    private void listPushButtonActionPerformed(ActionEvent evt) {
        if(listInputTextField.getText().equals("")) {
            return;
        }
        linkedListTemplate.insertElement(Integer.parseInt(listInputTextField.getText()));
         listStackComponent.setValues(linkedListTemplate,1,'n');
        listInputTextField.setText("");
    }

    private void listPopButtonActionPerformed(ActionEvent evt) {
	     if(linkedListTemplate.firstNode == null){
	        JOptionPane.showMessageDialog(null, "Stiva nu contine elemente.", "alert", JOptionPane.ERROR_MESSAGE);
	        listStackComponent.setValues(linkedListTemplate, 0, 'e');
	     }
	     else {
	         linkedListTemplate.deleteElement(linkedListTemplate.lastNode.data);
	         listStackComponent.setValues(linkedListTemplate, 0, 'n'); //n
	     }
    }

    private void sListInputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            linkedListTemplate.insertElement(Integer.parseInt(listInputTextField.getText()));
            listStackComponent.setValues(linkedListTemplate,1,'n');
            listInputTextField.setText(null);
       }
    }

    private void sinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           if(arrayInputTextField.getText().equals("")) {
                return;
            }
            int temp = stackArray.push(arrayInputTextField.getText());

            if(temp==-1) {
                arrayPushButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Stiva este plina.", "alert", JOptionPane.ERROR_MESSAGE);
            }
            arrayPopButton.setEnabled(true);
            arrayStackComponent.setValues(stackArray);
            arrayInputTextField.setText("");
       }
    }
}
