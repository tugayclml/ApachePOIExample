package example_TextReading;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ExtractDocxDocument {
	XWPFWordExtractor extractor;
	String text = null;

	public String readDocxDocument(String path) {
		
		try {
			FileInputStream file = new FileInputStream(path);
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(file));
			extractor = new XWPFWordExtractor(xdoc);
			text = extractor.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
	public List<String> startWithReferences(String text){
		int lastIndexNumber = text.lastIndexOf("KAYNAK�A");

		String text2 = text.substring(lastIndexNumber+8);
		String[] refenrence = text2.split("\n");
		List<String> references = new ArrayList<String>();

		for (int i = 0; i < refenrence.length; i++) {
			String s = refenrence[i].trim();
			if (s.length()!=0) {
				references.add(s);
			}
		}
		
		List<String> newSources = new ArrayList<String>();
		CharSequence cs = "http://";
		CharSequence cs2 = "https://";

		for (int i = 1; i < references.size(); i++) {
			String sc = references.get(i);
			boolean istheredoc = sc.endsWith(".");
			if (istheredoc) {
				newSources.add(references.get(i));
			} else {
				if (references.get(i).contains(cs) || references.get(i).contains(cs2)) {
					boolean isthereanyhttp = references.get(i).contains(cs);
					boolean isthereanyhttps = references.get(i).contains(cs2);
					newSources.add(references.get(i));
				} else {
					String birlestir = references.get(i);
					if (i < references.size()) {
						birlestir += references.get(i + 1);
						references.remove(i + 1);
					}
					newSources.add(birlestir);
				}
			}
		}
		
		return references;
	}
	
	
}
