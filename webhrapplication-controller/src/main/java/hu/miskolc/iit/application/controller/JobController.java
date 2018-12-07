package hu.miskolc.iit.application.controller;

import hu.miskolc.iit.application.Exceptions.JobIsNotFoundException;
import hu.miskolc.iit.application.controller.Converters.JobConverter;
import hu.miskolc.iit.application.controller.Dtos.JobDto;
import hu.miskolc.iit.application.service.JobService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /*Get Mappings*/
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<JobDto> GetAllJobs()
    {
        return JobConverter.ConvertJobListToJobDto(jobService.getAllJobs());
    }
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JobDto GetJobById(@PathVariable("id") int id)
    {
        return JobConverter.ConvertJobToJobDto(jobService.getJobById(id));
    }

    @GetMapping(value="/filterJobs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<JobDto> FilterJobs(@RequestParam(value = "currency", required = false) String currency,
                                   @RequestParam(value="location",required = false) String location,
                                   @RequestParam(value="career", required = false)  String career)
    {
        return JobConverter.ConvertJobListToJobDto(jobService.filterJobs(currency,location,career));
    }

    @DeleteMapping(value="/deleteJob/{id}")
    public void DeleteJob(@PathVariable("id") int id)
    {
        jobService.deleteJobById(id);
    }

    /*Exception handlers*/
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JobIsNotFoundException.class)
    public String JobIsNotFoundExceptionHandler(JobIsNotFoundException e)
    {
        return e.getMessage();
    }

    
}
