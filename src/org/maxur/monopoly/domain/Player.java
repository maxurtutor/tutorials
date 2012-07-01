package org.maxur.monopoly.domain;

/**
 * @author Maxim Yunusov
 * @version 1.0 01.07.12
 */
public class Player {

    private int money;

    public int getMoney() {
        return this.money;
    }

    public boolean hasMoney() {
        return this.money > 0;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
