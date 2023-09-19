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

        setLayout(new BorderLayout());

        treeCenterPanel.setLayout(new BoxLayout(treeCenterPanel, BoxLayout.LINE_AXIS));

        bstPanel.setBackground(new Color(254, 254, 254));
        bstPanel.setLayout(new BorderLayout());

        bstInsertButton.setText("Insereaza element");
        bstInsertButton.addActionListener(evt -> bstInsertButtonActionPerformed(evt));

        bstDelButton.setText("Sterge element");
        bstDelButton.addActionListener(evt -> bstDelButtonActionPerformed(evt));

        bstInsertText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                bstInsertTextKeyPressed(evt);
            }
        });

        GroupLayout bstNorthPanelLayout = 
        		GroupLayoutUtil.createCustomLayoutForBSTNorthPanel(bstNorthPanel, bstInsertText, bstInsertButton, bstDelText, bstDelButton);
        bstNorthPanel.setLayout(bstNorthPanelLayout);

        bstPanel.add(bstNorthPanel, BorderLayout.NORTH);

        bstSouthPanel.setBackground(new Color(255, 87, 51));
        bstSouthPanel.setPreferredSize(new Dimension(100, 100));
        bstPanel.add(bstSouthPanel, BorderLayout.SOUTH);

        treePane.addTab("Arbore binar de cautare", bstPanel);

        treeCenterPanel.add(treePane);

        add(treeCenterPanel, BorderLayout.CENTER);
    }
    
    private void enableButtons() {
        bstInsertButton.setEnabled(true);
        bstDelButton.setEnabled(true);
    }

    private void disableButtons() {
        bstInsertButton.setEnabled(false);
        bstDelButton.setEnabled(false);
    }

    private void bstDelButtonActionPerformed(ActionEvent evt) {
    	disableButtons();

        treeComponent.setValues(graphicalTree,'d', bstDelText.getText());
        bstDelText.setText("");

        enableButtons();
    }

    private void bstInsertButtonActionPerformed(ActionEvent evt) {
    	disableButtons();

        treeComponent.setValues(graphicalTree,'i', bstInsertText.getText());
        bstInsertText.setText("");

        enableButtons();
    }

    private void bstInsertTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    	   disableButtons();

	        treeComponent.setValues(graphicalTree,'i', bstInsertText.getText());
	        bstInsertText.setText("");

	        enableButtons();

       }
    }
}
