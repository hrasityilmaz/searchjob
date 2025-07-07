package art.timestop.searchjob.services;

import java.util.List;

import org.springframework.stereotype.Service;

import art.timestop.searchjob.entity.UsersType;
import art.timestop.searchjob.repository.UsersTypeRepository;

@Service
public class UsersTypeServiceImpl implements UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeServiceImpl(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    @Override
    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }

}
