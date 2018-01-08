package com.botanik.dao.intf;

import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.Region;
import java.util.List;

/**
 *
 * *@author teyyub  Aug 1, 2016 9:18:54 AM
 */
public interface ContinentDAO {
     List<Continent> getContinents();
     List<Country> getCountries();
     List<Region> getRegions();
}
