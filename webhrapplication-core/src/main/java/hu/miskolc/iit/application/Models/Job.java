package hu.miskolc.iit.application.Models;

import hu.miskolc.iit.application.Helpers.CareerType;
import hu.miskolc.iit.application.Helpers.CurrencyType;
import hu.miskolc.iit.application.Helpers.Location;

public class Job {
    private int Id;
    private String Name;
    private String Description;
    private int NumberOfApplicants;
    private int NumberOfFreeSpaces;
    private int Payment;
    private CurrencyType currency;
    private CareerType careerType;
    private Location location;

    public Job(int id, String name, String description, int numberOfApplicants, int numberOfFreeSpaces, int payment, CurrencyType currency, CareerType careerType, Location location) {
        Id = id;
        Name = name;
        Description = description;
        NumberOfApplicants = numberOfApplicants;
        NumberOfFreeSpaces = numberOfFreeSpaces;
        Payment = payment;
        this.currency = currency;
        this.careerType = careerType;
        this.location = location;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNumberOfApplicants() {
        return NumberOfApplicants;
    }

    public void setNumberOfApplicants(int numberOfApplicants) {
        NumberOfApplicants = numberOfApplicants;
    }

    public int getNumberOfFreeSpaces() {
        return NumberOfFreeSpaces;
    }

    public void setNumberOfFreeSpaces(int numberOfFreeSpaces) {
        NumberOfFreeSpaces = numberOfFreeSpaces;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public CareerType getCareerType() {
        return careerType;
    }

    public void setCareerType(CareerType careerType) {
        this.careerType = careerType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}

