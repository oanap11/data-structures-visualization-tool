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

    StackComponent stackComp;
    GraphicalArrayStack stackArray;
    StackListComponent lcomp;
    LinkedListTemplate listA;

    private JSeparator jSeparator1, jSeparator2, jSeparator3, jSeparator4, jSeparator5, jSeparator6;

    private JButton popButton, pushButton;

    private JPanel sArrayPanel, sLinkedPanel, stackArrayNorthPanel, stackCenterPanel, stackLinkedNorthPanel1, stackArraySouthPanel, stackLinkedSouthPanel;
    private JSlider sArraySlider;
    private JButton sLPushButton;

    private JSlider sLinkedSlider1;
    private JTextField sListInputText;
    private JButton sListPopButton;
    private JTextField sinputText;

    private JTabbedPane stackPane;
    private JButton stackResetButton;
    private JButton stackSizeButton;
    private JLabel stackSizeLabel;
    private JTextField stackSizeText;

    public StackPanel() {
        initComponents();
        lcomp = new StackListComponent();
        sLinkedPanel.add(lcomp,BorderLayout.CENTER);
        listA = new LinkedListTemplate();
        lcomp.setValues(listA,0,'n');
        sLinkedPanel.revalidate();
        pushButton.setEnabled(false);
        popButton.setEnabled(false);
        stackResetButton.setEnabled(false);
    }


    private void initComponents() {

        stackCenterPanel = new JPanel();
        stackPane = new JTabbedPane();
        sArrayPanel = new JPanel();

        sArraySlider = new JSlider();

        stackArraySouthPanel = new JPanel();
        stackLinkedSouthPanel = new JPanel();

        jSeparator3 = new JSeparator();
        stackArrayNorthPanel = new JPanel();
        pushButton = new JButton();
        popButton = new JButton();
        sinputText = new JTextField();
        stackSizeButton = new JButton();
        stackSizeText = new JTextField();
        stackSizeLabel = new JLabel();
        stackResetButton = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        sLinkedPanel = new JPanel();
        stackLinkedNorthPanel1 = new JPanel();
        sLPushButton = new JButton();
        sListPopButton = new JButton();
        sListInputText = new JTextField();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();

        sLinkedSlider1 = new JSlider();



        jSeparator6 = new JSeparator();

        setLayout(new BorderLayout());

        stackCenterPanel.setLayout(new BoxLayout(stackCenterPanel, BoxLayout.LINE_AXIS));

        sArrayPanel.setBackground(new Color(254, 254, 254));
        sArrayPanel.setLayout(new BorderLayout());

        sArraySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT,
        		TitledBorder.DEFAULT_POSITION, new Font("Bitstream Charter", 0, 12), new Color(222, 29, 29)));

        pushButton.setText("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                pushButtonActionPerformed(evt);
            }
        });

        popButton.setText("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                popButtonActionPerformed(evt);
            }
        });

        sinputText.setColumns(5);
        sinputText.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sinputTextActionPerformed(evt);
            }
        });
        sinputText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sinputTextKeyPressed(evt);
            }
        });

        stackSizeButton.setText("Numar de elemente");
        stackSizeButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                stackSizeButtonActionPerformed(evt);
            }
        });

        stackSizeText.setColumns(5);
        stackSizeText.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                stackSizeTextActionPerformed(evt);
            }
        });
        stackSizeText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                stackSizeTextKeyPressed(evt);
            }
        });

        stackSizeLabel.setFont(new Font("Ubuntu", 0, 18));
        stackSizeLabel.setForeground(new Color(241, 19, 19));
        stackSizeLabel.setText("Numar de elemente in stiva:  ");

        stackResetButton.setText("Reseteaza");
        stackResetButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                stackResetButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        GroupLayout stackArrayNorthPanelLayout = new GroupLayout(stackArrayNorthPanel);
        stackArrayNorthPanel.setLayout(stackArrayNorthPanelLayout);
        stackArrayNorthPanelLayout.setHorizontalGroup(
            stackArrayNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackArrayNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sinputText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pushButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stackSizeText, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stackSizeButton)
                .addGap(29, 29, 29)
                .addComponent(stackSizeLabel)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(stackResetButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addContainerGap())
        );
        stackArrayNorthPanelLayout.setVerticalGroup(
            stackArrayNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackArrayNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stackArrayNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(stackArrayNorthPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(stackArrayNorthPanelLayout.createSequentialGroup()
                        .addGroup(stackArrayNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addGroup(stackArrayNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sinputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pushButton)
                                .addComponent(popButton)
                                .addComponent(stackSizeButton)
                                .addComponent(stackSizeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(stackSizeLabel)
                                .addComponent(stackResetButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        sArrayPanel.add(stackArrayNorthPanel, BorderLayout.NORTH);
        stackArraySouthPanel.setBackground(new Color(255, 87, 51));
        stackArraySouthPanel.setPreferredSize(new Dimension(100, 100));

        sArrayPanel.add(stackArraySouthPanel, BorderLayout.SOUTH);

        stackPane.addTab("Stiva - Tablou de elemente", sArrayPanel);

        sLinkedPanel.setBackground(new Color(254, 254, 254));
        sLinkedPanel.setLayout(new BorderLayout());

        sLPushButton.setText("Push");
        sLPushButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sLPushButtonActionPerformed(evt);
            }
        });

        sListPopButton.setText("Pop");
        sListPopButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sListPopButtonActionPerformed(evt);
            }
        });

        sListInputText.setColumns(5);
        sListInputText.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sListInputTextActionPerformed(evt);
            }
        });
        sListInputText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sListInputTextKeyPressed(evt);
            }
        });

        jSeparator4.setOrientation(SwingConstants.VERTICAL);

        jSeparator5.setOrientation(SwingConstants.VERTICAL);

        GroupLayout stackLinkedNorthPanel1Layout = new GroupLayout(stackLinkedNorthPanel1);
        stackLinkedNorthPanel1.setLayout(stackLinkedNorthPanel1Layout);
        stackLinkedNorthPanel1Layout.setHorizontalGroup(
            stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackLinkedNorthPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sListInputText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sLPushButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sListPopButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236)
                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        stackLinkedNorthPanel1Layout.setVerticalGroup(
            stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(stackLinkedNorthPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGroup(stackLinkedNorthPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sListInputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sLPushButton)
                        .addComponent(sListPopButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sLinkedPanel.add(stackLinkedNorthPanel1, BorderLayout.NORTH);
        sLinkedPanel.add(stackLinkedSouthPanel, BorderLayout.SOUTH);

        stackLinkedSouthPanel.setBackground(new Color(255, 87, 51));
        stackLinkedSouthPanel.setPreferredSize(new Dimension(100, 100));

        sLinkedSlider1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N


        stackPane.addTab("Stiva - lista inlantuita", sLinkedPanel);

        stackCenterPanel.add(stackPane);

        add(stackCenterPanel, BorderLayout.CENTER);
    }

    private void sArraySkipButtonActionPerformed(ActionEvent evt) {}

    private void pushButtonActionPerformed(ActionEvent evt) {
        if(sinputText.getText().equals("")){
            //System.out.println("ok");
            return;
        }
        int temp = stackArray.push(sinputText.getText());

        if(temp==-1) {
            pushButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Stiva este plina.", "alert", JOptionPane.ERROR_MESSAGE);
        }
        popButton.setEnabled(true);
        stackComp.setValues(stackArray);
        sinputText.setText("");

    }

    private void popButtonActionPerformed(ActionEvent evt) {
        String temp = stackArray.pop();
        if(temp == null){
            popButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Stiva nu contine elemente", "alert", JOptionPane.ERROR_MESSAGE);
        }
        pushButton.setEnabled(true);
        stackComp.setValues(stackArray);
        sinputText.setText("");
    }

    private void stackSizeButtonActionPerformed(ActionEvent evt) {
        if(stackSizeText.getText().equals(""))
                return;
        if(stackComp != null) {
            sArrayPanel.remove(stackComp);
        }
        if(stackSizeText.getText() != " ") {
            stackSizeLabel.setText( "Numar de elemente in stiva:   "+ stackSizeText.getText());

            stackSizeButton.setEnabled(false);
            pushButton.setEnabled(true);
            popButton.setEnabled(true);
            stackResetButton.setEnabled(true);

        }
        stackComp = new StackComponent();

        sArrayPanel.add(stackComp, BorderLayout.CENTER);

        stackArray = new GraphicalArrayStack(Integer.parseInt(stackSizeText.getText()), sArrayPanel.getWidth(),sArrayPanel.getHeight());
        stackComp.setValues(stackArray);
        sArrayPanel.revalidate();

        stackSizeText.setText(null);
    }

    private void stackResetButtonActionPerformed(ActionEvent evt) {
        stackSizeLabel.setText( "Numar de elemente in stiva:  ");
        stackSizeButton.setEnabled(true);
        stackArray.size=0;
        stackComp.setValues(stackArray);
        pushButton.setEnabled(false);
        popButton.setEnabled(false);
        stackSizeButton.setEnabled(true);
    }

    private void stackSizeTextKeyPressed(KeyEvent evt) {
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(stackSizeText.getText().equals(""))
                return;
            if(stackComp != null) {
                sArrayPanel.remove(stackComp);
            }
            if(stackSizeText.getText() != " ") {
                stackSizeLabel.setText( "Numar de elemente in stiva:   " + stackSizeText.getText());

                stackSizeButton.setEnabled(false);
                pushButton.setEnabled(true);
                popButton.setEnabled(true);
                stackResetButton.setEnabled(true);

            }
            stackComp = new StackComponent();

            sArrayPanel.add(stackComp, BorderLayout.CENTER);

            stackArray = new GraphicalArrayStack(Integer.parseInt(stackSizeText.getText()), sArrayPanel.getWidth(),sArrayPanel.getHeight());
            stackComp.setValues(stackArray);
            sArrayPanel.revalidate();

            stackSizeText.setText(null);
        }
    }

    private void stackSizeTextActionPerformed(ActionEvent evt) {}

    private void sLPushButtonActionPerformed(ActionEvent evt) {
        if(sListInputText.getText().equals("")) {
            return;
        }
        listA.insertElement(Integer.parseInt(sListInputText.getText()));
         lcomp.setValues(listA,1,'n');
        sListInputText.setText("");
    }

    private void sListPopButtonActionPerformed(ActionEvent evt) {
	     if(listA.firstNode == null){
	        JOptionPane.showMessageDialog(null, "Stiva nu contine elemente.", "alert", JOptionPane.ERROR_MESSAGE);
	        lcomp.setValues(listA, 0, 'e');
	     }
	     else {
	         listA.deleteElement(listA.lastNode.data);
	         lcomp.setValues(listA, 0, 'n'); //n
	     }
    }

    private void sListInputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listA.insertElement(Integer.parseInt(sListInputText.getText()));
            lcomp.setValues(listA,1,'n');
            sListInputText.setText(null);
       }
    }

    private void sinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           if(sinputText.getText().equals("")) {
                return;
            }
            int temp = stackArray.push(sinputText.getText());

            if(temp==-1) {
                pushButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Stiva este plina.", "alert", JOptionPane.ERROR_MESSAGE);
            }
            popButton.setEnabled(true);
            stackComp.setValues(stackArray);
            sinputText.setText("");
       }
    }

    private void sinputTextActionPerformed(ActionEvent evt) {}

    private void sListInputTextActionPerformed(ActionEvent evt) {}


}
