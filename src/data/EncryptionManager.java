package data;

import java.util.ArrayList;
import java.util.List;

public class EncryptionManager {

	private CaesarCipher cesar = new CaesarCipher();
	private List<Encryption> encryptions = new ArrayList<Encryption>();

	public EncryptionManager() {
		encryptions.add(cesar);
	}

	public String encrypt(String encryptionTitle,String text) {
		for (Encryption enc : encryptions) {
			if (enc.toString().equals(encryptionTitle)) {
				return enc.encrypt(text);
			}
		}
		return "";
	}

	public String decrypt(String encryptionTitle,String text) {
		for (Encryption enc : encryptions) {
			if (enc.toString().equals(encryptionTitle)) {
				return enc.decrypt(text);
			}
		}
		return "";
	}

}
