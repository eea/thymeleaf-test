package eea.eprtr.model;

/**
 * Lookup Value.
 */
public class LOV {
	
    private String code;
    
    private String name;
    

    public LOV(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
}
