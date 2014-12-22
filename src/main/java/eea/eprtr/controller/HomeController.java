package eea.eprtr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * This controller class is meant to be super-simple to understand for beginners.
 * We could have optimized it using wildcards in order to have less methods, but that would have made it harder to read.
 * @author misvy
 */

@Controller
public class HomeController {
	
    /**
     * JSP with ThymeLeaf
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
        return "thymeleaf/index";
    }
}
