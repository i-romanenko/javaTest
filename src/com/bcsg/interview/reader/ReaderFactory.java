package com.bcsg.interview.reader;

/**
 * Created by irina on 21/08/15.
 */
public class ReaderFactory {
    public static IReader getReader(String inputSource) {
        return new CsvReader(inputSource);
    }
}
