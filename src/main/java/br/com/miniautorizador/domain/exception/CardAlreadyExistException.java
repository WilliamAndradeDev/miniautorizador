package br.com.miniautorizador.domain.exception;

import br.com.miniautorizador.domain.entity.CardEntity;

public class CardAlreadyExistException extends RuntimeException {
    private final CardEntity invalidCard;

    public CardAlreadyExistException(CardEntity invalidCard) {
        this.invalidCard=invalidCard;
    }

    public CardEntity getInvalidCard() {
        return invalidCard;
    }
}
