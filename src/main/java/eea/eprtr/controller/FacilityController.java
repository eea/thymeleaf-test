package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;

import eea.eprtr.model.FacilityName;
import eea.eprtr.util.BreadCrumbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * This controller class is meant to be super-simple to understand for beginners.
 * We could have optimized it using wildcards in order to have less methods, but that would have made it harder to read.
 * @author misvy
 */

@Controller
public class FacilityController {
	
    @RequestMapping(value="/facilities", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(Model model){
        buildFacilityList(model);
        model.addAttribute("title", "Facilities List");
        BreadCrumbs.set(model, "Facilities List");
        return "thymeleaf/facilities";
    }

    @RequestMapping(value="/facilities/{facilityId}", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(@PathVariable String facilityId, Model model){
        buildFacilityList(model);
        model.addAttribute("title", "Facility #" + facilityId);
        model.addAttribute("content", "Nothing here at the moment");
        BreadCrumbs.set(model, "/facilities", "Facilities List", "Facility #" + facilityId);
        return "thymeleaf/simplecontent";
    }

    private void buildFacilityList(Model model) {
        List<FacilityName> facilities = new ArrayList<FacilityName>();
        facilities.add(new FacilityName("16586", "Alfa Laval Nakskov A/S"));
        facilities.add(new FacilityName("16627", "Faxe Miljøanlæg"));
        facilities.add(new FacilityName("16272", "Kildemosegård Svineproduktion ApS"));
        facilities.add(new FacilityName("16992", "Miljøcenter Hasselø"));
        facilities.add(new FacilityName("16882", "DONG ENERGY THERMAL POWER A/S, Stignæsværket"));
        model.addAttribute("facilities", facilities);
    }

}
