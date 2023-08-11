package br.com.miniautorizador.domain.usecase;

import br.com.miniautorizador.domain.dataprovider.CardDataProvider;
import br.com.miniautorizador.domain.exception.CardNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class GetCardBalanceUseCase {

    private final CardDataProvider cardDataProvider;

    public GetCardBalanceUseCase(CardDataProvider cardDataProvider) {
        this.cardDataProvider = cardDataProvider;
    }

    public BigDecimal execute(final String cardNumber) {
        var card = cardDataProvider.getCardBy(cardNumber).orElseThrow(() -> {
            log.error("m=execute, stage=error, msg=O Cartão com o número {} não encontrado!",cardNumber);
            return new CardNotFoundException();
        });
        return card.getBalance();
    }
}
