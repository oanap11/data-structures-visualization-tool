package dsa.queue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;

import dsa.Node;
import dsa.SinglyLinkedList;
import dsa.panels.ListPanel;

public class QueueListComponent extends JComponent {

	SinglyLinkedList list;
	char flag;
    int operation;
    int tempX, tempY, currentX, currentY, finalX, finalY, data, lastCurrentX, lastCurrentY;
    int width, height;

    private void drawArrow(Graphics g, int x, int y, int flag) {
         // 1 - dreapta 2 - jos 3 - stanga 4 - sus
 	   switch(flag) {
 	   case 1:
 		    g.drawLine(x, y, x-3, y-3);
            g.drawLine(x, y, x-3, y+3);
            break;
 	   case 2:
 		    g.drawLine(x, y, x-3, y-3);
            g.drawLine(x, y, x+3, y-3);
            break;
 	   case 3:
 		    g.drawLine(x, y, x+3, y-3);
            g.drawLine(x, y, x+3, y+3);
            break;
 	   case 4:
 		    g.drawLine(x, y, x+3, y+3);
            g.drawLine(x, y, x-3, y+3);
            break;
 	   }
   }

   private void drawNode(Graphics g, int x, int y, String s){
         g.drawRect(x, y, 30, 30);
         g.drawRect(x + 30, y, 10, 30);
         g.drawString(s, x + 5, y + 20);
         drawNull(g, x + 37, y);
  }

  private void drawNull(Graphics g, int x, int y){
      g.drawLine(x, y + 15, x + 20, y + 15);
      g.drawLine(x + 20, y + 15, x + 20, y + 30);
      g.drawLine(x + 15, y + 30, x + 25, y + 30);
  }

  private void drawAnimation(Graphics g,int data){
      //punctele intermediare se gasesc cu algoritmul Bresenham de trasare a unei linii
      int i = 0;
      int dx, dy, p, x, y;

      this.operation = 0;

      tempX = 20;
      tempY = 20;
      currentX = lastCurrentX;
      currentY = lastCurrentY;
      dx = finalY - tempX;
      dy = finalY - tempY;

      p = 2 * dy - dx;
      x = tempX;
      y = tempY;
      g.setColor(Color.BLACK);
      drawNode(g, 20, 20, "" + data);

      while(x <= finalX){
         if(p < 0){
             x=x+1;
             p = p + 2 * (dy);
         }
         else{
             x = x+1;
             y = y+1;
             p = p + 2 * (dy - dx);
         }
        System.out.println("x=" + x + "    y=" + y);
        if(x % 4 == 0){
        this.update(g);
              try {
                 Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(ListPanel.class.getName()).log(Level.SEVERE, null, ex);
             }
             g.setColor(Color.WHITE);
             drawNode(g, finalX, finalY,""+data);
             g.setColor(Color.BLACK);
             g.drawLine(currentX+35, currentY + 15, x+20, y+30);
             drawNode(g,x,y,""+data);
        }

     }
         g.setColor(Color.white);
         g.drawLine(currentX + 35, currentY + 15, x + 20, y + 30);
         drawNode(g, x, y, "" + data);
  }

  	public void setValues(SinglyLinkedList list, int operation, char flag){
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

