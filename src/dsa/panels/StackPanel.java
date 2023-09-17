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

    private JPanel arrayPanel, listPanel; 
    private JPanel stackCenterPanel, arrayNorthPanel, arraySouthPanel, listSouthPanel, listNorthPanel;
    
    private JButton listPushButton, listPopButton;
    private JSlider listSlider;
    private JTextField listInputTextField;
    
    private JButton arrayPopButton, arrayPushButton, arrayResetButton, arraySizeButton;
    private JLabel arraySizeLabel;
    private JTextField arraySizeText;
    private JSlider arraySlider;
    private JTextField arrayInputTextField;

    public StackPanel() {
        initComponents();
        listStackComponent = new StackListComponent();
        listPanel.add(listStackComponent,BorderLayout.CENTER);
        linkedListTemplate = new LinkedListTemplate();
        listStackComponent.setValues(linkedListTemplate,0,'n');
        listPanel.revalidate();
        arrayPushButton.setEnabled(false);
        arrayPopButton.setEnabled(false);
        arrayResetButton.setEnabled(false);
    }
    
    void initArrayStackComponents() {
        arrayPanel = new JPanel();
        arraySlider = new JSlider();
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
        listSlider = new JSlider();
    }

    private void initComponents() {
    	tabbedPane = new JTabbedPane();
        stackCenterPanel = new JPanel();
        
    	initArrayStackComponents();
    	initListStackComponents();

        setLayout(new BorderLayout());

        stackCenterPanel.setLayout(new BoxLayout(stackCenterPanel, BoxLayout.LINE_AXIS));

        arrayPanel.setBackground(new Color(254, 254, 254));
        arrayPanel.setLayout(new BorderLayout());

        arraySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT,
        		TitledBorder.DEFAULT_POSITION, new Font("Bitstream Charter", 0, 12), new Color(222, 29, 29)));

        arrayPushButton.setText("Push");
        arrayPushButton.addActionListener(evt -> pushButtonActionPerformed(evt));

        arrayPopButton.setText("Pop");
        arrayPopButton.addActionListener(evt -> popButtonActionPerformed(evt));

        arrayInputTextField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sinputTextKeyPressed(evt);
            }
        });

        arraySizeButton.setText("Numar de elemente");
        arraySizeButton.addActionListener(evt -> stackSizeButtonActionPerformed(evt));

        arraySizeText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                stackSizeTextKeyPressed(evt);
            }
        });

        arraySizeLabel.setFont(new Font("Ubuntu", 0, 18));
        arraySizeLabel.setForeground(new Color(241, 19, 19));
        arraySizeLabel.setText("Numar de elemente in stiva:  ");

        arrayResetButton.setText("Reseteaza");
        arrayResetButton.addActionListener(evt -> stackResetButtonActionPerformed(evt));

        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);
        
        GroupLayout arrayStackLayout = GroupLayoutUtil.createCustomLayoutForArrayNorthPanel(
        	    arrayNorthPanel,
        	    arrayInputTextField,
        	    arrayPushButton,
        	    arrayPopButton,
        	    jSeparator1,
        	    arraySizeText,
        	    arraySizeButton,
        	    arraySizeLabel,
        	    jSeparator2,
        	    arrayResetButton
        	);

        arrayNorthPanel.setLayout(arrayStackLayout);
       
        arrayPanel.add(arrayNorthPanel, BorderLayout.NORTH);
        arraySouthPanel.setBackground(new Color(255, 87, 51));
        arraySouthPanel.setPreferredSize(new Dimension(100, 100));

        arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Stiva - Tablou de elemente", arrayPanel);

        listPanel.setBackground(new Color(254, 254, 254));
        listPanel.setLayout(new BorderLayout());

        listPushButton.setText("Push");
        listPushButton.addActionListener(evt -> listPushButtonActionPerformed(evt));

        listPopButton.setText("Pop");
        listPopButton.addActionListener(evt -> listPopButtonActionPerformed(evt));

        listInputTextField.setColumns(5);
        listInputTextField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sListInputTextKeyPressed(evt);
            }
        });

        GroupLayout stackLinkedNorthPanel1Layout = new GroupLayout(listNorthPanel);
        listNorthPanel.setLayout(stackLinkedNorthPanel1Layout);
        stackLinkedNorthPanel1Layout.setHorizontalGroup(
            stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackLinkedNorthPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listPushButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listPopButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        stackLinkedNorthPanel1Layout.setVerticalGroup(
            stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackLinkedNorthPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(listPushButton)
                        .addComponent(listPopButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listPanel.add(listNorthPanel, BorderLayout.NORTH);
        listPanel.add(listSouthPanel, BorderLayout.SOUTH);

        listSouthPanel.setBackground(new Color(255, 87, 51));
        listSouthPanel.setPreferredSize(new Dimension(100, 100));

        listSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        tabbedPane.addTab("Stiva - lista inlantuita", listPanel);
        stackCenterPanel.add(tabbedPane);
        add(stackCenterPanel, BorderLayout.CENTER);
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
