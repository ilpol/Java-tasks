package com.company;

public class Main {

    public static void main(String[] args) {
        //Задание 2
        String [] spamStrings = {"спам"};
        TextAnalyzer[] analyzers = {new SpamAnalyzer(spamStrings),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(5)};
	    System.out.println(TextCheck(analyzers, "это спам"));
	    System.out.println(TextCheck(analyzers, "это =("));
        System.out.println(TextCheck(analyzers, "много много много"));
        System.out.println(TextCheck(analyzers, "ок"));
    }

    static Label TextCheck (TextAnalyzer[] analyzers, String text) {
         for (TextAnalyzer analyzer: analyzers) {
             if (analyzer.processText(text)!=Label.OK)
                 return analyzer.processText(text);
         }
         return  Label.OK;
    }
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

abstract class AbstractKeywordAnalyzer implements TextAnalyzer {
   public abstract String[] getKeywords();
   public abstract Label getLabel();
   public Label processText(String text){
       for (String keyword : getKeywords()) {
             if (text.contains(keyword))
                   return getLabel();
       }
       return Label.OK;
   }
}

class SpamAnalyzer extends AbstractKeywordAnalyzer {
    String [] spamStrings;

    SpamAnalyzer (String[] spamStrings) {
        this.spamStrings = spamStrings;
    }
    @Override
    public String[] getKeywords() {
        return spamStrings;
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }

}

class NegativeTextAnalyzer extends  AbstractKeywordAnalyzer {

    String [] negStrings = {":(", "=(", ":|"};

    @Override
    public String[] getKeywords() {
        return  negStrings;
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {

    int longLength;

    TooLongTextAnalyzer (int lognLength) {
        this.longLength = lognLength;
    }

    public Label processText(String text){
        if (text.length()> longLength)
           return Label.TOO_LONG;
        else
            return Label.OK;
    }
}