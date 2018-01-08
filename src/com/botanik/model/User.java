package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub Aug 2, 2016 11:17:45 AM
 */
public class User extends Base {

    private boolean author = Boolean.FALSE;
    private boolean species = Boolean.FALSE;
    private boolean subSpecies = Boolean.FALSE;
    private boolean variety = Boolean.FALSE;
    private boolean subVariety = Boolean.FALSE;
    private boolean forma = Boolean.FALSE;
    private boolean subForma = Boolean.FALSE;
    private boolean genus = Boolean.FALSE;
    private boolean family = Boolean.FALSE;
    private boolean taxon = Boolean.FALSE;
    private boolean voucher = Boolean.FALSE;
    private boolean collector = Boolean.FALSE;
    private boolean firstCollector = Boolean.FALSE;
    private boolean serie = Boolean.FALSE;

    private String password;
    private Date insert_date;

    public boolean isAuthor() {
        return author;
    }

    public void setAuthor(boolean author) {
        this.author = author;
    }

    public boolean isSpecies() {
        return species;
    }

    public void setSpecies(boolean species) {
        this.species = species;
    }

    public boolean isSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(boolean subSpecies) {
        this.subSpecies = subSpecies;
    }

    public boolean isVariety() {
        return variety;
    }

    public void setVariety(boolean variety) {
        this.variety = variety;
    }

    public boolean isSubVariety() {
        return subVariety;
    }

    public void setSubVariety(boolean subVariety) {
        this.subVariety = subVariety;
    }

    public boolean isForma() {
        return forma;
    }

    public void setForma(boolean forma) {
        this.forma = forma;
    }

    public boolean isSubForma() {
        return subForma;
    }

    public void setSubForma(boolean subForma) {
        this.subForma = subForma;
    }

    public boolean isGenus() {
        return genus;
    }

    public void setGenus(boolean genus) {
        this.genus = genus;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }

    public boolean isTaxon() {
        return taxon;
    }

    public void setTaxon(boolean taxon) {
        this.taxon = taxon;
    }

    public boolean isVoucher() {
        return voucher;
    }

    public void setVoucher(boolean voucher) {
        this.voucher = voucher;
    }

    public boolean isCollector() {
        return collector;
    }

    public void setCollector(boolean collector) {
        this.collector = collector;
    }

    public boolean isFirstCollector() {
        return firstCollector;
    }

    public void setFirstCollector(boolean firstCollector) {
        this.firstCollector = firstCollector;
    }

    public boolean isSerie() {
        return serie;
    }

    public void setSerie(boolean serie) {
        this.serie = serie;
    }

  

 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

}
