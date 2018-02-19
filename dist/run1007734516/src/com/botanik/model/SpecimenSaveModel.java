package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub , Feb 10, 2018 , 1:23:45 PM
 */
public class SpecimenSaveModel {

    private Number institution_id;
    private String herba_no;
    private Number collection_id;
    private Number type_id;
    private Number status_id;
    private Number country_id;
    private Number region_id;
    private Number voucher_id;
    private Number taxon_id;
    private String det_ref_conf;
    private String iden_history;
    private String typified;
    private Number first_collector_id;
    private Number add_collector_id;
    private Date beginDate;
    private Date endDate;
    private String locality;
    private String annotation;
    private String habitat;
    private String literature;
    private String note;
    private GmapModel gmapModel;
    private ImageFile imageFile;
//    private String status;

    public SpecimenSaveModel() {
    }

    public SpecimenSaveModel(Number institution_id, String herba_no, Number collection_id, Number type_id, Number status_id, Number country_id, Number region_id, Number voucher_id, Number taxon_id, String det_ref_conf, String iden_history, String typified, Number first_collector_id, Number add_collector_id, Date beginDate, Date endDate, String locality, String annotation, String habitat, String literature, String note, GmapModel gmapModel, ImageFile imageFile) {
        this.institution_id = institution_id;
        this.herba_no = herba_no;
        this.collection_id = collection_id;
        this.type_id = type_id;
        this.status_id = status_id;
        this.country_id = country_id;
        this.region_id = region_id;
        this.voucher_id = voucher_id;
        this.taxon_id = taxon_id;
        this.det_ref_conf = det_ref_conf;
        this.iden_history = iden_history;
        this.typified = typified;
        this.first_collector_id = first_collector_id;
        this.add_collector_id = add_collector_id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.locality = locality;
        this.annotation = annotation;
        this.habitat = habitat;
        this.literature = literature;
        this.note = note;
        this.gmapModel = gmapModel;
        this.imageFile = imageFile;
    }

    public String note() {
        return note;
    }

    public Number institutionId() {
        return this.institution_id;
    }

    public Number regionId() {
        return this.region_id;
    }

    public Number taxonId() {
        return this.taxon_id;
    }

    public String typified() {
        return this.typified;
    }

    public String idenHistory() {
        return this.iden_history;
    }

    public Date beginDate() {
        return this.beginDate;
    }

    public Date endDate() {
        return this.endDate;
    }

    public Number countryId() {
        return this.country_id;
    }

    public String locality() {
        return this.locality;
    }

    public String annotation() {
        return this.annotation;
    }

    public String herbaNo() {
        return this.herba_no;
    }

    public Number collectionId() {
        return this.collection_id;
    }

    public Number typeId() {
        return type_id;
    }

    public Number voucherId() {
        return voucher_id;
    }

    public String detRefConf() {
        return det_ref_conf;
    }

    public Number firstCollectorId() {
        return first_collector_id;
    }

    public Number addCollectorId() {
        return add_collector_id;
    }

    public Number statusId() {
        return status_id;
    }

    public String getHabitat() {
        return habitat;
    }

    public String literature() {
        return literature;
    }

    public String getNote() {
        return note;
    }

    public GmapModel gmap() {
        return gmapModel;
    }

    public ImageFile image() {
        return imageFile;
    }

}
