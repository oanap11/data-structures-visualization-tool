package dsa.stack;

import java.awt.Color;
import java.awt.Graphics;

import dsa.Node;
import dsa.linked.list.SinglyListComponent;
import dsa.LinkedListTemplate;

public class ListStack extends SinglyListComponent {

	LinkedListTemplate list;
	char flag;
	int operation;
	int tempX, tempY, currentX, currentY, finalX, finalY, data, lastCurrentX, lastCurrentY;
	int width, height;

	public void setValues(LinkedListTemplate list, int operation, char flag) {
		this.flag = flag;
		this.list = list;
		this.operation = operation;
		repaint();
	}

	public void drawList(Graphics g) {
		height = this.getHeight();
		width = this.getWidth();

		int stepHeight = 70;
		int increaseDistance = 50;
		currentX = 20;
		currentY = 70;
		boolean changed = false;

		finalX = currentX + 60;
		finalY = currentY;
		Node currentNode = this.list.firstNode;

		g.setColor(Color.BLACK);
		while (currentNode != null) {
			g.setColor(Color.WHITE);
			drawNull(g, currentX + 37, currentY);

			if (currentX + 130 > width) {
				finalX = 90;
				stepHeight += (increaseDistance + 30);
				finalY = stepHeight;

				changed = true;
			} else {
				finalX = currentX + 60;
				finalY = currentY;
			}

			g.setColor(Color.black);
			drawNode(g, finalX, finalY, "" + currentNode.data);
			if (changed) {
				g.drawLine(currentX + 35, currentY + 15, currentX + 70, currentY + 15);
				g.drawLine(currentX + 70, currentY + 15, currentX + 70, currentY + (30 + increaseDistance / 2));
				g.drawLine(currentX + 70, currentY + (30 + increaseDistance / 2), 10, currentY + (30 + increaseDistance / 2));
				g.drawLine(10, currentY + (30 + increaseDistance / 2), 10, finalY + 15);
				g.drawLine(10, finalY + 15, finalX, finalY + 15);
				drawArrow(g, finalX, finalY + 15, 1);
				changed = false;
			} else {
				if (finalX != 80) {
					g.drawLine(currentX + 35, currentY + 15, finalX, finalY + 15);
					drawArrow(g, finalX, finalY + 15, 1);
				}
			}

			lastCurrentX = currentX;
			lastCurrentY = currentY;
			currentX = finalX;
			currentY = finalY;
			data = currentNode.data;

			currentNode = currentNode.next;
		}
		g.setColor(Color.RED);
		g.drawString("Top", finalX + 3, finalY + 77);
		g.setColor(Color.BLACK);
		g.drawLine(finalX + 13, finalY + 68, finalX + 13, finalY + 30);
		drawArrow(g, finalX + 13, finalY + 30, 4);
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Desenat");
		if (flag == 'e') {
			g.setColor(Color.RED);
		}
		drawList(g);
		if (this.operation == 1) {
			System.out.println("Elementul a fost inserat");
		}
	}
}