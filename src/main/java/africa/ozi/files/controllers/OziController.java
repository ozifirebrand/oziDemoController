package africa.ozi.files.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ozi/v1")
public class OziController {
    @GetMapping("/hello")
    public ResponseEntity<?> hello(String name){
        return ResponseEntity.ok().body("Hello" +name);
    }
}
