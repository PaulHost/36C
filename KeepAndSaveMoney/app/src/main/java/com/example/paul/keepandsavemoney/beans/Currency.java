package com.example.paul.keepandsavemoney.beans;

/**
 * Created by paul on 12.12.16.
 */

public class Currency {
    private String abbreviation;
    private String scale;
    private String name;
    private String officialRate;

    public Currency() {
    }

    public Currency(String abbreviation, String scale, String name, String officialRate) {
        this.abbreviation = abbreviation;
        this.scale = scale;
        this.name = name;
        this.officialRate = officialRate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialRate() {
        return officialRate;
    }

    public void setOfficialRate(String officialRate) {
        this.officialRate = officialRate;
    }
}
