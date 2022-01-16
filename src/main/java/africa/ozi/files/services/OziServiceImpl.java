package africa.ozi.files.services;

import africa.ozi.files.data.models.Ozi;
import africa.ozi.files.data.repositories.OziRepository;
import africa.ozi.files.dtos.requests.OziRequest;
import africa.ozi.files.dtos.responses.OziResponse;
import africa.ozi.files.modelMapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OziServiceImpl implements OziService {
    @Autowired
    private OziRepository repository;
    @Override
    public OziResponse createOzi(OziRequest oziRequest) {
        Ozi ozi = ModelMapper.map(oziRequest);

        repository.save(ozi);

        return ModelMapper.map(ozi);
    }

    @Override
    public Ozi findOzi(String id) {
        return repository.findById(id).get();
    }

}
