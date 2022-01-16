package africa.ozi.files.controllers;

import africa.ozi.files.dtos.requests.OziRequest;
import africa.ozi.files.dtos.responses.OziResponse;
import africa.ozi.files.services.OziService;
import africa.ozi.files.services.OziServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OziController {
    private final OziService oziService = new OziServiceImpl();

    @PostMapping("ozi")
    public ResponseEntity<?> createOzi(OziRequest request){

        OziResponse response = oziService.createOzi(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("all_ozi")
    public ResponseEntity<?> findAnOzi(String id){

        return new ResponseEntity<>(oziService.findOzi(id), HttpStatus.OK);
    }
}
