package example_TextReading;

public class MyPDFParser {
	public static void main(String[] args) {
		String text = "Alýcý, T. (2013) Gerçek Bir Yanýlsama. Bilinç, Ýstanbul: Metis.";
		boolean istheredoc = text.endsWith(".");
		System.out.println(istheredoc);
		System.out.println(text.length());
	}
}
