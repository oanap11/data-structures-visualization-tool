package dsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dsa.algos.PathFindingPanel;
import dsa.panels.ListPanel;
import dsa.panels.QueuePanel;
import dsa.panels.StackPanel;
import dsa.panels.TreePanel;

public class Main extends JFrame {

    static ListPanel listPanel;
    static PathFindingPanel algoPanel;
    static StackPanel stackPanel;
    static QueuePanel queuePanel;
    static TreePanel treePanel;
    static JPanel mainPanel;
    static JPanel welcomePanel;
    static JPanel avlPanel;

    private JMenuItem arrayMenu;
    private JMenu meniuPrincipal;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JSlider jSlider1;
    private JMenuItem linkedListMenu;
    private JMenuItem queueMenu;
    private JMenuItem stackMenu;
    private JMenuItem treeMenu;
    private JMenuItem algoMenu;

    ImageIcon stackIcon;

    public Main() {
    	logIn();

        initComponents();
        welcomePanel = new JPanel();
        mainPanel =  new JPanel();
        listPanel = new ListPanel();
        stackPanel = new StackPanel();
        queuePanel = new QueuePanel();
        treePanel = new TreePanel();
        algoPanel = new PathFindingPanel();

        JLabel picLabel = new JLabel();
        picLabel.setIcon(new ImageIcon(getClass().getResource("/images/idk.png")));
        welcomePanel.add(picLabel);

        mainPanel.setSize(800, 800);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

	    welcomePanel.setBackground(Color.white);
	    mainPanel.add(welcomePanel);

        mainPanel.add(listPanel);
        mainPanel.add(stackPanel);
        mainPanel.add(treePanel);
        mainPanel.add(queuePanel);
        mainPanel.add(algoPanel);

        add(mainPanel, BorderLayout.CENTER);
        hidePanels();
        this.pack();
    }

    private void logIn() {
		//login.setVisible(true);
	}

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jSlider1 = new JSlider();
        jMenuBar1 = new JMenuBar();
        meniuPrincipal = new JMenu();

        linkedListMenu = new JMenuItem();
        treeMenu = new JMenuItem();
        stackMenu = new JMenuItem();
        queueMenu = new JMenuItem();
        arrayMenu = new JMenuItem();
        algoMenu = new JMenuItem();
        jMenu2 = new JMenu();

        stackIcon = new ImageIcon("/images/back.png");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aplicatie pentru vizualizarea structurilor de date");
        setSize(new Dimension(800, 800));
        setLocationRelativeTo(null);
        setResizable(false);

        meniuPrincipal.setText("Structuri de date \n" + "▼\n" + "");

        linkedListMenu.setText("Liste Inlantuite");
        linkedListMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                linkedListMenuActionPerformed(evt);
            }
        });
        meniuPrincipal.add(linkedListMenu);

        treeMenu.setText("Arbori");
        treeMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                treeMenuActionPerformed(evt);
            }
        });
        meniuPrincipal.add(treeMenu);

        stackMenu.setText("Stiva");
        stackMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                stackMenuActionPerformed(evt);
            }
        });
        meniuPrincipal.add(stackMenu);

        queueMenu.setText("Coada");
        queueMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                queueMenuActionPerformed(evt);
            }
        });
        meniuPrincipal.add(queueMenu);

        algoMenu.setText("Algoritmi de cautare");
        algoMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                algoMenuActionPerformed(evt);
            }
        });
        meniuPrincipal.add(algoMenu);

        jMenuBar1.setPreferredSize(new Dimension(100, 100));
        jMenuBar1.add(meniuPrincipal);
        jMenuBar1.setLayout(new GridBagLayout());
        setJMenuBar(jMenuBar1);

        pack();
    }


    void setPanelSize() {
    	int w = 800;
    	int h = 800;
        mainPanel.setSize(w, h);

        listPanel.setSize(w,h);
        stackPanel.setSize(w,h);
        queuePanel.setSize(w,h);
        treePanel.setSize(w,h);

        System.out.println("Width = " + w + "\nHeight = " + h);
    }

    void hidePanels() {
        listPanel.setVisible(false);
        stackPanel.setVisible(false);
        queuePanel.setVisible(false);
        treePanel.setVisible(false);
        algoPanel.setVisible(false);
    }

    private void linkedListMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        listPanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void treeMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        treePanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void avlMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        avlPanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void stackMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        stackPanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void queueMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        queuePanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void algoMenuActionPerformed(ActionEvent evt) {
        hidePanels();
        algoPanel.setVisible(true);
        welcomePanel.setVisible(false);
    }

    private void arrayMenuActionPerformed(ActionEvent evt) {
        hidePanels();
    }

    private void formWindowStateChanged(WindowEvent evt) {
        this.revalidate();
        this.repaint();
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
    	UIManager.put("MenuBar.background", new Color(255, 87, 51));
        UIManager.put("MenuItem.background", new Color(255, 87, 51));

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				//new LoginForm().setVisible(true);
				new Main().setVisible(true);
			}
		});
    }

}
