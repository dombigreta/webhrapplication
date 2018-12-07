package hu.miskolc.iit.application.Helpers;

public enum CareerType {
    AVIATION("Aviation"),
    BUSINESS("Buiness"),
    LAWENFORCMENT("Law Enforcment"),
    MEDIA("Media"),
    MEDICAL("Medical"),
    TECHNOLOGY("Technolody"),
    INDUSTRIAL("Industrial");

    private final String description;

    private CareerType(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
