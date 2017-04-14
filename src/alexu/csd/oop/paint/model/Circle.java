package alexu.csd.oop.paint.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.xml.bind.annotation.XmlElement.DEFAULT;

public class Circle extends Ellipse{
	int radius;

	public Circle(final Point first, final Point second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void makeEllipse(){
		radius = (int)Math.sqrt(Math.pow(firstPoint.x - secondPoint.x, 2) + Math.pow(firstPoint.y - secondPoint.y , 2));
		width = height = 2 * radius;
		shape = new Ellipse2D.Double(firstPoint.x - radius, firstPoint.y - radius, width, height);
	}
	@Override
	public void draw(final Graphics2D g) {
		makeEllipse();
		g.setColor(color);
		if(fill == 1) {
			g.fill(getShape());
		}
		else {
			g.draw(getShape());
		}
		if(select == 1) {
			g.setColor(Color.green);
			Point p1 = new Point(firstPoint.x - radius, firstPoint.y - radius);
			Point p2 = new Point(firstPoint.x + radius - 10, firstPoint.y - radius);
			Point p3 = new Point(firstPoint.x + radius - 10, firstPoint.y + radius - 10);
			Point p4 = new Point(firstPoint.x - radius, firstPoint.y + radius - 10);
			g.fillRect(p1.x, p1.y, 10, 10);
			g.fillRect(p2.x, p2.y, 10, 10);
			g.fillRect(p3.x, p3.y, 10, 10);
			g.fillRect(p4.x, p4.y, 10, 10);
			g.setColor(color);
		}
		g.setColor(Color.black);

    }

}
