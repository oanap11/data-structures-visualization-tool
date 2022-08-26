package dsa.algos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class PathFindingPanel extends JPanel implements ActionListener {

	private Grid grid;
	private JPanel container;
	private JPanel controlPanel;
	private JPanel buttonPanel;
	private JPanel optionPanel;
	private JButton playButton;
	private JButton resetButton;
	private JSpinner stepSpinner;
	private JComboBox algorithmList;
	private JComboBox gridEditorList;
	private JLabel stepSpinnerLabel;
	private JLabel algorithmListLabel;
	private JLabel gridEditorListLabel;

	public PathFindingPanel(){

		grid = new Grid(600, 600, 50, 50);

		container = new JPanel(new BorderLayout());
		controlPanel = new JPanel(new BorderLayout());

		playButton = new JButton("Start");
		playButton.setMnemonic(KeyEvent.VK_S);
	    playButton.setActionCommand("start");
	    playButton.addActionListener(this);

		resetButton = new JButton("Reseteaza");
		resetButton.setMnemonic(KeyEvent.VK_R);
	    resetButton.setActionCommand("reset");
	    resetButton.addActionListener(this);

	    SpinnerNumberModel stepSizeModel = new SpinnerNumberModel(50, 10, 200, 10);
	    stepSpinner = new JSpinner(stepSizeModel);
	    stepSpinnerLabel = new JLabel("Timp / pas: ");
	    stepSpinnerLabel.setLabelFor(stepSpinner);
	    stepSpinnerLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	    String algorithms[] = {"Dijkstra" , "A*"};
	    algorithmList = new JComboBox(algorithms);
	    algorithmListLabel = new JLabel("Algoritm de cautare: ");
	    algorithmListLabel.setLabelFor(algorithmList);
	    algorithmListLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	    String editList[] = {"Start", "End"};
	    gridEditorList = new JComboBox(editList);
	    gridEditorList.addActionListener(this);
	    gridEditorListLabel = new JLabel("Schimba pozitia pe tabla: ");
	    gridEditorListLabel.setLabelFor(gridEditorList);
	    gridEditorListLabel.setHorizontalAlignment(SwingConstants.RIGHT);

	    buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
	    buttonPanel.add(playButton);
	    buttonPanel.add(resetButton);
	    controlPanel.add(buttonPanel, BorderLayout.WEST);

	    optionPanel = new JPanel(new GridLayout(3, 2, 0, 5));
		optionPanel.add(stepSpinnerLabel);
		optionPanel.add(stepSpinner);
		optionPanel.add(algorithmListLabel);
		optionPanel.add(algorithmList);
		optionPanel.add(gridEditorListLabel);
		optionPanel.add(gridEditorList);
		controlPanel.add(optionPanel,BorderLayout.CENTER);

		controlPanel.setPreferredSize(new Dimension(400,75));

		container.add(grid,BorderLayout.CENTER);
		container.add(controlPanel,BorderLayout.SOUTH);

		this.add(container);
		//this.setResizable(false);
		//this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if("start".equals(e.getActionCommand())){

			SwingWorker worker = new SwingWorker<Void,Void>(){
				@Override
				protected Void doInBackground(){
					grid.start((int)stepSpinner.getValue(), algorithmList.getSelectedIndex());
					return null;
				}
			};
			playButton.setEnabled(false);
			worker.execute();
		}

		if("reset".equals(e.getActionCommand())){
			grid.reset();
			playButton.setEnabled(true);
		}

		if(e.getSource() == gridEditorList){
			grid.setPositionable(gridEditorList.getSelectedIndex());
		}

	}
}