package example_TextReading;

public class MyPDFParser {
	public static void main(String[] args) {
		String text = "Al�c�, T. (2013) Ger�ek Bir Yan�lsama. Bilin�, �stanbul: Metis.";
		boolean istheredoc = text.endsWith(".");
		System.out.println(istheredoc);
		System.out.println(text.length());
	}
}
