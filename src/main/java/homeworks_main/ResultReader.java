package homeworks_main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ResultReader {
    public static List<Animal> readOlderAnimalsJSON() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String file = "resources/results/findOlderAnimals.json";
        String json = readFileAsString(file);
        System.out.println(json);
        TypeReference<List<Animal>> typeRef = new TypeReference<>() {
        };
        return mapper.readValue(json, typeRef);
    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static Integer getRowCountFromLog(String filePath) {
        int count = 0; // счетчик строк

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            System.out.println("Количество строк в файле: " + count);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return count;
    }
}
