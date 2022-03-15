package africa.ozi.files.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ozi/v1")
public class OziController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
