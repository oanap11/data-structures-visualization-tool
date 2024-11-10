package dsa.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

public class GraphicalArray {
	
	public Rectangle2D rectangles[];
	public String elements[];
	public Line2D headLine, tailLine;
	public int head, tail, count, size;
	private int xPoint = 80;
	
	public GraphicalArray(int size, int width, int height) {
		this.size = size;
		rectangles = new Rectangle2D[size];
		elements = new String[size];
		
		for (int i = 0; i < size; i++) {
			elements[i] = " ";
			rectangles[i] = new Rectangle2D.Double((50 + (i * 60)), height - 30, 60, 60);
		}
		
		headLine = new Line2D.Double(xPoint, height - 30, xPoint, height - 50);
		tailLine = new Line2D.Double(xPoint, height + 30, xPoint, height + 50);
	}
	
	public void updateRectanglesPosition(int halfHeight, Graphics graphics) {
		Graphics2D graphicsContext = (Graphics2D) graphics;
		
		for (Rectangle2D rectangle : rectangles) { 
		    int index = Arrays.asList(rectangles).indexOf(rectangle);  
		    rectangle.setRect(50 + (index * 60), halfHeight - 30, 60, 60);

		    int xCoordinate = (int) rectangle.getMinX();
		    int yCoordinate = (int) rectangle.getMinY();
		    
		    graphicsContext.draw(rectangle);
		    graphicsContext.drawString(elements[index], xCoordinate + 30, yCoordinate + 30);  
		}
    }
}
