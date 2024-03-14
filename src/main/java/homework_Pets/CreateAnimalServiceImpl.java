package homework_Pets;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimals(int n) {
        for (int i = 0; i < n; i++) {
            createAnimalOnCondition(i);
        }
    }

    @Override
    public void createAnimals() {
        int i = 0;
        do {
            createAnimalOnCondition(i);
            i++;
        }
        while (i < 10);
    }

    public AbstractAnimal createRandomCarp() {
        return new Carp(Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate());
    }

    public AbstractAnimal createRandomEagle() {
        return new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate());
    }

    public void createAnimalOnCondition(int counter) {
        if (counter % 2 == 0) {   //Для чётного значения счётчика создаём карпа, иначе орла
            System.out.println(createRandomCarp());
        } else {
            System.out.println(createRandomEagle());
        }
    }
}
