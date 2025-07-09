package art.timestop.searchjob.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import art.timestop.searchjob.entity.RecruiterProfile;
import art.timestop.searchjob.repository.RecruieterProfileRepository;

@Service
public class RecruiterProfileServiceImpl implements RecruiterProfileService{

    private final RecruieterProfileRepository recruieterProfileRepository;

    public RecruiterProfileServiceImpl(RecruieterProfileRepository recruieterProfileRepository) {
        this.recruieterProfileRepository = recruieterProfileRepository;
    }

    @Override
    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruieterProfileRepository.findById(id);
    }

    @Override
    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
       return recruieterProfileRepository.save(recruiterProfile);
    }

    

}
