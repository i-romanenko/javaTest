package com.bcsg.interview.masker;

import com.bcsg.interview.CardDetails;

/**
 * Created by irina on 21/08/15.
 */
public class DefaultMasker implements IMasker {
    @Override
    public void maskCardNumber(CardDetails cardDetails) {
        StringBuffer maskedNumberBuffer = new StringBuffer();
        maskedNumberBuffer.append(cardDetails.getCardNumber().substring(0, 1));
        maskedNumberBuffer.append(cardDetails.getCardNumber().substring(1).replaceAll("[0-9]", "x"));
        cardDetails.setMaskedCardNumber(maskedNumberBuffer.toString());
    }
}
