package alexu.csd.oop.paint.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel{
	private JButton saveBtn1 ;
	private JButton saveBtn2 ;
	private JButton loadBtn ;
	private JButton undoBtn ;
	private JButton redoBtn ;
	private JButton classLoaderBtn ;
	private String required = null;
	private Color Default;
	private ButtonIcon injectImage = new ButtonIcon();

	public ToolBar(){
		this.setBounds(150, 0, 600, 30);
		this.setLayout(new GridLayout(1, 12, 8, 5));
		this.setBackground(new Color(72,61,139));
		injectImage.setToolBar(this);
		 saveBtn1 = new JButton("JSON Save");
		 injectImage.setIcon(saveBtn1);
		 saveBtn2 = new JButton("XML Save");
		 injectImage.setIcon(saveBtn2);
		 loadBtn = new JButton("Load");
		 injectImage.setIcon(loadBtn);;
		 undoBtn = new JButton("Undo");
		 injectImage.setIcon(undoBtn);
		 redoBtn = new JButton("Redo");
		 injectImage.setIcon(redoBtn);
		 classLoaderBtn = new JButton("LoadClass");
		 injectImage.setIcon(classLoaderBtn);
		 Default = saveBtn1.getBackground();
		this.add(saveBtn1);
		this.add(saveBtn2);
		this.add(loadBtn);
		this.add(undoBtn);
		this.add(redoBtn);
		this.add(classLoaderBtn);
	}

	public void  setRequired(final String s){
 		required = s;
 	}
	public JButton getSave1(){
		return saveBtn1;
	}
	public JButton getSave2(){
		return saveBtn2;
	}
	public JButton getLoad(){
		return loadBtn;
	}
	public JButton getUndo(){
		return undoBtn;
	}
	public JButton getRedo(){
		return redoBtn;
	}
	public JButton getclassLoader(){
		return classLoaderBtn;
	}

}
