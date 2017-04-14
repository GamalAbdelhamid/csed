package alexu.csd.oop.paint.view;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonIcon {
	private InputStream buttonImage ;
	private ToolBar element1=null;
	private DrawBar element2=null ;
	public ButtonIcon(){

	}

	public void setIcon (final JButton x){
		if(element1!=null){
		if(x.equals(element1.getSave1())||x.equals(element1.getSave2()) ){
			buttonImage = getClass().getResourceAsStream("/IconResources/disk-icon.png");
		}
		if(x.equals(element1.getLoad())){
			buttonImage =getClass().getResourceAsStream("/IconResources/Documents-icon.png");
		}
		if(x.equals(element1.getUndo())){
			buttonImage =getClass().getResourceAsStream("/IconResources/undo-icon.png");
		}
		if(x.equals(element1.getRedo())){
			buttonImage = getClass().getResourceAsStream("/IconResources/redo-icon.png");
		}
		if(x.equals(element1.getclassLoader())){
			buttonImage = getClass().getResourceAsStream("/IconResources/classload.png");
		}
		}
		else if (element2!=null){
		if(x.equals(element2.getLine())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Line-icon.png");
		}
		if(x.equals(element2.getEllipse())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Editing-Ellipse-Stroked-icon.png");
		}
		if(x.equals(element2.getCircle())){
			buttonImage = getClass().getResourceAsStream("/IconResources/playstation-circle-dark-icon.png");
		}
		if(x.equals(element2.getRectangle())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Editing-Rectangle-icon.png");
		}
		if(x.equals(element2.getSquare())){
			buttonImage = getClass().getResourceAsStream("/IconResources/playstation-square-dark-icon.png");
		}
		if(x.equals(element2.getTriangle())){
			buttonImage = getClass().getResourceAsStream("/IconResources/playstation-triangle-dark-icon.png");
		}
		if(x.equals(element2.getMove())){
			buttonImage = getClass().getResourceAsStream("/IconResources/move-icon.png");
		}
		if(x.equals(element2.getFill())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Color-fill-icon.png");
		}
		if(x.equals(element2.getResize())){
			buttonImage = getClass().getResourceAsStream("/IconResources/resize-hor-icon.png");
		}
		if(x.equals(element2.getDelete())){
			buttonImage = getClass().getResourceAsStream("/IconResources/trash-empty-icon.png");
		}
		if(x.equals(element2.getColor())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Color-Meter-icon.png");
		}
		if(x.equals(element2.getSelect())){
			buttonImage = getClass().getResourceAsStream("/IconResources/Cursor-Select-icon.png");
		}
		}

				try {
			 Image logo = ImageIO.read(buttonImage);
			 logo = logo.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
			    x.setIcon(new ImageIcon(logo));
			  } catch (Exception ex) {
			  }
	}
	public void setToolBar(final ToolBar x){
		element1=x;
	}
	public void setDrawBar(final DrawBar y){
		element2=y;
	}

}
