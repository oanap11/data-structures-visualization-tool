package dsa.queue;

import dsa.utils.GraphicalArrayStructure;

public class GraphicalArrayQueue extends GraphicalArrayStructure {

    public GraphicalArrayQueue(int size, int width, int height) {
        super(size, width, height);
    }

    @Override
    protected void insertElement(String element) {
        elements[tail] = element; // Enqueue at the tail
        tail = (tail + 1) % size;
    }

    @Override
    protected String extractElement() {
        String temp = elements[head]; // Dequeue from the head
        clearElement(head);
        head = (head + 1) % size;
        return temp;
    }
}
