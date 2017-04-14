package alexu.csd.oop.paint.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Point;

public class ColourPalette {
	public BasicStroke getStroke(final int x) {
		BasicStroke type = null;
		switch (x) {
		case 1:
			type = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER, 10.0f);
			break;
		case 2:
			type = new BasicStroke(1.0f, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_BEVEL, 10.0f);
			break;
		case 3:
			type = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_ROUND, 10.0f);
			break;

		}
		return type;
	}
	public GradientPaint getGradient(final Point start,final Point finish,final Color from, final Color to){
		GradientPaint lamina = new GradientPaint(start.x,start.y,from,finish.x,finish.y,to);
		return lamina ;
	}

}
