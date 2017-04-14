package alexu.csd.oop.paint.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

import alexu.csd.oop.paint.controller.LoadRoutine;
import alexu.csd.oop.paint.controller.SaveRoutine;
import alexu.csd.oop.paint.model.MShape;

public class GUI extends JFrame implements ActionListener{
	private DrawBar drawBar = new DrawBar();
	private ToolBar toolBar = new ToolBar();
	private DrawArea drawArea = new DrawArea();
	ArrayList<MShape> list = new ArrayList<>();
	Graphics f = getGraphics();
	int select = 1;

	public GUI() {
		drawArea.setBarObject(drawBar);
		String required = null;
		this.setVisible(true);
		this.setTitle("Paint");
		this.setSize(1300, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		this.add(drawBar,BorderLayout.WEST);
		this.add(toolBar,BorderLayout.NORTH);
		this.add(drawArea,BorderLayout.CENTER);
		drawBar.getCircle().addActionListener(this);
		drawBar.getLine().addActionListener(this);
		drawBar.getEllipse().addActionListener(this);
		drawBar.getRectangle().addActionListener(this);
		drawBar.getSquare().addActionListener(this);
		drawBar.getTriangle().addActionListener(this);
		toolBar.getSave1().addActionListener(this);
		toolBar.getSave2().addActionListener(this);
		toolBar.getLoad().addActionListener(this);
		toolBar.getUndo().addActionListener(this);
		toolBar.getRedo().addActionListener(this);
		drawBar.getSelect().addActionListener(this);
		drawBar.getColor().addActionListener(this);
		drawBar.getFill().addActionListener(this);
		drawBar.getDelete().addActionListener(this);
		drawBar.getMove().addActionListener(this);
		drawBar.getResize().addActionListener(this);


	}

	public static void main(final String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() != toolBar.getUndo() && e.getSource() != toolBar.getRedo()) {
			if(drawArea.getUndoFlag() == 1 ) {
				drawArea.storeState();
				drawArea.setUndoFlag(0);
				drawArea.setRedoFlag(0);
			}
		}
		if(e.getSource() == drawBar.getLine()){
				drawBar.setRequired("line");
				drawArea.setRequired("line");
		}
		else if(e.getSource() == drawBar.getCircle()) {
			drawBar.setRequired("circle");
			drawArea.setRequired("circle");
		}
		else if(e.getSource() == drawBar.getRectangle()) {
			drawBar.setRequired("rectangle");
			drawArea.setRequired("rectangle");
		}
		else if(e.getSource() == drawBar.getSquare()) {
			drawBar.setRequired("square");
			drawArea.setRequired("square");
		}
		else if(e.getSource() == drawBar.getEllipse()) {
			drawBar.setRequired("ellipse");
			drawArea.setRequired("ellipse");
		}
		else if(e.getSource() == drawBar.getTriangle()) {
			drawBar.setRequired("triangle");
			drawArea.setRequired("triangle");
		}
		else if(e.getSource() == drawBar.getSelect()) {
			drawBar.setRequired("select");
			drawArea.setRequired("select");
		}
		else if(e.getSource() == drawBar.getDelete()) {
			drawArea.getList().remove(drawArea.getSelectIndex());
			drawArea.storeState();
			repaint();
		}
		else if(e.getSource() == drawBar.getResize()) {
			drawBar.setRequired("resize");
			drawArea.setRequired("resize");

		}
		else if(e.getSource() == drawBar.getColor()) {
			Color c = JColorChooser.showDialog(null, "Choose a Color", Color.green);
			drawArea.getList().get(drawArea.getSelectIndex()).setColor(c);
			drawArea.storeState();
			drawArea.setRequired(null);
			drawBar.setRequired(null);
			repaint();
		}
		else if(e.getSource() == drawBar.getMove()) {
			drawArea.setRequired("move");
		}
		else if(e.getSource() == drawBar.getFill()) {
			Color c = JColorChooser.showDialog(null, "Choose a Color", Color.green);
			drawArea.getList().get(drawArea.getSelectIndex()).fill(1, c);
			drawArea.storeState();
			drawArea.setRequired(null);
			drawBar.setRequired(null);
			repaint();
		}
		else if(e.getSource() == toolBar.getUndo()) {
			drawArea.undo();

		}
		else if(e.getSource() == toolBar.getRedo()) {
			drawArea.redo();
		}
		else if(e.getSource() == toolBar.getSave1()) {
			SaveRoutine save = new SaveRoutine();
			System.out.println("save1");
			save.setArray(drawArea.setRequired("save1"));
			save.choosePath();

		}
		else if(e.getSource() == toolBar.getSave2()) {
			SaveRoutine save = new SaveRoutine();
			System.out.println("save1");
			save.setArray(drawArea.setRequired("save2"));
			save.choosePathXML();

		}
		else if(e.getSource() == toolBar.getLoad()) {
			System.out.println("Load 1");
			LoadRoutine load = new LoadRoutine();
			load.readFiles();
			drawArea.setList(load.sendArray(drawArea.setRequired("load")));
			repaint();
			drawArea.storeState();
		}
		else{
			drawBar.setRequired("null");
		}

	}

}
