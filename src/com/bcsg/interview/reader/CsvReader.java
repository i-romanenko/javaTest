package com.bcsg.interview.reader;

import com.bcsg.interview.CardDetails;
import com.bcsg.interview.CardDetailsBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by irina on 21/08/15.
 */
public class CsvReader implements IReader {

    private String inputSource;

    public CsvReader(String inputSource) {
        this.inputSource = inputSource;
    }

    @Override
    public SortedSet<CardDetails> readData() {
        SortedSet<CardDetails> cardDetailsSet = new TreeSet<CardDetails>();
        BufferedReader br = null;
        String line = "";
        String separator = ",";

        try {
            br = new BufferedReader(new FileReader(inputSource));
            while ((line = br.readLine()) != null) {
                String[] cardDetails = line.split(separator);
                CardDetails card = CardDetailsBuilder.build(cardDetails);
                cardDetailsSet.add(card);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            return cardDetailsSet;
        }
    }
}
