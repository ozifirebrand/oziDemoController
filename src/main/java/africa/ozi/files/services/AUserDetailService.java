package africa.ozi.files.services;

import africa.ozi.files.data.models.PrinterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class AUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PrinterUser printerUser = new PrinterUser();
        printerUser.setUsername("Toye");
        printerUser.setPassword("MyPassWord");

        return new User(printerUser.getUsername(), printerUser.getPassword(), new ArrayList<>());
    }

    public String createToken(Map<String, Object> claims, String subject){


        return subject;
    }
}
