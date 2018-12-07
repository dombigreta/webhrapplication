package web.config;


import hu.miskolc.iit.application.JobRepositoryImpl;
import hu.miskolc.iit.application.daoservice.JobRepository;
import hu.miskolc.iit.application.service.JobService;
import hu.miskolc.iit.application.serviceImpl.JobServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobMethodsContext {

    @Bean
    public JobService jobService() {
        return new JobServiceImpl();
    }

    @Bean
    public JobRepository jobRepository() {return new JobRepositoryImpl();}
}
