package art.timestop.searchjob.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import art.timestop.searchjob.entity.IrecruiterJobs;
import art.timestop.searchjob.entity.JobCompany;
import art.timestop.searchjob.entity.JobLocation;
import art.timestop.searchjob.entity.JobPostActivity;
import art.timestop.searchjob.entity.RecruiterJobsDto;
import art.timestop.searchjob.repository.JobPostActivityRepository;

@Service
public class JobPostActivityServiceImpl implements JobPostActivityService{

    private final JobPostActivityRepository jobPostActivityRepository;



    public JobPostActivityServiceImpl(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }


    @Override
    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity); 
    }


    @Override
    public List<RecruiterJobsDto> getRecruiterJobs(int recruiter) {
       List<IrecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecIrecruiterJobs(recruiter);
       
       List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();
       for(IrecruiterJobs rec : recruiterJobsDtos){
        JobLocation loc = new JobLocation(rec.getLocationId(), rec.getCity(), rec.getState(), rec.getCountry());
        JobCompany comp = new JobCompany(rec.getCompanyId(), rec.getName(), "");
        recruiterJobsDtoList.add(new RecruiterJobsDto(rec.getTotalCondidates(), rec.getJob_post_id(), rec.getJob_title(), loc, comp));
       }
       return recruiterJobsDtoList;
    }


    @Override
    public JobPostActivity getOne(int id) {
        return jobPostActivityRepository.findById(id).orElseThrow(()->new RuntimeException("Job not found"));
    }

}
