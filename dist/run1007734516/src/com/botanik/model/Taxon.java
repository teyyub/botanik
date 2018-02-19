 

package com.botanik.model;

/**
 *
 * @author teyyub , Jan 7, 2018 ,  1:19:23 PM 
 */
public class Taxon extends Base{
    private Number genus_id;
    private Number rank_id;
    private Number tax_status_id;
    private Number species_id;
    private Number sub_species_id;
    private Number variety_id;
    private Number sub_variety_id;
    private Number forma_id;
    private Number sub_forma_id;
    private Number author_id;
    private Number sub_author_id;
    private Number v_author_id;
    private Number sv_author_id;
    private Number f_author_id;
    private Number sf_author_id;  
    private Number accepted_taxon_id;
    private Number basionym_id;
    private String annotation;
    private String full_name;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
            

    public Number getAccepted_taxon_id() {
        return accepted_taxon_id;
    }

    public void setAccepted_taxon_id(Number accepted_taxon_id) {
        this.accepted_taxon_id = accepted_taxon_id;
    }

    public Number getBasionym_id() {
        return basionym_id;
    }

    public void setBasionym_id(Number basionym_id) {
        this.basionym_id = basionym_id;
    }
        
    
    public Number getGenus_id() {
        return genus_id;
    }

    public void setGenus_id(Number genus_id) {
        this.genus_id = genus_id;
    }

    public Number getRank_id() {
        return rank_id;
    }

    public void setRank_id(Number rank_id) {
        this.rank_id = rank_id;
    }

    public Number getTax_status_id() {
        return tax_status_id;
    }

    public void setTax_status_id(Number tax_status_id) {
        this.tax_status_id = tax_status_id;
    }

    public Number getSpecies_id() {
        return species_id;
    }

    public void setSpecies_id(Number species_id) {
        this.species_id = species_id;
    }

    public Number getSub_species_id() {
        return sub_species_id;
    }

    public void setSub_species_id(Number sub_species_id) {
        this.sub_species_id = sub_species_id;
    }

    public Number getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(Number variety_id) {
        this.variety_id = variety_id;
    }

    public Number getSub_variety_id() {
        return sub_variety_id;
    }

    public void setSub_variety_id(Number sub_variety_id) {
        this.sub_variety_id = sub_variety_id;
    }

    public Number getForma_id() {
        return forma_id;
    }

    public void setForma_id(Number forma_id) {
        this.forma_id = forma_id;
    }

    public Number getSub_forma_id() {
        return sub_forma_id;
    }

    public void setSub_forma_id(Number sub_forma_id) {
        this.sub_forma_id = sub_forma_id;
    }

    public Number getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Number author_id) {
        this.author_id = author_id;
    }

    public Number getSub_author_id() {
        return sub_author_id;
    }

    public void setSub_author_id(Number sub_author_id) {
        this.sub_author_id = sub_author_id;
    }

    public Number getV_author_id() {
        return v_author_id;
    }

    public void setV_author_id(Number v_author_id) {
        this.v_author_id = v_author_id;
    }

    public Number getSv_author_id() {
        return sv_author_id;
    }

    public void setSv_author_id(Number sv_author_id) {
        this.sv_author_id = sv_author_id;
    }

    public Number getF_author_id() {
        return f_author_id;
    }

    public void setF_author_id(Number f_author_id) {
        this.f_author_id = f_author_id;
    }

    public Number getSf_author_id() {
        return sf_author_id;
    }

    public void setSf_author_id(Number sf_author_id) {
        this.sf_author_id = sf_author_id;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return full_name; 
    }
    
    
    
}
