package homeworks_main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {"config", "homeworks_main"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            printLeapYearAnimalMap(ctx);
        };
    }

    private static void printLeapYearAnimalMap(ApplicationContext ctx) {
        AnimalsRepositoryImpl animalRepository = (AnimalsRepositoryImpl) ctx.getBean(AnimalRepository.class);
        Map<String, LocalDate> leapYearAnimalMap = animalRepository.getLeapYearAnimalMap();
        System.out.println(leapYearAnimalMap);
    }
}
