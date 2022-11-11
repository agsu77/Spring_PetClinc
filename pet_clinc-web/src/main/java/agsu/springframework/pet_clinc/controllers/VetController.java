package agsu.springframework.pet_clinc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping({"Vets","vets"})
    public String indexVet(){
        return "vets/Vets";
    }

}
