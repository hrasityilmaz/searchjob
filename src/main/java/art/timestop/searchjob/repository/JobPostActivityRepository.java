package art.timestop.searchjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import art.timestop.searchjob.entity.JobPostActivity;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    
}
