package br.com.miniautorizador.domain.dataprovider;

import br.com.miniautorizador.domain.entity.CardEntity;

import java.util.Optional;

public interface CardDataProvider {

    CardEntity createCard(final CardEntity cardEntity);

    Optional<CardEntity> getCardBy(String cardNumber);
}
