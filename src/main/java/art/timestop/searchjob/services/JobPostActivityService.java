
package art.timestop.searchjob.services;

import java.util.List;

import art.timestop.searchjob.entity.JobPostActivity;
import art.timestop.searchjob.entity.RecruiterJobsDto;

public interface JobPostActivityService {
    public JobPostActivity addNew(JobPostActivity jobPostActivity);
    public List<RecruiterJobsDto> getRecruiterJobs(int recruiter);
    public JobPostActivity getOne(int id);
}
