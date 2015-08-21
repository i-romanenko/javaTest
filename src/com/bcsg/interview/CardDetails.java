package com.bcsg.interview;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by irina on 21/08/15.
 */
public class CardDetails implements Comparable<CardDetails> {
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-yyyy");
    private String bankName;
    private String cardNumber;
    private Date expiryDate;
    private String maskedCardNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardDetails)) return false;

        CardDetails that = (CardDetails) o;

        if (!bankName.equals(that.bankName)) return false;
        if (!cardNumber.equals(that.cardNumber)) return false;
        if (!expiryDate.equals(that.expiryDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankName.hashCode();
        result = 31 * result + cardNumber.hashCode();
        result = 31 * result + expiryDate.hashCode();
        return result;
    }

    @Override
    public int compareTo(CardDetails o) {
        return this.getExpiryDate().compareTo(o.expiryDate);
    }

    @Override
    public String
    toString() {
        return bankName  +
                ", " + maskedCardNumber +
                ", " + dateFormatter.format(expiryDate);
    }
}
