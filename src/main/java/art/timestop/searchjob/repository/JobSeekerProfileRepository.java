package art.timestop.searchjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import art.timestop.searchjob.entity.JobSeekerProfile;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {

}
