package dsa.queue;

import dsa.utils.GraphicalArray;

public class GraphicalArrayQueue extends GraphicalArray  {

	public GraphicalArrayQueue(int size, int width, int height) {
		super(size, width, height);
	}

	public String dequeue() {
		String temp;
		if (count == 0) {
			System.out.println("Coada nu contine elemente.");
			return null;
		}
		temp = val[head];
		val[head] = " ";
		head = (head + 1) % size;
		count--;
		return temp;
	}

	public int enqueue(String element) {
		if (count == size) {
			System.out.println("Coada este plina - nu mai pot fi adaugate elemente.");
			return -1;
		}
		val[tail] = element;
		tail = (tail + 1) % size;
		count++;
		return 0;
	}

} 
