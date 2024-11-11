package dsa.stack;

import java.awt.Color;
import java.awt.Graphics;

import dsa.linked.list.SinglyListComponent;
import dsa.LinkedListTemplate;

public class ListStack extends SinglyListComponent {

	public void setValues(LinkedListTemplate list, int operation) {
		this.list = list;
		this.operation = operation;
		repaint();
	}

	public void drawList(Graphics g) {
		initializeDrawingVariables(g);

		while (currentNode != null) {
			useCommonLogicForDrawing(g, currentNode, stepHeight, increaseDistance, changed);

			currentNode = currentNode.next;
		}
		
		drawTopArrow(g);
	}
	
	void drawTopArrow(Graphics g) {
  		g.setColor(Color.RED);
        g.drawString("Top", finalX + 3, finalY + 77);
        g.setColor(Color.BLACK);
        g.drawLine(finalX + 13, finalY + 68, finalX + 13, finalY + 30);
        drawArrow(g, finalX + 13, finalY + 30, 4);
  	}

	@Override
	public void paintComponent(Graphics g) {
		drawList(g);
	}
}