package com.pflb.learning.day5.sql;

@Table(name = "city")
public class City implements Entity {
    @Column(name = "ID")
    public String id;

    @Column(name = "Name")
    public String name;
}
