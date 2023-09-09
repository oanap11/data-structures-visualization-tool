package dsa.linked.list;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import dsa.Node;
import dsa.SinglyLinkedList;

public class ListComponent extends JComponent{

   SinglyLinkedList list;
   int operation;
   int tempX, tempY, currentX, currentY, finalX, finalY,data,lastCurrentX, lastCurrentY;
   int width, height;
   int interX, interY;

   public ListComponent() {}

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

   //metoda pentru desenarea unui nod in lista
   private void drawNode(Graphics g, int x, int y, String s){
        g.drawRect(x, y, 30, 30); //deseneaza dreptunghiul principal
        g.drawRect(x + 30, y, 10, 30); //deseneaza dreptunghiul pentru adresa, din care porneste pointer-ul/sageata
        g.drawString(s, x + 5, y + 20); //deseneaza urmatorul nod cu elementul inserat
        drawNull(g, x + 37, y); //daca nodul nu are vecin, deseneaza sageata null care porneste din zona pentru adresa
   }

   private void drawNull(Graphics g, int x, int y){
	   g.drawLine(x, y + 15, x + 20, y + 15); //linie orizontala
	   g.drawLine(x + 20, y + 15, x + 20, y + 30);
	   g.drawLine(x + 15, y + 30, x + 25, y + 30); //deseneaza linie jos
   }

   private void drawAnimation(){
     //Breshenham
     int i = 0;
     int dx, dy, p, x, y;
     int prevX, prevY;
     this.operation = 1;

     tempX = 20;
     tempY = 20;
     currentX = lastCurrentX;
     currentY = lastCurrentY;
     dx = 60 + finalX - tempX; //deltaX = x2 - x1
     dy = finalY - tempY; //deltaY = y2 - y1

     p = 2 * dy - dx; //pentru rasterizare, formula este P0 = 2 * deltaY - deltaX
     x = tempX;
     y = tempY;
     while(x <= finalX || y <= finalY){
        if(p < 0) {
            x++;
            p = p + 2 * dy;
        }
        else {
            x++;
            y++;
            p = p + 2 * (dy - dx);
        }
       System.out.println("x = " + x + "    y = " + y);
       if(x % 4 == 0){
            prevX = x;
            prevY = y;
            interX = x;
            interY = y;

	         try {
	             Thread.sleep(10);
	         }
	         catch (InterruptedException ex) {}

	         repaint();
       }

     }
       this.operation = 0;

 	}

  	public void setValues(SinglyLinkedList list, int operation){
	      this.list = list;
	      this.operation = operation;

	      if(this.operation == 1){
            Thread t1 = new Thread(new Runnable(){
                @Override
				public void run(){
                	drawAnimation();
                }
            });
            t1.start();

      }
      repaint();
   }

  void drawInterPath(Graphics g) {
      height = this.getHeight();
      width = this.getWidth();

      int stepHeight;
      int increaseDistance = 50;  //distanta fata de lista verticala in cazul redimensionarii
      boolean changed = false;
      currentX = 20;
      currentY = 70;
      stepHeight = 70;

      Node temp = this.list.firstNode;
      //deseneaza primul nod
      g.setColor(Color.RED);
      drawNode(g, currentX, currentY, "Start");

      g.setColor(Color.BLACK);
      while(temp != null && temp.next != null){
    	  //scoate nodul din lista
          g.setColor(Color.WHITE);
          //deseneaza nod
          drawNull(g, currentX + 37, currentY);

          if(currentX + 130 > width){
              finalX = 20;
              stepHeight += (increaseDistance + 30);
              finalY = stepHeight;

              changed = true;
          }
          else{
              finalX = currentX + 60;
              finalY = currentY;
          }

          g.setColor(Color.black);
          drawNode(g, finalX, finalY, "" + temp.data);
          if(changed){
            g.drawLine(currentX + 35, currentY + 15, currentX + 70, currentY + 15);
            g.drawLine(currentX + 70, currentY + 15, currentX + 70, currentY + (30 + increaseDistance/2));
            g.drawLine(currentX + 70, currentY + (30 + increaseDistance/2), 10, currentY + (30 + increaseDistance/2));
            g.drawLine(10, currentY + (30 + increaseDistance/2), 10, finalY + 15);
            g.drawLine(10, finalY + 15, finalX, finalY + 15);
            drawArrow(g, finalX, finalY + 15, 1);
            changed = false;
          }
          else{
              g.drawLine(currentX+35, currentY+15, finalX, finalY+15);
              drawArrow(g, finalX, finalY+15, 1);
          }
          //actualizeaza valorile
          lastCurrentX = currentX;
          lastCurrentY = currentY;
          currentX = finalX;
          currentY = finalY;
          data = temp.data;

          temp = temp.next;
      }
      drawNode(g, interX, interY, "" + temp.data);
  }


  public void drawList(Graphics g){
      height = this.getHeight();
      width = this.getWidth();

      int stepHeight;
      int increaseDistance = 50;
      boolean changed = false;
      currentX = 20;
      currentY = 70;
      stepHeight = 70;

      Node temp = this.list.firstNode;
      g.setColor(Color.RED);
      drawNode(g, currentX, currentY, "Start");

      g.setColor(Color.BLACK);
      while(temp != null){
          g.setColor(Color.WHITE);
          drawNull(g, currentX + 37, currentY);

          if( currentX + 130 > width){
              finalX = 20;
              stepHeight += increaseDistance + 30;
              finalY = stepHeight;

              changed = true;
          }
          else{
              finalX = currentX + 60;
              finalY = currentY;
          }

          g.setColor(Color.black);
          drawNode(g, finalX, finalY, "" + temp.data);
          if(changed){
            g.drawLine(currentX + 35, currentY + 15, currentX + 70, currentY + 15);
            g.drawLine(currentX + 70, currentY + 15, currentX + 70, currentY + (30 + increaseDistance/2));
            g.drawLine(currentX + 70, currentY + (30 + increaseDistance/2), 10, currentY + (30 + increaseDistance/2));
            g.drawLine(10, currentY + (30 + increaseDistance/2), 10, finalY + 15);
            g.drawLine(10, finalY + 15, finalX, finalY + 15);
            drawArrow(g, finalX, finalY + 15, 1);
            changed = false;
          }
          else{
              g.drawLine(currentX + 35, currentY + 15, finalX, finalY + 15);
              drawArrow(g, finalX, finalY + 15, 1);
          }

          lastCurrentX = currentX;
          lastCurrentY = currentY;
          currentX = finalX;
          currentY = finalY;
          data = temp.data;

          temp = temp.next;
      }

  }

  @Override
public void paintComponent(Graphics g) {
      System.out.println("Desenat" + this.operation);

      if(this.operation == 1){
          System.out.println("A fost inserat un element in lista.");
          drawInterPath(g);
      }
      else {
        drawList(g);
      }
  }
}