package alexu.csd.oop.paint.model;
import java.awt.*;

import javax.swing.RepaintManager;

public abstract class MShape {

	 protected Point firstPoint;
	 protected Point secondPoint;
	 protected Point thirdPoint = new Point(0, 0);
     protected Color color;
     protected Shape shape;
     protected int select;
     protected int fill;



    public Point getFirstPoint() {
		return firstPoint;
	}

	public void setFirstPoint(final Point first) {
		this.firstPoint = first;
	}

	public Point getSecondPoint(){
		return this.secondPoint;
	}

	public void setSecondPoint(final Point second) {
		this.secondPoint = second;
	}
	public void setThirdPoint(Point third) {
		this.thirdPoint = third;
	}
	public Point getThirdPoint() {
		return thirdPoint;
	}

	public Shape getShape() {
		return shape;
	}

    public void setColor(final Color color){
        this.color = color;
    }
    public Color getColor(){
        return color ;
    }
    public void draw(final Graphics2D g) {

    }
    public void select(int select) {
    	this.select = select;
    }
    public void fill(int fill, Color c) {
    	this.fill = fill;
    	this.color = c;
    }
    public int getSelect() {
    	return select;
    }
    public int getFill() {
    	return fill;
    }
    public void setFill(int fill) {
    	this.fill = fill;
    }
    public void setShape(Shape s) {
    	this.shape = s;
    }
}