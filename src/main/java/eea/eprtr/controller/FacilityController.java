package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import eea.eprtr.model.FacilityName;
import eea.eprtr.util.BreadCrumbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class FacilityController {

    static HashMap<String, FacilityName> facilityDB;

    static {
        facilityDB = new HashMap<String, FacilityName>();
        facilityDB.put("16586", new FacilityName("16586", "Alfa Laval Nakskov A/S"));
        facilityDB.put("16627", new FacilityName("16627", "Faxe Miljøanlæg"));
        facilityDB.put("16272", new FacilityName("16272", "Kildemosegård Svineproduktion ApS"));
        facilityDB.put("16992", new FacilityName("16992", "Miljøcenter Hasselø"));
        facilityDB.put("16882", new FacilityName("16882", "DONG ENERGY THERMAL POWER A/S, Stignæsværket"));
    }

    @RequestMapping(value="/facilities", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(Model model){
        buildFacilityList(model);
        model.addAttribute("title", "Facilities List");
        BreadCrumbs.set(model, "Facilities List");
        return "facilities";
    }

    @RequestMapping(value="/facilities/{facilityId}", method=RequestMethod.GET)
    public String findFacilitiesThymeLeaf(@PathVariable String facilityId, Model model){
        FacilityName fn = facilityDB.get(facilityId);
        model.addAttribute("title", fn.getName());
        model.addAttribute("content", "Nothing here at the moment");
        BreadCrumbs.set(model, "/facilities", "Facilities List", fn.getName());
        return "simplecontent";
    }

    private void buildFacilityList(Model model) {
        List<FacilityName> facilities = new ArrayList<FacilityName>();
        for (FacilityName fn : facilityDB.values()) {
            facilities.add(fn);
        }
        model.addAttribute("facilities", facilities);
    }

}
