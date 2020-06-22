package com.company;

/**
 * Letter about who whom gave what salary
 */
public class Salary extends BaseMessage <Integer> {
    Salary(String from, String to, int content) {
        super(from,to,content);
    }
}
