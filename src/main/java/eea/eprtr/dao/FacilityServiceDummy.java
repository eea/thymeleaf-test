package eea.eprtr.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eea.eprtr.model.FacilityName;

public class FacilityServiceDummy implements FacilityService {

    static private HashMap<String, FacilityName> facilityDB;

    static {
        facilityDB = new HashMap<String, FacilityName>();
        facilityDB.put("16586", new FacilityName("16586", "Alfa Laval Nakskov A/S"));
        facilityDB.put("16627", new FacilityName("16627", "Faxe Miljøanlæg"));
        facilityDB.put("16272", new FacilityName("16272", "Kildemosegård Svineproduktion ApS"));
        facilityDB.put("16992", new FacilityName("16992", "Miljøcenter Hasselø"));
        facilityDB.put("16882", new FacilityName("16882", "DONG ENERGY THERMAL POWER A/S, Stignæsværket"));
    }

    @Override
    public FacilityName getByCode(String code) {
        return facilityDB.get(code);
    }

    @Override
    public List<FacilityName> getAll() {
        List<FacilityName> facilities = new ArrayList<FacilityName>();
        for (FacilityName fn : facilityDB.values()) {
            facilities.add(fn);
        }
        return facilities;
    }

}
