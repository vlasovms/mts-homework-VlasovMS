package homework_Pets;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        createAnimalServiceImpl.createAnimals(5);
        createAnimalServiceImpl.createAnimals();
        CreateAnimalService createAnimalService = new CreateAnimalService() {
            @Override
            public void createAnimals() {
                CreateAnimalService.super.createAnimals();
            }
        };

        createAnimalService.createAnimals();
    }
}