package hu.miskolc.iit.application.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import hu.miskolc.iit.application.Exceptions.ApplicantIsNotFoundException;
import hu.miskolc.iit.application.Exceptions.WrongEducationTypeException;
import hu.miskolc.iit.application.Exceptions.WrongGenderException;
import hu.miskolc.iit.application.Service.ApplicantService;
import hu.miskolc.iit.application.controller.Converters.ApplicantConverter;
import hu.miskolc.iit.application.controller.Dtos.ApplicantDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private ApplicantService service;

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    /*Get Mappings*/
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ApplicantDto> getAllApplicant() {
        return ApplicantConverter.ConvertApplicantsToApplicantDtoList(service.getAllApplicants());
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ApplicantDto getApplicantById(@PathVariable("id") int id) {
        return ApplicantConverter.ConvertApplicantToApplicantDto(service.getApplicantById(id));
    }

    @GetMapping(value="/filterApplicants", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ApplicantDto> filterApplicants(@RequestParam(value="gender",required = false) String gender,
                                               @RequestParam(value="education", required = false) String education)
    {
        return ApplicantConverter.ConvertApplicantsToApplicantDtoList(service.filterApplicants(gender,education));
    }

    @PostMapping(value="/newApplicant", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addApplicant(@RequestBody ApplicantDto applicantDto)
    {
        service.addNewApplicant(ApplicantConverter.ConvertApplicantDtoToApplicant(applicantDto));
    }

    /*Delete Mappings*/
    @DeleteMapping(value = "{id}")
    public void DeleteApplicantById(@PathVariable("id") int id)
    {
        service.deleteApplicantById(id);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicantIsNotFoundException.class)
    public String ApplicantisNotFoundExceptionHandler(ApplicantIsNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(WrongGenderException.class)
    public String WrongGenderExceptionHandler(WrongGenderException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(WrongEducationTypeException.class)
    public String WrongEducationTypeExceptionHandler(WrongEducationTypeException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public String HandleInvalidIdInput(Exception e)
    {
        return "The id you have given was not valid! Please only use numbers!";
    }


}
