package dsa.stack;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GraphicalArrayStack {

	Rectangle2D stackArray[];
    String val[];
    Line2D t;
    int top, count;
	public int size;

    public GraphicalArrayStack(int size, int width, int height) {
          	this.size = size;
            stackArray = new Rectangle2D[size];
            val = new String[size];
            for(int i=0; i<size; i++){
                val[i] = " ";
                stackArray[i] = new Rectangle2D.Double((50+(i*60)), (height/2)-30, 60, 60);
                top = 0;
                count = 0;
            }
            t = new Line2D.Double(80, (height/2) + 30, 80, (height/2) + 50 );
    }

    //scoate elemente din stiva
    public String pop() {
        String temp;
        if(top == 0) {
            System.out.println("Stiva nu contine elemente.");
            return null;
        }
        temp = val[top-1];
        val[top-1] = " ";
        top = top-1;
        count = count-1;
        return temp;
    }

    //adauga elemente in stiva
    public int push(String element) {
           if(top == size) {
               System.out.println("Stiva este plina.");
               return -1;
           }
           val[top] = element;
           top = top + 1;
           count = count + 1;
           return 0;
    }

}