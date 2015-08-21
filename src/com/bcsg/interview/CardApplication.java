package com.bcsg.interview;

import com.bcsg.interview.reader.IReader;
import com.bcsg.interview.reader.ReaderFactory;
import com.bcsg.interview.writer.IWriter;
import com.bcsg.interview.writer.WriterFactory;

import java.util.SortedSet;

/**
 * Created by irina on 21/08/15.
 */
public class CardApplication {
    public static void main(String[] args) {
        IReader reader = ReaderFactory.getReader(args[0]);

        SortedSet<CardDetails> cardDetailsSet = reader.readData();
        IWriter writer = WriterFactory.getWriter();
        writer.writeData(cardDetailsSet);
    }
}
