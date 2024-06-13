package homeworks_main;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {
    Map<String, List<Animal>> createAnimals();

     Map<String, List<Animal>> getAnimalMap();
}