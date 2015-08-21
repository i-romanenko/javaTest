package com.bcsg.interview.reader;

import com.bcsg.interview.CardDetails;

import java.util.SortedSet;

/**
 * Created by irina on 21/08/15.
 */
public interface IReader {
    public SortedSet<CardDetails> readData();
}
