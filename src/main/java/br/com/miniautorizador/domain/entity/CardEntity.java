package br.com.miniautorizador.domain.entity;

import java.math.BigDecimal;

public class CardEntity {
    private final String number;
    private String password;
    private BigDecimal balance;

    public CardEntity(String number, String password, BigDecimal balance) {
        this.number = number;
        this.password = password;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
