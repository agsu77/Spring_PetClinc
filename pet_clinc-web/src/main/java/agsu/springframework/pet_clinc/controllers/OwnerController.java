package agsu.springframework.pet_clinc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.services.OwnerService;

@RequestMapping({ "owners", "Owners" })
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({ "/find" })
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> listOwners = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (listOwners.isEmpty()) {
            result.rejectValue("lastName", "notFound", "notFound");
            return "owners/findOwners";
        } else if (listOwners.size() == 1) {
            owner = listOwners.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", listOwners);
            return "owners/ownersList";
        }
    }

    @RequestMapping({ "/{ownerId}" })
    public ModelAndView showOwners(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }
}
