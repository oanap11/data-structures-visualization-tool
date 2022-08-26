package dsa;

import java.awt.geom.Line2D;

public class Arrow {

	Line2D line, arr1, arr2;

	public Arrow(double x1, double y1, double x2, double y2) {
        line = new Line2D.Double(x1, y1, x2, y2);
    }

}
