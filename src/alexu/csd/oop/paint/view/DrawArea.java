package alexu.csd.oop.paint.view;
import alexu.csd.oop.paint.model.*;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.List;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.event.ListSelectionListener;

public class DrawArea extends JComponent
	implements MouseListener, MouseMotionListener {
	private DrawBar barObject;
	private String required = null;
	private ArrayList<MShape> list = new ArrayList<>();
	private Point first,second, third;
	private int start = 0;
	private int selectIndex = -1;
	private Point curPoint1 = new Point();
	private Point curPoint2 = new Point();
	private Point curPoint3 = new Point();
	private Stack<ArrayList<MShape>> undo = new Stack<>();
	private Stack<ArrayList<MShape>> redo = new Stack<>();
	int undoFlag = 0;
	int redoFlag = 0;

	public DrawArea() {
		this.setBounds(110, 50, 1150, 600);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		storeState();
	}

	@Override
	public final void paintComponent(final Graphics g) {
		if(list == null) {
			this.setBackground(Color.white);
		}
		else {
			Graphics2D G = (Graphics2D) g;
			for(int k = 0; k < list.size(); k ++){
				Graphics2D m = (Graphics2D) g;
				m.setStroke(new BasicStroke(2.0f));
				m.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				list.get(k).draw(m);
			}
		}
	}




	@Override
	public void mouseDragged(final MouseEvent e) {
		// TODO Auto-generated method stub
		if(required == "resize" && selectIndex >= 0){
			list.get(selectIndex).setSecondPoint(e.getPoint());
			repaint();
		}
		else if(required == "move" && selectIndex >= 0) {
			second = e.getPoint();
			list.get(selectIndex).setFirstPoint(new Point(curPoint1.x + (second.x - first.x), curPoint1.y + (second.y - first.y)));
			list.get(selectIndex).setSecondPoint(new Point(curPoint2.x + (second.x - first.x), curPoint2.y + (second.y - first.y)));
			list.get(selectIndex).setThirdPoint(new Point(curPoint3.x + (second.x - first.x), curPoint3.y + (second.y - first.y)));
			
			repaint();
		}

	}

	@Override
	public void mouseMoved(final MouseEvent e) {
		// TODO Auto-generated method stub
		if(start == 1){
		if(required == "line"){
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}
		else if(required == "rectangle"){
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}

		else if(required == "square"){
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}
		else if(required == "circle"){
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}
		else if(required == "ellipse"){
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}
		else if(required == "triangle") {
			second = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(second);
			repaint();
		}
		}
		if(required == "triangle" && start == 2) {
			third = e.getPoint();
			list.get(list.size() - 1).setSecondPoint(third);
			list.get(list.size() - 2).setSecondPoint(third);
			repaint();
		}

	}

	@Override
	public void mouseClicked(final MouseEvent e) {
		// TODO Auto-generated method stub
		
			if(required == "line" && start == 0){
				first = e.getPoint();
				second = e.getPoint();
				list.add(new Line(first, second));
				start = 1;
			}
			else if(required == "rectangle" && start == 0) {
				first = e.getPoint();
				second = e.getPoint();
				list.add(new alexu.csd.oop.paint.model.Rectangle(first, second));
				start = 1;
			}
			else if(required == "square" && start == 0){
				first = e.getPoint();
				second = e.getPoint();
				list.add(new Square(first, second));
				start = 1;
			}
			else if(required == "circle" && start == 0){
				first = e.getPoint();
				second = e.getPoint();
				list.add(new Circle(first, second));
				start = 1;
			}
			else if(required == "ellipse" && start == 0){
				first = e.getPoint();
				second = e.getPoint();
				list.add(new Ellipse(first, second));
				start = 1;
			}
			else if(required == "triangle" && start == 0) {
				first = e.getPoint();
				second = e.getPoint();
				list.add(new Line(first, second));
				start = 1;
			}
			else if(required == "triangle" && start == 1) {
			second = e.getPoint();
			third = e.getPoint();
			list.add(new Line(list.get(list.size() - 1).getFirstPoint(), third));
			list.add(new Line(list.get(list.size() - 1).getSecondPoint(), third));
			start = 2;
			}
			else if(required == "triangle" && start == 2) {
			start = 0;
			list.add(new Triangle(list.get(list.size() - 1).getFirstPoint(), list.get(list.size() - 1).getSecondPoint(), list.get(list.size() - 2).getFirstPoint()));
			list.remove(list.size() - 2);
			list.remove(list.size() - 2);
			list.remove(list.size() - 2);
			storeState();
			required = null;
			}

			else if(required != null && start == 1) {
			storeState();
			required = null;
			start = 0;
			}
			else if(required == "select") {
				for(int i = list.size() - 1; i >= 0; i --) {
					if(list.get(i).getShape().contains(e.getPoint())) {
						list.get(i).select(1);
						selectIndex = i;
						first = list.get(i).getFirstPoint();
						curPoint1 = list.get(i).getFirstPoint();
						curPoint2 = list.get(i).getSecondPoint();
						curPoint3 = list.get(i).getThirdPoint();
						break;
					}
					int x[] = new int[3];
					int y[] = new int[3];
					x[0] = list.get(i).getFirstPoint().x;
					x[1] = list.get(i).getSecondPoint().x - 15;
					x[2] = list.get(i).getSecondPoint().x + 15;
					y[0] = list.get(i).getFirstPoint().y;
					y[1] = list.get(i).getSecondPoint().y + 15;
					y[2] = list.get(i).getSecondPoint().y - 15;
					if(new Polygon(x, y, 3).contains(e.getPoint())) {
						list.get(i).select(1);
						selectIndex = i;
						curPoint1 = list.get(i).getFirstPoint();
						curPoint2 = list.get(i).getSecondPoint();
						curPoint3 = list.get(i).getThirdPoint();
						break;
					}
				}
				required = null;
			}
			else{
				setRequired(null);
			}
			barObject.setRequired(required);
			repaint();
	}

	@Override
	public void mouseEntered(final MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub
		if(start == 1) {
			start = 0;
			setRequired(null);
		}

	}

	@Override
	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub
		//setRequired(null);
		//selectIndex = -1;
		if((required == "resize" || required == "move") && selectIndex >= 0) {
			setRequired(null);
			storeState();
		}


	}

	public ArrayList<MShape> setRequired(final String s) {
		required = s;
		barObject.setRequired(required);
		repaint();
		if(required != "color" && required != "move" && required != "resize" && required != "delete" && required !="fill" && selectIndex != -1) {
			list.get(selectIndex).select(0);
			selectIndex = -1;
			return null;
		}
		if(required.equals("save1")){
			System.out.println("save2");
			return list;
		}
		if(required.equals("save2")){
			System.out.println("save2");
			return list;
		}
		if(required.equals("load")){
			return list;
		}
		return null;
	}

	public void setBarObject(final DrawBar object){
		this.barObject = object;
	}

	public ArrayList<MShape> getList() {
		return list;
	}
	public void setList(final ArrayList<MShape> temp) {
	      list=temp;
	}
	public int getSelectIndex() {
		return selectIndex;
	}


	public void storeState() {
		ArrayList<MShape> l = new ArrayList<>();
		redo.clear();
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i) instanceof Line) {
				Line newLine = new Line(list.get(i).getFirstPoint(), list.get(i).getSecondPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
			else if(list.get(i) instanceof Square) {
				Square newLine = new Square(list.get(i).getFirstPoint(), list.get(i).getSecondPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
			else if(list.get(i) instanceof Circle) {
				Circle newLine = new Circle(list.get(i).getFirstPoint(), list.get(i).getSecondPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
			else if(list.get(i) instanceof alexu.csd.oop.paint.model.Rectangle) {
				alexu.csd.oop.paint.model.Rectangle newLine = new alexu.csd.oop.paint.model.Rectangle(list.get(i).getFirstPoint(), list.get(i).getSecondPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
			else if(list.get(i) instanceof Triangle) {
				Triangle newLine = new Triangle(list.get(i).getFirstPoint(), list.get(i).getSecondPoint(), list.get(i).getThirdPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
			else if(list.get(i) instanceof Ellipse) {
				Ellipse newLine = new Ellipse(list.get(i).getFirstPoint(), list.get(i).getSecondPoint());
				newLine.setColor(list.get(i).getColor());
				newLine.setFill(list.get(i).getFill());
				l.add(newLine);
			}
		}
		undo.push(l);
	}

	public void undo() {
		list.clear();
		ArrayList<MShape> l = new ArrayList<>();
		repaint();
		if(undo.size() > 0) {
			if(undoFlag == 0) {
				redo.push(undo.pop());
				undoFlag = 1;
				redoFlag = 0;
			}
			l = undo.pop();
			for(int i = 0; i < l.size(); i ++) {
				if(l.get(i) instanceof Line) {
					Line newLine = new Line(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Square) {
					Square newLine = new Square(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Circle) {
					Circle newLine = new Circle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof alexu.csd.oop.paint.model.Rectangle) {
					alexu.csd.oop.paint.model.Rectangle newLine = new alexu.csd.oop.paint.model.Rectangle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Triangle) {
					Triangle newLine = new Triangle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint(), l.get(i).getThirdPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Ellipse) {
					Ellipse newLine = new Ellipse(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
			}
			redo.push(l);
			repaint();
		}
		
		
	}
	public void redo() {
		if(redo.size() > 0) {
			list.clear();
			ArrayList<MShape> l = new ArrayList<>();
			repaint();
			if(redoFlag == 0) {
				undo.push(redo.pop());
				redoFlag = 1;
				undoFlag = 0;
			}
			l = redo.pop();
			for(int i = 0; i < l.size(); i ++) {
				if(l.get(i) instanceof Line) {
					Line newLine = new Line(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Square) {
					Square newLine = new Square(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Circle) {
					Circle newLine = new Circle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof alexu.csd.oop.paint.model.Rectangle) {
					alexu.csd.oop.paint.model.Rectangle newLine = new alexu.csd.oop.paint.model.Rectangle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Triangle) {
					Triangle newLine = new Triangle(l.get(i).getFirstPoint(), l.get(i).getSecondPoint(), l.get(i).getThirdPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
				else if(l.get(i) instanceof Ellipse) {
					Ellipse newLine = new Ellipse(l.get(i).getFirstPoint(), l.get(i).getSecondPoint());
					newLine.setColor(l.get(i).getColor());
					newLine.setFill(l.get(i).getFill());
					list.add(newLine);
				}
			}
			undo.push(l);
			repaint();

		}
	}
	public void setUndoFlag(int flag) {
		undoFlag = flag;
	}
	public int getUndoFlag() {
		return undoFlag;
	}
	public void setRedoFlag(int flag) {
		redoFlag = flag;
	}
	public int getRedoFlag() {
		return redoFlag;
	}
}
