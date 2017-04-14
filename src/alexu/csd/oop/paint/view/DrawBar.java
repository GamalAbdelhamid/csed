package alexu.csd.oop.paint.view;

 import java.awt.Color;
 import java.awt.GridLayout;
 import java.awt.Image;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.IOException;

 import javax.imageio.ImageIO;
 import javax.swing.Icon;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JPanel;

 public class DrawBar extends JPanel {
 	private String required = null;
 	private JButton lineBtn;
 	private JButton circleBtn;
 	private JButton ellipseBtn;
 	private JButton rectangleBtn;
 	private JButton squareBtn;
 	private JButton triangleBtn;
 	private final Color Default;
	private JButton selectBtn;
	private JButton moveBtn;
	private JButton resizeBtn;
	private JButton deleteBtn;
	private JButton colorBtn;
	private JButton fillBtn;
	private ButtonIcon injectImage = new ButtonIcon();
	private boolean classLoaderActive = false;

 	public DrawBar(){
 		this.setBounds(0, 50, 105, 620);
		this.setLayout(new GridLayout(15, 1, 10, 10));
 		this.setBackground(new Color(72,61,139));
 		injectImage.setDrawBar(this);
 	    lineBtn = new JButton("Line");
 	     injectImage.setIcon(lineBtn);
 		circleBtn = new JButton("Circle");
 		 injectImage.setIcon(circleBtn);
 		ellipseBtn = new JButton("Ellipse");
 		 injectImage.setIcon(ellipseBtn);
 		rectangleBtn = new JButton("Rectangle");
 		 injectImage.setIcon(rectangleBtn);
 		squareBtn = new JButton("Square");
 		 injectImage.setIcon(squareBtn);
 		triangleBtn = new JButton("Triangle");
 		 injectImage.setIcon(triangleBtn);
		selectBtn = new JButton("Select");
		 injectImage.setIcon(selectBtn);
		moveBtn = new JButton("Move");
		 injectImage.setIcon(moveBtn);
		resizeBtn = new JButton("Resize");
		 injectImage.setIcon(resizeBtn);
		deleteBtn = new JButton("Delete");
		 injectImage.setIcon(deleteBtn);
		colorBtn = new JButton("Color");
		 injectImage.setIcon(colorBtn);
		fillBtn = new JButton("Fill");
		 injectImage.setIcon(fillBtn);
 	    Default = triangleBtn.getBackground();
 	    this.add(lineBtn);
 		this.add(ellipseBtn);
 		this.add(circleBtn);
 		this.add(rectangleBtn);
 		this.add(squareBtn);
 		this.add(triangleBtn);
		this.add(selectBtn);
		this.add(moveBtn);
		this.add(resizeBtn);
		this.add(deleteBtn);
		this.add(colorBtn);
		this.add(fillBtn);
 	}


 	 public void  setRequired(final String s){
 		required = s;
 		returnshadows();
 	}
 	 public String getRequired(){
 		 return required;
 	 }
 	 private void returnshadows() {
 		 if(required == "line"){
 			 lineBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 lineBtn.setBackground(Default);
 		 }
 		 if(required == "circle"){
 			 circleBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 circleBtn.setBackground(Default);
 		 }
 		 if(required == "ellipse"){
 			 ellipseBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 ellipseBtn.setBackground(Default);
 		 }
 		 if(required == "rectangle"){
 			 rectangleBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 rectangleBtn.setBackground(Default);
 		 }
 		 if(required == "square"){
 			 squareBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 squareBtn.setBackground(Default);
 		 }
 		 if(required == "triangle"){
 			 triangleBtn.setBackground(Color.GRAY);
 		 }
 		 else{
 			 triangleBtn.setBackground(Default);
 		 }
 		 if(required == "select"){
 			 selectBtn.setBackground(Color.GRAY);
 		 }
 		 else{
			 selectBtn.setBackground(Default);
		 }
 		if(required == "move"){
			 moveBtn.setBackground(Color.GRAY);
		 }
		 else{
			 moveBtn.setBackground(Default);
		 }
 		if(required == "resize"){
			 resizeBtn.setBackground(Color.GRAY);
		 }
		 else{
			 resizeBtn.setBackground(Default);
		 }
 		if(required == "delete"){
			 deleteBtn.setBackground(Color.GRAY);
		 }
		 else{
			 deleteBtn.setBackground(Default);
		 }
 		if(required == "color"){
			 colorBtn.setBackground(Color.GRAY);
		 }
		 else{
			 colorBtn.setBackground(Default);
		 }
 	 }

 	 public void classLoaderViewer(){
// 		 if(required == "classLoader" && classLoaderActive == false){
// 			 classLoaderActive = true;
// 		 }
// 		 else if(classLoaderActive == true){
//			  if(required == "circle"){
//		 			 circleBtn.setVisible(true);
//		 			 required = null;
//		 			 classLoaderActive = false;
//			 }
//			  if(required == "rectangle"){
//		 			 rectangleBtn.setVisible(true);
//		 			required = null;
//		 			 classLoaderActive = false;
//			 }
//			  if(required == "square"){
//		 			 squareBtn.setVisible(true);
//		 			required = null;
//		 			 classLoaderActive = false;
//			 }
//			  if(required == "triangle"){
//		 			 triangleBtn.setVisible(true);
//		 			required = null;
//		 			 classLoaderActive = false;
//			 }
//		 }



 	 }
 	 //getter suite
 	 public JButton getLine(){
 		 return lineBtn;
 	 }
 	 public JButton getSquare(){
 		 return squareBtn;
 	 }
 	 public JButton getTriangle(){
 		 return triangleBtn;
 	 }
 	 public JButton getEllipse(){
 		 return ellipseBtn;
 	 }
 	 public JButton getCircle(){
 		 return circleBtn;
 	 }
 	 public JButton getRectangle(){
 		 return rectangleBtn;
 	 }
	 public JButton getDelete(){
		 return deleteBtn;
	 }
	 public JButton getColor(){
		 return colorBtn;
	 }
	 public JButton getSelect(){
		 return selectBtn;
	 }
	 public JButton getMove(){
		 return moveBtn;
	 }
	 public JButton getResize(){
		 return resizeBtn;
	 }
	 public JButton getFill() {
		 return fillBtn;
	 }

 }