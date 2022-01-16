package africa.ozi.files;

import africa.ozi.files.data.repositories.OziRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = OziRepository.class)
public class OziMain {
    public static void main(String[] args) {
        SpringApplication.run(OziMain.class, args);
    }
}
