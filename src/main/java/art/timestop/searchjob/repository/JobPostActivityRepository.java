package art.timestop.searchjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import art.timestop.searchjob.entity.IrecruiterJobs;
import art.timestop.searchjob.entity.JobPostActivity;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {

    @Query(value = " SELECT COUNT(s.user_id) as totalCandidates,j.job_post_id,j.job_title,l.id as locationId,l.city,l.state,l.country,c.id as companyId,c.name FROM job_post_activity j " +
            " inner join job_location l " +
            " on j.job_location_id = l.id " +
            " INNER join job_company c  " +
            " on j.job_company_id = c.id " +
            " left join job_seeker_apply s " +
            " on s.job = j.job_post_id " +
            " where j.posted_by_id = :recruiter " +
            " GROUP By j.job_post_id" ,nativeQuery = true)

    List<IrecruiterJobs> getRecIrecruiterJobs(@Param("recruiter") int recruiter);
}
