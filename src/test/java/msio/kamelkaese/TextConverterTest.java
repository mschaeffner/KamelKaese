package msio.kamelkaese;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class TextConverterTest {

	@Test
	public void test() throws IOException {

		String input = "Die Donaudampfschifffahrtsgesellschaft ist ein Tochterunternehmen des Bahnsteigreparaturservice.";

		TextConverter converter = new TextConverter();
		String ouptut = converter.convert(input);
		
		assertThat(ouptut, is("Die DonauDampfSchiffFahrtsGesellschaft ist ein TochterUnternehmen des BahnsteigReparaturService."));
	}
	
}
