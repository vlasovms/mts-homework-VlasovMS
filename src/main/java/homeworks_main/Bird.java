package homeworks_main;

import java.time.LocalDate;

public abstract class Bird extends AbstractAnimal {
    private Double wingspan;
    private Double beakSize;

    public Bird() {
    }

    public Bird(Double wingspan, Double beakSize) {
        this.wingspan = wingspan;
        this.beakSize = beakSize;
    }

    public Bird(String breed, String name, Double cost, String character, Double wingspan, Double beakSize, LocalDate birthDate, String secretInformation, String animalType) {
        super(breed, name, cost, character, birthDate, secretInformation, animalType);
        this.wingspan = wingspan;
        this.beakSize = beakSize;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public Double getBeakSize() {
        return beakSize;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }

    public void setBeakSize(Double beakSize) {
        this.beakSize = beakSize;
    }
}
