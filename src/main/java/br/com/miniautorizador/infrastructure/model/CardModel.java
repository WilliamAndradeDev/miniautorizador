package br.com.miniautorizador.infrastructure.model;

import br.com.miniautorizador.domain.entity.CardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "card")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 16,unique = true)
    private String number;
    @Column(nullable = false,length = 25)
    private String password;
    @Column(nullable = false)
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