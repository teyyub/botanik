package com.botanik.dao.intf;

import com.botanik.model.Base;
import com.botanik.model.Collection;
import com.botanik.model.Collector;
import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.FirstCollector;
import com.botanik.model.Institution;
import com.botanik.model.Rank;
import com.botanik.model.Region;
import com.botanik.model.Series;
import com.botanik.model.Status;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
import java.util.List;

/**
 *
 * *@author teyyub  Aug 1, 2016 9:18:54 AM
 */
public interface ContinentDAO {
     List<Continent> getContinents();
     List<Country> getCountries();
     List<Region> getRegions();
     List<Rank> getRanks(); 
     List<Status> getTaxStatus();
     List<Status> getSpecimenStatusList();
     List<Institution> getInstitutionList();
     List<Voucher> getVoucherList();
     List<Type> getTTypesList();
     List<Base> getFamilyCategoryList();
     List<Series> getSerieses();
     List<Collector> getCollectorByType(int type);
     List<Collection> getCollection();
     void saveSeries(Series series);
     void saveResions(List<Region> regions);
     void saveContries(List<Country> regions);
     void saveInstitution(List<Institution> institions); 
     void saveCollection(List<Collection> collections);
     void saveVoucher(List<Voucher> vouchers);
     void saveTType(List<Type> types);
     void saveStatus(List<Status> statuses);
     void saveFamilyCategory(List<Base> familyCategory);
     void saveCollector(Collector colector);
     
}
