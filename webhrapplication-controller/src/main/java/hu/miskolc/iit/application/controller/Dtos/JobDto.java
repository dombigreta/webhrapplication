package hu.miskolc.iit.application.controller.Dtos;

import hu.miskolc.iit.application.Models.Job;

public class JobDto {
    private String Name;
    private String Description;
    private int NumberOfApplicants;
    private int NumberOfFreePlaces;
    private int Payment;
    private String currency;
    private String careerType;
    private String location;

    public JobDto()
    {

    }

    public JobDto(String name, String description, int numberOfApplicants, int numberOfFreePlaces, int payment, String currency, String careerType, String location) {
        Name = name;
        Description = description;
        NumberOfApplicants = numberOfApplicants;
        NumberOfFreePlaces = numberOfFreePlaces;
        Payment = payment;
        this.currency = currency;
        this.careerType = careerType;
        this.location = location;
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

    public int getNumberOfFreePlaces() {
        return NumberOfFreePlaces;
    }

    public void setNumberOfFreePlaces(int numberOfFreePlaces) {
        NumberOfFreePlaces = numberOfFreePlaces;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCareerType() {
        return careerType;
    }

    public void setCareerType(String careerType) {
        this.careerType = careerType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}