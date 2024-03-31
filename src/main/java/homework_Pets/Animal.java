package homework_Pets;

import java.time.LocalDate;

public interface Animal {
    String getBreed();

    String getName();

    Double getCost();

    String getCharacter();

    LocalDate getBirthDate();

    int getAge();
}
