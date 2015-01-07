package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import eea.eprtr.dao.FacilityService;
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
        List<LOV> countries = new ArrayList<LOV>();
        countries.add(new LOV("-1", "All Reporting States for E-PRTR"));
        countries.add(new LOV("-2", "EU15"));
        countries.add(new LOV("-3", "EU25"));
        countries.add(new LOV("-4", "EU27"));
        countries.add(new LOV("15", "Austria"));
        countries.add(new LOV("22", "Belgium"));
        countries.add(new LOV("34", "Bulgaria"));
        countries.add(new LOV("57", "Cyprus"));
        countries.add(new LOV("58", "Czech Republic"));
        countries.add(new LOV("59", "Denmark"));
        countries.add(new LOV("68", "Estonia"));
        countries.add(new LOV("73", "Finland"));
        countries.add(new LOV("74", "France"));
        countries.add(new LOV("81", "Germany"));
        countries.add(new LOV("84", "Greece"));
        countries.add(new LOV("100", "Hungary"));
        countries.add(new LOV("101", "Iceland"));
        countries.add(new LOV("106", "Ireland"));
        countries.add(new LOV("109", "Italy"));
        countries.add(new LOV("122", "Latvia"));
        countries.add(new LOV("127", "Liechtenstein"));
        countries.add(new LOV("128", "Lithuania"));
        countries.add(new LOV("129", "Luxembourg"));
        countries.add(new LOV("137", "Malta"));
        countries.add(new LOV("156", "Netherlands"));
        countries.add(new LOV("166", "Norway"));
        countries.add(new LOV("177", "Poland"));
        countries.add(new LOV("178", "Portugal"));
        countries.add(new LOV("182", "Romania"));
        countries.add(new LOV("197", "Serbia"));
        countries.add(new LOV("201", "Slovakia"));
        countries.add(new LOV("202", "Slovenia"));
        countries.add(new LOV("207", "Spain"));
        countries.add(new LOV("213", "Sweden"));
        countries.add(new LOV("214", "Switzerland"));
        countries.add(new LOV("234", "United Kingdom"));
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
