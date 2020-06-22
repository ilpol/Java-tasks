package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Consumes letters from Consumer interface, stores and gives out them
 * @param <T> type of message in letter
 */
class MailService<T> implements Consumer<BaseMessage> {

    Map<String, List<T>> mailBox;

    MailService() {
        mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, new ArrayList<>());
            }
        };
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
     * @param baseMessage current letter
     */
    @Override
    public void accept(BaseMessage baseMessage) {
        BaseMessage message = (BaseMessage) baseMessage;
        String to = message.getTo();
        if (!mailBox.containsKey(to))
            mailBox.put(to,  new ArrayList<>());
        mailBox.get(to).add((T) message.getContent());
    }
}
