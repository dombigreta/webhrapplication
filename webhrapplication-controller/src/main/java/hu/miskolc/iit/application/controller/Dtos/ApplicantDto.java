package hu.miskolc.iit.application.controller.Dtos;

public class ApplicantDto {
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String gender;
    private String address;
    private String education;
    private int age;


    public ApplicantDto() {
    }

    public ApplicantDto(String firstName, String lastName, String middleName, String gender, String address, String education, int age) {
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        this.gender = gender;
        this.address = address;
        this.education = education;
        this.age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}