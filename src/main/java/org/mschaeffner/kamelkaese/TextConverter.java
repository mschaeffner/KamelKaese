package org.mschaeffner.kamelkaese;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import de.danielnaber.jwordsplitter.AbstractWordSplitter;
import de.danielnaber.jwordsplitter.GermanWordSplitter;

public class TextConverter {

	private final AbstractWordSplitter wordSplitter;

	public TextConverter() throws IOException {
		this.wordSplitter = new GermanWordSplitter(false);
	}

	public String convert(String content) {

		String result = Tokenizer.tokenize(content)
				.stream()
				.map(word -> {

					List<String> parts = wordSplitter.splitWord(word);
					return parts.size() == 1 ? word : upcaseParts(parts);

				}).collect(Collectors.joining());

		return result;
	}

	private String upcaseParts(List<String> parts) {
		return parts.stream()
				.map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
				.collect(Collectors.joining());
	}

}
