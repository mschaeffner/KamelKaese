package msio.kamelkaese;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Tokenizer {

	public static List<String> tokenize(String content) {
		List<String> result = new ArrayList<String>();

		StringBuilder currentWord = new StringBuilder();
		boolean isLastCharLetter = true;

		PrimitiveIterator.OfInt it = content.chars().iterator();
		while (it.hasNext()) {
			char c = (char) it.nextInt();

			boolean isLetter = Character.isLetter(c);
			if (isLastCharLetter != isLetter) {
				isLastCharLetter = isLetter;
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
