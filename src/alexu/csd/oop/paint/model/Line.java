package alexu.csd.oop.paint.model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class Line extends MShape {
	int selected = 0;
	public Line(final Point first, final Point second) {
		firstPoint = first;
		secondPoint = second;
	}

 	public void makeLine() {
 		shape = new Line2D.Double(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
 	}

 	@Override
	public void draw(final Graphics2D g) {
		// TODO Auto-generated method stub
 		makeLine();
 		g.setColor(color);
 		g.draw(getShape());
 		if(select == 1) {
 			g.setColor(color.green);
 			Point p1 = new Point(firstPoint.x - 5, firstPoint.y - 5);
 			Point p2 = new Point(secondPoint.x - 5, secondPoint.y - 5);
 			g.fillRect(p1.x, p1.y, 10, 10);
 			g.fillRect(p2.x, p2.y, 10, 10);	
 			g.setColor(color);
 		}
 		if(fill == 1) {
			g.fill(getShape());
		}
 		g.setColor(Color.black);

	}

}
