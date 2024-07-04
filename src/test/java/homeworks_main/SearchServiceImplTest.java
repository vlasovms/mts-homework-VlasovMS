package homeworks_main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void cleanUpStreams() {
        output.reset();
        System.setOut(null);
    }

    @DisplayName("Тест проверяет корректность вывода сообщения в консоль для кейсов с НЕ високосным годом")
    @ParameterizedTest
    @MethodSource("getTestAnimalNoLeapYear")
    void checkNotLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalBirthDateException {
        SearchService searchService = new SearchServiceImpl();
        searchService.checkLeapYearAnimal(animal);
        assertEquals("Имя: " + animal.getName() + " не был рожден в високосный год\r\n", output.toString());
    }

    @DisplayName("Тест проверяет корректность вывода сообщения в консоль для кейсов с високосным годом")
    @ParameterizedTest
    @MethodSource("getTestAnimalLeapYear")
    void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalBirthDateException {
        SearchService searchService = new SearchServiceImpl();
        searchService.checkLeapYearAnimal(animal);
        assertEquals("Имя: " + animal.getName() + " был рожден в високосный год\r\n", output.toString());

    }


    @DisplayName("Тест проверяет, что в случае незаполненной даты рождения метод выкинет эксепшн InvalidAnimalBirthDateException")
    @Test
    void checkInvalidAnimalBirthDateExceptionThrows() {
        assertThrows(InvalidAnimalBirthDateException.class, () -> checkNotLeapYearAnimal(new Eagle()));
    }

    @DisplayName("Тест проверяет, что метод выкинет InvalidAnimalException в случае, если объект пустой")
    @Test
    void checkInvalidAnimalExceptionThrows() {
        assertThrows(InvalidAnimalException.class, () -> checkNotLeapYearAnimal(null));
    }

    static List<AbstractAnimal> getTestAnimalNoLeapYear() {
        return List.of(
                new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(2003, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""),
                new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(1987, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""),
                new Carp(Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), new GregorianCalendar(2017, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""));
    }

    static List<AbstractAnimal> getTestAnimalLeapYear() {
        return List.of(
                new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(2004, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""),
                new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), new GregorianCalendar(1988, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""),
                new Carp(Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), new GregorianCalendar(1980, 2, 25).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), "", ""));
    }
}