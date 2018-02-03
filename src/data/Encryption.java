package data;

public abstract class Encryption {
	
	private final String[] ALFABET_LETTERS = {"a","�","b","c","�","d","e","�","f","g","h","j","k","l","�","m","n","�","o","�","p","r","s","�","t","u","v","w","y","z","�","�"};

	public Encryption() {}

	public abstract String encrypt(String text);
	
	public abstract String decrypt(String text);
	
	public abstract String toString();
		
	private String[] getALFABET_LETTERS() {
		return ALFABET_LETTERS;
	}
	
}
