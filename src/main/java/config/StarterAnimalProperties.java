package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class StarterAnimalProperties {
    private String[] animalNames;

    public void setAnimalNames(String[] animalNames) {
        this.animalNames = animalNames;
    }

    public String[] getAnimalNames() {
        return animalNames;
    }
}
