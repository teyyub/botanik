package com.botanik.model;
 
import java.util.Date;


/**
 *
 * @author teyyub
 */
public class Specimen {

//    private String voucher;
//    private String institution;
//    private Family family = new Family();
//    private String collector;
//    private String continent;
//    private String country;
//    private int herbarNo;
  
    private int number;
    private Number institution_id;
    private String nbr;
    private int garden_id;
    private int taxon_id;
    private int typified_id;
    private int series_id;
    private Date date;
    
    private int country_id;
    private String locality;
    private String annotation;
    private String ser_nr;
    private boolean accessible;
    private boolean dg_image;
    private boolean dg_im_obs;
    private boolean checked;
    private String herba_no;
    private int collection_id;
    private int type_id;
    private int voucher_id;
    private String def_Ref_conf;
    private int first_collector_id;
    private int add_collector_id;
    private int status_id;
    
//    private String region;
//    private String state_or_province;
//    private String series;
//    private String ident_history;
//    private String garden;
//    private String det_ref_conf;
//    private String typified_by;
//    private String habitus;
//    private String phorophyte;
//    private String locality;
//    private String epithet;
//    Date date;
//    String location;
//    String annotation;
//    private Serie serie = new Serie();
//    private Epithet epithet = new Epithet();
//    private Author author = new Author();
//    private Genus genus = new Genus();
//    private Taxon taxon = new Taxon();

//    public String getLocality() {
//        return locality;
//    }
//
//    public void setLocality(String locality) {
//        this.locality = locality;
//    }
//
//    public String getPhorophyte() {
//        return phorophyte;
//    }
//
//    public void setPhorophyte(String phorophyte) {
//        this.phorophyte = phorophyte;
//    }
//
//    public String getHabitus() {
//        return habitus;
//    }
//
//    public void setHabitus(String habitus) {
//        this.habitus = habitus;
//    }
//    
//    
//    
//    public String getDet_ref_conf() {
//        return det_ref_conf;
//    }
//
//    public void setDet_ref_conf(String det_ref_conf) {
//        this.det_ref_conf = det_ref_conf;
//    }
//
//    public String getTypified_by() {
//        return typified_by;
//    }
//
//    public void setTypified_by(String typified_by) {
//        this.typified_by = typified_by;
//    }     
//    
//    public Genus getGenus() {
//        return genus;
//    }
//
//    public void setGenus(Genus genus) {
//        this.genus = genus;
//    }
//       
//    
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//    
//    public Epithet getEpithet() {
//        return epithet;
//    }
//
//    public void setEpithet(Epithet epithet) {
//        this.epithet = epithet;
//    }
//    
//    
//
//    public Serie getSerie() {
//        return serie;
//    }
//
//    public void setSerie(Serie serie) {
//        this.serie = serie;
//    }
//
//    public String getVoucher() {
//        return voucher;
//    }
//
//    public void setVoucher(String voucher) {
//        this.voucher = voucher;
//    }
//
//    public String getInstitution() {
//        return institution;
//    }
//
//    public void setInstitution(String institution) {
//        this.institution = institution;
//    }
//
//    public Family getFamily() {
//        return family;
//    }
//
//    public void setFamily(Family family) {
//        this.family = family;
//    }
//
//   
//
//    public String getCollector() {
//        return collector;
//    }
//
//    public void setCollector(String collector) {
//        this.collector = collector;
//    }
//
//    public String getContinent() {
//        return continent;
//    }
//
//    public void setContinent(String continent) {
//        this.continent = continent;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public int getHerbarNo() {
//        return herbarNo;
//    }
//
//    public void setHerbarNo(int herbarNo) {
//        this.herbarNo = herbarNo;
//    }
//
//    public Taxon getTaxon() {
//        return taxon;
//    }
//
//    public void setTaxon(Taxon taxon) {
//        this.taxon = taxon;
//    }
//
//    
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
//
//    public String getRegion() {
//        return region;
//    }
//
//    public void setRegion(String region) {
//        this.region = region;
//    }
//
//    public String getState_or_province() {
//        return state_or_province;
//    }
//
//    public void setState_or_province(String state_or_province) {
//        this.state_or_province = state_or_province;
//    }
//
//    public String getSeries() {
//        return series;
//    }
//
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public String getIdent_history() {
//        return ident_history;
//    }
//
//    public void setIdent_history(String ident_history) {
//        this.ident_history = ident_history;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getAnnotation() {
//        return annotation;
//    }
//
//    public void setAnnotation(String annotation) {
//        this.annotation = annotation;
//    }
//
//    public String getGarden() {
//        return garden;
//    }
//
//    public void setGarden(String garden) {
//        this.garden = garden;
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Number getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id( Number institution_id) {
        this.institution_id = institution_id;
    }

    public String getNbr() {
        return nbr;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public int getGarden_id() {
        return garden_id;
    }

    public void setGarden_id(int garden_id) {
        this.garden_id = garden_id;
    }

    public int getTaxon_id() {
        return taxon_id;
    }

    public void setTaxon_id(int taxon_id) {
        this.taxon_id = taxon_id;
    }

    public int getTypified_id() {
        return typified_id;
    }

    public void setTypified_id(int typified_id) {
        this.typified_id = typified_id;
    }

    public int getSeries_id() {
        return series_id;
    }

    public void setSeries_id(int series_id) {
        this.series_id = series_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getSer_nr() {
        return ser_nr;
    }

    public void setSer_nr(String ser_nr) {
        this.ser_nr = ser_nr;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isDg_image() {
        return dg_image;
    }

    public void setDg_image(boolean dg_image) {
        this.dg_image = dg_image;
    }

    public boolean isDg_im_obs() {
        return dg_im_obs;
    }

    public void setDg_im_obs(boolean dg_im_obs) {
        this.dg_im_obs = dg_im_obs;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getHerba_no() {
        return herba_no;
    }

    public void setHerba_no(String herba_no) {
        this.herba_no = herba_no;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getDef_Ref_conf() {
        return def_Ref_conf;
    }

    public void setDef_Ref_conf(String def_Ref_conf) {
        this.def_Ref_conf = def_Ref_conf;
    }

    public int getFirst_collector_id() {
        return first_collector_id;
    }

    public void setFirst_collector_id(int first_collector_id) {
        this.first_collector_id = first_collector_id;
    }

    public int getAdd_collector_id() {
        return add_collector_id;
    }

    public void setAdd_collector_id(int add_collector_id) {
        this.add_collector_id = add_collector_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

}
