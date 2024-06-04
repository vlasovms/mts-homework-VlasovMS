package config;

import homeworks_main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableConfigurationProperties(StarterAnimalProperties.class)
public class StarterAnimalConfiguration {
    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService(StarterAnimalProperties props) {
        System.out.println("We in app Configuration");
        ApplicationPropertiesHolder.setApplicationProperties(props);
        return new CreateAnimalServiceImpl(props);
    }

    @Bean
    @Autowired
    public AnimalRepository animalRepository(CreateAnimalService createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }


}
