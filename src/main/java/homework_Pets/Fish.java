package homework_Pets;

public abstract class Fish extends AbstractAnimal {
    private double gillVolume;


    public Fish(double gillVolume) {
        this.gillVolume = gillVolume;
    }

    public Fish(String breed, String name, Double cost, String character, double gillVolume) {
        super(breed, name, cost, character);
        this.gillVolume = gillVolume;
    }

    public void setGillVolume(double gillVolume) {
        this.gillVolume = gillVolume;
    }

    public double getGillVolume() {
        return gillVolume;
    }
}
