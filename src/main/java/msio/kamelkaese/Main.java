package msio.kamelkaese;

import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		staticFileLocation("/public");

		post("/KamelKäse", (req, res) -> {
			return new TextConverter(req.body()).convert();
		});

	}

}
