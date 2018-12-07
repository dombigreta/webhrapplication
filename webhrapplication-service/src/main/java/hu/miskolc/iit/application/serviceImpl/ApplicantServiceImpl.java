package hu.miskolc.iit.application.serviceImpl;

import hu.miskolc.iit.application.Exceptions.ApplicantIsNotFoundException;
import hu.miskolc.iit.application.Exceptions.WrongEducationTypeException;
import hu.miskolc.iit.application.Exceptions.WrongGenderException;
import hu.miskolc.iit.application.Helpers.Education;
import hu.miskolc.iit.application.Helpers.Gender;
import hu.miskolc.iit.application.Models.Applicant;
import hu.miskolc.iit.application.Service.ApplicantService;
import hu.miskolc.iit.application.dao.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository repository;

    @Override
    public List<Applicant> getAllApplicants()
    {

        return repository.findAll();
    }

    @Override
    public Applicant getApplicantById(int Id) throws ApplicantIsNotFoundException
    {
        return repository.findById(Id);
    }

    @Override
    public List<Applicant> filterApplicants(String gender, String education) throws WrongEducationTypeException, WrongGenderException
    {
        List<Applicant> applicants = new ArrayList<Applicant>();
        List<Applicant> applicantsToBeRemoved = new ArrayList<Applicant>();

        for(Applicant app : repository.findAll())
        {
            applicants.add(app);
        }

        for(Applicant applicant : applicants)
        {
            if(!isNull(gender))
            {
                try
                {
                    Gender filterGender = Gender.valueOf(gender.toUpperCase());
                    if(!applicant.getGender().equals(filterGender))
                    {
                        applicantsToBeRemoved.add(applicant);
                        continue;
                    }

                }catch (IllegalArgumentException e)
                {
                    throw new WrongGenderException(gender);
                }
            }

            if(!isNull(education))
            {
                try
                {
                    Education filterEducation = Education.valueOf(education.toUpperCase());
                    if(!applicant.getEducation().equals(filterEducation))
                    {
                        applicantsToBeRemoved.add(applicant);
                        continue;
                    }

                }catch(IllegalArgumentException e)
                {
                    throw new WrongEducationTypeException(education);
                }
            }
        }
        applicants.removeAll(applicantsToBeRemoved);

        return applicants;
    }

    @Override
    public void addNewApplicant(Applicant applicant) throws WrongEducationTypeException, WrongGenderException
    {
        applicant.setId(repository.getLastId());
        repository.save(applicant);

    }

    @Override
    public void deleteApplicantById(int Id) throws ApplicantIsNotFoundException
    {
        repository.delete(Id);
    }
}
