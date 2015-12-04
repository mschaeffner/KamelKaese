package msio.kamelkaese;

import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		staticFileLocation("/public");

		TextConverter converter = new TextConverter();
		
		post("/KamelKäse", (req, res) -> {
			return converter.convert(req.body());
		});


	}

}
