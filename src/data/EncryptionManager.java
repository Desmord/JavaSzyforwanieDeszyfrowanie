package data;

import java.util.ArrayList;
import java.util.List;

public class EncryptionManager {

	private CaesarCipher cesar = new CaesarCipher();
	private VigenereCipher vine = new VigenereCipher();
	private List<Encryption> encryptions = new ArrayList<Encryption>();

	public EncryptionManager() {
		encryptions.add(cesar);
		encryptions.add(vine);
	}

	public String encrypt(String encryptionTitle,String text,String key) {
		for (Encryption enc : encryptions) {
			if (enc.toString().equals(encryptionTitle)) {
				return enc.encrypt(text,key);
			}
		}
		return "";
	}

	public String decrypt(String encryptionTitle,String text,String key) {
		for (Encryption enc : encryptions) {
			if (enc.toString().equals(encryptionTitle)) {
				return enc.decrypt(text,key);
			}
		}
		return "";
	}

}
