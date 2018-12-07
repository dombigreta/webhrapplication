package hu.miskolc.iit.application.controller.Converters;

import hu.miskolc.iit.application.Exceptions.WrongEducationTypeException;
import hu.miskolc.iit.application.Exceptions.WrongGenderException;
import hu.miskolc.iit.application.Helpers.Education;
import hu.miskolc.iit.application.Helpers.Gender;
import hu.miskolc.iit.application.Models.Applicant;
import hu.miskolc.iit.application.controller.Dtos.ApplicantDto;
import hu.miskolc.iit.application.controller.Dtos.JobDto;

import java.util.ArrayList;
import java.util.List;

public class ApplicantConverter {
    public static ApplicantDto ConvertApplicantToApplicantDto(Applicant applicant)
    {
        return new ApplicantDto(applicant.getFirstName(),
                                applicant.getLastName(),
                                applicant.getMiddleName(),
                                applicant.getGender().toString(),
                                applicant.getAddress(),
                                applicant.getEducation().toString(),
                                applicant.getAge());
    }

    public static List<ApplicantDto> ConvertApplicantsToApplicantDtoList(List<Applicant> applicants)
    {
        List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
        applicants.stream().forEach(applicant ->
        {
            ApplicantDto applicantDto = new ApplicantDto(   applicant.getFirstName(),
                                                            applicant.getLastName(),
                                                            applicant.getMiddleName(),
                                                            applicant.getGender().toString(),
                                                            applicant.getAddress(),
                                                            applicant.getEducation().toString(),
                                                            applicant.getAge());
            applicantDtos.add(applicantDto);
        });

        return applicantDtos;
    }

    public static Applicant ConvertApplicantDtoToApplicant(ApplicantDto applicantDto)
    {
        Gender gender;
        Education education;
        try
        {
            gender = Gender.valueOf(applicantDto.getGender().toUpperCase());
        }catch (IllegalArgumentException e)
        {
            throw new WrongGenderException(applicantDto.getGender());
        }

        try
        {
            education = Education.valueOf(applicantDto.getEducation().toUpperCase());
        }catch (IllegalArgumentException e)
        {
            throw new WrongEducationTypeException(applicantDto.getEducation());
        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setMiddleName(applicantDto.getMiddleName());
        applicant.setEducation(Education.valueOf(applicantDto.getEducation().toUpperCase()));
        applicant.setGender(Gender.valueOf(applicantDto.getGender().toUpperCase()));
        applicant.setAddress(applicantDto.getAddress());
        applicant.setAge(applicant.getAge());

        return applicant;

    }



}
