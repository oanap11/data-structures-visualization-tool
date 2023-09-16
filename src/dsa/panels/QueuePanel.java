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

import dsa.LinkedListTemplate;
import dsa.queue.GraphicalArrayQueue;
import dsa.queue.QueueComponent;
import dsa.queue.QueueListComponent;


public class QueuePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	QueueComponent queueComponent;
    GraphicalArrayQueue arrayQueue;
    QueueListComponent listComponent;
    LinkedListTemplate listA;
    
    private JTabbedPane queuePane;
    private JSeparator jSeparator1, jSeparator2;
    private JPanel queueCenterPanel;
    
    // array components
    private JButton arrayEnqueueButton, arrayDequeueButton, arrayResetButton, arraySizeButton;
    private JPanel arrayPanel;
    private JSlider arraySlider;
    private JTextField arrayInputTextField;
    private JLabel arraySizeLabel;
    private JTextField arraySizeText;
    private JPanel arraySouthPanel;
    private JPanel arrayNorthPanel;
    
    // linked list components
    private JButton listEnqueueButton, listDequeueButton;
    private JPanel listPanel;
    private JSlider listSlider;
    private JTextField listInputTextField;
    private JPanel listSouthPanel;
    private JPanel listNorthPanel;
    
    public QueuePanel() {
        initComponents();
        listComponent = new QueueListComponent();
        listPanel.add(listComponent, BorderLayout.CENTER);
        listA = new LinkedListTemplate();
        listComponent.setValues(listA,0, 'n');
        arrayEnqueueButton.setEnabled(false);
        arrayDequeueButton.setEnabled(false);
        arrayResetButton.setEnabled(false);
        listPanel.revalidate();
    }

    private void initComponents() {


        queueCenterPanel = new JPanel();
        queuePane = new JTabbedPane();
        arrayPanel =  new JPanel();
        arrayNorthPanel = new JPanel();
        arrayEnqueueButton = new JButton();
        arrayDequeueButton = new JButton();
        arrayInputTextField = new JTextField();
        arraySizeButton = new JButton();
        arraySizeText = new JTextField();
        arraySizeLabel = new JLabel();
        arrayResetButton = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        arraySouthPanel = new JPanel();
        arraySlider = new JSlider();

        listPanel = new JPanel();
        listNorthPanel = new JPanel();
        listEnqueueButton = new JButton();
        listDequeueButton = new JButton();
        listInputTextField = new JTextField();
        listSouthPanel = new JPanel();
        listSlider = new JSlider();

        setLayout(new BorderLayout());

        queueCenterPanel.setLayout(new BoxLayout(queueCenterPanel, BoxLayout.LINE_AXIS));

        arrayPanel.setBackground(new Color(254, 254, 254));
        arrayPanel.setLayout(new BorderLayout());

        //butonul pentru adaugarea de elemente in coada
        arrayEnqueueButton.setText("Adauga element");
        arrayEnqueueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                enqueueButtonActionPerformed(evt);
            }
        });

        //botonul pentru stergerea de elemente
        arrayDequeueButton.setText("Sterge element");
        arrayDequeueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                dequeueButtonActionPerformed(evt);
            }
        });

        //insereaza elementul
        arrayInputTextField.setColumns(5);
        arrayInputTextField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                qinputTextKeyPressed(evt);
            }
        });

        arraySizeButton.setText("Numar elemente");
        arraySizeButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sizeButtonActionPerformed(evt);
            }
        });
        arraySizeButton.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sizeButtonKeyPressed(evt);
            }
        });

        arraySizeText.setColumns(5);
        arraySizeText.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                sizeTextActionPerformed(evt);
            }
        });
        arraySizeText.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                sizeTextKeyPressed(evt);
            }
        });

        arraySizeLabel.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        arraySizeLabel.setForeground(new Color(241, 19, 19));
        arraySizeLabel.setText("Numar de elemente:  ");

        arrayResetButton.setText("Reseteaza");
        arrayResetButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        GroupLayout queueNorthPanelLayout = new GroupLayout(arrayNorthPanel);
        arrayNorthPanel.setLayout(queueNorthPanelLayout);
        queueNorthPanelLayout.setHorizontalGroup(
            queueNorthPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arrayInputTextField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrayEnqueueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrayDequeueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arraySizeText, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arraySizeButton)
                .addGap(29, 29, 29)
                .addComponent(arraySizeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrayResetButton, 0, GroupLayout.DEFAULT_SIZE, 200)
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
                                .addComponent(arrayInputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(arrayEnqueueButton)
                                .addComponent(arrayDequeueButton)
                                .addComponent(arraySizeButton)
                                .addComponent(arraySizeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(arraySizeLabel)
                                .addComponent(arrayResetButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        arrayPanel.add(arrayNorthPanel, BorderLayout.NORTH);
        arraySouthPanel.setBackground(new Color(255, 87, 51));
        arraySouthPanel.setPreferredSize(new Dimension(100, 100));
        arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);

        arraySlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 12), new java.awt.Color(222, 29, 29))); // NOI18N

        arrayPanel.add(arraySouthPanel, BorderLayout.SOUTH);

        queuePane.addTab("Coada - Tablou de elemente", arrayPanel);

        listPanel.setBackground(Color.white);
        listPanel.setLayout(new BorderLayout());

        listEnqueueButton.setText("Adauga element");
        listEnqueueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                qListEnqueueButtonActionPerformed(evt);
            }
        });

        listDequeueButton.setText("Scoate element");
        listDequeueButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
            	dequeueButtonListActionPerformed(evt);
            }
        });

        listInputTextField.setColumns(5);
        listInputTextField.addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent evt) {
                qListinputTextKeyPressed(evt);
            }
        });

        GroupLayout queueNorthLinkedPanelLayout = new GroupLayout(listNorthPanel);
        listNorthPanel.setLayout(queueNorthLinkedPanelLayout);
        queueNorthLinkedPanelLayout.setHorizontalGroup(
            queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthLinkedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listEnqueueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listDequeueButton, 0, GroupLayout.DEFAULT_SIZE, 200)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGap(82, 82, 82))
        );
        queueNorthLinkedPanelLayout.setVerticalGroup(
            queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(queueNorthLinkedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(queueNorthLinkedPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(listInputTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(listEnqueueButton)
                        .addComponent(listDequeueButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listPanel.add(listNorthPanel, BorderLayout.NORTH);
        listPanel.add(listSouthPanel, BorderLayout.SOUTH);

        listSouthPanel.setBackground(new Color(255, 87, 51));
        listSouthPanel.setPreferredSize(new Dimension(100, 100));
        listPanel.add(listSouthPanel, BorderLayout.SOUTH);

        listSlider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(), "Animation Speed", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Bitstream Charter", 0, 12), new Color(222, 29, 29))); // NOI18N


        queuePane.addTab("Coada - Lista", listPanel);
        queueCenterPanel.add(queuePane);
        add(queueCenterPanel, BorderLayout.CENTER);
    }

    private void dequeueButtonActionPerformed(ActionEvent evt) {
         String s = arrayQueue.dequeue();
         if(s == null) {
             arrayDequeueButton.setEnabled(false);
             JOptionPane.showMessageDialog(null, "Coada este goala.", "alert", JOptionPane.ERROR_MESSAGE);
         }
         arrayEnqueueButton.setEnabled(true);
         queueComponent.setValues(arrayQueue);
         arrayInputTextField.setText("");
    }

    private void sizeButtonActionPerformed(ActionEvent evt) {
        if(arraySizeText.getText().equals(""))
                return;

        if(queueComponent != null) {
            arrayPanel.remove(queueComponent);
        }
        if(arraySizeText.getText() != " ") {
            arraySizeLabel.setText( "Numar elemente:  " + arraySizeText.getText());
            arraySizeButton.setEnabled(false);
            arrayEnqueueButton.setEnabled(true);
            arrayDequeueButton.setEnabled(true);
            arrayResetButton.setEnabled(true);
        }
        queueComponent = new QueueComponent();

        arrayPanel.add(queueComponent,BorderLayout.CENTER);

        arrayQueue = new GraphicalArrayQueue(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(),arrayPanel.getHeight());
        queueComponent.setValues(arrayQueue);
        arrayPanel.revalidate();

        arraySizeText.setText(null);
    }

    private void sizeTextActionPerformed(ActionEvent evt) {
    }

    private void resetButtonActionPerformed(ActionEvent evt) {
        arraySizeLabel.setText( "Numar elemente:   ");
        arraySizeButton.setEnabled(true);
        arrayEnqueueButton.setEnabled(false);
        arrayDequeueButton.setEnabled(false);
        arrayResetButton.setEnabled(false);
        arrayQueue.size = 0;
        queueComponent.setValues(arrayQueue);
    }

    private void sizeTextKeyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(arraySizeText.getText().equals(""))
                return;

        if(queueComponent != null){
            arrayPanel.remove(queueComponent);
        }
        if(arraySizeText.getText() != " "){
            arraySizeLabel.setText( "Numar elemenete: " + arraySizeText.getText());

            arraySizeButton.setEnabled(false);
            arrayEnqueueButton.setEnabled(true);
            arrayDequeueButton.setEnabled(true);
            arrayResetButton.setEnabled(true);
        }
        queueComponent = new QueueComponent();

        arrayPanel.add(queueComponent,BorderLayout.CENTER);

        arrayQueue = new GraphicalArrayQueue(Integer.parseInt(arraySizeText.getText()), arrayPanel.getWidth(),arrayPanel.getHeight());
        queueComponent.setValues(arrayQueue);
        arrayPanel.revalidate();

        arraySizeText.setText(null);

        }
    }

    private void enqueueButtonActionPerformed(ActionEvent evt) {
        int a = arrayQueue.enqueue(arrayInputTextField.getText());
        if(a==-1){
            JOptionPane.showMessageDialog(null, "Coada este plina.", "alert", JOptionPane.ERROR_MESSAGE);
            arrayEnqueueButton.setEnabled(false);
        }
        arrayDequeueButton.setEnabled(true);
        queueComponent.setValues(arrayQueue);
        arrayInputTextField.setText("");
    }

    private void dequeueButtonListActionPerformed(ActionEvent evt) {
       if(listA.firstNode == null)
             JOptionPane.showMessageDialog(null, "Nu sunt elemente in coada", "alert", JOptionPane.ERROR_MESSAGE);
       else
             listA.deleteElement(listA.firstNode.data);
      listComponent.setValues(listA,0,'n');
    }

    private void qListEnqueueButtonActionPerformed(ActionEvent evt) {
        listA.insertElement(Integer.parseInt(listInputTextField.getText()));
        listComponent.setValues(listA,1, 'n');
        listInputTextField.setText("");
    }

    private void qinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int a = arrayQueue.enqueue(arrayInputTextField.getText());
            if(a==-1){
                JOptionPane.showMessageDialog(null, "Coada este plina", "alert", JOptionPane.ERROR_MESSAGE);
                arrayEnqueueButton.setEnabled(false);
            }
            arrayDequeueButton.setEnabled(true);
            queueComponent.setValues(arrayQueue);
            arrayInputTextField.setText("");
       }
    }

    private void sizeButtonKeyPressed(KeyEvent evt) {}

    private void qListinputTextKeyPressed(KeyEvent evt) {
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            listA.insertElement(Integer.parseInt(listInputTextField.getText()));
            listComponent.setValues(listA,1, 'n');
            listInputTextField.setText("");
       }
    }


}
