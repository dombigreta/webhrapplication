package hu.miskolc.iit.application.Service;

import hu.miskolc.iit.application.Exceptions.ApplicantIsNotFoundException;
import hu.miskolc.iit.application.Exceptions.WrongEducationTypeException;
import hu.miskolc.iit.application.Exceptions.WrongGenderException;
import hu.miskolc.iit.application.Models.Applicant;

import java.util.List;

public interface ApplicantService {
    List<Applicant> getAllApplicants();

    Applicant getApplicantById(int Id) throws ApplicantIsNotFoundException;

    List<Applicant> filterApplicants(String gender, String education);

    void addNewApplicant(Applicant applicant) throws WrongEducationTypeException, WrongGenderException;

    void deleteApplicantById(int Id) throws ApplicantIsNotFoundException;

}
