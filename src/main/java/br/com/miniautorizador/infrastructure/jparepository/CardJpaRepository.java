package br.com.miniautorizador.infrastructure.jparepository;

import br.com.miniautorizador.infrastructure.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardJpaRepository extends JpaRepository<CardModel, UUID> {

    Optional<CardModel> getCardByNumber(String number);
}
