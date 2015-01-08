package eea.eprtr.controller;

import eea.eprtr.util.BreadCrumbs;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * See http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/multipart/MultipartFile.html
 * http://docs.oracle.com/javaee/6/tutorial/doc/gmhal.html
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileupload")
    public String fileUpload(Model model) {
        String pageTitle = "Upload file";
        BreadCrumbs.set(model, pageTitle);
        return "fileupload"; 
    } 

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST) 
    public String importFile(@RequestParam("file") MultipartFile myFile) throws IOException { 
        String pageTitle = "Upload file";

        File destination = new File("/var/tmp", UUID.randomUUID().toString());
        myFile.transferTo(destination);
        // Redirect to a successful upload page 
        return "redirect:uploadSuccess"; 
    } 

    @RequestMapping(value = "/uploadSuccess")
    public String faq(Model model) {
        String pageTitle = "File uploaded";
        BreadCrumbs.set(model, pageTitle);
        return "uploadSuccess";
    }
}
