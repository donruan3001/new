package ALURAPROJECT.demo.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ALURAPROJECT.demo.domain.User.RepositoryUser;

@Service
public class AutenticationService implements UserDetailsService{
    @Autowired
    private RepositoryUser repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return repository.findByEmail(email);

        
    }
   
}
