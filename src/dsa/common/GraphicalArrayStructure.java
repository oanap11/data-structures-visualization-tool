package dsa.common;

public abstract class GraphicalArrayStructure extends ArrayRenderer {
    public int head = 0;
    public int tail = 0;
    protected int count = 0;

    public GraphicalArrayStructure(int size, int width, int height) {
        super(size, width, height);
    }

    public int add(String element) {
        if (isFull()) {
            return -1;
        }
        insertElement(element);
        count++;
        return 0;
    }

    public String remove() {
        if (isEmpty()) {
            return null;
        }
        String element = extractElement();
        count--;
        return element;
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void insertElement(String element);

    protected abstract String extractElement();

    // Utility methods
    protected boolean isFull() {
        return count == size;
    }

    protected boolean isEmpty() {
        return count == 0;
    }

    protected void clearElement(int index) {
        elements[index] = " ";
    }
}
