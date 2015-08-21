package com.bcsg.interview.writer;

import com.bcsg.interview.CardDetails;

import java.util.SortedSet;

/**
 * Created by irina on 21/08/15.
 */
public class ConsoleWriter implements IWriter {
    @Override
    public void writeData(SortedSet<CardDetails> cards) {
        for(CardDetails card: cards){
            System.out.println(card);
        }
    }
}
