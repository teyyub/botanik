package com.botanik.model;

/**
 *
 * @author teyyub , Feb 10, 2018 , 3:01:59 PM
 */
public class GmapModel {

    private Double id;
    private Double latitudeDegree;
    private Double latitudeMinute;
    private Double latitudeSecond;
    private Double longitudeDegree;
    private Double longitudeMinute;
    private Double longitudeSecond;
    private Double degLatitude;
    private Double degLongitude;

    public GmapModel(Double latitudeDegree,
            Double latitudeMinute,
            Double latitudeSecond,
            Double longitudeDegree,
            Double longitudeMinute,
            Double longitudeSecond) {
        this.latitudeDegree = latitudeDegree;
        this.latitudeMinute = latitudeMinute;
        this.latitudeSecond = latitudeSecond;
        this.longitudeDegree = longitudeDegree;
        this.longitudeMinute = longitudeMinute;
        this.longitudeSecond = longitudeSecond;
        degLatitude = calculateDegreeLatitude(latitudeDegree, latitudeMinute, latitudeSecond);
        degLongitude = calculateDegreeLongitute(longitudeDegree, longitudeMinute, longitudeSecond);
    }

    public GmapModel() {
    }

    public Double calculateDegreeLatitude(Double latitudeDegree, Double latitudeMinute, Double latitudeSecond) {
        Double result = latitudeDegree + latitudeMinute / 60 + latitudeSecond + 3600;
        return result;
    }

    public Double calculateDegreeLongitute(Double longitudeDegree, Double longitudeMinute, Double longitudeSecond) {
        Double result = longitudeDegree + longitudeMinute / 60 + longitudeSecond / 3600;
        return result;
    }

    public Double getLatitudeDegree() {
        return latitudeDegree;
    }

    public Double getLatitudeMinute() {
        return latitudeMinute;
    }

    public Double getLatitudeSecond() {
        return latitudeSecond;
    }

    public Double getLongitudeDegree() {
        return longitudeDegree;
    }

    public Double getLongitudeMinute() {
        return longitudeMinute;
    }

    public Double getLongitudeSecond() {
        return longitudeSecond;
    }

    public Double getDegLatitude() {
        return degLatitude;
    }

    public Double getDegLongitude() {
        return degLongitude;
    }

}
