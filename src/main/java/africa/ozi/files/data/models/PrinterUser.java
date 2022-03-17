package africa.ozi.files.data.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class PrinterUser {
    @Id
    private Long id;

    private String firstName;
    private String password;
    private String username;
}
