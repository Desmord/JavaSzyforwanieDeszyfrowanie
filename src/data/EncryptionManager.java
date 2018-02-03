package data;

import java.util.List;

public class EncryptionManager {

	private List<Encryption> encryptions;
	
	public EncryptionManager() {
		super();
		encryptions.add(new CaesarCipher());
	}
	
	public String encrypt(String encryptionTitle) {
		//tutaj porwoanie w pentli nazw i wybranie odpowiedzniej metody
		System.out.println(encryptions.get(0).toString());
		
		//zwaracznie tekstu do wstawienia
		return null;
	}
	
	public String decrypt(String encryptionTitle) {
		return null;
	}
	
}
