package data;

public abstract class Encryption {

	public Encryption() {}

	public abstract String encrypt(String text);
	
	public abstract String decrypt(String text);
	
	public abstract String toString();
	
}
