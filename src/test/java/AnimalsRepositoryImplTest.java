import homework_Pets.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalsRepositoryImplTest {
    List<Animal> testAnimalList = null;
    AnimalRepository animalsRepository = null;

    @BeforeEach
    public void setUpTestEnv() {
        testAnimalList = getAnimalsPool();
        animalsRepository = new AnimalsRepositoryImpl();
    }

    @DisplayName("Тест проверяет, что в мапу попадают только животные родившиеся в високосный год")
    @Test
    public void findLeapYearNames() {
        Map<String, LocalDate> leapYearsAnimalMap = animalsRepository.findLeapYearNames(testAnimalList);
        assertEquals(leapYearsAnimalMap.get("Carp Volodya"), new GregorianCalendar(1980, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        assertEquals(leapYearsAnimalMap.get("Eagle Ben"), new GregorianCalendar(1988, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        assertFalse(leapYearsAnimalMap.containsKey("Eagle John"));
    }

    @DisplayName("Тест проверяет, что в мапу попадают только животные, старше 30 лет")
    @Test
    public void findOlderAnimal() {
        Map<Animal, Integer> olderThan30AnimalMap = animalsRepository.findOlderAnimal(testAnimalList, 30);
        assertTrue(olderThan30AnimalMap.containsKey(new Eagle(0.0, 0.0, "", "", "Ben", 0.0, "", new GregorianCalendar(1988, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));
        assertFalse(olderThan30AnimalMap.containsKey(new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), "John", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(2003, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));
        assertTrue(olderThan30AnimalMap.containsKey(new Carp(Randomizer.generateUUID(), "Volodya", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), new GregorianCalendar(1980, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));
    }

    @DisplayName("Тест проверяет, что в кейсе, когда не найдено ни одного животного старше 100 лет, то в мапу запишется самый старший из них")
    @Test
    public void findOlderAnimalCheckOlder() {
        Map<Animal, Integer> olderThan30AnimalMap = animalsRepository.findOlderAnimal(testAnimalList, 100);
        assertTrue(olderThan30AnimalMap.containsKey(new Carp(Randomizer.generateUUID(), "Volodya", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), new GregorianCalendar(1980, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())));
    }

    @DisplayName("Тест проверяет, что в мапу записывается ожидаемое количество дублей животных")
    @Test
    public void findDuplicate() {
        Map<String, Integer> olderThan30AnimalMap = animalsRepository.findDuplicate(testAnimalList);
        assertEquals(2, (int) olderThan30AnimalMap.get("Eagle"));
        assertEquals(1, (int) olderThan30AnimalMap.get("Carp"));
    }

    static List<Animal> getAnimalsPool() {
        return List.of(new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), "John", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(2003, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()), new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), "Ben", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(1988, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()), new Carp(Randomizer.generateUUID(), "Volodya", Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), new GregorianCalendar(1980, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
    }
}