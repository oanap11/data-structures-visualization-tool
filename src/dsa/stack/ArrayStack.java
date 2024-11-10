package dsa.stack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ArrayStack extends JComponent {

	GraphicalArrayStack stack;

	public synchronized void setValues(GraphicalArrayStack stack) {
		this.stack = stack;
		repaint();
	}

	@Override
	public synchronized void paintComponent(Graphics graphics) {
		
		Graphics2D graphicsContext = (Graphics2D) graphics;
		int halfHeight = getHeight() / 2;
		
		stack.updateRectanglesPosition(halfHeight, graphics);

		if (this.stack.size != 0) {
			graphicsContext.setStroke(new BasicStroke(4));
			int tl = 80 + (stack.head * 60);
			
			stack.tailLine.setLine(tl, halfHeight + 37, tl, halfHeight + 80);
			graphicsContext.draw(stack.tailLine);

			int x1[] = { tl, tl - 8, tl + 8, tl };
			int y1[] = { halfHeight + 30, halfHeight + 50, halfHeight + 50, halfHeight + 30 };

			graphicsContext.draw(stack.tailLine);
			graphics.setColor(Color.red);
			graphics.drawString("Top", tl - 4, halfHeight + 95);
			graphics.setColor(Color.black);
			graphics.fillPolygon(x1, y1, 4);
			graphicsContext.setStroke(new BasicStroke(1));
		}
	}

}
