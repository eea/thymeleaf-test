package eea.eprtr.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import eea.eprtr.model.BreadCrumb;

/**
 * Generate the bread crumbs.
 */
public class BreadCrumbs {
    private static BreadCrumb eionetCrumb;
    private static BreadCrumb homeCrumb;

    static {
        eionetCrumb = new BreadCrumb("http://eionet.europa.eu/", "Eionet");
        homeCrumb = new BreadCrumb("/", "E-PRTR");
    }

    public static void set(Model model, BreadCrumb... crumbs) {
        List<BreadCrumb> breadcrumbList = new ArrayList<BreadCrumb>();

        breadcrumbList.add(eionetCrumb);
        breadcrumbList.add(homeCrumb);

        for (BreadCrumb crumb : crumbs) {
            breadcrumbList.add(crumb);
        }
        model.addAttribute("breadcrumbs", breadcrumbList);
    }

}
