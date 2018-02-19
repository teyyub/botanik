package com.botanik.dao.intf;

import com.botanik.model.Genus;
import com.botanik.model.Taxon;
import java.util.List;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:54:06 PM
 */
public interface GenusDAO {

    void saveGenus(Genus genus);
    List<Taxon> getTaxonList();
    List<Genus> getGenuses();
}
