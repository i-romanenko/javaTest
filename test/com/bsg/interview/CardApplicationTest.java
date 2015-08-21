package com.bsg.interview;

import com.bcsg.interview.CardDetails;
import com.bcsg.interview.CardDetailsBuilder;
import com.bcsg.interview.reader.IReader;
import com.bcsg.interview.reader.ReaderFactory;
import org.junit.Test;

import java.text.ParseException;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by irina on 21/08/15.
 */
public class CardApplicationTest {

    @Test
    public void testReadData(){
        IReader reader = ReaderFactory.getReader("mid-test.csv");
        SortedSet<CardDetails> cardDetailsSortedSet = reader.readData();
        assertEquals(3, cardDetailsSortedSet.size());
    }

    @Test
    public void testDataOrder() throws ParseException {
        String[] cardDetails1 = {"Bank1", "1234-1234-1234-124", "Apr-2019"};
        String[] cardDetails2 = {"Bank2", "1234-5432-1234-543", "Mar-2019"};
        String[] cardDetails3 = {"Bank1", "9876-0987-6543-2356", "Jun-2016"};
        String[] cardDetails4 = {"Bank2", "1111-2222-3333-4444", "Feb-2017"};

        CardDetails card1 = CardDetailsBuilder.build(cardDetails1);
        CardDetails card2 = CardDetailsBuilder.build(cardDetails2);
        CardDetails card3 = CardDetailsBuilder.build(cardDetails3);
        CardDetails card4 = CardDetailsBuilder.build(cardDetails4);

        SortedSet<CardDetails> cards = new TreeSet<CardDetails>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        assertEquals(card3, cards.first());
        assertEquals(card1, cards.last());
        assertNotEquals(card2, cards.first());
    }

    @Test
    public void testDataMask() throws ParseException {
        String[] cardDetails1 = {"Bank1", "4634-1234-1234-124", "Apr-2019"};
        String[] cardDetails2 = {"Bank2", "3734-5432-1234-543", "Mar-2019"};
        String[] cardDetails3 = {"Bank1", "9876-0987-6543-2356", "Jun-2016"};
        String[] cardDetails4 = {"Bank2", "4111-2222-3333-4444", "Feb-2017"};
        String[] cardDetails5 = {"Bank2", "3534-5432-1234-543", "Mar-2019"};

        CardDetails card1 = CardDetailsBuilder.build(cardDetails1);
        CardDetails card2 = CardDetailsBuilder.build(cardDetails2);
        CardDetails card3 = CardDetailsBuilder.build(cardDetails3);
        CardDetails card4 = CardDetailsBuilder.build(cardDetails4);
        CardDetails card5 = CardDetailsBuilder.build(cardDetails5);

        assertEquals("4xxx-xxxx-xxxx-xxx", card1.getMaskedCardNumber());
        assertEquals("xxxx-xxxx-xxxx-543", card2.getMaskedCardNumber());
        assertEquals("9xxx-xxxx-xxxx-xxxx", card3.getMaskedCardNumber());
        assertEquals("41xx-xxxx-xxxx-xxxx", card4.getMaskedCardNumber());
        assertEquals("3xxx-xxxx-xxxx-xxx", card5.getMaskedCardNumber());

    }
}
