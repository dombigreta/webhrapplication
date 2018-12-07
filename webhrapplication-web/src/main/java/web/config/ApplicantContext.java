package web.config;

import hu.miskolc.iit.application.Service.ApplicantService;
import hu.miskolc.iit.application.controller.ApplicantController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
public class ApplicantContext {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantContext(ApplicantService applicantService)
    {
        this.applicantService = applicantService;
    }

    @Bean
    public ApplicantController applicantController()
    {
        return new ApplicantController(applicantService);
    }
}
