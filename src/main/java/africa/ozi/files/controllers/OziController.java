package africa.ozi.files.controllers;

import africa.ozi.files.dtos.requests.OziRequest;
import africa.ozi.files.dtos.responses.OziResponse;
import africa.ozi.files.services.OziService;
import africa.ozi.files.services.OziServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ozi/v1")
public class OziController {

    @Autowired
    private OziService oziService;

    @PostMapping("ozi")
    public ResponseEntity<?> createOzi(@RequestBody OziRequest request){

        return new ResponseEntity<>(oziService.createOzi(request), HttpStatus.CREATED);
    }

    @GetMapping("all_ozi")
    public ResponseEntity<?> findAnOzi(@RequestParam("id") String id){

        return new ResponseEntity<>(oziService.findOziById(id), HttpStatus.OK);
    }
}
