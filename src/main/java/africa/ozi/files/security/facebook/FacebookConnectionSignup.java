package africa.ozi.files.security.facebook;

import africa.ozi.files.data.models.PrinterUser;
import africa.ozi.files.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
@Component
public class FacebookConnectionSignup implements ConnectionSignUp {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        PrinterUser user = new PrinterUser();
        user.setPassword(randomAlphabetic(8));
        user.setUsername(connection.getDisplayName());
        userRepository.save(user);
        return user.getUsername();
    }
}
