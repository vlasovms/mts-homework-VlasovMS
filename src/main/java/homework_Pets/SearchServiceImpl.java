package homework_Pets;

import java.util.Date;

public class SearchServiceImpl implements SearchService {

    public void checkLeapYearAnimal(Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        if (animal == null) {
            throw new InvalidAnimalException("На вход пришёл некорректный объект животного " + new Date());
        }
        if (animal.getBirthDate() == null) {
            throw new InvalidAnimalBirthDateException("у животного " + animal.getClass().getSimpleName() + " не указана дата его рождения");
        }
        System.out.println("Имя: " + animal.getName() + (animal.getBirthDate().isLeapYear() ? " был рожден в високосный год" : " не был рожден в високосный год"));
    }
}
