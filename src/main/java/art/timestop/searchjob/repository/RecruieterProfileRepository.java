package art.timestop.searchjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import art.timestop.searchjob.entity.RecruiterProfile;

public interface RecruieterProfileRepository extends  JpaRepository<RecruiterProfile, Integer> {
    
}
