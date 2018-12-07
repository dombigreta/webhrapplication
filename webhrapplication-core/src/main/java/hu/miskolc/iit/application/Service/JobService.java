package hu.miskolc.iit.application.Service;

import hu.miskolc.iit.application.Exceptions.JobIsNotFoundException;
import hu.miskolc.iit.application.Exceptions.WrongCareerTypeException;
import hu.miskolc.iit.application.Exceptions.WrongCurrencyTypeException;
import hu.miskolc.iit.application.Exceptions.WrongLocationException;
import hu.miskolc.iit.application.Models.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    Job getJobById(int id) throws JobIsNotFoundException;

    List<Job> filterJobs(String currency, String location, String career);

    void addNewJob(Job job) throws WrongLocationException, WrongCareerTypeException, WrongCurrencyTypeException;

    void deleteJobById(int id) throws JobIsNotFoundException;
}
