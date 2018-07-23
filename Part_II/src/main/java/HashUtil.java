
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import domain.Hash;
import domain.Text;

public class HashUtil {
    public static Text parseJSON(String json) throws JsonSyntaxException {
        Gson gson = new Gson();
        Text text = gson.fromJson(json, Text.class);
        return text;
    }

    public static String getHashJSON(String value) {
        Gson gson = new Gson();
        return gson.toJson(new Hash(calculateHash(value)));
    }

    public static String calculateHash(String str) {
        return Hashing.sha256().hashString(str, Charsets.UTF_8).toString();
    }
}
