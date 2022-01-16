package africa.ozi.files.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data

public class Ozi {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;
    private String complexion;
    private String gender;
}
