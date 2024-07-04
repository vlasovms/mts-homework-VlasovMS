package homeworks_main;

public enum AnimalTypes {
    CARP("Carp"),
    EAGLE("Eagle");
    private String title;

    AnimalTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
