package hu.miskolc.iit.application.Helpers;

public enum CurrencyType {
    HUF("HUF"),
    EUR("EUR"),
    USD("USD"),
    GPB("GPB");

    private final String description;

    private CurrencyType(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return name().toUpperCase();
    }

}
