package art.timestop.searchjob.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import art.timestop.searchjob.entity.Users;
import art.timestop.searchjob.repository.UsersRepository;
import art.timestop.searchjob.util.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users users =  usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Couldnt found user"));
       return new CustomUserDetails(users);
    }

}
