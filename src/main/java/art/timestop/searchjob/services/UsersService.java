package art.timestop.searchjob.services;

import java.util.Optional;

import art.timestop.searchjob.entity.Users;


public interface UsersService {
    public Users addNew(Users users);
    Optional<Users> getUserByEmail(String email);
    public Object getCurrentUserProfile();
}
