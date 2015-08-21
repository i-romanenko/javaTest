package com.bcsg.interview.masker;

/**
 * Created by irina on 21/08/15.
 */
public class MaskerFactory {
    public static final String VISA_PATTERN = "^4[0-9]{3}[- ]?[0-9]{4}[- ]?[0-9]{4}[- ]?[0-9]{4}";
    public static final String MASTERCARD_PATTERN = "^5[1-5][0-9]{2}[- ]?[0-9]{4}[- ]?[0-9]{4}[- ]?[0-9]{4}";
    public static final String AMERICAN_EXPRESS_PATTERN = "^3[47][0-9]{2}[- ]?[0-9]{4}[- ]?[0-9]{4}[- ]?[0-9]{3}";

    public static IMasker getMaskerByCardType(String cardNumber){
        CardType cardType = getCardType(cardNumber);
        switch (cardType){
            case VISA: return new VisaMasker();
            case AMERICAN_EXPRESS: return new AmericanExpressMasker();
            default: return new DefaultMasker();
        }
    }

    private static CardType getCardType(String cardNumber) {
        if(cardNumber.matches(VISA_PATTERN)){
            return CardType.VISA;
        }
        if(cardNumber.matches(MASTERCARD_PATTERN)){
            return CardType.MASTERCARD;
        }
        if(cardNumber.matches(AMERICAN_EXPRESS_PATTERN)){
            return CardType.AMERICAN_EXPRESS;
        }
        return CardType.OTHER;
    }

    public enum CardType{
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS,
        OTHER
    }
}
