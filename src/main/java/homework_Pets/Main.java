package homework_Pets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        AnimalRepository animalRepository = new AnimalsRepositoryImpl();

        Animal eagle = createAnimalService.createRandomEagle();
        Animal carp = createAnimalService.createRandomCarp();
        Animal carp2 = createAnimalService.createRandomCarp();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(eagle);
        animalList.add(carp);
        animalList.add(carp2);
        Map<Animal, Integer> findolderAnimalMap = animalRepository.findOlderAnimal(animalList, 0);
        List<Animal> animalListFromJson = ResultReader.readOlderAnimalsJSON();
        System.out.println(animalListFromJson);
        System.out.println(ResultReader.getRowCountFromLog("resources/animals/logData.txt"));

    }
}