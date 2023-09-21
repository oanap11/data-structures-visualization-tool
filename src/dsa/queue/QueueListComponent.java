package dsa.queue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;

import dsa.Node;
import dsa.linked.list.SinglyListComponent;
import dsa.LinkedListTemplate;
import dsa.panels.ListPanel;

public class QueueListComponent extends SinglyListComponent {

	LinkedListTemplate list;
	char flag;
    int operation;
    int tempX, tempY, currentX, currentY, finalX, finalY, data, lastCurrentX, lastCurrentY;
    int width, height;

  	public void setValues(LinkedListTemplate list, int operation, char flag){
  		this.flag = flag;
  		this.list = list;
  		this.operation = operation;
  		repaint();
    }

  	public void drawList(Graphics g){
  		height = this.getHeight();
  		width = this.getWidth();

  		int stepHeight;
  		int incr_distance = 50;
  		boolean changed = false;
  		currentX = 20;
  		currentY = 70;
  		stepHeight = 70;

  		Node temp = this.list.firstNode;
  		finalX = currentX + 60;
  		finalY = currentY;

  		g.setColor(Color.RED);
  		g.drawString("Head", currentX, currentY + 20);
  		g.setColor(Color.BLACK);
  		g.drawLine(currentX + 33, currentY + 15, currentX + 59, currentY + 15);
  		drawArrow(g, currentX + 59, currentY + 15, 1);


  		while(temp != null){
          g.setColor(Color.WHITE);
          drawNull(g,currentX + 37, currentY);

           if(currentX + 130 > width){
               finalX = 90;
               stepHeight += (incr_distance + 30);
               finalY = stepHeight;

               changed = true;
           }
           else{
               finalX = currentX + 60;
               finalY = currentY;
           }

           g.setColor(Color.black);
           drawNode(g, finalX, finalY, ""+temp.data);
           if(changed){
             g.drawLine(currentX+35, currentY+15, currentX+70, currentY+15);
             g.drawLine(currentX+70, currentY+15, currentX+70, currentY+(30+incr_distance/2));
             g.drawLine(currentX+70, currentY+(30+incr_distance/2), 10, currentY+(30+incr_distance/2));
             g.drawLine(10, currentY+(30+incr_distance/2), 10, finalY+15);
             g.drawLine(10, finalY+15, finalX, finalY+15);
             changed = false;
           }
           else{
               g.drawLine(currentX+35, currentY+15, finalX, finalY+15);

           }
           drawArrow(g, finalX, finalY+15, 1);

           lastCurrentX = currentX;
           lastCurrentY = currentY;
           currentX = finalX;
           currentY = finalY;
           data = temp.data;

           temp = temp.next;
       }

       g.setColor(Color.RED);
       g.drawString("Tail",finalX+3,finalY+77);

       g.setColor(Color.BLACK);
       g.drawLine(finalX+13, finalY+68, finalX+13, finalY+30);
       drawArrow(g, finalX+13, finalY+30, 4);
   }

     @Override
	public void paintComponent(Graphics g) {
    	 System.out.println("Desenat!");

    	 drawList(g);
    	 if(this.operation == 1){
    		 System.out.println("A fost insertat un nou element.");
    	 }
     }
 }

