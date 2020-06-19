package com.company;

/**
 * Base letter functionality
 * @param <T> type of message, will be given in children
 */
public class BaseMessage <T> {
    String from, to;
    T content;
    BaseMessage(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    /**
     * Getter of letter sender
     * @return letter sender
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Getter of letter receiver
     * @return letter receiver
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Getter of letter message
     * @return letter message
     */
    public T getContent() {
        return this.content;
    }
}
