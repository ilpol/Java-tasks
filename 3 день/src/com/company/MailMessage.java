package com.company;

/**
 * Letter about who whom wrote what message
 */
public class MailMessage extends BaseMessage <String> {
    MailMessage(String from, String to, String content) {
        super(from,to,content);
    }
}