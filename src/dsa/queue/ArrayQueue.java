package dsa.queue;

import java.awt.Graphics;

import dsa.utils.AbstractArrayComponent;

public class ArrayQueue extends AbstractArrayComponent {

    GraphicalArrayQueue queue;

    public synchronized void setValues(GraphicalArrayQueue queue) {
        this.queue = queue;
        repaint();
    }

    @Override
    protected int getHead() {
        return queue.head;
    }

    @Override
    protected int getTail() {
        return queue.tail;
    }

    @Override
    protected int getLogicalSize() { 
        return queue.size;
    }

    @Override
    protected void updateRectanglesPosition(int halfHeight, Graphics graphics) {
        queue.updateRectanglesPosition(halfHeight, graphics);
    }

    @Override
    protected void updateHeadTailLines(int halfHeight) {
        int tailPosition = 80 + (queue.tail * 60);
        int headPosition = 80 + (queue.head * 60);

        queue.headLine.setLine(headPosition, halfHeight - 37, headPosition, halfHeight - 80);
        queue.tailLine.setLine(tailPosition, halfHeight + 37, tailPosition, halfHeight + 80);
    }
}
