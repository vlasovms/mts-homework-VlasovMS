package homeworks_main;

import java.time.LocalDate;
import java.util.Objects;

public class Eagle extends Bird {
    private String democraticRoar;

    public Eagle() {
    }

    public Eagle(Double wingspan, Double beakSize, String democraticRoar) {
        super(wingspan, beakSize);
        this.democraticRoar = democraticRoar;
    }

    public Eagle(Double wingspan, Double beakSize, String democraticRoar, String breed, String name, Double cost, String character, LocalDate birthDate, String secretInformation, String animalType) {
        super(breed, name, cost, character, wingspan, beakSize, birthDate, secretInformation, animalType);
        this.democraticRoar = democraticRoar;
    }

    public String getDemocraticRoar() {
        return democraticRoar;
    }

    public void setDemocraticRoar(String democraticRoar) {
        this.democraticRoar = democraticRoar;
    }

    @Override
    public String toString() {
        return "Eagle: " + " breed: " + this.breed + "; " + " name: " + this.name + "; " + " cost: " + this.cost + "; " + " character: " + this.character + "; " + " democraticRoar: " + this.democraticRoar + "; " + " wingspan: " + super.getWingspan() + "; " + " beakSize: " + super.getBeakSize() + " birthDate: " + super.getBirthDate() + " secretInfo: " + this.secretInformation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Eagle eagle = (Eagle) obj;
        return Objects.equals(name, eagle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
