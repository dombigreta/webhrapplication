package hu.miskolc.iit.application.serviceImpl;

import hu.miskolc.iit.application.Exceptions.JobIsNotFoundException;
import hu.miskolc.iit.application.Exceptions.WrongCareerTypeException;
import hu.miskolc.iit.application.Exceptions.WrongCurrencyTypeException;
import hu.miskolc.iit.application.Exceptions.WrongLocationException;
import hu.miskolc.iit.application.Helpers.CareerType;
import hu.miskolc.iit.application.Helpers.CurrencyType;
import hu.miskolc.iit.application.Helpers.Location;
import hu.miskolc.iit.application.Models.Job;
import hu.miskolc.iit.application.dao.JobRepository;
import hu.miskolc.iit.application.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository repository;

    @Override
    public List<Job> getAllJobs()
    {
       return repository.findAll();
    }

    @Override
    public Job getJobById(int id) throws JobIsNotFoundException
    {
        return repository.findById(id);
    }

    @Override
    public List<Job> filterJobs(String currency, String location, String career)  throws WrongLocationException, WrongCareerTypeException, WrongCurrencyTypeException
    {
        List<Job> jobs = new ArrayList<Job>();
        List<Job> jobsToBeRemoved = new ArrayList<Job>();

        for(Job job : repository.findAll())
        {
            jobs.add(job);
        }

        for(Job job : jobs)
        {
            if(!isNull(currency))
            {
                try
                {
                    CurrencyType currencyFilter = CurrencyType.valueOf(currency.toUpperCase());
                    if(!job.getCurrency().equals(currencyFilter))
                    {
                        jobsToBeRemoved.add(job);
                        continue;
                    }
                }catch(IllegalArgumentException e)
                {
                    throw new WrongCurrencyTypeException(currency);
                }
            }

            if(!isNull(location))
            {
                try
                {
                    Location locationFilter = Location.valueOf(location.toUpperCase());
                    if(!job.getLocation().equals(locationFilter))
                    {
                        jobsToBeRemoved.add(job);
                        continue;
                    }
                }catch (IllegalArgumentException e)
                {
                    throw new WrongLocationException(location);
                }
            }

            if(!isNull(career))
            {
                try
                {
                    CareerType careerFilter = CareerType.valueOf(career.toUpperCase());
                    if(job.getCareerType().equals(careerFilter))
                    {
                        jobsToBeRemoved.add(job);
                        continue;
                    }

                }catch (IllegalArgumentException e)
                {
                    throw new WrongCareerTypeException(career);
                }
            }


        }

        jobs.removeAll(jobsToBeRemoved);
        return jobs;
    }
    @Override
    public void addNewJob(Job job)  throws WrongLocationException, WrongCareerTypeException, WrongCurrencyTypeException
    {
        job.setId(repository.getLastId());
        repository.save(job);
    }

    @Override
    public void deleteJobById(int id) throws JobIsNotFoundException
    {
        repository.remove(id);
    }


}
