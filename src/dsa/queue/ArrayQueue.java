package dsa.queue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

import javax.swing.JComponent;

public class ArrayQueue extends JComponent {

	GraphicalArrayQueue queue;

	public synchronized void setValues(GraphicalArrayQueue queue) {
		this.queue = queue;
		repaint();
	}

	@Override
	public synchronized void paintComponent(Graphics graphics) {
		Graphics2D graphicsContext = (Graphics2D) graphics;
		int halfHeight = getHeight() / 2;
		
		queue.updateRectanglesPosition(halfHeight, graphics);

		if (this.queue.size != 0) {
			graphicsContext.setStroke(new BasicStroke(4));
			int tailPosition = 80 + (queue.tail * 60);
			int headPosition = 80 + (queue.head * 60);
			
			queue.headLine.setLine(headPosition, halfHeight - 37, headPosition, halfHeight - 80);
			queue.tailLine.setLine(tailPosition, halfHeight + 37, tailPosition, halfHeight + 80);
			graphicsContext.draw(queue.headLine);
			
			int headXPoints[] = { headPosition, headPosition - 8, headPosition + 8, headPosition };
			int headYPoints[] = { halfHeight - 30, halfHeight - 50, halfHeight - 50, halfHeight - 30 };
			
			int tailXPoints[] = { tailPosition, tailPosition - 8, tailPosition + 8, tailPosition };
			int tailYPoints[] = { halfHeight + 30, halfHeight + 50, halfHeight + 50, halfHeight + 30 };

			graphics.fillPolygon(headXPoints, headYPoints, 4);
			graphics.setColor(Color.red);
			graphics.drawString("Tail", tailPosition - 4, halfHeight + 95);
			graphics.drawString("Head", headPosition - 4, halfHeight - 87);
			graphics.setColor(Color.black);
			graphics.fillPolygon(tailXPoints, tailYPoints, 4);
			
			graphicsContext.draw(queue.tailLine);
			graphicsContext.setStroke(new BasicStroke(1));
		}
	}
}