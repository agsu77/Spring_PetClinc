package agsu.springframework.pet_clinc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import agsu.springframework.pet_clinc.services.OwnerService;

@RequestMapping({ "owners", "Owners" })
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({ "", "/", "index" })
    public String indexOwner(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/owners";
    }
}
