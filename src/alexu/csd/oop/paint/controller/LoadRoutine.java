package alexu.csd.oop.paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import alexu.csd.oop.paint.model.MShape;

public class LoadRoutine {
	private File selectedFile;
	private ArrayList<MShape> shapelist = null;
	private Formatter writer = null;
	private FileFilter sieve = new FileNameExtensionFilter("JSON files", "json");
	private FileFilter sieve2 = new FileNameExtensionFilter("XML files", "xml");
	private String stream = null;

	public ArrayList<MShape> sendArray(final ArrayList<MShape> substitute) {
		if (shapelist != null) {
			return shapelist;
		} else {
			return substitute;
		}
	}

	public void readFiles() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(sieve);
		fileChooser.setFileFilter(sieve2);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(new JFrame());
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			if (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".json")) {
				XStream deserializer = new XStream(new JettisonMappedXmlDriver());
				deserializer.alias("shapelist", ArrayList.class);
				deserializer.alias("firstPoint", Point.class);
				deserializer.alias("secondPoint", Point.class);
				deserializer.alias("thirdPoint", Point.class);
				deserializer.alias("color", Color.class);
				shapelist = (ArrayList) deserializer.fromXML(selectedFile);
			}

			else if (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".xml")) {
				XStream deserializer = new XStream(new StaxDriver());
				deserializer.alias("shapelist", ArrayList.class);
				deserializer.alias("firstPoint", Point.class);
				deserializer.alias("secondPoint", Point.class);
				deserializer.alias("thirdPoint", Point.class);
				deserializer.alias("color", Color.class);
				shapelist = (ArrayList) deserializer.fromXML(selectedFile);
			}

			else {
				JOptionPane.showMessageDialog(null,
						"This file format isnot supported please" + " choose XML or JSON files");
			}

		}
	}
}
