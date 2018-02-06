package data;

public abstract class Encryption {

	protected final String[] ALFABET_LETTERS = { "a", "�", "b", "c", "�", "d", "e", "�", "f", "g", "h", "i", "j", "k",
			"l", "�", "m", "n", "�", "o", "�", "p", "r", "s", "�", "t", "u", "v", "w", "y", "z", "�", "�" };
	protected final String[] UPPER_ALFABET_LETTERS = { "A", "�", "B", "C", "�", "D", "E", "�", "F", "G", "H", "I", "J",
			"K", "L", "�", "M", "N", "�", "O", "�", "P", "R", "S", "�", "T", "U", "V", "W", "Y", "Z", "�", "�" };
	
	public Encryption() {}

	public abstract String encrypt(String text,String key);
	
	public abstract String decrypt(String text,String key);
	
	public abstract String toString();
	
}
