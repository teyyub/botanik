 

package com.botanik.dao.intf;

import com.botanik.model.Taxon;
import java.util.List;

/**
 *
 * @author teyyub , Feb 5, 2018 ,  10:04:45 AM 
 */
public interface TaxonDAO {
  void saveTaxon(Taxon taxon);
  List<Taxon> getTaxon();
}
