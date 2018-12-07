package hu.miskolc.iit.application.controller.Converters;


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

}
