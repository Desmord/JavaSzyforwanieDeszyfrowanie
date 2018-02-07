package data;

public class BackwardsCipher extends Encryption {

	@Override
	public String encrypt(String text, String key) {

		String encryptedText = "";

		for (int i = text.length() - 1; i >= 0; i--) {

			if (!isSpace(text.substring(i, i + 1))) {
				encryptedText = encryptedText + text.substring(i, i + 1);
			} else {
				encryptedText = encryptedText + " ";
			}

		}

		return encryptedText;
	}

	@Override
	public String decrypt(String text, String key) {
		String decryptedText = "";

		for (int i = text.length() - 1; i >= 0; i--) {

			if (!isSpace(text.substring(i, i + 1))) {
				decryptedText = decryptedText + text.substring(i, i + 1);
			} else {
				decryptedText = decryptedText + " ";
			}

		}

		return decryptedText;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Szyfr przestawieniowy - wspak";
	}

	private boolean isSpace(String letter) {
		if (letter.matches(" ")) {
			return true;
		} else {
			return false;
		}
	}

}
