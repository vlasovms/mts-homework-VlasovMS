package homework_Pets;

public class Carp extends Fish {
    private String lure;

    public Carp(String breed, String name, Double cost, String character, double gillVolume, String lure) {
        super(breed, name, cost, character, gillVolume);
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
                " lure: " + this.lure;
    }
}
