package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import eea.eprtr.dao.FacilityService;
import eea.eprtr.dao.CountryService;
import eea.eprtr.model.FacilityName;
import eea.eprtr.model.FacilitySearchForm;
import eea.eprtr.model.LOV;
import eea.eprtr.util.BreadCrumbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private CountryService countryService;

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

    /**
     * Should get this from the database.
     */
    @ModelAttribute("allCountries")
    public List<LOV> populateCountries() {
        List<LOV> countries = countryService.getAll();
        countries.add(new LOV("-1", "All Reporting States for E-PRTR"));
        countries.add(new LOV("-2", "EU15"));
        countries.add(new LOV("-3", "EU25"));
        countries.add(new LOV("-4", "EU27"));
        return countries;
    }

    @ModelAttribute("allYears")
    public List<LOV> populateYears() {
        List<LOV> years = new ArrayList<LOV>();
        years.add(new LOV("2007", "2007"));
        years.add(new LOV("2008", "2008"));
        years.add(new LOV("2009", "2009"));
        years.add(new LOV("2010", "2010"));
        years.add(new LOV("2011", "2011"));
        years.add(new LOV("2012", "2012"));
        years.add(new LOV("2013", "2013"));
        return years;
    }

    @RequestMapping(value="/facilitylevels")
    public String facilityLevels(final FacilitySearchForm facilitySearchForm, Model model) {
        String pageTitle = "Search Facilities";
        model.addAttribute("title", pageTitle);
        BreadCrumbs.set(model, pageTitle);
        return "facilitylevels";
    }

    @RequestMapping(value="/facilitylevels", params={"search"})
    public String facilityLevels(final FacilitySearchForm facilitySearchForm, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "facilitylevels";
        }
        //Use the data in facilitySearchForm
        //facilityService.search(facilitySearchForm);
        model.clear();
        return "redirect:/facilitylevels";
    }
}
