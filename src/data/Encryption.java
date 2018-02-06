package data;

public abstract class Encryption {

	protected final String[] ALFABET_LETTERS = { "a", "π", "b", "c", "Ê", "d", "e", "Í", "f", "g", "h", "i", "j", "k",
			"l", "≥", "m", "n", "Ò", "o", "Û", "p", "r", "s", "ú", "t", "u", "v", "w", "y", "z", "ü", "ø" };
	protected final String[] UPPER_ALFABET_LETTERS = { "A", "•", "B", "C", "∆", "D", "E", " ", "F", "G", "H", "I", "J",
			"K", "L", "£", "M", "N", "—", "O", "”", "P", "R", "S", "å", "T", "U", "V", "W", "Y", "Z", "è", "Ø" };
	
	public Encryption() {}

	public abstract String encrypt(String text,String key);
	
	public abstract String decrypt(String text,String key);
	
	public abstract String toString();
	
}
