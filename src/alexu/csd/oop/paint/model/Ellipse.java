package alexu.csd.oop.paint.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Ellipse extends MShape {
    protected int width =  0;
    protected int height = 0;
    protected int selected = 0;

    public Ellipse(final Point first, final Point second) {
        firstPoint = first;
        secondPoint = second;
    }

    public void makeEllipse() {
    	width = Math.abs(firstPoint.x - secondPoint.x);
    	height = Math.abs(firstPoint.y - secondPoint.y);
//    	int x1 = firstPoint.x;
//		int y1 = firstPoint.y;
//		int x2 = secondPoint.x;
//		int y2 = secondPoint.y;
//    	if(x1 > x2 && y1 < y2) {
//			firstPoint.x = x1 - width;
//			firstPoint.y = y1;
//			secondPoint.x = x1;
//			secondPoint.y = y2;
//		}
    	shape = new Ellipse2D.Double(firstPoint.x, firstPoint.y, width, height);
 	}
    @Override
	public void draw(final Graphics2D g) {
    	this.makeEllipse();
    	g.setColor(color);
    	g.draw(getShape());
    	if(select == 1) {
    		g.setColor(Color.green);
			Point p1 = new Point(firstPoint.x + width - 10 , firstPoint.y);
			Point p2 = new Point(firstPoint.x + width - 10 , firstPoint.y + height - 10);
			Point p3 = new Point(firstPoint.x , firstPoint.y );
			Point p4 = new Point(firstPoint.x, firstPoint.y + height - 10);
			g.fillRect(p1.x, p1.y, 10, 10);
			g.fillRect(p2.x, p2.y, 10, 10);
			g.fillRect(p3.x, p3.y, 10, 10);
			g.fillRect(p4.x, p4.y, 10, 10);
			g.setColor(color);
		}
    	if(fill == 1) {
			g.fill(getShape());
		}
    	g.setColor(Color.black);
    }


}