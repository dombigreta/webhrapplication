package hu.miskolc.iit.application.controller.Converters;


import hu.miskolc.iit.application.Exceptions.WrongCareerTypeException;
import hu.miskolc.iit.application.Exceptions.WrongCurrencyTypeException;
import hu.miskolc.iit.application.Exceptions.WrongLocationException;
import hu.miskolc.iit.application.Helpers.CareerType;
import hu.miskolc.iit.application.Helpers.CurrencyType;
import hu.miskolc.iit.application.Helpers.Location;
import hu.miskolc.iit.application.Models.Job;
import hu.miskolc.iit.application.controller.Dtos.JobDto;

import java.util.ArrayList;
import java.util.List;

public class JobConverter {

    public static JobDto ConvertJobToJobDto(Job job)
    {
        return new JobDto(  job.getName(),
                            job.getDescription(),
                            job.getNumberOfApplicants(),
                            job.getNumberOfFreeSpaces(),
                            job.getPayment(),
                            job.getCurrency().toString(),
                            job.getCareerType().toString(),
                            job.getLocation().toString());
    }

    public static List<JobDto> ConvertJobListToJobDto(List<Job> jobs)
    {
        List<JobDto> jobDtos = new ArrayList<JobDto>();
        jobs.stream().forEach(job ->
        {
            JobDto jobDto = new JobDto(
                    job.getName(),
                    job.getDescription(),
                    job.getNumberOfApplicants(),
                    job.getNumberOfFreeSpaces(),
                    job.getPayment(),
                    job.getCurrency().toString(),
                    job.getCareerType().toString(),
                    job.getLocation().toString()
            );
            jobDtos.add(jobDto);
        });

        return jobDtos;
    }

    public static Job ConvertJobDtoToJob(JobDto jobDto) throws WrongLocationException, WrongCareerTypeException, WrongCurrencyTypeException
    {

        Location location;
        CareerType career;
        CurrencyType currency;
        try
        {
            location = Location.valueOf(jobDto.getLocation().toUpperCase());
        }catch (IllegalArgumentException e)
        {
            throw new WrongLocationException(jobDto.getLocation());
        }

        try
        {
            career = CareerType.valueOf(jobDto.getCareerType().toUpperCase());
        }catch (IllegalArgumentException e)
        {
            throw new WrongCareerTypeException(jobDto.getCareerType());
        }


        try
        {
            currency = CurrencyType.valueOf(jobDto.getCurrency().toUpperCase());
        }catch (IllegalArgumentException e)
        {
            throw new WrongCurrencyTypeException(jobDto.getCurrency());

        }
        Job job = new Job();
        job.setCareerType(CareerType.valueOf(jobDto.getCareerType().toUpperCase()));
        job.setCurrency(CurrencyType.valueOf(jobDto.getCurrency().toUpperCase()));
        job.setLocation(Location.valueOf(jobDto.getLocation().toUpperCase()));
        job.setDescription(jobDto.getDescription());
        job.setName(jobDto.getName());
        job.setNumberOfApplicants(jobDto.getNumberOfApplicants());
        job.setNumberOfFreeSpaces(jobDto.getNumberOfFreePlaces());
        return job;
    }

}
