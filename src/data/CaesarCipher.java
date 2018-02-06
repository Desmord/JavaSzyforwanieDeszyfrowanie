package data;

/**
 * Caesar Cipher - swipe by 3
 * 
 * @author Mikolaj
 *
 */
public class CaesarCipher extends Encryption {

	public CaesarCipher() {
	}

	@Override
	public String encrypt(String text,String key) {

		String encryptedText = "";

		for (int i = 0; i < text.length(); i++) {

			if (!space(text.substring(i, i + 1))) {

				if (letterUpperCase(text.substring(i, i + 1))) {
					
					encryptedText = encryptedText + getEcnryptedUpperCaseLetter(text.substring(i, i + 1));

				} else {
					
					encryptedText = encryptedText + getEcnryptedLetter(text.substring(i, i + 1));

				}
			} else {
				encryptedText = encryptedText + " ";

			}
		}

		return encryptedText;

	}

	private String getEcnryptedLetter(String letter) {

		int alphabetLetterIndex = 0;

		for (int j = 0; j < getALFABET_LETTERS().length; j++) {

			if (letter.equals(getALFABET_LETTERS()[j])) {

				alphabetLetterIndex = j;

				if (alphabetLetterIndex == 30) {
					return getALFABET_LETTERS()[0];
				} else if (alphabetLetterIndex == 31) {
					return getALFABET_LETTERS()[1];
				} else if (alphabetLetterIndex == 32) {
					return getALFABET_LETTERS()[2];
				} else {
					return getALFABET_LETTERS()[j + 3];
				}

			}
		}
		return "";
	}

	private String getEcnryptedUpperCaseLetter(String letter) {

		int alphabetLetterIndex = 0;

		for (int j = 0; j < getUPPER_ALFABET_LETTERS().length; j++) {

			if (letter.equals(getUPPER_ALFABET_LETTERS()[j])) {

				alphabetLetterIndex = j;

				if (alphabetLetterIndex == 30) {
					return getUPPER_ALFABET_LETTERS()[0];
				} else if (alphabetLetterIndex == 31) {
					return getUPPER_ALFABET_LETTERS()[1];
				} else if (alphabetLetterIndex == 32) {
					return getUPPER_ALFABET_LETTERS()[2];
				} else {
					return getUPPER_ALFABET_LETTERS()[j + 3];
				}
			}
		}
		return "";
	}
	

	@Override
	public String decrypt(String text,String key) {
		String decryptedText = "";

		for (int i = 0; i < text.length(); i++) {

			if (!space(text.substring(i, i + 1))) {

				if (letterUpperCase(text.substring(i, i + 1))) {
					
					decryptedText = decryptedText + getDecnryptedUpperCaseLetter(text.substring(i, i + 1));

				} else {
					
					decryptedText = decryptedText + getDecnryptedLetter(text.substring(i, i + 1));

				}
			} else {
				decryptedText = decryptedText + " ";

			}
		}

		return decryptedText;
	}
	
	private String getDecnryptedLetter(String letter) {

		int alphabetLetterIndex = 0;

		for (int j = 0; j < getALFABET_LETTERS().length; j++) {

			if (letter.equals(getALFABET_LETTERS()[j])) {

				alphabetLetterIndex = j;

				if (alphabetLetterIndex == 2) {
					return getALFABET_LETTERS()[32];
				} else if (alphabetLetterIndex == 1) {
					return getALFABET_LETTERS()[31];
				} else if (alphabetLetterIndex == 0) {
					return getALFABET_LETTERS()[30];
				} else {
					return getALFABET_LETTERS()[j - 3];
				}

			}
		}
		return "";
	}

	private String getDecnryptedUpperCaseLetter(String letter) {

		int alphabetLetterIndex = 0;

		for (int j = 0; j < getUPPER_ALFABET_LETTERS().length; j++) {

			if (letter.equals(getUPPER_ALFABET_LETTERS()[j])) {

				alphabetLetterIndex = j;

				if (alphabetLetterIndex == 2) {
					return getUPPER_ALFABET_LETTERS()[32];
				} else if (alphabetLetterIndex == 1) {
					return getUPPER_ALFABET_LETTERS()[31];
				} else if (alphabetLetterIndex == 0) {
					return getUPPER_ALFABET_LETTERS()[30];
				} else {
					return getUPPER_ALFABET_LETTERS()[j - 3];
				}
			}
		}
		return "";
	}
	
	/**
	 * Check if character given letter empty space
	 * 
	 * @return ture if character is empty same
	 */
	private boolean space(String letter) {

		if (letter.matches(" ")) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Check if letter given letter is UpperCase
	 * 
	 * @return ture if letter is upperCase
	 */
	private boolean letterUpperCase(String letter) {

		String rex = "[A-Z¥ÊÆ£ÑÓŒ¯]";

		if (letter.matches(rex)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Szyfr Cezara";
	}

	private String[] getALFABET_LETTERS() {
		return ALFABET_LETTERS;
	}

	private String[] getUPPER_ALFABET_LETTERS() {
		return UPPER_ALFABET_LETTERS;
	}

}
