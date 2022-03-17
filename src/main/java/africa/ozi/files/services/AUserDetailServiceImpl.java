package africa.ozi.files.services;

import africa.ozi.files.data.models.Authority;
import africa.ozi.files.data.models.PrinterUser;
import africa.ozi.files.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PrinterUser printerUser = repository.findPrinterUserByUsername(username) ;
        if ( printerUser == null ){
            throw new UsernameNotFoundException("User with email: "+username + " does not exist!");
        }
        return new User(printerUser.getUsername(), printerUser.getPassword(), new ArrayList<>());
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities){
        return authorities.stream().map
                (authority -> {return new SimpleGrantedAuthority(
                    authority.name());
        }).collect(Collectors.toList());
    }
}
