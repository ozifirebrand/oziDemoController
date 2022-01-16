package africa.ozi.files.modelMapper;

import africa.ozi.files.data.models.Ozi;
import africa.ozi.files.dtos.requests.OziRequest;
import africa.ozi.files.dtos.responses.OziResponse;

public class ModelMapper {

    public static Ozi map (OziRequest oziRequest){
        Ozi ozi = new Ozi();
        ozi.setAge(oziRequest.getAge());
        ozi.setComplexion(oziRequest.getComplexion());
        ozi.setFirstName(oziRequest.getFirstName());
        ozi.setGender(oziRequest.getGender());
        ozi.setHeight(oziRequest.getHeight());
        ozi.setLastName(oziRequest.getLastName());
        ozi.setWeight(ozi.getWeight());

        return ozi;

    }

    public static OziResponse map(Ozi ozi){
        OziResponse response = new OziResponse();
        response.setFirstName(ozi.getFirstName());
        response.setGender(ozi.getGender());
        response.setLastName(ozi.getLastName());

        return response;

    }
}
