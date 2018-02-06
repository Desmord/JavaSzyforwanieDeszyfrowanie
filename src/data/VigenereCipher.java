package data;

public class VigenereCipher extends Encryption {

	private String key = "";

	@Override
	public String encrypt(String text, String key) {

		String encryptedText = "";

		createProperEncryptionKey(text, key);

		int textIndex = 0;
		int keyIndex = 0;

		boolean isUpperCase = false;

		for (int i = 0; i < text.length(); i++) {

			if (text.substring(i, i + 1).matches(" ")) {
				encryptedText = encryptedText + " ";
			} else {

				// Wyszukiwanie indexow textu -> funkcja
				if (isletterUpperCase(text.substring(i, i + 1))) {

					isUpperCase = true;

					for (int j = 0; j < UPPER_ALFABET_LETTERS.length; j++) {
						if (text.substring(i, i + 1).equals(UPPER_ALFABET_LETTERS[j])) {
							textIndex = j;
						}
					}

				} else {

					isUpperCase = false;

					for (int j = 0; j < ALFABET_LETTERS.length; j++) {
						if (text.substring(i, i + 1).equals(ALFABET_LETTERS[j])) {
							textIndex = j;
						}
					}

				}

				// wyszukiwanie indexu klucza
				for (int j = 0; j < ALFABET_LETTERS.length; j++) {
					if (this.key.substring(i, i + 1).toLowerCase().equals(ALFABET_LETTERS[j])) {
						keyIndex = j;
					}
				}

				// Sprawdzanie czy jest wiekszy
				if (textIndex >= keyIndex) {
					if (isUpperCase) {
						encryptedText = encryptedText + UPPER_ALFABET_LETTERS[textIndex - keyIndex];
					} else {
						encryptedText = encryptedText + ALFABET_LETTERS[textIndex - keyIndex];
					}
				} else {
					if (isUpperCase) {
						encryptedText = encryptedText + UPPER_ALFABET_LETTERS[33 - (keyIndex - textIndex)];
					} else {
						encryptedText = encryptedText + ALFABET_LETTERS[33 - (keyIndex - textIndex)];
					}
				}
			}
		}

		return encryptedText;
	}

	@Override
	public String decrypt(String text, String key) {

		String decryptedText = "";

		createProperEncryptionKey(text, key);

		int textIndex = 0;
		int keyIndex = 0;

		boolean isUpperCase = false;

		for (int i = 0; i < text.length(); i++) {

			if (text.substring(i, i + 1).matches(" ")) {
				decryptedText = decryptedText + " ";
			} else {

				// Wyszukiwanie indexow textu -> funkcja
				if (isletterUpperCase(text.substring(i, i + 1))) {

					isUpperCase = true;

					for (int j = 0; j < UPPER_ALFABET_LETTERS.length; j++) {
						if (text.substring(i, i + 1).equals(UPPER_ALFABET_LETTERS[j])) {
							textIndex = j;
						}
					}

				} else {

					isUpperCase = false;

					for (int j = 0; j < ALFABET_LETTERS.length; j++) {
						if (text.substring(i, i + 1).equals(ALFABET_LETTERS[j])) {
							textIndex = j;
						}
					}

				}

				// wyszukiwanie indexu klucza
				for (int j = 0; j < ALFABET_LETTERS.length; j++) {
					if (this.key.substring(i, i + 1).toLowerCase().equals(ALFABET_LETTERS[j])) {
						keyIndex = j;
					}
				}

				// Sprawdzanie czy jest wiekszy
				if (textIndex + keyIndex < 32) {
					if (isUpperCase) {
						decryptedText = decryptedText + UPPER_ALFABET_LETTERS[textIndex + keyIndex];
					} else {
						decryptedText = decryptedText + ALFABET_LETTERS[textIndex + keyIndex];
					}
				} else {
					if (isUpperCase) {
						decryptedText = decryptedText + UPPER_ALFABET_LETTERS[keyIndex - (33 - textIndex)];
					} else {
						decryptedText = decryptedText + ALFABET_LETTERS[keyIndex - (33 - textIndex)];
					}
				}
			}
		}

		return decryptedText;
	}

	@Override
	public String toString() {
		return "Szyfr Vigenere’a";
	}

	/**
	 * Generates the key at the correct length depending on the given key and text
	 * 
	 * @param text
	 * @param key
	 */
	private void createProperEncryptionKey(String text, String key) {

		this.key = "";

		if (text.length() == key.length()) {

			this.key = key;

		} else if (text.length() < key.length()) {

			this.key = key.substring(0, text.length());

		} else {

			int multipeAmount = text.length() / key.length();
			int restNumber = text.length() % key.length();

			for (int i = 0; i < multipeAmount; i++) {
				this.key = this.key + key;
			}

			if (restNumber != 0) {
				this.key = this.key + key.substring(0, restNumber);
			}

		}

	}

	private boolean isletterUpperCase(String letter) {

		String rex = "[A-Z¥ÊÆ£ÑÓŒ¯]";

		if (letter.matches(rex)) {
			return true;
		} else {
			return false;
		}
	}

}
