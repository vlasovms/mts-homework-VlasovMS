package homework_Pets;

public interface CreateAnimalService {
    default void createAnimals() {
        int i = 0;
        while (i < 10) {
            CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
            createAnimalService.createAnimalOnCondition(i);
            i++;
        }
    }
}
