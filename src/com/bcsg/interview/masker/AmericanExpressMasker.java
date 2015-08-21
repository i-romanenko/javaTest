package com.bcsg.interview.masker;

import com.bcsg.interview.CardDetails;

/**
 * Created by irina on 21/08/15.
 */
public class AmericanExpressMasker implements IMasker{

    @Override
    public void maskCardNumber(CardDetails cardDetails) {
        StringBuffer maskedCardNumberBuffer = new StringBuffer();
        maskedCardNumberBuffer.append(cardDetails.getCardNumber().substring(0, cardDetails.getCardNumber().length() - 3).replaceAll("[0-9]", "x"));
        maskedCardNumberBuffer.append(cardDetails.getCardNumber().substring(cardDetails.getCardNumber().length()-3));
        cardDetails.setMaskedCardNumber(maskedCardNumberBuffer.toString());
    }
}
