package web.config;


import hu.miskolc.iit.application.controller.JobController;
import hu.miskolc.iit.application.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
public class JobContext {

    private final JobService jobService;

    @Autowired
    public JobContext(JobService jobService) {
        this.jobService = jobService;
    }

    @Bean
    public JobController jobController() {
        return new JobController(jobService);
    }


}