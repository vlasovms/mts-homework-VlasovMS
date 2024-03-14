package homework_Pets;

import java.time.LocalDate;

public abstract class Fish extends AbstractAnimal {
    private double gillVolume;

    public Fish(){
    }
    public Fish(double gillVolume) {
        this.gillVolume = gillVolume;
    }

    public Fish(String breed, String name, Double cost, String character, double gillVolume, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
        this.gillVolume = gillVolume;
    }

    public void setGillVolume(double gillVolume) {
        this.gillVolume = gillVolume;
    }

    public double getGillVolume() {
        return gillVolume;
    }
}
