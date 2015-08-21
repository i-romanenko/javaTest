package com.bcsg.interview.writer;

import com.bcsg.interview.CardDetails;

import java.util.SortedSet;

/**
 * Created by irina on 21/08/15.
 */
public interface IWriter {

    public void writeData(SortedSet<CardDetails> cards);
}
