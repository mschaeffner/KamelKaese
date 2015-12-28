package msio.kamelkaese;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Tokenizer {

	private enum TokenType {
		LETTER, DIGIT, WHITESPACE, OTHER;
		
		static TokenType get(char c) {
			if(Character.isLetter(c)) {
				return LETTER;
			} else if (Character.isDigit(c)) {
				return DIGIT;
			} else if (Character.isWhitespace(c)) {
				return WHITESPACE;
			} else {
				return OTHER;
			}
		}
		
	}
	
	public static List<String> tokenize(String content) {
		if(content == null) {
			throw new IllegalArgumentException("content must not be null value.");
		}
		
		List<String> result = new ArrayList<String>();

		StringBuilder currentWord = new StringBuilder();
		TokenType currentType = TokenType.LETTER;

		PrimitiveIterator.OfInt it = content.chars().iterator();
		while (it.hasNext()) {
			char c = (char) it.nextInt();

			TokenType type = TokenType.get(c);
			if (currentType != type) {
				currentType = type;
				result.add(currentWord.toString());
				currentWord.setLength(0);
			}

			currentWord.append(c);

		}

		result.add(currentWord.toString());

		if(result.get(0).length() == 0) {
			result.remove(0);
		}
		
		return result;
	}

}
