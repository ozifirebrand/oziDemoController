package africa.ozi.files.dtos.requests;

import lombok.Data;

@Data
public class OziRequest {

    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;
    private String complexion;
    private String gender;

}
