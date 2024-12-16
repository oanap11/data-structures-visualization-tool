package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dsa.LinkedListTemplate;
import dsa.common.GroupLayoutUtil;

public class BasePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    LinkedListTemplate linkedListTemplate;

    // Panels
    protected JTabbedPane tabbedPane;
    protected JPanel mainPanel;
    protected JPanel arrayPanel, arrayNorthPanel, arraySouthPanel;
    protected JPanel listPanel, listNorthPanel, listSouthPanel;

    // Buttons 
    protected JButton arrayAddButton, arrayRemoveButton, arrayResetButton, arraySizeButton;
    protected JButton listAddButton, listRemoveButton;

    // Text Fields
    protected JTextField arrayInputTextField;
    protected JTextField listInputTextField;
    protected JTextField arraySizeText;

    // Labels
    protected JLabel arraySizeLabel;

    public BasePanel() {
        initializePanels();
    }

    private void initializePanels() {
    	mainPanel = new JPanel();
        arrayPanel = createPanel(new BorderLayout(), Color.WHITE);
        arrayNorthPanel = new JPanel();
        arraySouthPanel = new JPanel();
        listPanel = createPanel(new BorderLayout(), Color.WHITE);
        listNorthPanel = new JPanel();
        listSouthPanel = new JPanel();
        tabbedPane = new JTabbedPane();
    }

    private JPanel createPanel(LayoutManager layout, Color bgColor) {
        JPanel panel = new JPanel(layout);
        if (bgColor != null) {
            panel.setBackground(bgColor);
        }
        return panel;
    }

    void initArrayComponents() {
        arrayAddButton = new JButton();
        arrayRemoveButton = new JButton();
        arrayResetButton = new JButton();
        arrayInputTextField = new JTextField();
        arraySizeButton = new JButton();
        arraySizeText = new JTextField();
        arraySizeLabel = createLabel("Numar de elemente:  ", new Font("Ubuntu", Font.PLAIN, 18), new Color(241, 19, 19));
    }

    void initListComponents() {
        listAddButton = new JButton();
        listRemoveButton = new JButton();
        listInputTextField = new JTextField();
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    protected void configureArrayNorthPanel() {
        arrayNorthPanel.setLayout(GroupLayoutUtil.createCustomLayoutForArrayNorthPanel(
            arrayNorthPanel, arrayInputTextField, arrayAddButton,
            arrayRemoveButton, arraySizeText, arraySizeButton, arraySizeLabel, arrayResetButton
        ));
    }

    void configureListNorthPanel() {
        listNorthPanel.setLayout(GroupLayoutUtil.createCustomLayoutForListNorthPanel(
            listNorthPanel, listInputTextField, listAddButton, listRemoveButton
        ));
    }

    protected void configureArrayView() {
        configurePanel(arrayPanel, arrayNorthPanel, arraySouthPanel);
    }

    void setupListPanelLayout() {
        configurePanel(listPanel, listNorthPanel, listSouthPanel);
    }

    private void configurePanel(JPanel parentPanel, JPanel northPanel, JPanel southPanel) {
        parentPanel.add(northPanel, BorderLayout.NORTH);
        southPanel.setBackground(new Color(255, 87, 51));
        southPanel.setPreferredSize(new Dimension(100, 100));
        parentPanel.add(southPanel, BorderLayout.SOUTH);
    }

    void enableArrayButtons() {
        setArrayButtonsEnabled(true);
    }

    void disableArrayButtons() {
        setArrayButtonsEnabled(false);
    }

    private void setArrayButtonsEnabled(boolean enabled) {
        arrayAddButton.setEnabled(enabled);
        arrayRemoveButton.setEnabled(enabled);
        arrayResetButton.setEnabled(enabled);
        arrayInputTextField.setEnabled(enabled);
    }

    protected void configureButton(JButton button, String text, ActionListener listener) {
        button.setBackground(Color.WHITE);
        button.setText(text);
        button.setFocusable(false);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(listener);
    }
}