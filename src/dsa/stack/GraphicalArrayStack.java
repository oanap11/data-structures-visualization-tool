package dsa.stack;

import dsa.utils.GraphicalArray;

public class GraphicalArrayStack extends GraphicalArray {

	public GraphicalArrayStack(int size, int width, int height) {
		super(size, width, height);
	}
	

	public String pop() {
		String temp;
		if (head == 0) {
			System.out.println("Stiva nu contine elemente.");
			return null;
		}
		temp = elements[head - 1];
		elements[head - 1] = " ";
		head = head - 1;
		count--;
		return temp;
	}

	public int push(String element) {
		if (count == size) {
			System.out.println("Stiva este plina.");
			return -1;
		}
		elements[head] = element;
		head++;
		count++;
		return 0;
	}

}