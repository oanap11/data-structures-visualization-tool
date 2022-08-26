package dsa.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

import dsa.SinglyLinkedList;
import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;
import dsa.queue.QueueListComponent;


public class QueuePanel extends JPanel {

    QueueComponent queueComponent;
    GraphicalArrayQueue arrayQueue;
    QueueListComponent lcomp;
    SinglyLinkedList listA;

    private JButton dequeueButton, dequeueButtonList, enqueueButton;
    private JSeparator jSeparator1, jSeparator2, jSeparator3, jSeparator5, jSeparator6;
    private JPanel qArrayPanel, qLinkedPanel;
    private JSlider qArraySlider, qLinkedSlider;

    private JButton qLinkedStepButton, qListEnqueueButton;
    private JTextField qListinputText, qinputText;
    private JPanel queueCenterPanel, queueNorthLinkedPanel, queueNorthPanel;
    private JTabbedPane queuePane;
    private JPanel queueSouthLinkedPanel, queueSouthPanel;
    private JButton resetButton, sizeButton;
    private JLabel sizeLabel;
    private JTextField sizeText;

    public QueuePanel() {
        initComponents();
        sizeText.setText(null);
        lcomp = new QueueListComponent();
        qLinkedPanel.add(lcomp, BorderLayout.CENTER);
        listA = new SinglyLinkedList();
        lcomp.setValues(listA,0, 'n');
        enqueueButton.setEnabled(false);
        dequeueButton.setEnabled(false);
        resetButton.setEnabled(false);
        qLinkedPanel.revalidate();
    }

    private void initComponents() {


        queueCenterPanel = new JPanel();
        queuePane = new JTabbedPane();
        qArrayPanel =  new JPanel(){

            @Override
			public void paint(Graphics g){
                super.paint(g);
                System.out.println("here");
            }

        };
        queueNorthPanel = new JPanel();
        enqueueButton = new JButton();
        dequeueButton = new JButton();
        qinputText = new JTextField();
        sizeButton = new JButton();
        sizeText = new JTextField();
        sizeLabel = new JLabel();
        resetButton = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        queueSouthPanel = new JPanel();
        qArraySlider = new JSlider();

        jSeparator3 = new JSeparator();
        qLinkedPanel = new JPanel();
        queueNorthLinkedPanel = new JPanel();
        qListEnqueueButton = new JButton();
        dequeueButtonList = new JButton();
        qListinputText = new JTextField();
        jSeparator5 = new JSeparator();
        queueSouthLinkedPanel = new JPanel();
        qLinkedSlider = new JSlider();
        qLinkedStepButton = new JButton();
        jSeparator6 = new JSeparator();

        setLayout(new BorderLayout());

        queueCenterPanel.setLayout(new BoxLayout(queueCenterPanel, BoxLayout.LINE_AXIS));

        qArrayPanel.setBackground(new Color(254, 254, 254));
        qArrayPanel.setLayout(new BorderLayout());

        //butonul pentru adaugarea de elemente in coada
        enqueueButton.setText("Adauga element");
        enqueueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                enqueueButtonActionPerformed(evt);
            }
        });

        //botonul pentru stergerea de elemente
        dequeueButton.setText("Sterge element");
        dequeueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                dequeueButtonActionPerformed(evt);
            }
        });

        //insereaza elementul
        qinputText.setColumns(5);
        qinputText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                qinputTextKeyPressed(evt);
            }
        });

        sizeButton.setText("Numar elemente");
        sizeButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sizeButtonActionPerformed(evt);
            }
        });
        sizeButton.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sizeButtonKeyPressed(evt);
            }
        });

        sizeText.setColumns(5);
        sizeText.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sizeTextActionPerformed(evt);
            }
        });
        sizeText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sizeTextKeyPressed(evt);
            }
        });

        sizeLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        sizeLabel.setForeground(new Color(241, 19, 19));
        sizeLabel.setText("Numar de elemente:  ");

        resetButton.setText("Reseteaza");
        resetButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        GroupLayout queueNorthPanelLayout = new GroupLayout(queueNorthPanel);
        queueNorthPanel.setLayout(queueNorthPanelLayout);
        queueNorthPanelLayout.setHorizontalGroup(
            queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qinputText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enqueueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dequeueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeText, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeButton)
                .addGap(29, 29, 29)
                .addComponent(sizeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addContainerGap())
        );
        queueNorthPanelLayout.setVerticalGroup(
            queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(queueNorthPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(queueNorthPanelLayout.createSequentialGroup()
                        .addGroup(queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addGroup(queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(qinputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(enqueueButton)
                                .addComponent(dequeueButton)
                                .addComponent(sizeButton)
                                .addComponent(sizeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sizeLabel)
                                .addComponent(resetButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        qArrayPanel.add(queueNorthPanel, BorderLayout.NORTH);
        queueSouthPanel.setBackground(new Color(255, 87, 51));
        queueSouthPanel.setPreferredSize(new Dimension(100, 100));
        qArrayPanel.add(queueSouthPanel, BorderLayout.SOUTH);

        qArraySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        qArrayPanel.add(queueSouthPanel, BorderLayout.SOUTH);

        queuePane.addTab("Coada - Tablou de elemente", qArrayPanel);

        qLinkedPanel.setBackground(Color.white);
        qLinkedPanel.setLayout(new BorderLayout());

        qListEnqueueButton.setText("Adauga element");
        qListEnqueueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                qListEnqueueButtonActionPerformed(evt);
            }
        });

        dequeueButtonList.setText("Scoate element");
        dequeueButtonList.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
            	dequeueButtonListActionPerformed(evt);
            }
        });

        qListinputText.setColumns(5);
        qListinputText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                qListinputTextKeyPressed(evt);
            }
        });

        jSeparator5.setOrientation(SwingConstants.VERTICAL);

        GroupLayout queueNorthLinkedPanelLayout = new GroupLayout(queueNorthLinkedPanel);
        queueNorthLinkedPanel.setLayout(queueNorthLinkedPanelLayout);
        queueNorthLinkedPanelLayout.setHorizontalGroup(
            queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthLinkedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qListinputText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qListEnqueueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dequeueButtonList, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        queueNorthLinkedPanelLayout.setVerticalGroup(
            queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthLinkedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(qListinputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(qListEnqueueButton)
                        .addComponent(dequeueButtonList)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        qLinkedPanel.add(queueNorthLinkedPanel, BorderLayout.NORTH);
        qLinkedPanel.add(queueSouthLinkedPanel, BorderLayout.SOUTH);

        queueSouthLinkedPanel.setBackground(new Color(255, 87, 51));
        queueSouthLinkedPanel.setPreferredSize(new Dimension(100, 100));
        qLinkedPanel.add(queueSouthLinkedPanel, BorderLayout.SOUTH);

        qLinkedSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Bitstream Charter", 0, 12), new Color(222, 29, 29))); // NOI18N


        queuePane.addTab("Coada - Lista", qLinkedPanel);
        queueCenterPanel.add(queuePane);
        add(queueCenterPanel, BorderLayout.CENTER);
    }

    private void dequeueButtonActionPerformed(ActionEvent evt) {
         String s = arrayQueue.dequeue();
         if(s == null) {
             dequeueButton.setEnabled(false);
             JOptionPane.showMessageDialog(null, "Coada este goala.", "alert", JOptionPane.ERROR_MESSAGE);
         }
         enqueueButton.setEnabled(true);
         queueComponent.setValues(arrayQueue);
         qinputText.setText("");
    }

    private void sizeButtonActionPerformed(ActionEvent evt) {
        if(sizeText.getText().equals(""))
                return;

        if(queueComponent != null) {
            qArrayPanel.remove(queueComponent);
        }
        if(sizeText.getText() != " ") {
            sizeLabel.setText( "Numar elemente:  " + sizeText.getText());
            sizeButton.setEnabled(false);
            enqueueButton.setEnabled(true);
            dequeueButton.setEnabled(true);
            resetButton.setEnabled(true);
        }
        queueComponent = new QueueComponent();

        qArrayPanel.add(queueComponent,BorderLayout.CENTER);

        arrayQueue = new GraphicalArrayQueue(Integer.parseInt(sizeText.getText()), qArrayPanel.getWidth(),qArrayPanel.getHeight());
        queueComponent.setValues(arrayQueue);
        qArrayPanel.revalidate();

        sizeText.setText(null);
    }

    private void sizeTextActionPerformed(ActionEvent evt) {
    }

    private void resetButtonActionPerformed(ActionEvent evt) {
        sizeLabel.setText( "Numar elemente:   ");
        sizeButton.setEnabled(true);
        enqueueButton.setEnabled(false);
        dequeueButton.setEnabled(false);
        resetButton.setEnabled(false);
        arrayQueue.size = 0;
        queueComponent.setValues(arrayQueue);
    }

    private void sizeTextKeyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(sizeText.getText().equals(""))
                return;

        if(queueComponent != null){
            qArrayPanel.remove(queueComponent);
        }
        if(sizeText.getText() != " "){
            sizeLabel.setText( "Numar elemenete: " + sizeText.getText());

            sizeButton.setEnabled(false);
            enqueueButton.setEnabled(true);
            dequeueButton.setEnabled(true);
            resetButton.setEnabled(true);
        }
        queueComponent = new QueueComponent();

        qArrayPanel.add(queueComponent,BorderLayout.CENTER);

        arrayQueue = new GraphicalArrayQueue(Integer.parseInt(sizeText.getText()), qArrayPanel.getWidth(),qArrayPanel.getHeight());
        queueComponent.setValues(arrayQueue);
        qArrayPanel.revalidate();

        sizeText.setText(null);

        }
    }

    private void enqueueButtonActionPerformed(ActionEvent evt) {
        int a = arrayQueue.enqueue(qinputText.getText());
        if(a==-1){
            JOptionPane.showMessageDialog(null, "Coada este plina.", "alert", JOptionPane.ERROR_MESSAGE);
            enqueueButton.setEnabled(false);
        }
        dequeueButton.setEnabled(true);
        queueComponent.setValues(arrayQueue);
        qinputText.setText("");
    }

    private void dequeueButtonListActionPerformed(ActionEvent evt) {
       if(listA.first == null)
             JOptionPane.showMessageDialog(null, "Nu sunt elemente in coada", "alert", JOptionPane.ERROR_MESSAGE);
       else
             listA.deleteElement(listA.first.data);
      lcomp.setValues(listA,0,'n');
    }

    private void qListEnqueueButtonActionPerformed(ActionEvent evt) {
        listA.insertElement(Integer.parseInt(qListinputText.getText()));
        lcomp.setValues(listA,1, 'n');
        qListinputText.setText("");
    }

    private void qinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int a = arrayQueue.enqueue(qinputText.getText());
            if(a==-1){
                JOptionPane.showMessageDialog(null, "Coada este plina", "alert", JOptionPane.ERROR_MESSAGE);
                enqueueButton.setEnabled(false);
            }
            dequeueButton.setEnabled(true);
            queueComponent.setValues(arrayQueue);
            qinputText.setText("");
       }
    }

    private void sizeButtonKeyPressed(KeyEvent evt) {}

    private void qListinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            listA.insertElement(Integer.parseInt(qListinputText.getText()));
            lcomp.setValues(listA,1, 'n');
            qListinputText.setText("");
       }
    }


}
