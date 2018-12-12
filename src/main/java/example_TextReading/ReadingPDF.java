package example_TextReading;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingPDF {
	
	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
		PDDocument document = PDDocument.load(new File("C:\\Users\\Tugay\\Desktop\\BitirmeProje\\Denemeler\\test.pdf"));
		if(!document.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			int indexNumber = text.indexOf("KAYNAKÇA");
			String text2 = text.substring(indexNumber);
			String[] text3 = text2.split("\n");
			for(int i=0;i<text3.length;i++) {
				System.out.println(i + " : " + text3[i]);
			}
			System.out.println(text3.length);
		}
		document.close();
	}
	
}
