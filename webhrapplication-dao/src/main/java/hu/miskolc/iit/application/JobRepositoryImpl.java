package hu.miskolc.iit.application;

import hu.miskolc.iit.application.Exceptions.JobIsNotFoundException;
import hu.miskolc.iit.application.Helpers.CareerType;
import hu.miskolc.iit.application.Helpers.CurrencyType;
import hu.miskolc.iit.application.Helpers.Location;
import hu.miskolc.iit.application.Models.Job;
import hu.miskolc.iit.application.dao.JobRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Repository
public class JobRepositoryImpl implements JobRepository {

    private List<Job> jobs;

    public JobRepositoryImpl()
    {
        jobs = new ArrayList<Job>()
        {{
            this.add(new Job(1,"Truck Driver","MINIMUM " +
                    "2 YEARS EXPERIENCE NEEDED, CALL FOR DETAILS 586-610-1123.. " +
                    "TRUCK DRIVER WANTED ... UP TO 55 CPM - 2000.00 BONUS (Clinton Township) " +
                    "Driver Referral Program",
                    12,  2, 100000, CurrencyType.USD,
                    CareerType.INDUSTRIAL, Location.AMERICA));

            this.add(new Job(2,"Registered Nurse" ,"FULL TIME - NIGHT SHIFT **** " +
                    "The Registered Nurse is directly responsible for the care given to " +
                    "his/her assigned patients. He/She communicates with the physician about changes",
                    100,90, 20000,CurrencyType.EUR,CareerType.MEDICAL,Location.EUROPE));

            this.add(new Job(3,"Freelance Writer" ,"We are looking for part-time freelance writers to work " +
                    "2-3 days per week and contribute 4-5 articles per day (~300 words/article).",
                    100,90, 2000, CurrencyType.HUF,CareerType.MEDIA, Location.HUNGARY));
        }};
    }

    @Override
    public List<Job> findAll()
    {
        return jobs;
    }

    @Override
    public Job findById(int id) throws JobIsNotFoundException {
        Job job = null;
        try
        {
            job = jobs.stream().filter(x -> x.getId() == id).findAny().get();
        }
        catch (NoSuchElementException e)
        {
            throw new JobIsNotFoundException(id);
        }
        return job;
    }

    @Override
    public void save(Job job)
    {

        System.out.println(job.getDescription());
        jobs.add(job);
    }

    @Override
    public void remove(int id) throws  JobIsNotFoundException
    {
        Job jobToBeDeleted = findById(id);
        jobs.remove(jobToBeDeleted);
    }
    @Override
    public int getLastId()
    {
        return jobs.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }
}
