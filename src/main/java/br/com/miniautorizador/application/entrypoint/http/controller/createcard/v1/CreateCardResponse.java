package br.com.miniautorizador.application.entrypoint.http.controller.createcard.v1;

import br.com.miniautorizador.domain.entity.CardEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
public record CreateCardResponse(
        @JsonProperty("numeroCartao")
        String number,
        @JsonProperty("senha")
        String password
){
    public CreateCardResponse(CardEntity createdCard) {
        this(createdCard.getNumber(),createdCard.getPassword());
    }
}