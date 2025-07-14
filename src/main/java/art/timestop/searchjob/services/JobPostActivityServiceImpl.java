package art.timestop.searchjob.services;

import org.springframework.stereotype.Service;

import art.timestop.searchjob.entity.JobPostActivity;
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

}
