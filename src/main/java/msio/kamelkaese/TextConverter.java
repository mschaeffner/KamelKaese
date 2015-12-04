package msio.kamelkaese;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.danielnaber.jwordsplitter.AbstractWordSplitter;
import de.danielnaber.jwordsplitter.GermanWordSplitter;

public class TextConverter {

	private final String content;
	
	private final AbstractWordSplitter wordSplitter;

	private final List<String> words = new ArrayList<String>();

	private String currentWord = "";
	
	private boolean isLetter = true;

	public TextConverter(String content) throws IOException {
		this.content = content;
		this.wordSplitter = new GermanWordSplitter(false);
	}
	
	public String convert() throws IOException {

		content.chars().forEach(i -> add((char) i));
		words.add(currentWord);

		String result = words
				.stream()
				.map(word -> {

					List<String> splittedWords = wordSplitter.splitWord(word);
					if(splittedWords.size() == 1) {
						
						return word;

					} else {
						
						return splittedWords.stream()
								.map(w -> w.substring(0, 1).toUpperCase() + w.substring(1))
								.collect(Collectors.joining());

					}
					
				}).collect(Collectors.joining());

		return result;
	}

	private void add(char c) {
		if(isLetter == Character.isLetter(c)) {
			currentWord = currentWord + c;
		} else {
			isLetter = Character.isLetter(c);
			words.add(currentWord);
			currentWord = String.valueOf(c);
		}
	}

}
