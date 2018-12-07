package hu.miskolc.iit.application.Models;

import hu.miskolc.iit.application.Helpers.Education;
import hu.miskolc.iit.application.Helpers.Gender;

public class Applicant {

        private int Id;
        private String FirstName;
        private String LastName;
        private String MiddleName;
        private Gender gender;
        private String address;
        private Education education;
        private int age;

        public Applicant() {
        }

        public Applicant(int id, String firstName, String lastName, String middleName, Gender gender, String address, Education education, int age) {
            Id = id;
            FirstName = firstName;
            LastName = lastName;
            MiddleName = middleName;
            this.gender = gender;
            this.address = address;
            this.education = education;
            this.age = age;
        }

        public void setId(int id){
            Id =  id;
        }

        public int getId() {
            return Id;
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

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Education getEducation() {
            return education;
        }

        public void setEducation(Education education) {
            this.education = education;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
}
