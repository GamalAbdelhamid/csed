package alexu.csd.oop.paint.model;
import java.awt.*;
import java.awt.geom.Rectangle2D;
public class Rectangle extends MShape {
	protected int width;
	protected int height;
	protected int selected = 0;
	public Rectangle(final Point first, final Point second) {
		// TODO Auto-generated constructor stub
		firstPoint = first;
		secondPoint = second;
	}

	public void makeRectangle() {
		width = (Math.abs(firstPoint.x - secondPoint.x) );
		height = (Math.abs(firstPoint.y - secondPoint.y) );
		int x1 = firstPoint.x;
		int y1 = firstPoint.y;
		int x2 = secondPoint.x;
		int y2 = secondPoint.y;
		if(x1 > x2 && y1 < y2) {
			firstPoint.x = x1 - width;
			firstPoint.y = y1;
			secondPoint.x = x1;
			secondPoint.y = y2;
		}
		shape = new Rectangle2D.Double(firstPoint.x, firstPoint.y, width, height);
	}
	@Override
	public void draw(final Graphics2D g) {
		g.setColor(color);
		makeRectangle();
		g.draw(getShape());
		if(select == 1) {
			g.setColor(Color.green);
			Point p2 = new Point(firstPoint.x + width, firstPoint.y);
			Point p3 = new Point(firstPoint.x + width, firstPoint.y + height);
			Point p4 = new Point(firstPoint.x, firstPoint.y + height);
			g.fillRect(firstPoint.x - 5, firstPoint.y - 5, 10, 10);
			g.fillRect(p2.x - 5, p2.y - 5, 10, 10);
			g.fillRect(p3.x - 5, p3.y - 5, 10, 10);
			g.fillRect(p4.x - 5, p4.y - 5, 10, 10);
			g.setColor(color);
		}
		if(fill == 1) {
			g.fill(getShape());
		}
		g.setColor(Color.black);
	}
	



}
