package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Consumes letters from Consumer interface, stores and gives out them
 * @param <T> type of message in letter
 */
class MailService<T> implements Consumer {

    MailBox mailBox;

    MailService() {
        mailBox = new MailBox<T>();
    }

    /**
     * Getter of letter
     * @return letter
     */
    public Map<String, List<T>> getMailBox() {

        return mailBox;
    }

    /**
     * Consumes letters and stores them
     * @param curItem current letter
     */
    @Override
    public void accept(Object curItem) {
        BaseMessage message = (BaseMessage) curItem;
        String to = message.getTo();

        if (mailBox.containsKey(to)) {
            (mailBox.get(to)).add((T) message.getContent());
        }
        else {
            ArrayList newArray = new ArrayList<>();
            newArray.add(message.getContent());
            mailBox.put(message.getTo(),newArray);
        }
    }
}
