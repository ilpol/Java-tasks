package com.pflb.learning.day5.sql;

@Table(name = "country")
public class Country implements Entity {
    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;
}


