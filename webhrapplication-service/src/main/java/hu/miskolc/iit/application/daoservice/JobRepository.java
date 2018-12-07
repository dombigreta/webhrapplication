package hu.miskolc.iit.application.daoservice;

import hu.miskolc.iit.application.Exceptions.JobIsNotFoundException;
import hu.miskolc.iit.application.Models.Job;

import java.util.Collection;
import java.util.List;

public interface JobRepository {

        List<Job> findAll();

        Job findById(int id) throws JobIsNotFoundException;

        void save(Job job);

        void remove(int id) throws  JobIsNotFoundException;

        int getLastId();
}
