package br.com.miniautorizador.application.dataprovider;

import br.com.miniautorizador.domain.dataprovider.CardDataProvider;
import br.com.miniautorizador.domain.entity.CardEntity;
import br.com.miniautorizador.infrastructure.model.CardModel;
import br.com.miniautorizador.infrastructure.jparepository.CardJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CardDataProviderImpl implements CardDataProvider {

    private final CardJpaRepository cardJpaRepository;

    public CardDataProviderImpl(CardJpaRepository cardJpaRepository) {
        this.cardJpaRepository = cardJpaRepository;
    }

    @Override
    public CardEntity createCard(CardEntity cardEntity) {
        var cardModelToSave = new CardModel(cardEntity);
        var savedCardModel = cardJpaRepository.save(cardModelToSave);
        return savedCardModel.toCarEntity();
    }

    @Override
    public Optional<CardEntity> getCardBy(String cardNumber) {
        return cardJpaRepository
                .getCardByNumber(cardNumber)
                .map(CardModel::toCarEntity);
    }
}
