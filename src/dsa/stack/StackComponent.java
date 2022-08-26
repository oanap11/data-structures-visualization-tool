package dsa.stack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class StackComponent extends JComponent {

	GraphicalArrayStack stack;

	public synchronized void setValues(GraphicalArrayStack sA) {
      this.stack = sA;
      repaint();
   }

	@Override
	public synchronized void paintComponent(Graphics g) {

       Graphics2D qG = (Graphics2D) g;
       for (int i = 0; i < stack.size; i++) {
           stack.stackArray[i].setRect((50+(i*60)),(getHeight()/2)-30,60,60);

           int x = (int) stack.stackArray[i].getMinX();
           int y = (int) stack.stackArray[i].getMinY();
           qG.draw(stack.stackArray[i]);
           qG.drawString(stack.val[i],x + 30 , y + 30);
      }

        if(this.stack.size != 0) {
            qG.setStroke(new BasicStroke(4));
            int tl= 80 + (stack.top * 60);
            stack.t.setLine(tl, (getHeight()/2)+37, tl,(getHeight()/2)+80);
            qG.draw(stack.t);
            int h = (getHeight()/2);

            int x1[] = {tl, tl- 8,tl + 8, tl};
            int y1[] = {h + 30, h +50,h +  50, h+30};

            qG.draw(stack.t);
            g.setColor(Color.red);
            g.drawString("Top",tl-4,(getHeight()/2)+95);
            g.setColor(Color.black);
            g.fillPolygon(x1,y1 , 4);
            qG.setStroke(new BasicStroke(1));
        }
   }

}
