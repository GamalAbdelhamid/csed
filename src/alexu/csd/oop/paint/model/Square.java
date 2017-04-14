package alexu.csd.oop.paint.model;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Square extends Rectangle {
	public Square(final Point first, final Point second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeRectangle() {
		// TODO Auto-generated method stub
		super.makeRectangle();
		if(width < height){
			width = height;
		}
		else{
			height = width;
		}
		shape = new Rectangle2D.Double(firstPoint.x, firstPoint.y, width, height);
	}

}
