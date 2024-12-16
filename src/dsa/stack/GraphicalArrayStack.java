package dsa.stack;

import dsa.common.GraphicalArrayStructure;

public class GraphicalArrayStack extends GraphicalArrayStructure {

    public GraphicalArrayStack(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    protected void insertElement(String element) {
        elements[head++] = element; // Push to the top of the stack
    }

    @Override
    protected String extractElement() {
        String temp = elements[--head]; // Pop from the top of the stack
        clearElement(head);
        return temp;
    }
}
