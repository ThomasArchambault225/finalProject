package org.example;

/**
 * This class represents a Credit Card with a balance, credit limit, and owner.
 */
public class CreditCard {
    // Fields
    private Money balance;
    private Money creditLimit;
    private Person owner;

    /**
     * Constructor to initialize the CreditCard with an owner and a credit limit.
     *
     * @param newCardHolder The person who owns the credit card.
     * @param limit          The credit limit for the card.
     */
    public CreditCard(Person newCardHolder, Money limit) {
        this.owner = newCardHolder;
        this.creditLimit = new Money(limit); // Use copy constructor to avoid aliasing
        this.balance = new Money(0.0);      // Initialize balance to zero
    }

    /**
     * Accessor method for the balance.
     *
     * @return A copy of the current balance.
     */
    public Money getBalance() {
        return new Money(this.balance); // Return a new Money object to maintain security
    }

    /**
     * Accessor method for the credit limit.
     *
     * @return A copy of the credit limit.
     */
    public Money getCreditLimit() {
        return new Money(this.creditLimit); // Return a new Money object to maintain security
    }

    /**
     * Accessor method for the owner's information.
     *
     * @return The owner's information as a String.
     */
    public String getPersonals() {
        return this.owner.toString();
    }

    /**
     * Method to charge an amount to the credit card.
     *
     * @param amount The amount to charge.
     */
    public void charge(Money amount) {
        Money newBalance = this.balance.add(amount); // Calculate new balance
        if (newBalance.compareTo(this.creditLimit) <= 0) { // Check if within limit
            this.balance = newBalance; // Update balance
            System.out.println("Charge: " + amount.toString());
        } else {
            System.out.println("Exceeds credit limit");
        }
    }

    /**
     * Method to make a payment to the credit card.
     *
     * @param amount The amount to pay.
     */
    public void payment(Money amount) {
        this.balance = this.balance.subtract(amount); // Subtract payment from balance
        System.out.println("Payment: " + amount.toString());
    }
}
