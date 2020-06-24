package com.pflb.learning.day5.sql;

@Table(name = "countrylanguage")
public class Countrylanguage implements Entity {
    @Column(name = "CountryCode")
    public String countrycode;

    @Column(name = "Language")
    public String language;
}
