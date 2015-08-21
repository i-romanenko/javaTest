package com.bcsg.interview;

import com.bcsg.interview.masker.IMasker;
import com.bcsg.interview.masker.MaskerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by irina on 21/08/15.
 */
public class CardDetailsBuilder {

    public static CardDetails build(String[] cardDetails) throws ParseException {
        CardDetails card = new CardDetails();
        card.setBankName(cardDetails[0]);
        card.setCardNumber(cardDetails[1]);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
        card.setExpiryDate(formatter.parse(cardDetails[2]));
        IMasker masker = MaskerFactory.getMaskerByCardType(card.getCardNumber());
        masker.maskCardNumber(card);
        return card;
    }
}
