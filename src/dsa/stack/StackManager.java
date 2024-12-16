package dsa.stack;

import java.awt.Graphics;

import dsa.common.AbstractArrayComponent;

public class StackManager extends AbstractArrayComponent {

    GraphicalArrayStack stack;

    public synchronized void setValues(GraphicalArrayStack stack) {
        this.stack = stack;
        repaint();
    }

    @Override
    protected int getHead() {
        return stack.head;
    }

    @Override
    protected int getTail() {
        return stack.head; // For a stack, head and tail are the same as there's only one pointer (top).
    }

    @Override
    protected int getLogicalSize() {
        return stack.size;
    }

    @Override
    protected void updateRectanglesPosition(int halfHeight, Graphics graphics) {
        stack.updateRectanglesPosition(halfHeight, graphics);
    }

    @Override
    protected void updateHeadTailLines(int halfHeight) {
        int headPosition = 80 + (stack.head * 60);
        stack.tailLine.setLine(headPosition, halfHeight + 37, headPosition, halfHeight + 80); // Reused as a single pointer line.
    }
}
