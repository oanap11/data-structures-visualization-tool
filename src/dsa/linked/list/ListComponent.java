package dsa.linked.list;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComponent;

import dsa.Node;
import dsa.SinglyLinkedList;

public class ListComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	SinglyLinkedList list;
	int operation;
	int tempX, tempY, currentX, currentY, finalX, finalY, data, lastCurrentX, lastCurrentY;
	int width, height;
	int interX, interY;
	
	// Using a thread pool improves performance while maintaining thread safety
	private final ExecutorService threadPool = Executors.newCachedThreadPool(); // Initialize a thread pool

	public ListComponent() {
	}

	protected void drawArrow(Graphics g, int x, int y, int flag) {
		int arrowSize = 3;
		int[][] offsets = { { -arrowSize, 0 }, { 0, -arrowSize }, { arrowSize, 0 }, { 0, arrowSize } };
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		for (int i = 0; i < 3; i++) {
			int index = (flag + i) % 4;
			xPoints[i] = x + offsets[index][0];
			yPoints[i] = y + offsets[index][1];
		}

		g.drawPolygon(xPoints, yPoints, 3);
	}

	// metoda pentru desenarea unui nod in lista
	protected void drawNode(Graphics g, int x, int y, String s) {
		g.drawRect(x, y, 30, 30); // deseneaza dreptunghiul principal
		g.drawRect(x + 30, y, 10, 30); // deseneaza dreptunghiul pentru adresa, din care porneste pointer-ul/sageata
		g.drawString(s, x + 5, y + 20); // deseneaza urmatorul nod cu elementul inserat
		drawNull(g, x + 37, y); // daca nodul nu are vecin, deseneaza sageata null care porneste din zona pentru
								// adresa
	}

	protected void drawNull(Graphics g, int x, int y) {
		g.drawLine(x, y + 15, x + 20, y + 15); // linie orizontala
		g.drawLine(x + 20, y + 15, x + 20, y + 30);
		g.drawLine(x + 15, y + 30, x + 25, y + 30); // deseneaza linie jos
	}

	private void drawAnimation() {
		// Breshenham
		int deltaX, deltaY, p, x, y;
		int prevX = 0, prevY = 0;

		this.operation = 1;
		tempX = 20;
		tempY = 20;
		currentX = lastCurrentX;
		currentY = lastCurrentY;

		deltaX = 60 + finalX - tempX; // deltaX = x2 - x1
		deltaY = finalY - tempY; // deltaY = y2 - y1

		p = 2 * deltaY - deltaX; // pentru rasterizare, formula este P0 = 2 * deltaY - deltaX
		x = tempX;
		y = tempY;

		while (x <= finalX) { // Only need to check x, as y is always incremented
			System.out.println("x = " + x + "    y = " + y);

			if (x % 4 == 0) {
				prevX = x;
				prevY = y;
				interX = x;
				interY = y;

				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				repaint();
			}

			x++;

			if (p < 0) {
				p += 2 * deltaY;
			} else {
				y++;
				p += 2 * (deltaY - deltaX);
			}
		}
		this.operation = 0;

	}

	public void setValues(SinglyLinkedList list, int operation) {
		this.list = list;
	    this.operation = operation;

	    if (this.operation == 1) {
	        threadPool.submit(this::drawAnimation); // Submit the task to the thread pool
	    }

	    repaint();
	}

	void drawInterPath(Graphics g) {
		height = this.getHeight();
		width = this.getWidth();

		int stepHeight = 70;
		int increaseDistance = 50; // distanta fata de lista verticala in cazul redimensionarii
		int startX = 20;
		int startY = 70;
		currentX = startX;
		currentY = startY;
		boolean changed = false;

		Node currentNode = this.list.firstNode;
		
		g.setColor(Color.RED);
		drawNode(g, currentX, currentY, "Start"); // deseneaza primul nod
		g.setColor(Color.BLACK);
		
		while (currentNode != null && currentNode.next != null) {
			g.setColor(Color.WHITE);
			drawNull(g, currentX + 37, currentY);

			if (currentX + 130 > width) {
				finalX = startX;
				stepHeight += (increaseDistance + 30);
				finalY = stepHeight;
				changed = true;
			} else {
				finalX = currentX + 60;
				finalY = currentY;
			}

			g.setColor(Color.black);
			drawNode(g, finalX, finalY, String.valueOf(currentNode.data));
			
			if (changed) {
				drawPathWithChanges(g, currentX, currentY, finalX, finalY, increaseDistance);
				changed = false;
			} else {
				g.drawLine(currentX + 35, currentY + 15, finalX, finalY + 15);
				drawArrow(g, finalX, finalY + 15, 1);
			}
			// actualizeaza valorile
			lastCurrentX = currentX;
			lastCurrentY = currentY;
			currentX = finalX;
			currentY = finalY;
			data = currentNode.data;

			currentNode = currentNode.next;
		}
		drawNode(g, interX, interY, String.valueOf(currentNode.data));
	}

	public void drawList(Graphics g) {
		height = this.getHeight();
		width = this.getWidth();

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
			g.setColor(Color.WHITE);
			drawNull(g, currentX + 37, currentY);

			if (currentX + 130 > width) {
				finalX = 20;
				stepHeight += increaseDistance + 30;
				finalY = stepHeight;

				changed = true;
			} else {
				finalX = currentX + 60;
				finalY = currentY;
			}

			g.setColor(Color.black);
			drawNode(g, finalX, finalY, "" + temp.data);
			
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

	}
	
	protected void drawPathWithChanges(Graphics g, int startX, int startY, int finalX, int finalY, int increaseDistance) {
	    g.drawLine(startX + 35, startY + 15, startX + 70, startY + 15);
	    g.drawLine(startX + 70, startY + 15, startX + 70, startY + (30 + increaseDistance / 2));
	    g.drawLine(startX + 70, startY + (30 + increaseDistance / 2), 10, startY + (30 + increaseDistance / 2));
	    g.drawLine(10, startY + (30 + increaseDistance / 2), 10, finalY + 15);
	    g.drawLine(10, finalY + 15, finalX, finalY + 15);
	    drawArrow(g, finalX, finalY + 15, 1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Desenat" + this.operation);
		if (this.operation == 1) {
			System.out.println("A fost inserat un element in lista.");
			drawInterPath(g);
		} else {
			drawList(g);
		}
	}
}