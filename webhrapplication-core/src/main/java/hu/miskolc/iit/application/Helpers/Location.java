package hu.miskolc.iit.application.Helpers;

public enum Location {
    HUNGARY("Hungary"),
    AMERICA("America"),
    GREATBRITAIN("Great Britain"),
    EUROPE("Europe");

    private final String description;

    private Location(String description)
    {
        this.description = description;
    }

    @Override
    public String toString(){
        return name().toLowerCase();
    }

}
