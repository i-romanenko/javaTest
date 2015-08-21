package com.bcsg.interview.masker;

import com.bcsg.interview.CardDetails;

/**
 * Created by irina on 21/08/15.
 */
public class VisaMasker implements IMasker {
    @Override
    public void maskCardNumber(CardDetails cardDetails) {
        StringBuffer maskedNumberBuffer = new StringBuffer();
        maskedNumberBuffer.append(cardDetails.getCardNumber().substring(0, 2));
        maskedNumberBuffer.append(cardDetails.getCardNumber().substring(2).replaceAll("[0-9]", "x"));
        cardDetails.setMaskedCardNumber(maskedNumberBuffer.toString());
    }
}
