package hu.miskolc.iit.application;

import hu.miskolc.iit.application.Exceptions.ApplicantIsNotFoundException;
import hu.miskolc.iit.application.Helpers.Education;
import hu.miskolc.iit.application.Helpers.Gender;
import hu.miskolc.iit.application.Models.Applicant;
import hu.miskolc.iit.application.dao.ApplicantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ApplicationRepositoryImpl implements ApplicantRepository {

    private List<Applicant> applicants;


    public ApplicationRepositoryImpl()
    {
        applicants = new ArrayList<Applicant>(){{
            this.add(new Applicant(1,"Kovács","Béla","", Gender.MALE,
                    "4933 Blackwell Street,Anchorage", Education.HIGHSCHOOL,20));
            this.add(new Applicant(2,"Kiss","Anna","", Gender.FEMALE,
                    "4029 Counts Lane, Connecticut", Education.ACADEMY,30));
            this.add(new Applicant(3,"Vincze","Gyula","", Gender.MALE,
                    "8411 Veszprém Izabella u. 72. ", Education.TERTIARY,18));
            this.add(new Applicant(4,"Pál","Borhala","", Gender.MALE,
                    "7585 Bakháza Eötvös út 3. ", Education.ACADEMY,20));
            this.add(new Applicant(5,"Szücs","Vanda","", Gender.MALE,
                    "8411 Veszprém Izabella u. 72. ", Education.PRIMARY,33));
            this.add(new Applicant(6,"Antal","Zsanett","", Gender.FEMALE,
                    "8411 Veszprém Izabella u. 72. ", Education.PRIMARY,42));
            this.add(new Applicant(7,"Vincze","Gyula","", Gender.MALE,
                    "150, Kallirois Avenue 8026 Paphos  ", Education.TERTIARY,29));
            this.add(new Applicant(8,"Vörös","Anna","", Gender.FEMALE,
                    "66 Shore Street STOCKPORT SK1 0PR ", Education.SECONDARY,25));
        }};
    }

    @Override
    public List<Applicant> findAll()
    {
        return applicants;
    }

    @Override
    public Applicant findById(int id) throws ApplicantIsNotFoundException
    {
        Applicant applicant = null;
        try
        {
            applicant = applicants.stream().filter(x -> x.getId() == id).findFirst().get();
        }
        catch (NoSuchElementException e)
        {
            throw  new ApplicantIsNotFoundException(id);
        }

        return applicant;
    }

    @Override
    public void save(Applicant applicant){
        this.applicants.add(applicant);
    }

    @Override
    public void delete(int id) throws ApplicantIsNotFoundException
    {
        Applicant applicantToBeRemoved = findById(id);
        this.applicants.remove(applicantToBeRemoved);
    }

    @Override
    public int getLastId()
    {
        return applicants.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }
}
