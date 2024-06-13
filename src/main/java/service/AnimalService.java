package service;

import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAnimalsByIds(Iterable<Long> ids) {
        return animalRepository.findAllById(ids);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }
}
