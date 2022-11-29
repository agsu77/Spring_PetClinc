package agsu.springframework.pet_clinc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import agsu.springframework.pet_clinc.services.VetService;

@Controller
public class VetController {

    
    private final VetService vetService;

    public VetController(VetService vetServiceParam) {
        this.vetService = vetServiceParam;
    }

    @RequestMapping({"Vets","vets"})
    public String indexVet(Model model){
        model.addAttribute("vets", vetService.findAll());
        
        return "vets/Vets";
    }

}
