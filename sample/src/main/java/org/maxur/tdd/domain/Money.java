package org.maxur.tdd.domain;

import javax.annotation.Nullable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;


/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/14/14</pre>
 */
@Embeddable
public class Money implements Comparable<Money> {

    @Column(name = "AMOUNT", nullable = false)
    private BigInteger amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public BigInteger getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Money() {

    }

    public Money(double amount, Currency currency) {
        this.amount = BigInteger.valueOf(Math.round (amount * 100));
        this.currency = currency;
    }

    public Money (long amount, Currency currency) {
        this.amount = BigInteger.valueOf(amount * 100);
        this.currency = currency;
    }


    public double amount() {
        return amount.doubleValue() / 100;
    }

    public Currency currency() {
        return currency;
    }


    public static Money dollars(double amount) {
        return new Money (amount, Currency.USD);
    }


    public Money add (Money arg) {
        assertSameCurrencyAs(arg);
        return new Money (amount.add(arg.amount), currency, true);
    }
    public Money subtract (Money arg) {
        return this.add(arg.negate());
    }

    void assertSameCurrencyAs(Money arg) {
        assert currency.equals(arg.currency) : "money math mismatch";
    }

    private Money (BigInteger amountInPennies, Currency currency, boolean privacyMarker) {
        assert amountInPennies != null;
        assert currency != null;
        this.amount = amountInPennies;
        this.currency = currency;
    }

    public Money multiply (double arg) {
        return new Money (amount() * arg, currency);
    }

    public Money[] divide(int denominator) {
        BigInteger bigDenominator = BigInteger.valueOf(denominator);
        Money[] result = new Money[denominator];
        BigInteger simpleResult = amount.divide(bigDenominator);
        for (int i = 0; i < denominator ; i++) {
            result[i] = new Money(simpleResult, currency, true);
        }
        int remainder = amount.subtract(simpleResult.multiply(bigDenominator)).intValue();
        for (int i=0; i < remainder; i++) {
            result[i] = result[i].add(new Money(BigInteger.valueOf(1), currency, true));
        }
        return result;
    }

    public Money negate() {
        return new Money (amount.negate(), currency, true);
    }

    public boolean greaterThan(Money arg) {
        return (this.compareTo(arg) == 1);
    }

    public boolean lessThan(Money arg) {
        return (this.compareTo(arg) == -1);
    }

    public boolean equals(Object arg) {
        if (!(arg instanceof Money)) return false;
        Money other = (Money) arg;
        return (currency.equals(other.currency) && (amount.equals(other.amount)));
    }

    public int hashCode() {
        return amount.hashCode();
    }

    @Override
    public int compareTo(@Nullable Money arg) {
        assert arg != null;
        assertSameCurrencyAs(arg);
        return amount.compareTo(arg.amount);
    }

}
