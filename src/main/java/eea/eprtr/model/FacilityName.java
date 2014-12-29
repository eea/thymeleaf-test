package eea.eprtr.model;

public class FacilityName {
	
    private String code;
    
    private String name;
    

    public FacilityName(String code, String name) {
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
