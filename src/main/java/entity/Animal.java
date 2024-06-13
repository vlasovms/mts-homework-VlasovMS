package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Animal {

    @Id
    @SequenceGenerator(name = "animal_id_seq", sequenceName = "animal_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "animal_id_seq")
    private Long id;
    @Setter
    private String name;
    @Setter
    private String breed;
    @Setter
    private Double cost;
    @Setter
    @Column(name = "charact")
    private String character;
    @Setter
    @Column(name = "birthdate")
    private LocalDate birthDate;
    @Column(name = "secretinformation")
    private String secretInformation;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "type", nullable = false)
    private AnimalType animalType;

    public Animal(String breed, String name, Double cost, String character, LocalDate birthDate, String secretInformation, AnimalType animalType) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
        this.secretInformation = secretInformation;
        this.animalType = animalType;
    }


    public int getAge() {
        return getBirthDate() != null ? getBirthDate().until(LocalDate.now()).getYears() : 0;
    }

}

