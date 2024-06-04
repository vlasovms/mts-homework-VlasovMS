package homeworks_main;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalsRepositoryImpl implements AnimalRepository {
    private Map<String, List<Animal>> animalMap;
    private Map<String, LocalDate> leapYearAnimalMap;

    public AnimalsRepositoryImpl(CreateAnimalService createAnimalService) {
        this.animalMap = createAnimalService.getAnimalMap();
    }

    public AnimalsRepositoryImpl() {
    }

    @Override
    @PostConstruct
    public Map<String, LocalDate> findLeapYearNames() {
        List<Animal> animalList = animalMap.values().stream().flatMap(List::stream).toList();
        leapYearAnimalMap = animalList.stream()
                .filter(x -> x.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(e -> e.getClass().getSimpleName() + " " + e.getName(), Animal::getBirthDate));
        return leapYearAnimalMap;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) {
        return animalList.stream()
                .filter(x -> x.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(e -> e.getClass().getSimpleName() + " " + e.getName(), Animal::getBirthDate));
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, Integer minAge) {
        Map<Animal, Integer> olderAnimalMap;
        olderAnimalMap = animalList.stream()
                .filter(e -> e.getAge() > minAge)
                .collect(Collectors.toMap(e -> e, Animal::getAge));

        if (olderAnimalMap.isEmpty()) {
            Animal maxAgeAnimal = Collections.min(animalList, Comparator.comparing(Animal::getBirthDate));    //Ищем животное с минимальной датой рождения, то есть самого старшего
            olderAnimalMap.put(maxAgeAnimal, maxAgeAnimal.getAge());
        }
        try {
            File file = new File("resources/results/findOlderAnimals.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, olderAnimalMap.keySet());
        } catch (IOException e) {
            throw new RuntimeException(e);
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
    public Double findAverageAge(List<Animal> animalList) {
        Double averageAnimalsAge = (animalList.stream()
                .mapToInt(Animal::getAge)
                .average()).orElse(0);

        System.out.println(averageAnimalsAge);
        return averageAnimalsAge;
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animalList) {
        Double animalsAveragePrice = getAveragePrice(animalList);
        return animalList.stream()
                .filter(i -> i.getAge() > 5)
                .filter(i -> i.getCost() > animalsAveragePrice)
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

    public Map<String, LocalDate> getLeapYearAnimalMap() {
        return leapYearAnimalMap;
    }

    public Map<String, List<Animal>> getAnimalMap() {
        return animalMap;
    }
}
