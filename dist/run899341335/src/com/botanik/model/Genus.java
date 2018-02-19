 

package com.botanik.model;

/**
 *
 * @author teyyub , Jan 7, 2018 ,  1:19:20 PM 
 */
public class Genus extends Base{
    private Number author_id;
    private Number family_id;
    private Number taxon_id;
    private String ref_no;
    private String addition;
    private String remarks;
    private boolean hybrid;
    private boolean accepted;
    private String full_name;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
       
    public Number getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Number author_id) {
        this.author_id = author_id;
    }

    public Number getFamily_id() {
        return family_id;
    }

    public void setFamily_id(Number family_id) {
        this.family_id = family_id;
    }

    public Number getTaxon_id() {
        return taxon_id;
    }

    public void setTaxon_id(Number taxon_id) {
        this.taxon_id = taxon_id;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isHybrid() {
        return hybrid;
    }

    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return full_name+"  " +"[" +super.getId()+"]"; 
    }
    
    
    
            
            
}
