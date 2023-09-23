package dsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dsa.algos.PathFindingPanel;
import dsa.panels.ListPanel;
import dsa.panels.QueuePanel;
import dsa.panels.StackPanel;
import dsa.panels.TreePanel;
import login.LoginForm;

public class Main extends JFrame {
	
	private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 800;
    private static final String IMAGE_PATH = "/images/welcomeDS.png";
    private static final Color MENU_BAR_BACKGROUND_COLOR = new Color(255, 87, 51);

    static JPanel mainPanel;
    static JPanel welcomePanel;
    static ListPanel listPanel;
    static PathFindingPanel algoPanel;
    static StackPanel stackPanel;
    static QueuePanel queuePanel;
    static TreePanel treePanel;
    
    private JMenu meniuPrincipal;
    private JMenuBar menuBar;

    public Main() {

        initComponents();  
        initializePanels();   
        setWelcomePicture();
        setMainPanel();
	    addAllPanelsToMain();
        hidePanels();
        this.pack();
    }
    
    private void initComponents() {

    	menuBar = new JMenuBar();
        meniuPrincipal = new JMenu();

        initUI();

        meniuPrincipal.setText("Structuri de date \n" + "▼\n" + "");
        
        addDataStructureMenuItem("Liste Inlantuite", this::linkedListMenuActionPerformed);
        addDataStructureMenuItem("Arbori", this::treeMenuActionPerformed);
        addDataStructureMenuItem("Stiva", this::stackMenuActionPerformed);
        addDataStructureMenuItem("Coada", this::queueMenuActionPerformed);
        addDataStructureMenuItem("Algoritmi de cautare", this::algoMenuActionPerformed);
        
        configureMenuBar();
        pack();
    }
    
    void initUI() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicatie pentru vizualizarea structurilor de date");
        setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void initializePanels() {
    	welcomePanel = new JPanel();
        mainPanel =  new JPanel();
        listPanel = new ListPanel();
        stackPanel = new StackPanel();
        queuePanel = new QueuePanel();
        treePanel = new TreePanel();
        algoPanel = new PathFindingPanel();
    }
    
    private void setWelcomePicture() {
    	JLabel welcomePicture = new JLabel();
    	welcomePicture.setIcon(new ImageIcon(getClass().getResource(IMAGE_PATH)));
        welcomePanel.add(welcomePicture);
    }
    
    private void setMainPanel() {
    	mainPanel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    }
    
    private void addAllPanelsToMain() {
    	mainPanel.add(welcomePanel);
        mainPanel.add(listPanel);
        mainPanel.add(stackPanel);
        mainPanel.add(treePanel);
        mainPanel.add(queuePanel);
        mainPanel.add(algoPanel);
        add(mainPanel, BorderLayout.CENTER);
    }
    
    void hidePanels() {
        listPanel.setVisible(false);
        stackPanel.setVisible(false);
        queuePanel.setVisible(false);
        treePanel.setVisible(false);
        algoPanel.setVisible(false);
    }

    void configureMenuBar() {
    	menuBar.setPreferredSize(new Dimension(100, 100));
        menuBar.add(meniuPrincipal);
        menuBar.setLayout(new GridBagLayout());
        setJMenuBar(menuBar);
    }
    
    private void addDataStructureMenuItem(String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        meniuPrincipal.add(menuItem);
    }
    
    
    private void switchToPanel(JPanel panel) {
        hidePanels();
        panel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void menuItemActionPerformed(ActionEvent evt, JPanel panel) {
        switchToPanel(panel);
    }

    private void linkedListMenuActionPerformed(ActionEvent evt) {
        menuItemActionPerformed(evt, listPanel);
    }

    private void treeMenuActionPerformed(ActionEvent evt) {
        menuItemActionPerformed(evt, treePanel);
    }

    private void stackMenuActionPerformed(ActionEvent evt) {
        menuItemActionPerformed(evt, stackPanel);
    }

    private void queueMenuActionPerformed(ActionEvent evt) {
        menuItemActionPerformed(evt, queuePanel);
    }

    private void algoMenuActionPerformed(ActionEvent evt) {
        menuItemActionPerformed(evt, algoPanel);
    }

    public static void main(String args[]) {

    	try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
    	catch (Exception e) {}

    	Font f = new Font("dialog", Font.BOLD, 50);
    	UIManager.put("MenuItem.foreground", Color.WHITE);
    	UIManager.put("Menu.foreground", Color.WHITE);
    	UIManager.put("Menu.font", f);
    	UIManager.put("MenuItem.font", f);
    	UIManager.put("MenuBar.background", MENU_BAR_BACKGROUND_COLOR);
        UIManager.put("MenuItem.background", MENU_BAR_BACKGROUND_COLOR);
		
		SwingUtilities.invokeLater(() -> {
            //new Main().setVisible(true);
			new LoginForm().setVisible(true);
        });
    }
}
