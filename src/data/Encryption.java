package data;

public abstract class Encryption {
	
	private final String[] ALFABET_LETTERS = {"a","¹","b","c","æ","d","e","ê","f","g","h","j","k","l","³","m","n","ñ","o","ó","p","r","s","œ","t","u","v","w","y","z","Ÿ","¿"};

	public Encryption() {}

	public abstract String encrypt(String text);
	
	public abstract String decrypt(String text);
	
	public abstract String toString();
		
	private String[] getALFABET_LETTERS() {
		return ALFABET_LETTERS;
	}
	
}
