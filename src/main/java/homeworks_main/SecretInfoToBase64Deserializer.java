package homeworks_main;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Base64;

public class SecretInfoToBase64Deserializer extends JsonDeserializer<String> {
    public SecretInfoToBase64Deserializer() {
        this(null);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return new String(Base64.getDecoder().decode(p.readValueAs(String.class)));
    }

    public SecretInfoToBase64Deserializer(Class<String> t) {
        super();
    }

}
