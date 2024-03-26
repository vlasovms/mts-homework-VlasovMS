package homework_Pets;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalsRepositoryImpl implements AnimalRepository {
    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) {
        return animalList.stream()
                .filter(x -> x.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(e -> e.getClass().getSimpleName() + " " + e.getName(), Animal::getBirthDate));
    }


    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, Integer minAge) {
        Map<Animal, Integer> olderAnimalMap = animalList.stream()
                .filter(e -> e.getAge() > minAge)
                .collect(Collectors.toMap(e -> e, Animal::getAge));

        if (olderAnimalMap.isEmpty()) {
            Animal maxAgeAnimal = Collections.min(animalList, Comparator.comparing(Animal::getBirthDate));    //Ищем животное с минимальной датой рождения, то есть самого старшего
            olderAnimalMap.put(maxAgeAnimal, maxAgeAnimal.getAge());
        }
        return olderAnimalMap;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animalArrayList) {
        Map<String, Integer> dupAnimalMap = new HashMap<>();
        for (Animal animal : animalArrayList) {
            if (dupAnimalMap.containsKey(animal.getClass().getSimpleName())) {   //Если в мапе уже есть животное такого класса, то инкрементируем счётчик этого животного, иначе добавляем название нового животного в мапу с value = 1
                dupAnimalMap.put(animal.getClass().getSimpleName(), dupAnimalMap.get(animal.getClass().getSimpleName()) + 1);
            } else {
                dupAnimalMap.put(animal.getClass().getSimpleName(), 1);
            }
        }
        return dupAnimalMap;
    }

    @Override
    public Map<String, List<Animal>> findDuplicateList(List<Animal> animalArrayList) {
        return animalArrayList.stream().collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()));
    }

    @Override
    public void findAverageAge(List<Animal> animalList) {
        System.out.println(animalList.stream()
                .mapToInt(Animal::getAge)
                .average());
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animalList) {
        return animalList.stream()
                .filter(i -> i.getAge() > 5)
                .filter(i -> i.getCost() > getAveragePrice(animalList))
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());
    }

    public Double getAveragePrice(List<Animal> animalList) {
        return animalList.stream()
                .mapToDouble(Animal::getCost)
                .average().orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<String> findMinCostAnimals(List<Animal> animalList) {
        return animalList.stream()
                .sorted((o1, o2) -> o2.getName()
                        .compareTo(o1.getName()))
                .limit(3)
                .map(Animal::getName)
                .collect(Collectors.toList());

    }
}
