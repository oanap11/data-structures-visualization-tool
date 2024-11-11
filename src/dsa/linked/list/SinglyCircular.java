
package dsa.linked.list;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dsa.Node;
import dsa.LinkedListTemplate;

public class SinglyCircular extends SinglyListComponent {
	
	private static final long serialVersionUID = 1L;

	int initialX, initialY;
	private final ExecutorService threadPool = Executors.newCachedThreadPool(); // Initialize a thread pool

	private void drawNodeWithoutArrow(Graphics g, int x, int y, String s) {
		g.drawRect(x, y, 30, 30);
		g.drawRect(x + 30, y, 10, 30);
		g.drawString(s, x + 5, y + 20);
	}

	private void drawLastPointer(Graphics g, int x, int y) {
		if (y == 70) {
			g.drawLine(x, y + 15, x + 20, y + 15);
			g.drawLine(x + 20, y + 15, x + 20, y - 10);
			g.drawLine(x + 20, y - 10, initialX + 20, initialY - 10);
			g.drawLine(initialX + 20, initialY - 10, initialX + 20, initialY);
		} else {
			g.drawLine(x, y + 15, x + 20, y + 15);
			g.drawLine(x + 20, y + 15, x + 20, y + 40);
			g.drawLine(x + 20, y + 40, 7, y + 40);
			g.drawLine(7, y + 40, 7, 60);
			g.drawLine(7, 60, initialX + 20, 60);
			g.drawLine(initialX + 20, 60, initialX + 20, initialY);
		}
		drawArrow(g, initialX + 20, initialY, 2);
	}

	void drawInterPath(Graphics g) {
		height = this.getHeight();
		width = this.getWidth();
		
		int first = 1;
		int stepHeight = 70;
		int increaseDistance = 50;
		boolean changed = false;
		currentX = 20;
		currentY = 70;

		Node currentNode = this.list.firstNode;
		g.setColor(Color.RED);
		drawNodeWithoutArrow(g, currentX, currentY, "Start");
		g.setColor(Color.BLACK);
		
		while (currentNode != null && currentNode.next != null) {
			if (first == 1) {
				initialX = currentX + 60;
				initialY = currentY;
				g.setColor(Color.WHITE);
				drawNull(g, currentX + 37, currentY);
				first = 0;
			} else {

			}

			if (currentX + 130 > width) {
				finalX = 20;
				stepHeight += (increaseDistance + 30);
				finalY = stepHeight;
				changed = true;
			} else {
				finalX = currentX + 60;
				finalY = currentY;
			}

			g.setColor(Color.black);
			drawNodeWithoutArrow(g, finalX, finalY, "" + currentNode.data);
			
			if (changed) {
				drawPathWithChanges(g, currentX, currentY, finalX, finalY, increaseDistance);
				changed = false;
			} else {
				g.drawLine(currentX + 35, currentY + 15, finalX, finalY + 15);
				drawArrow(g, finalX, finalY + 15, 1);
			}

			lastCurrentX = currentX;
			lastCurrentY = currentY;
			currentX = finalX;
			currentY = finalY;
			data = currentNode.data;

			currentNode = currentNode.next;
		}
		if (currentNode != null) {
			g.drawLine(currentX + 35, currentY + 15, interX, interY + 15);
			drawNodeWithoutArrow(g, interX, interY, "" + currentNode.data);
			drawLastPointer(g, interX + 37, interY);
		}
	}

	public void drawList(Graphics g) {
		height = this.getHeight();
		width = this.getWidth();
		
		int first = 1;
		int stepHeight = 70;
		int increaseDistance = 50;
		boolean changed = false;
		currentX = 20;
		currentY = 70;

		Node temp = this.list.firstNode;
		g.setColor(Color.RED);
		drawNode(g, currentX, currentY, "Start");
		g.setColor(Color.BLACK);
		
		while (temp != null) {
			if (first == 1) {
				initialX = currentX + 60;
				initialY = currentY;
				g.setColor(Color.WHITE);
				drawNull(g, currentX + 37, currentY);
				first = 0;
			} else {

			}

			if (currentX + 130 > width) {
				finalX = 20;
				stepHeight += (increaseDistance + 30);
				finalY = stepHeight;

				changed = true;
			} else {
				finalX = currentX + 60;
				finalY = currentY;
			}

			g.setColor(Color.black);
			drawNodeWithoutArrow(g, finalX, finalY, "" + temp.data);
			
			if (changed) {
				drawPathWithChanges(g, currentX, currentY, finalX, finalY, increaseDistance);
				changed = false;
			} else {
				g.drawLine(currentX + 35, currentY + 15, finalX, finalY + 15);
				drawArrow(g, finalX, finalY + 15, 1);
			}

			lastCurrentX = currentX;
			lastCurrentY = currentY;
			currentX = finalX;
			currentY = finalY;
			data = temp.data;

			temp = temp.next;
		}
		if (this.list.firstNode != null)
			drawLastPointer(g, finalX + 37, finalY);

	}

	public void setValues(LinkedListTemplate listCircular, int operation) {
		this.list = listCircular;
		this.operation = operation;

		if (this.operation == 1) {
			threadPool.submit(this::drawAnimation); // Submit the task to the thread pool
		}

		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("DESENAT" + this.operation);

		if (this.operation == 1) {
			System.out.println("A fost adaugat un nou element in lista.");
			drawInterPath(g);
		} else {
			drawList(g);
		}
	}

}
