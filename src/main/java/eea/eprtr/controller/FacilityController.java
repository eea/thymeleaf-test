package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import eea.eprtr.model.FacilityName;
import eea.eprtr.dao.FacilityService;
import eea.eprtr.util.BreadCrumbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping(value="/facilities", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(Model model){
        String pageTitle = "Facilities List";

        List<FacilityName> facilities = facilityService.getAll();
        model.addAttribute("facilities", facilities);
        model.addAttribute("title", pageTitle);
        BreadCrumbs.set(model, pageTitle);
        return "facilities";
    }

    @RequestMapping(value="/facilities/{facilityId}", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(@PathVariable String facilityId, Model model){
        FacilityName fn = facilityService.getByCode(facilityId);
        model.addAttribute("title", fn.getName());
        model.addAttribute("content", "Nothing here at the moment");
        BreadCrumbs.set(model, "/facilities", "Facilities List", fn.getName());
        return "simplecontent";
    }
}
