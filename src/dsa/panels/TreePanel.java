package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import dsa.trees.GraphicalTree;
import dsa.trees.TreeComponent;

public class TreePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton bstDelButton;
    private JTextField bstDelText;
    private JButton bstInsertButton;
    private JTextField bstInsertText;
    private JPanel bstNorthPanel;
    private JPanel bstPanel;
    private JSlider bstSlider;
    private JPanel bstSouthPanel;
    private JPanel treeCenterPanel;
    private JTabbedPane treePane;

    TreeComponent treeComponent;
    GraphicalTree graphicalTree;

    public TreePanel() {
        initComponents();
        treeComponent = new TreeComponent();
        bstPanel.add(treeComponent, BorderLayout.CENTER);
        graphicalTree = new GraphicalTree();
    }

    private void initComponents() {
    	treePane = new JTabbedPane();
        treeCenterPanel = new JPanel();
        treePane = new JTabbedPane();
        bstPanel = new JPanel();
        bstNorthPanel = new JPanel();
        bstInsertButton = new JButton();
        bstDelButton = new JButton();
        bstInsertText = new JTextField();
        bstDelText = new JTextField();
        bstSouthPanel = new JPanel();
        bstSlider = new JSlider();

        setLayout(new BorderLayout());

        treeCenterPanel.setLayout(new BoxLayout(treeCenterPanel, BoxLayout.LINE_AXIS));

        bstPanel.setBackground(new Color(254, 254, 254));
        bstPanel.setLayout(new BorderLayout());

        bstInsertButton.setText("Insereaza element");
        bstInsertButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                bstInsertButtonActionPerformed(evt);
            }
        });

        bstDelButton.setText("Sterge element");
        bstDelButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                bstDelButtonActionPerformed(evt);
            }
        });

        bstInsertText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                bstInsertTextKeyPressed(evt);
            }
        });

        GroupLayout bstNorthPanelLayout = new GroupLayout(bstNorthPanel);
        bstNorthPanel.setLayout(bstNorthPanelLayout);

        bstNorthPanelLayout.setHorizontalGroup(
            bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bstNorthPanelLayout.createSequentialGroup()
            	.addContainerGap()
                .addComponent(bstInsertText, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bstInsertButton)
                .addGap(24, 24, 24)
                .addComponent(bstDelText, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bstDelButton)
                .addGap(30, 30, 30)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addContainerGap(172, Short.MAX_VALUE))

        );

        bstNorthPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {bstDelText, bstInsertText});

        bstNorthPanelLayout.setVerticalGroup(
            bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bstNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bstNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bstInsertButton)
                    .addComponent(bstDelButton)
                    .addComponent(bstInsertText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bstDelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bstPanel.add(bstNorthPanel, BorderLayout.NORTH);

        bstSlider.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        bstSouthPanel.setBackground(new Color(255, 87, 51));
        bstSouthPanel.setPreferredSize(new Dimension(100, 100));
        bstPanel.add(bstSouthPanel, BorderLayout.SOUTH);



        treePane.addTab("Arbore binar de cautare", bstPanel);

        treeCenterPanel.add(treePane);

        add(treeCenterPanel, BorderLayout.CENTER);
    }

    private void bstDelButtonActionPerformed(ActionEvent evt) {
        bstInsertButton.setEnabled(false);
        bstDelButton.setEnabled(false);

        treeComponent.setValues(graphicalTree,'d', bstDelText.getText());
        bstDelText.setText("");

        bstInsertButton.setEnabled(true);
        bstDelButton.setEnabled(true);
    }

    private void bstInsertButtonActionPerformed(ActionEvent evt) {
        bstInsertButton.setEnabled(false);
        bstDelButton.setEnabled(false);

        treeComponent.setValues(graphicalTree,'i', bstInsertText.getText());
        bstInsertText.setText("");

        bstInsertButton.setEnabled(true);
        bstDelButton.setEnabled(true);
    }

    private void bstInsertTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	        bstInsertButton.setEnabled(false);
	        bstDelButton.setEnabled(false);

	        treeComponent.setValues(graphicalTree,'i', bstInsertText.getText());
	        bstInsertText.setText("");

	        bstInsertButton.setEnabled(true);
	        bstDelButton.setEnabled(true);

       }
    }


}
