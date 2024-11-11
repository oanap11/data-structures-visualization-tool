package dsa.trees;

import java.awt.Graphics;

import javax.swing.JComponent;

public class TreeComponent extends JComponent {

	String val;
	char flag;
	GraphicalTree graphicalTree;

	public synchronized void setValues(GraphicalTree graphicalTree, char flag, String v) {
		this.graphicalTree = graphicalTree;
		this.flag = flag;
		val = v;
		repaint();
	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		int gap = 0;
		switch (flag) {
		case 'i':
			graphicalTree.insertElement(val);
			break;
		case 'd':
			if (graphicalTree.deleteElement(val) == true) {
				break;
			}
			// If delete was unsuccessful, do not continue drawing
			return;
		}

		if (graphicalTree != null) {
			gap = graphicalTree.getTreeDepth(graphicalTree.root);
			gap = gap * gap * 10;
			drawTree(g, gap);
		}
		flag = 'k';
	}

	// Common code for drawing the tree with the calculated gap
	private void drawTree(Graphics g, int gap) {
		graphicalTree.draw(graphicalTree.root, g, getWidth() / 2, 50, getWidth() / 2, 50, 0, gap);
	}

}