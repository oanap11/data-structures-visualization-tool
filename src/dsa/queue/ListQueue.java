package dsa.queue;

import java.awt.Color;
import java.awt.Graphics;


import dsa.linked.list.SinglyListComponent;
import dsa.LinkedListTemplate;

public class ListQueue extends SinglyListComponent {

  	public void setValues(LinkedListTemplate list, int operation){
  		this.list = list;
  		this.operation = operation;
  		repaint();
    }
  	
  	protected void drawList(Graphics g){
  		initializeDrawingVariables(g);
  		
  		drawHeadArrow(g);

  		while(currentNode != null){
  			useCommonLogicForDrawing(g, currentNode, stepHeight, increaseDistance, changed);
  			currentNode = currentNode.next;
  		}
  		drawTailArrow(g);   
  	}
  	
  	void drawHeadArrow(Graphics g) {
  		g.setColor(Color.RED);
  		g.drawString("Head", currentX, currentY + 20);
  		g.setColor(Color.BLACK);
  		g.drawLine(currentX + 33, currentY + 15, currentX + 59, currentY + 15);
  		drawArrow(g, currentX + 59, currentY + 15, 1);
  	}
  	
  	void drawTailArrow(Graphics g) {
  		g.setColor(Color.RED);
        g.drawString("Tail", finalX + 3, finalY + 77);
        g.setColor(Color.BLACK);
        g.drawLine(finalX + 13, finalY + 68, finalX + 13, finalY + 30);
        drawArrow(g, finalX + 13, finalY + 30, 4);
  	}

     @Override
	public void paintComponent(Graphics g) {
    	 drawList(g);
     }
 }

