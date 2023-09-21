package dsa.queue;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GraphicalArrayQueue {

	Rectangle2D queueArray[];
	String val[];
	Line2D h, t;
	int head, tail, count;
	public int size;

	public GraphicalArrayQueue(int size, int width, int height) {
		this.size = size;
		queueArray = new Rectangle2D[size];
		val = new String[size];
		for (int i = 0; i < size; i++) {
			val[i] = " ";
			// construieste si initializeaza un dreptunghi folosind coordonatele specificate
			queueArray[i] = new Rectangle2D.Double((50 + (i * 60)), (height / 2) - 30, 60, 60);
			head = tail = count = 0;
		}
		h = new Line2D.Double(80, (height / 2) - 30, 80, (height / 2) - 50);
		t = new Line2D.Double(80, (height / 2) + 30, 80, (height / 2) + 50);
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
