package homeworks_main;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "animalType")
@JsonSubTypes({@JsonSubTypes.Type(value = Carp.class, name = "Carp"), @JsonSubTypes.Type(value = Eagle.class, name = "Eagle")})

public interface Animal {
    String getBreed();

    String getName();

    Double getCost();

    String getCharacter();

    LocalDate getBirthDate();

    int getAge();

    String getSecretInformation();

    String getAnimalType();

}
