package art.timestop.searchjob.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skills {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

    private String name;

    private String experienceLevel;

    private String yearsOfExperience;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;

    public Skills() {
    }

    public Skills(int id, String name, String experienceLevel, String yearsOfExperience,
            JobSeekerProfile jobSeekerProfile) {
        Id = id;
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.yearsOfExperience = yearsOfExperience;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Skills [Id=" + Id + ", name=" + name + ", experienceLevel=" + experienceLevel + ", yearsOfExperience="
                + yearsOfExperience + ", jobSeekerProfile=" + jobSeekerProfile + "]";
    }

    
    

}
