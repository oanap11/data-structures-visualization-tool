package dsa.queue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class QueueComponent extends JComponent {

	GraphicalArrayQueue queue;
	int componentHeight_HALF;

	public synchronized void setValues(GraphicalArrayQueue qA) {
      this.queue = qA;
      repaint();
   }

   @Override
public synchronized void paintComponent(Graphics g) {

       Graphics2D qG = (Graphics2D) g;
       componentHeight_HALF = getHeight() / 2;

       for (int i = 0; i < queue.size; i++){
    	   //deseneaza reprezentarea grafica pentru coada implementata prin array
           queue.qArray[i].setRect((50 + (i*60)), componentHeight_HALF - 30, 60, 60);

           int x = (int) queue.qArray[i].getMinX();

           int y = (int) queue.qArray[i].getMinY();
           qG.draw(queue.qArray[i]);
           qG.drawString(queue.val[i],x + 30 , y + 30);
      }

        if(this.queue.size != 0) {
            qG.setStroke(new BasicStroke(4));
            int tl= 80 + (queue.tail * 60);
            int hd = 80 + (queue.head * 60);
            queue.h.setLine(hd, componentHeight_HALF - 37, hd, componentHeight_HALF - 80);
            queue.t.setLine(tl, componentHeight_HALF + 37, tl, componentHeight_HALF + 80);
            qG.draw(queue.h);

            int h = componentHeight_HALF;
            int x[] = {hd, hd - 8, hd + 8, hd};
            int y[] = {h -30, h - 50, h -  50, h - 30};
            int x1[] = {tl, tl - 8, tl + 8, tl};
            int y1[] = {h + 30, h +50, h +  50, h + 30};

            g.fillPolygon(x, y, 4);
            qG.draw(queue.t);
            g.setColor(Color.red);
            g.drawString("Tail", tl - 4, componentHeight_HALF + 95);
            g.drawString("Head", hd - 4, componentHeight_HALF - 87);
            g.setColor(Color.black);
            g.fillPolygon(x1,y1 , 4);
            qG.setStroke(new BasicStroke(1));
        }

   }
}