package web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class TSPWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext acwactx = new AnnotationConfigWebApplicationContext();

        acwactx.register(JobContext.class);
        acwactx.setServletContext(servletContext);

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet((WebApplicationContext) acwactx));

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

    }
}
