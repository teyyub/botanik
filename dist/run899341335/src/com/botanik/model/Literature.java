package com.botanik.model;

import java.util.Date;

/**
 *
 * @author teyyub Jul 18, 2016 1:59:49 PM
 */
public class Literature {

    private Number id;
    private String title;
    private String suptitle;
//    private String author;
    private String listing;
    private String periodical;
    private Date year;
    private String keyword;
    private String valume;
    private int page;
//    private String category;
    private int status;
    private String url;
    private String annotation;
    private String addition;
    private String signature;
    private String printerLocation;
    private String recentPublisher;
    private String showAuthor;
    private Author author = new Author();
    private Editor editor = new Editor();
    private Printer printer = new Printer();
    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getValume() {
        return valume;
    }

    public void setValume(String valume) {
        this.valume = valume;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
 

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSuptitle() {
        return suptitle;
    }

    public void setSuptitle(String suptitle) {
        this.suptitle = suptitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String getPrinterLocation() {
        return printerLocation;
    }

    public void setPrinterLocation(String printerLocation) {
        this.printerLocation = printerLocation;
    }

    public String getRecentPublisher() {
        return recentPublisher;
    }

    public void setRecentPublisher(String recentPublisher) {
        this.recentPublisher = recentPublisher;
    }

    public String getShowAuthor() {
        return showAuthor;
    }

    public void setShowAuthor(String showAuthor) {
        this.showAuthor = showAuthor;
    }
    
    
    
    
}
