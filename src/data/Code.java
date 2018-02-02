package data;

public abstract class Code {
	
	public abstract String encrypt(String text);
	
	public abstract String decrypt(String text);
	
	public abstract String toString();
	
	public Code() {}
}
