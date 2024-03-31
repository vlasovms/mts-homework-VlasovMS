package homework_Pets;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animalList = AbstractAnimal.createRandomAnimalsList(10);
        AnimalsRepositoryImpl animalRepository = new AnimalsRepositoryImpl();
        System.out.println(animalRepository.findMinCostAnimals(animalList));
        System.out.println(animalList);
    }
}