package org.mschaeffner.kamelkaese;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mschaeffner.kamelkaese.Tokenizer.tokenize;

import java.util.Arrays;

import org.junit.Test;

public class TokenizerTest {

	@Test(expected=IllegalArgumentException.class)
	public void testNullValue() {
		tokenize(null);
	}

	@Test
	public void test() {

		assertThat(tokenize(""), is(Arrays.asList()));
		assertThat(tokenize("a"), is(Arrays.asList("a")));
		assertThat(tokenize("abc"), is(Arrays.asList("abc")));
		assertThat(tokenize("XYZ"), is(Arrays.asList("XYZ")));
		assertThat(tokenize("a b c"), is(Arrays.asList("a", " ", "b", " ", "c")));
		assertThat(tokenize("a1b2,3"), is(Arrays.asList("a", "1", "b", "2", ",", "3")));
		assertThat(tokenize("That's a test."), is(Arrays.asList("That", "'", "s", " ", "a", " ", "test", ".")));
		assertThat(tokenize("!§$%&()"), is(Arrays.asList("!§$%&()")));
		assertThat(tokenize("    s"), is(Arrays.asList("    ", "s")));
	
	}

	@Test
	public void testWithSpaceAndNumbers() {

		assertThat(tokenize("Am 12. Juli 2015 hat es geregnet."), is(Arrays.asList("Am", " ", "12", ".", " ", "Juli", " ", "2015", " ", "hat", " ", "es", " ", "geregnet", ".")));
		
	}

}
