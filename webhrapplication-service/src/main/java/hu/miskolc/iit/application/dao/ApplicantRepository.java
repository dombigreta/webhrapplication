package hu.miskolc.iit.application.dao;

import hu.miskolc.iit.application.Exceptions.ApplicantIsNotFoundException;
import hu.miskolc.iit.application.Models.Applicant;

import java.util.List;

public interface ApplicantRepository {
    List<Applicant> findAll();

    Applicant findById(int id) throws ApplicantIsNotFoundException;

    void save(Applicant applicant);

    void delete(int id) throws ApplicantIsNotFoundException;

    int getLastId();
}
