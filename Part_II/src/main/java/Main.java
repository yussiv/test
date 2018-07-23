import static spark.Spark.post;

import domain.Text;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        post("/hash", (request, response) -> handleRequest(request, response));
    }

    private static String handleRequest(Request req, Response res) {
        try {
            Text text = HashUtil.parseJSON(req.body());
            return HashUtil.getHashJSON(text.text);

        } catch (Exception e) {
            res.status(400);
            return "Bad Request";
        }
    }
}

