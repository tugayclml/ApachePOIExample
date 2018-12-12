package example_TextReading;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ReadingWord {


	private static XWPFWordExtractor extractor;

	public static void main(String[] args) throws Exception {
		 try {
			   FileInputStream fis = new FileInputStream("C:\\Users\\Tugay\\Desktop\\BitirmeProje\\Denemeler\\test2.docx");
			   XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			   extractor = new XWPFWordExtractor(xdoc);
			   String text = extractor.getText();
			   int indexNumber = text.indexOf("KAYNAKÇA");
			   String text2 = text.substring(indexNumber);
			   String[] text4 = text2.split("\n");
			   
			   
			   List<String> sources = new ArrayList<String>();
			   
			   for(int i=0;i<text4.length;i++) {
				   sources.add(text4[i]);
			   }
			   
			   for(int i=0;i<sources.size();i++) {
				   System.out.println(i + ". source : " + sources.get(i));
			   }
			   
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   
			   List<String> newSources = new ArrayList<String>();
			   CharSequence cs = "http://";
			   CharSequence cs2 = "https://";
			   
			   for(int i=0;i<sources.size();i++) {
				   String sc = sources.get(i);
				   System.out.println("sources.get("+i+") : " + sc);
				   boolean istheredoc = sc.endsWith(". ");
				   System.out.println("Noktasý var mý : " + istheredoc);
				   if(istheredoc) {
					   newSources.add(sources.get(i));
				   }else {
					   if( sources.get(i).contains(cs)||sources.get(i).contains(cs2) ) {
						   boolean isthereanyhttp = sources.get(i).contains(cs);
						   boolean isthereanyhttps = sources.get(i).contains(cs2);
						   System.out.println("isthereanyhttp : " + isthereanyhttp);
						   System.out.println("isthereanyhttps : " + isthereanyhttps);
						   newSources.add(sources.get(i));
					   }else {
						   String birlestir = sources.get(i);
						   if(i<sources.size()) {
							   birlestir +=  sources.get(i+1);
							   sources.remove(i+1);
						   }
						   System.out.println("Birlestir : " + birlestir);
						   newSources.add(birlestir);
					   }
				   }
			   }
			   
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("***************************************************");
			   System.out.println("Kaynaklarýn sayýsý : " + newSources.size());
			   for(int i=0;i<newSources.size();i++) {
				   System.out.println(i + " : " + newSources.get(i));
			   }
			   
			   
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
	        
	        
	  }
}
