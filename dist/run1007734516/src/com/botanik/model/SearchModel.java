package com.botanik.model;

import java.time.LocalDate;

/**
 *
 * @author teyyub , Feb 10, 2018 , 12:02:21 PM
 */
public class SearchModel {

    private String taxon;
    private String family;
    private String number;
    private LocalDate date;
    private Number country_id;
    private Number region_id;

    public SearchModel() {
    }

    public SearchModel(String taxon, String family, String number, LocalDate date, Number country_id, Number region_id) {
        this.taxon = taxon;
        this.family = family;
        this.number = number;
        this.date = date;
        this.country_id = country_id;
        this.region_id = region_id;
    }

    public SearchModel createModel() {
        SearchModel model = new SearchModel(taxon, family, number, date, country_id, region_id);
        return model;
    }

    public String taxon() {
        return this.taxon;
    }

    public String family() {
        return this.family;
    }

    public String number() {
        return this.number;
    }

    public LocalDate date() {
        return this.date;
    }

    public Number countryId() {
        return this.country_id;
    }

    public Number region_id() {
        return this.region_id;
    }
}
