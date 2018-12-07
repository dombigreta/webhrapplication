package web.config;

import hu.miskolc.iit.application.ApplicationRepositoryImpl;
import hu.miskolc.iit.application.Service.ApplicantService;
import hu.miskolc.iit.application.Service.JobService;
import hu.miskolc.iit.application.dao.ApplicantRepository;
import hu.miskolc.iit.application.serviceImpl.ApplicantServiceImpl;
import hu.miskolc.iit.application.serviceImpl.JobServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicantMethodContext {
    @Bean
    public ApplicantService applicantService()
    {
        return new ApplicantServiceImpl();
    }
    @Bean
    public ApplicantRepository applicantRepository()
    {
        return new ApplicationRepositoryImpl();
    }
}
