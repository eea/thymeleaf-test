package eea.eprtr.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * This controller class is meant to be super-simple to understand for beginners.
 * We could have optimized it using wildcards in order to have less methods, but that would have made it harder to read.
 */

@Controller
public class SimpleDocController {

    /**
     * Frontpage.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        loadFromDB("/index", model);
        return "thymeleaf/simplecontent";
    }

    /**
     * About.
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        loadFromDB("/about", model);
        return "thymeleaf/simplecontent";
    }

    private void loadFromDB(String name, Model model) {
        Properties props = new Properties();
        try {
            InputStream inStream = SimpleDocController.class.getResourceAsStream(name + ".properties");
            props.load(inStream);
            inStream.close();
            for (String key : props.stringPropertyNames()) {
                model.addAttribute(key, props.getProperty(key));
            }
        } catch (IOException e) {
           model.addAttribute("title", "No properties file");
           model.addAttribute("content", "No properties file");
        }
    }
}
