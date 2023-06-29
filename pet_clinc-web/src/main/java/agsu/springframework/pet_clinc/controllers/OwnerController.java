package agsu.springframework.pet_clinc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import agsu.springframework.pet_clinc.services.OwnerService;

@RequestMapping({ "owners", "Owners" })
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({ "", "/", "index" })
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/owners";
    }

    @RequestMapping({"/find" })
    public String findOwners() {
        return "notimplemented";
    }
    
    @RequestMapping({"/{ownerId}" })
    public ModelAndView showOwners(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }
}
