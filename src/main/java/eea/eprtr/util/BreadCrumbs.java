package eea.eprtr.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import eea.eprtr.model.BreadCrumb;

/**
 * Generate the bread crumbs.
 */
public class BreadCrumbs {

    /** Eionet portal. This should be part of the layout template - not here. */
    private static BreadCrumb eionetCrumb;

    /** Toplevel of this site. */
    private static BreadCrumb homeCrumb;

    // To prevent initialisations.
    private BreadCrumbs() {
    }

    static {
        eionetCrumb = new BreadCrumb("http://www.eionet.europa.eu/", "Eionet");
        homeCrumb = new BreadCrumb("/", "E-PRTR");
    }

    /**
     * Convenience method to set a breadcrumb on a top level page.
     */
    public static void set(Model model, String lastcrumb) {
        BreadCrumbs.set(model, new BreadCrumb(null, lastcrumb));
    }

    /**
     * Convenience method to set a breadcrumb on a page one level below.
     */
    public static void set(Model model, String parentLink, String parentText, String lastcrumb) {
        BreadCrumbs.set(model, new BreadCrumb(parentLink, parentText), new BreadCrumb(null, lastcrumb));
    }

    /**
     * Create a indefinite list of breadcrumbs.
     */
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
