package eea.eprtr.model;

/**
 * This class implements one breadcrumb.
 */
public class BreadCrumb {
	
    /** link to place in hierarchy. Can be null for last crumb. */
    private String link;
    /** The text for the link. */
    private String linktext;


    public BreadCrumb(String link, String linktext) {
        this.link = link;
        this.linktext = linktext;
    }

    public String getLink() {
        return link;
    }

    /**
     * Return the breadcrumb link text, but truncate it if it is longer than 25 characters.
     */
    public String getLinktext() {
        if (linktext == null || "".equals(linktext)) {
            return "Unknown";
        } else if (linktext.length() >= 25) {
            return linktext.substring(0, 24) + "…";
        } else {
            return linktext;
        }
    }

}
