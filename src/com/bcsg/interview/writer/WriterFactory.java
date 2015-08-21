package com.bcsg.interview.writer;

/**
 * Created by irina on 21/08/15.
 */
public class WriterFactory {
    public static IWriter getWriter(){
        return new ConsoleWriter();
    }
}
