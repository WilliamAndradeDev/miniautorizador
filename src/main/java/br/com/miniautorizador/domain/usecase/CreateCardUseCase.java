package br.com.miniautorizador.domain.usecase;

import br.com.miniautorizador.domain.entity.CardEntity;
import br.com.miniautorizador.domain.dataprovider.CardDataProvider;
import br.com.miniautorizador.domain.exception.CardAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class CreateCardUseCase {
    private final CardDataProvider cardDataProvider;

    public CreateCardUseCase(CardDataProvider cardDataProvider) {
        this.cardDataProvider = cardDataProvider;
    }

    public CardEntity execute(final String password, final String number) {
        var cardToBeCreated = new CardEntity(number,password,new BigDecimal("500"));
        cardDataProvider.getCardBy(number).ifPresent(card -> {
            log.error("m=execute,stage=error,msg=O cartão já existe!");
            throw new CardAlreadyExistException(card);
        });
        return cardDataProvider.createCard(cardToBeCreated);
    }
}
