package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AnimalType {
    private String type;
    @Id
    @SequenceGenerator(name = "animal_type_id_seq", sequenceName = "animal_type_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "animal_type_id_seq")
    private Long id;
    @OneToMany(mappedBy = "animalType")
    private List<Animal> animals;
}
