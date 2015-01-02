package eea.eprtr.controller;

import java.util.ArrayList;
import java.util.List;

import eea.eprtr.model.User;
import eea.eprtr.util.BreadCrumbs;

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
public class UserController {
	
    /**
     * JSP with ThymeLeaf
     */
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public String findUsersThymeLeaf(Model model){
        buildUserList(model);
        model.addAttribute("title", "Users List");
        BreadCrumbs.set(model, "Users List");
        return "users";
    }

    private void buildUserList(Model model) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Paul", "Chapman"));
        users.add(new User("Mike", "Wiesner"));
        users.add(new User("Mark", "Secrist"));
        users.add(new User("Ken", "Krueger"));
        users.add(new User("Wes", "Gruver"));
        users.add(new User("Kevin", "Crocker"));
        model.addAttribute("users", users);
    }

}
