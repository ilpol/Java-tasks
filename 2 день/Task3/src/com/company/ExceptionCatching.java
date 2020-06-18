package com.company;


import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class ExceptionCatching {

    public static void catchMe() throws FileNotFoundException, URISyntaxException {
        if (true) throw new NullPointerException();
        if (true) throw new ArithmeticException();
        if (true) throw new FileNotFoundException();
        if (true) throw new URISyntaxException("","");
    }

}
