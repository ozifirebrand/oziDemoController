package africa.ozi.files.services;

import africa.ozi.files.data.models.Ozi;
import africa.ozi.files.dtos.requests.OziRequest;
import africa.ozi.files.dtos.responses.OziResponse;

public interface OziService {
    OziResponse createOzi (OziRequest oziRequest);
    Ozi findOzi (String id);
}
