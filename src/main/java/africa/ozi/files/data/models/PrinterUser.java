package africa.ozi.files.data.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PrinterUser {
    String firstName;
    String password;
    String username;
}
