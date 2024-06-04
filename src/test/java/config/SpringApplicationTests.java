package config;

import homeworks_main.Animal;
import homeworks_main.AnimalRepository;
import homeworks_main.CreateAnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestStarterAnimalConfiguration.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class SpringApplicationTests {
    @Autowired
    private CreateAnimalService createAnimalService;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private Environment env;


    @Test
    void checkMainBeansInstantiated() {
        assertNotNull(createAnimalService);
        assertNotNull(animalRepository);
    }

    @Test
    void checkPropertyAnimalNames() {
        assertNotNull(env.getProperty("animalNames"));
    }

    @Test
    void checkAnimalMapIsAutoFilled() {
        Map<String, List<Animal>> animalMap = animalRepository.getAnimalMap();
        assertFalse(animalMap.isEmpty());
    }


}
