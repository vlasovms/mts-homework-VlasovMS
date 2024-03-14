package homework_Pets;

public class Main {
    public static void main(String[] args) throws InvalidAnimalException {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        SearchService searchServiceImpl = new SearchServiceImpl();
        Animal eagle = createAnimalServiceImpl.createRandomEagle();

        try {
            searchServiceImpl.checkLeapYearAnimal(eagle);
        } catch (InvalidAnimalException | InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой: " + e.getMessage());
        }

       System.out.println(eagle);

    }
}