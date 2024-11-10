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
			drawArrows(graphics);
			graphicsContext.draw(stack.tailLine);
			graphicsContext.setStroke(new BasicStroke(1));
		}
	}
	
	void drawArrows(Graphics graphics) {
		int tailPosition = 80 + (stack.head * 60);
		int halfHeight = getHeight() / 2;
		int tailXPoints[] = { tailPosition, tailPosition - 8, tailPosition + 8, tailPosition };
		int tailYPoints[] = { halfHeight + 30, halfHeight + 50, halfHeight + 50, halfHeight + 30 };
		
		stack.tailLine.setLine(tailPosition, halfHeight + 37, tailPosition, halfHeight + 80);
		
		graphics.setColor(Color.red);
		graphics.drawString("Top", tailPosition - 4, halfHeight + 95);
		graphics.setColor(Color.black);
		graphics.fillPolygon(tailXPoints, tailYPoints, 4);
	}
}
