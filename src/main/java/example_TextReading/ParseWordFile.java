package example_TextReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.findSource.FindEditorSource;
import com.findSource.FindMessageFromForum;
import com.findSource.FindThesisSource;
import com.findSource.FindTranslateSource;
import com.findSource.FindWebSiteSource;

public class ParseWordFile {

	private static XWPFWordExtractor extractor;

	public static void main(String[] args) {

		String text = null;
		String pathName = "C:\\Users\\Tugay\\Desktop\\BitirmeProje\\";

		try {

			FileInputStream file = new FileInputStream(pathName+ "test2.docx");
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(file));
			extractor = new XWPFWordExtractor(xdoc);
			text = extractor.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int lastIndexNumber = text.lastIndexOf("KAYNAKÇA");
		System.out.println(text.lastIndexOf("KAYNAKÇA"));
		System.out.println(text.substring(lastIndexNumber));

		String text2 = text.substring(lastIndexNumber);
		String[] source = text2.split("\n");
		List<String> sources = new ArrayList<String>();

		for (int i = 0; i < source.length; i++) {
			if (source[i] != "") {
				sources.add(source[i]);
			}
		}

		System.out.println("Sources size : " + sources.size());

		for (int i = 0; i < sources.size(); i++) {
			System.out.println(i + ". " + sources.get(i));
		}

		List<String> newSources = new ArrayList<String>();
		CharSequence cs = "http://";
		CharSequence cs2 = "https://";

		for (int i = 1; i < sources.size(); i++) {
			String sc = sources.get(i);
			System.out.println("sources.get(" + i + ") : " + sc);
			boolean istheredoc = sc.endsWith(".");
			System.out.println("Noktasý var mý : " + istheredoc);
			if (istheredoc) {
				newSources.add(sources.get(i));
			} else {
				if (sources.get(i).contains(cs) || sources.get(i).contains(cs2)) {
					boolean isthereanyhttp = sources.get(i).contains(cs);
					boolean isthereanyhttps = sources.get(i).contains(cs2);
					System.out.println("isthereanyhttp : " + isthereanyhttp);
					System.out.println("isthereanyhttps : " + isthereanyhttps);
					newSources.add(sources.get(i));
				} else {
					String birlestir = sources.get(i);
					if (i < sources.size()) {
						birlestir += sources.get(i + 1);
						sources.remove(i + 1);
					}
					System.out.println("Birlestir : " + birlestir);
					newSources.add(birlestir);
				}
			}
		}
		
		File file,file2,file3,file4,file5,file6;
		FileWriter fw,fw2,fw3,fw4,fw5,fw6;
		String newline = System.getProperty("line.separator");
		
		//===============================================================================
		
		try {
			file = new File(pathName+ "kaynakça.txt");
			fw = new FileWriter(file);
			for (int i = 0; i < newSources.size(); i++) {
				fw.write(i + ".  kaynak : " + newSources.get(i) + newline);
				fw.write("\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//===============================================================================
		
		FindEditorSource findEditor = new FindEditorSource();
		List<String> editorSource = new ArrayList<String>();
		editorSource = findEditor.findEditorSource(newSources);
		
		try {
			file2 = new File(pathName+"editörlükaynak.txt");
			fw2 = new FileWriter(file2);
			for(int i=0;i<editorSource.size();i++) {
				fw2.write(i + ". kaynak : " + editorSource.get(i) + newline);
				fw2.write("\n");
			}
			fw2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//===============================================================================
		
		FindTranslateSource findTranslateSource = new FindTranslateSource();
		List<String> translateSource = new ArrayList<String>();
		translateSource = findTranslateSource.findTranslateSource(newSources);
		
		try {
			file3 = new File(pathName+"translateSource.txt");
			fw3 = new FileWriter(file3);
			for(int i=0;i<translateSource.size();i++) {
				fw3.write(i + ". kaynak : " + translateSource.get(i) + newline);
				fw3.write("\n");
			}
			fw3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//===============================================================================
		
		FindMessageFromForum findMessageFromForum = new FindMessageFromForum();
		List<String> forumSource = new ArrayList<String>();
		forumSource = findMessageFromForum.findMessageFromForum(newSources);
		
		try {
			file4 = new File(pathName+"forumSource.txt");
			fw4 = new FileWriter(file4);
			for(int i=0;i<forumSource.size();i++) {
				fw4.write(i + ". kaynak : " + forumSource.get(i) + newline);
				fw4.write("\n");
			}
			fw4.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//===============================================================================
		FindWebSiteSource findWebSiteSource = new FindWebSiteSource();
		List<String> webSiteSource = new ArrayList<String>();
		webSiteSource = findWebSiteSource.findWebSiteSource(newSources);
		
		try {
			file5 = new File(pathName + "websiteSource.txt");
			fw5 = new FileWriter(file5);
			for(int i=0;i<webSiteSource.size();i++) {
				fw5.write(i + ". kaynak : " + webSiteSource.get(i) + newline);
				fw5.write("\n");
			}
			fw5.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//===============================================================================
		
		FindThesisSource findThesisSource = new FindThesisSource();
		List<String> thesisSource = new ArrayList<String>();
		thesisSource = findThesisSource.findThesisSource(newSources);
		try {
			file6 = new File(pathName + "thesisSource.txt");
			fw6 = new FileWriter(file6);
			for(int i=0;i<thesisSource.size();i++) {
				fw6.write(i + ". kaynak : " + thesisSource.get(i) + newline);
				fw6.write("\n");
			}
			fw6.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
