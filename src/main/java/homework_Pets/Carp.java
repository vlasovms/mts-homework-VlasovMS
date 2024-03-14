package homework_Pets;

import java.time.LocalDate;

public class Carp extends Fish {
    private String lure;

    public Carp() {
    }

    public Carp(String breed, String name, Double cost, String character, double gillVolume, String lure, LocalDate birthDate) {
        super(breed, name, cost, character, gillVolume, birthDate);
        this.lure = lure;
    }

    public void setLure(String lure) {
        this.lure = lure;
    }

    public String getLure() {
        return lure;
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
                " birthDate: " + this.birthDate;
    }
}
