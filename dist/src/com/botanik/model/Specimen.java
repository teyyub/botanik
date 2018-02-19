package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub
 */
public class Specimen {

    private int number;
    private Number institution_id;
    private String nbr;
    private Number region_id;
    private Number taxon_id;
    private String taxonName;
    private String typified_id;
    private String iden_history;

    private Date date;
    private Date beginDate;
    private Date endDate;
    private String date1;
    private String date2;
    private Number country_id;
    private String locality;
    private String annotation;
    private String ser_nr;

    private String herba_no;
    private Number collection_id;
    private String collectionName;
    private Number type_id;
    private Number voucher_id;
    private String def_Ref_conf;
    private Number first_collector_id;
    private Number add_collector_id;
    private Number status_id;
    private Number image_id;
    private String habitat;
    private String literature;
    private String note;
    private Double n1;
    private Double n2;
    private Double n3;
    private Double e1;
    private Double e2;
    private Double e3;
    private Double degLat;
    private Double degLong;
    private String image_folder;
    private String status;
    private String collectorName;

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }
    
    

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    
    
    public String getImage_folder() {
        return image_folder;
    }

    public void setImage_folder(String image_folder) {
        this.image_folder = image_folder;
    }

    public String getTaxonName() {
        return taxonName;
    }

    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }

    
    public Double getDegLat() {
        return degLat;
    }

    public void setDegLat(Double degLat) {
        this.degLat = degLat;
    }

    public Double getDegLong() {
        return degLong;
    }

    public void setDegLong(Double degLong) {
        this.degLong = degLong;
    }
   
    
    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getN3() {
        return n3;
    }

    public void setN3(Double n3) {
        this.n3 = n3;
    }

    public Double getE1() {
        return e1;
    }

    public void setE1(Double e1) {
        this.e1 = e1;
    }

    public Double getE2() {
        return e2;
    }

    public void setE2(Double e2) {
        this.e2 = e2;
    }

    public Double getE3() {
        return e3;
    }

    public void setE3(Double e3) {
        this.e3 = e3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
            
    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    
    
    public Number getImage_id() {
        return image_id;
    }

    public void setImage_id(Number image_id) {
        this.image_id = image_id;
    }
     
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIden_history() {
        return iden_history;
    }

    public void setIden_history(String iden_history) {
        this.iden_history = iden_history;
    }

    public Number getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Number region_id) {
        this.region_id = region_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Number getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(Number institution_id) {
        this.institution_id = institution_id;
    }

    public String getNbr() {
        return nbr;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

//    public boolean isAccessible() {
//        return accessible;
//    }
//
//    public void setAccessible(boolean accessible) {
//        this.accessible = accessible;
//    }
//
//    public boolean isDg_image() {
//        return dg_image;
//    }
//
//    public void setDg_image(boolean dg_image) {
//        this.dg_image = dg_image;
//    }
//
//    public boolean isDg_im_obs() {
//        return dg_im_obs;
//    }
//
//    public void setDg_im_obs(boolean dg_im_obs) {
//        this.dg_im_obs = dg_im_obs;
//    }
//
//    public boolean isChecked() {
//        return checked;
//    }
//
//    public void setChecked(boolean checked) {
//        this.checked = checked;
//    }

    public String getHerba_no() {
        return herba_no;
    }

    public void setHerba_no(String herba_no) {
        this.herba_no = herba_no;
    }

    public String getDef_Ref_conf() {
        return def_Ref_conf;
    }

    public void setDef_Ref_conf(String def_Ref_conf) {
        this.def_Ref_conf = def_Ref_conf;
    }

    public Number getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Number status_id) {
        this.status_id = status_id;
    }

    public Number getTaxon_id() {
        return taxon_id;
    }

    public void setTaxon_id(Number taxon_id) {
        this.taxon_id = taxon_id;
    }

    public String getTypified_id() {
        return typified_id;
    }

    public void setTypified_id(String typified_id) {
        this.typified_id = typified_id;
    }

    public Number getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Number country_id) {
        this.country_id = country_id;
    }

    public Number getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Number collection_id) {
        this.collection_id = collection_id;
    }

    public Number getType_id() {
        return type_id;
    }

    public void setType_id(Number type_id) {
        this.type_id = type_id;
    }

    public Number getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(Number voucher_id) {
        this.voucher_id = voucher_id;
    }

    public Number getFirst_collector_id() {
        return first_collector_id;
    }

    public void setFirst_collector_id(Number first_collector_id) {
        this.first_collector_id = first_collector_id;
    }

    public Number getAdd_collector_id() {
        return add_collector_id;
    }

    public void setAdd_collector_id(Number add_collector_id) {
        this.add_collector_id = add_collector_id;
    }

}
