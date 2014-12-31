package eea.eprtr.model;

/**
 * This class implements one single simple html document.
 */
public class SimpleDoc {
	
    /** Name of page. */
    private String name;
    /** Title of page. */
    private String title;
    /** Content of page. */
    private String content;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
