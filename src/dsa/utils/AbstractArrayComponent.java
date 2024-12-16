package dsa.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public abstract class AbstractArrayComponent extends JComponent {
	private static final long serialVersionUID = 1L;

	protected abstract int getHead();
    protected abstract int getTail();
    protected abstract int getLogicalSize();
    protected abstract void updateRectanglesPosition(int halfHeight, Graphics graphics);
    protected abstract void updateHeadTailLines(int halfHeight);

    @Override
    public synchronized void paintComponent(Graphics graphics) {
        Graphics2D graphicsContext = (Graphics2D) graphics;
        int halfHeight = getHeight() / 2;

        updateRectanglesPosition(halfHeight, graphics);

        if (getLogicalSize() != 0) {
            graphicsContext.setStroke(new BasicStroke(4));
            drawArrows(graphics, halfHeight);
            updateHeadTailLines(halfHeight);
            graphicsContext.setStroke(new BasicStroke(1));
        }
    }

    private void drawArrows(Graphics graphics, int halfHeight) {
        int tailPosition = 80 + (getTail() * 60);
        int headPosition = 80 + (getHead() * 60);

        int tailXPoints[] = { tailPosition, tailPosition - 8, tailPosition + 8, tailPosition };
        int tailYPoints[] = { halfHeight + 30, halfHeight + 50, halfHeight + 50, halfHeight + 30 };

        graphics.setColor(Color.red);
        graphics.drawString("Head", tailPosition - 4, halfHeight + 95);

        if (this instanceof dsa.queue.ArrayQueue) { // Queue-specific: draw head
            int headXPoints[] = { headPosition, headPosition - 8, headPosition + 8, headPosition };
            int headYPoints[] = { halfHeight - 30, halfHeight - 50, halfHeight - 50, halfHeight - 30 };

            graphics.fillPolygon(headXPoints, headYPoints, 4);
            graphics.drawString("Tail", headPosition - 4, halfHeight - 87);
        }

        graphics.setColor(Color.black);
        graphics.fillPolygon(tailXPoints, tailYPoints, 4);
    }
}
