package homeworks_main;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Base64;

public class SecretInfoToBase64Serializer extends JsonSerializer<String> {
    public SecretInfoToBase64Serializer() {
        this(null);
    }

    public SecretInfoToBase64Serializer(Class<String> t) {
        super();
    }

    @Override
    public void serialize(String secretInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(Base64.getEncoder().encodeToString(secretInfo.getBytes()));
    }
}

