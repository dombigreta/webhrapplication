package hu.miskolc.iit.application.Helpers;

public enum Education {
    PRIMARY("Primary"),
    SECONDARY("Secondary"),
    TERTIARY("Tertiary"),
    HIGHSCHOOL("High schoole"),
    ACADEMY("Academy");

    private final String description;

    private Education(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
