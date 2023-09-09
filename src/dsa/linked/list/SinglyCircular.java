
package dsa.linked.list;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import dsa.Node;
import dsa.SinglyLinkedList;

public class SinglyCircular extends JComponent {
    private static final long serialVersionUID = 1L;

	SinglyLinkedList list;
    int operation ;
    int tempX, tempY, currentX, currentY, finalX, finalY, data, lastCurrentX, lastCurrentY;
    int initialX, initialY, interX, interY;
    int width, height;

    private void drawArrow(Graphics g, int x, int y, int flag) {
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

    private void drawFirstNode(Graphics g, int x, int y, String s){
        g.drawRect(x, y, 30, 30);
        g.drawRect(x+30, y, 10, 30);
        g.drawString(s, x+5, y+20);
        drawNull(g,x+37,y);
    }

    private void drawNode(Graphics g, int x, int y, String s){
        g.drawRect(x, y, 30, 30);
        g.drawRect(x+30, y, 10, 30);
        g.drawString(s, x+5, y+20);
    }

    private void drawNull(Graphics g, int x, int y){
	     g.drawLine(x, y+15, x+20, y+15);
	     g.drawLine(x+20, y+15, x+20, y+30);
	     g.drawLine(x+15, y+30, x+25, y+30);
    }

    private void drawLastPointer(Graphics g,int x, int y){
        if(y == 70){
        	g.drawLine(x, y+15, x+20, y+15);
            g.drawLine(x+20, y+15, x+20, y-10);
            g.drawLine(x+20, y-10, initialX+20, initialY-10);
            g.drawLine(initialX+20, initialY-10, initialX+20, initialY);
        }
        else{
            g.drawLine(x, y+15, x+20, y+15);
            g.drawLine(x+20, y+15, x+20, y+40);
            g.drawLine(x+20, y+40, 7, y+40);
            g.drawLine(7, y+40, 7, 60);
            g.drawLine(7, 60, initialX+20, 60);
            g.drawLine(initialX+20, 60, initialX+20, initialY);
        }
        drawArrow(g, initialX+20, initialY, 2);
    }

    private void drawAnimation(){
    	// Finding intermediate points by breshnam line
    	int i = 0;
    	int dx, dy, p, x, y;
    	int prevx , prevy;
    	this.operation = 1;

	     tempX = 20;
	     tempY = 20;
	     currentX = lastCurrentX;
	     currentY = lastCurrentY;
	     dx = 60 + finalX - tempX;
	     dy = finalY - tempY;

	     p = 2 * (dy) - (dx);
	     x = tempX;
	     y = tempY;
	     while(x <= finalX || y <= finalY) {
	        if(p < 0) {
	            x = x + 1;
	            p = p + 2 * (dy);
	        }
	        else {
	            x = x + 1;
	            y = y + 1;
	            p = p + 2 * (dy - dx);
	        }
	       System.out.println("x="+x+"    y="+y);
	       if(x % 4 == 0) {
	            prevx  = x;
	            prevy = y;
	            interX = x;
	            interY = y;

	         try {
	             Thread.sleep(100);
	         }
	         catch (InterruptedException ex) {}
	         repaint();
	       }

	   }
	       this.operation = 0;
    }

  void drawInterPath(Graphics g){
      height = this.getHeight();
      width = this.getWidth();

      int step_height, first = 1;
      int incr_distance = 50;
      boolean changed = false;
      currentX = 20;
      currentY = 70;
      step_height = 70;

      Node temp = this.list.firstNode;
      // draw first node
      g.setColor(Color.RED);
      drawNode(g,currentX,currentY,"Start");

      g.setColor(Color.BLACK);
      while(temp != null && temp.next != null){
         if(first == 1){
           initialX = currentX + 60;
           initialY = currentY;
           g.setColor(Color.WHITE);
           drawNull(g,currentX+37,currentY);
              first = 0;
         }else{

          }

          if( currentX+130 > width)
          {
              finalX = 20;
              step_height += (incr_distance + 30);
              finalY = step_height;

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
            drawArrow(g, finalX, finalY+15, 1);
            changed = false;
          }
          else{
              g.drawLine(currentX+35, currentY+15, finalX, finalY+15);
              drawArrow(g, finalX, finalY+15, 1);
          }

          lastCurrentX = currentX;
          lastCurrentY = currentY;
          currentX = finalX;
          currentY = finalY;
          data = temp.data;

          temp = temp.next;
      }
      if(temp != null)
      {
          g.drawLine(currentX+35, currentY+15,  interX, interY+15);
          drawNode(g, interX, interY, ""+temp.data);
          drawLastPointer(g, interX + 37, interY);
      }
  }

  public void drawList(Graphics g){
      height = this.getHeight();
      width = this.getWidth();
      int first = 1;
     int step_height;
     int incr_distance = 50;
      boolean changed = false;
     currentX = 20;
     currentY = 70;
      step_height = 70;

      Node temp = this.list.firstNode;

      g.setColor(Color.RED);
      drawFirstNode(g,currentX,currentY,"Start");

      g.setColor(Color.BLACK);
      while(temp != null){
          if(first == 1){
           initialX = currentX + 60;
           initialY = currentY;
           g.setColor(Color.WHITE);
           drawNull(g,currentX+37,currentY);
              first = 0;
         }else{

          }

          if( currentX+130 > width)
          {
              finalX = 20;
              step_height += (incr_distance + 30);
              finalY = step_height;

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
            drawArrow(g, finalX, finalY+15, 1);
            changed = false;
          }
          else{
              g.drawLine(currentX+35, currentY+15, finalX, finalY+15);
              drawArrow(g, finalX, finalY+15, 1);
          }

          lastCurrentX = currentX;
          lastCurrentY = currentY;
          currentX = finalX;
          currentY = finalY;
          data = temp.data;

          temp = temp.next;
      }
      if(this.list.firstNode != null)
        drawLastPointer(g, finalX + 37, finalY);

     }

  public void setValues(SinglyLinkedList listCircular, int operation) {
      this.list = listCircular;
      this.operation = operation;
      if(this.operation == 1){
            Thread t1 = new Thread(new Runnable() {
                @Override
				public void run() {
                	drawAnimation();
                }
            });
            t1.start();
      }
      repaint();
   }

  @Override
public void paintComponent(Graphics g) {
      System.out.println("DESENAT" + this.operation);

      if(this.operation == 1){
          System.out.println("A fost adaugat un nou element in lista.");
          drawInterPath(g);
      }
      else {
        drawList(g);
      }
  }

}
