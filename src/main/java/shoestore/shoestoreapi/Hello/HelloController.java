package shoestore.shoestoreapi.Hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/")
    public String sayhi(){
        return "Welcome to the ShoeStore";
    }

}
