package alexu.csd.oop.paint.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Triangle extends MShape {
	public Triangle(final Point first, final Point second,final Point third) {
		firstPoint = first;
		secondPoint = second;
		thirdPoint = third;
	}

	public void setThirdPoint(final Point third) {
		thirdPoint = third;
	}

	public void makeTriangle(){
		int x[] = new int[3];
		int y[] = new int[3];
		x[0] = firstPoint.x;
		x[1] = secondPoint.x;
		x[2] = thirdPoint.x;
		y[0] = firstPoint.y;
		y[1] = secondPoint.y;
		y[2] = thirdPoint.y;
		shape = new Polygon(x, y, 3); 	
	}
	
	public void draw(final Graphics2D g) {
		g.setColor(color);
		makeTriangle();
		g.draw(getShape());
		if(select == 1) {
			g.setColor(Color.green);
			g.fillRect(firstPoint.x - 5, firstPoint.y - 5, 10, 10);
			g.fillRect(secondPoint.x - 5, secondPoint.y - 5, 10, 10);
			g.fillRect(thirdPoint.x - 5, thirdPoint.y - 5, 10, 10);
			g.setColor(color);
		}
		if(fill == 1) {
			g.fill(getShape());
		}
		g.setColor(Color.black);
	}

}
