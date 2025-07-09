package art.timestop.searchjob.services;

import java.util.Optional;

import art.timestop.searchjob.entity.RecruiterProfile;

public interface RecruiterProfileService {

    public Optional<RecruiterProfile> getOne(Integer id);

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile);

}
