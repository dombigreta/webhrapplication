package hu.miskolc.iit.application.controller;

import hu.miskolc.iit.application.Models.Job;
import hu.miskolc.iit.application.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("")
    public List<Job> helloWorld(){
        return jobService.getAllJobs();
    }


}
