package com.botanik.dao.intf;

import com.botanik.model.SearchModel;
import com.botanik.model.Specimen;
import com.botanik.model.SpecimenSaveModel;
import java.util.List;

/**
 *
 * @author teyyub , Feb 5, 2018 , 6:08:35 PM
 */
public interface SpecimenDAO {

    void saveSpecimen(Specimen specimen);

    void saveSpecimen(SpecimenSaveModel model);

    List<Specimen> getSpecimenBy(Specimen specimen);

    List<Specimen> getSpecimenByModel(SearchModel model);

}
