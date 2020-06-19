package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores letters in Map pattern: {sender1: {letter1,letter2,...},...}
 * @param <T> type of stored letter messages
 */
public class MailBox<T> extends HashMap <String,List<T>> {
    @Override
    public List<T> get(Object key) {
        return super.getOrDefault(key, new ArrayList<T>());
    }
}
