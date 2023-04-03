package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public int setRate(int rate) {
        this.rate = rate;
        return 0;
    }
}