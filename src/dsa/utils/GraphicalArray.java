package dsa.utils;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GraphicalArray {
	
	public Rectangle2D array[];
	public String val[];
	public Line2D h, t;
	public int head, tail, count;
	public int size;

	public GraphicalArray(int size, int width, int height) {
		this.size = size;
		array = new Rectangle2D[size];
		val = new String[size];
		for (int i = 0; i < size; i++) {
			val[i] = " ";
			array[i] = new Rectangle2D.Double((50 + (i * 60)), (height / 2) - 30, 60, 60);
			head = tail = count = 0;
		}
		h = new Line2D.Double(80, (height / 2) - 30, 80, (height / 2) - 50);
		t = new Line2D.Double(80, (height / 2) + 30, 80, (height / 2) + 50);
	}

}
