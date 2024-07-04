package homeworks_main;


import java.time.LocalDate;
import java.util.Objects;

public class Carp extends Fish {
    private String lure;

    public Carp() {
    }

    public Carp(String breed, String name, Double cost, String character, double gillVolume, String lure, LocalDate birthDate, String secretInformation, String animalType) {
        super(breed, name, cost, character, gillVolume, birthDate, secretInformation, animalType);
        this.lure = lure;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    public String getLure() {
        return lure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carp carp = (Carp) o;
        return Objects.equals(name, carp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fish: " +
                " breed: " + this.breed + "; " +
                " name: " + this.name + "; " +
                " cost: " + this.cost + "; " +
                " character: " + this.character + "; " +
                " gillVolume: " + super.getGillVolume() + "; " +
                " lure: " + this.lure +
                " birthDate: " + this.birthDate +
                " secretInfo: " + this.secretInformation;
    }
}
