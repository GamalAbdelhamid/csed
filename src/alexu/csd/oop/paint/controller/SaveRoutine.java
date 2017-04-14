package alexu.csd.oop.paint.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import alexu.csd.oop.paint.model.MShape;

public class SaveRoutine {
	private File selectedFile;
	private ArrayList<MShape> shapelist = null;
	private Formatter writer = null;
	FileFilter sieve = new FileNameExtensionFilter("JSON files", "json");
	FileFilter sieve2 = new FileNameExtensionFilter("XML files", "xml");

	public void setArray(final ArrayList<MShape> s) {
		shapelist = s;
		System.out.println("save3");
	}

	public void choosePath() {
		XStream serializer = new XStream(new JettisonMappedXmlDriver());
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(sieve);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(new JFrame());
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".json")) {
				selectedFile = new File(fileChooser.getSelectedFile() + ".json");
			}
			try {
				serializer.setMode(XStream.NO_REFERENCES);
				serializer.alias("shapelist", ArrayList.class);
				writer = new Formatter(selectedFile);
				writer.format("%s ", serializer.toXML(shapelist));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.close();
		}
	}

	public void choosePathXML() {
		XStream serializer2 = new XStream(new StaxDriver());
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(sieve2);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(new JFrame());
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".xml")) {
				selectedFile = new File(fileChooser.getSelectedFile() + ".xml");
			}
			try {
				serializer2.setMode(XStream.NO_REFERENCES);
				serializer2.alias("shapelist", ArrayList.class);
				writer = new Formatter(selectedFile);
				writer.format("%s ", serializer2.toXML(shapelist));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.close();
		}
	}

}
