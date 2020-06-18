package com.company;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

	    try {
            ExceptionCatching.catchMe();
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException ");
        }
    }
}


