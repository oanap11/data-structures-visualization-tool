package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dsa.SinglyLinkedList;
import dsa.linked.list.ListComponent;
import dsa.linked.list.SinglyCircular;


public class ListPanel extends JPanel {

    ListComponent singlyLinked;
    SinglyCircular singlyCircular;
    SinglyLinkedList listSimple, listCircular;

    private JButton singlyaddButton, singlyCircularAddButton, deleteButtonList, deleteButtonCircular;
    private JTabbedPane lsitPane;
    private JTextField singlyAddNodeField, circularAddNodeField;
    private JTextField singlyListDelField, circularListDelField;

    private JPanel singlyListPanel, singlyListSouthPanel, singlyListNorthPanel;
    private JPanel singlyCircularPanel, singlyCircularNorthPanel, singlyCircularSouthPanel;

    private JSlider singlySlider;
    private JSlider singlySlider1;

    public ListPanel() {
	        initComponents();

	        singlyCircular = new SinglyCircular();
	        singlyLinked = new ListComponent();

	        singlyListPanel.add(singlyLinked,BorderLayout.CENTER);
	        singlyCircularPanel.add(singlyCircular,BorderLayout.CENTER);

	        listSimple = new SinglyLinkedList();
	        listCircular = new SinglyLinkedList();

	        singlyLinked.setValues(listSimple, 0);
	        singlyCircular.setValues(listCircular, 0);

	        singlyListPanel.revalidate();
	        singlyCircularPanel.revalidate();

    }

        private void initComponents() {

        lsitPane = new JTabbedPane();
        singlyListPanel =  new JPanel() {
            @Override
			public void paint(Graphics g)
            {
                super.paint(g);

            }

        };
        singlyListNorthPanel = new JPanel();
        singlyListSouthPanel = new JPanel();
        singlyAddNodeField = new JTextField();
        singlyaddButton = new JButton();
        singlyListDelField = new JTextField();
        deleteButtonList = new JButton();

        singlySlider = new JSlider();

        singlyCircularPanel = new JPanel();
        singlyCircularNorthPanel = new JPanel();
        singlyCircularSouthPanel = new JPanel();
        circularAddNodeField = new JTextField();
        singlyCircularAddButton = new JButton();
        circularListDelField = new JTextField();
        deleteButtonCircular = new JButton();

        singlySlider1 = new JSlider();

        setLayout(new BorderLayout());

        singlyListPanel.setBackground(Color.white);
        singlyListPanel.setLayout(new BorderLayout());

        singlyAddNodeField.setColumns(5);
        singlyAddNodeField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                singlyaddNodeTextKeyPressed(evt);
            }
        });

        singlyaddButton.setText("Insereaza");
        singlyaddButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                singlyaddButtonActionPerformed(evt);
            }
        });

        singlyListDelField.setColumns(5);
        singlyListDelField.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                singlyListDelFieldActionPerformed(evt);
            }
        });
        singlyListDelField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                singlyListDelFieldKeyPressed(evt);
            }
        });

        deleteButtonList.setBackground(Color.white);
        deleteButtonList.setText("Sterge");
        deleteButtonList.setFocusable(false);
        deleteButtonList.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButtonList.setVerticalTextPosition(SwingConstants.BOTTOM);
        deleteButtonList.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        GroupLayout singlyListNorthPanelLayout = new GroupLayout(singlyListNorthPanel);
        singlyListNorthPanel.setLayout(singlyListNorthPanelLayout);
        singlyListNorthPanelLayout.setHorizontalGroup(
            singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyListNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addComponent(singlyAddNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singlyaddButton, 0, GroupLayout.DEFAULT_SIZE, 150)
                .addGap(35, 35, 35)
                .addComponent(singlyListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButtonList)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        singlyListNorthPanelLayout.setVerticalGroup(
            singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyListNorthPanelLayout.createSequentialGroup()
                .addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(singlyListNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(singlyaddButton)
                        .addComponent(singlyAddNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(singlyListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteButtonList))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        singlyListPanel.add(singlyListNorthPanel, BorderLayout.NORTH);
        singlyListSouthPanel.setBackground(new Color(255, 87, 51));
        singlyListSouthPanel.setPreferredSize(new Dimension(100, 100));
        singlyListPanel.add(singlyListSouthPanel, BorderLayout.SOUTH);

        singlySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        lsitPane.addTab("Lista simplu inlantuita", singlyListPanel);

        singlyCircularPanel.setBackground(new Color(254, 254, 254));
        singlyCircularPanel.setLayout(new BorderLayout());

        circularAddNodeField.setColumns(5);
        circularAddNodeField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                circularAddNodeFieldKeyPressed(evt);
            }
        });

        singlyCircularAddButton.setText("Adauga element");
        singlyCircularAddButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                singlyaddButton1ActionPerformed(evt);
            }
        });

        circularListDelField.setColumns(5);
        circularListDelField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                circularListDelFieldKeyPressed(evt);
            }
        });

        deleteButtonCircular.setBackground(Color.white);
        deleteButtonCircular.setText("Sterge element");
        deleteButtonCircular.setFocusable(false);
        deleteButtonCircular.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButtonCircular.setVerticalTextPosition(SwingConstants.BOTTOM);
        deleteButtonCircular.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        GroupLayout singlyCircularNorthPanelLayout = new GroupLayout(singlyCircularNorthPanel);
        singlyCircularNorthPanel.setLayout(singlyCircularNorthPanelLayout);
        singlyCircularNorthPanelLayout.setHorizontalGroup(
            singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singlyCircularNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singlyCircularAddButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addGap(41, 41, 41)
                .addComponent(circularListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButtonCircular, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        singlyCircularNorthPanelLayout.setVerticalGroup(
            singlyCircularNorthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, singlyCircularNorthPanelLayout.createSequentialGroup()
                .addGroup(singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(singlyCircularNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(singlyCircularAddButton)
                        .addComponent(circularAddNodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(circularListDelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteButtonCircular))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        singlyCircularPanel.add(singlyCircularNorthPanel, BorderLayout.NORTH);
        singlyCircularSouthPanel.setBackground(new Color(255, 87, 51));
        singlyCircularSouthPanel.setPreferredSize(new Dimension(100, 100));
        singlyCircularPanel.add(singlyCircularSouthPanel, BorderLayout.SOUTH);


        singlySlider1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Animation Speed", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        lsitPane.addTab("Lista circulara simplu inlantuita", singlyCircularPanel);
        add(lsitPane, BorderLayout.CENTER);
    }


    //eveniment la apasarea butonului de inserare pentru a adauga elemente lista simplu inlantuita
    private void singlyaddButtonActionPerformed(ActionEvent evt) {
    	listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
    	singlyLinked.setValues(listSimple, 1);
    	singlyAddNodeField.setText("");
    }

    //eveniment la apasarea butonului de inserare pentru a adauga elemente lista circulara simplu inlantuita
    private void singlyaddButton1ActionPerformed(ActionEvent evt) {
        listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
        singlyCircular.setValues(listCircular, 1);
        circularAddNodeField.setText("");
    }

    //eveniment la apasarea butonului de stergere pentru a scoate elemente din lista simplu inlantuita
    private void deleteButtonActionPerformed(ActionEvent evt) {
        if(listSimple.deleteElement(Integer.parseInt(singlyListDelField.getText())) == null){
        	JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            singlyListDelField.setText("");
        }
        singlyLinked.setValues(listSimple, 0);
    }

  //eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista simplu inlantuita
    private void singlyaddNodeTextKeyPressed(KeyEvent evt) {
    	if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    		listSimple.insertElement(Integer.parseInt(singlyAddNodeField.getText()));
    		singlyLinked.setValues(listSimple, 1);
    		singlyAddNodeField.setText("");
    	}
    }

    //eveniment la apasarea butonului de stergere elemente in lista circulara simplu inlantuita
    private void jButton37ActionPerformed(ActionEvent evt) {
         if(listCircular.deleteElement(Integer.parseInt(circularListDelField.getText())) == null){
        	 JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            circularListDelField.setText("");
        }
        singlyCircular.setValues(listCircular, 0);
    }

	//eveniment la apasarea tastei Enter pentru adaugarea de elemente in lista circulara simplu inlantuita
    private void circularAddNodeFieldKeyPressed(KeyEvent evt) {
    	if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            listCircular.insertElement(Integer.parseInt(circularAddNodeField.getText()));
            singlyCircular.setValues(listCircular, 1);
            circularAddNodeField.setText("");
       }
    }

  //eveniment la apasarea tastei Enter pentru stergerea de elemente in lista circulara simplu inlantuita
    private void circularListDelFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          if(listCircular.deleteElement(Integer.parseInt(circularListDelField.getText())) == null){
        	  JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            circularListDelField.setText("");
        }
        singlyCircular.setValues(listCircular, 0);
       }

    }

    //eveniment la apasarea tastei Enter pentru stergerea de elemente in lista simplu inlantuita
    private void singlyListDelFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           if(listSimple.deleteElement(Integer.parseInt(singlyListDelField.getText())) == null){
        	  JOptionPane.showMessageDialog(this, "Elementul nu a fost gasit in lista.");
        }
        else {
            singlyListDelField.setText("");
        }
           singlyLinked.setValues(listSimple, 0);
       }
    }

    private void singlyListDelFieldActionPerformed(ActionEvent evt) {}

}
