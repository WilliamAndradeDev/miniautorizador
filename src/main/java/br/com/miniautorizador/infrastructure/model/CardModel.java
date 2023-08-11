package br.com.miniautorizador.infrastructure.model;

import br.com.miniautorizador.domain.entity.CardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "card")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String number;
    private String password;
    private BigDecimal balance;

    public CardModel(CardEntity cardEntity) {
        this.number = cardEntity.getNumber();
        this.password = cardEntity.getPassword();
        this.balance = cardEntity.getBalance();
    }

    public CardEntity toCarEntity() {
        return new CardEntity(
                this.number,
                this.password,
                this.balance
        );
    }
}