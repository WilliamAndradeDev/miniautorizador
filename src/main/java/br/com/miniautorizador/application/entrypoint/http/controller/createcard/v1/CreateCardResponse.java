package br.com.miniautorizador.application.entrypoint.http.controller.createcard.v1;

import br.com.miniautorizador.domain.entity.CardEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class CreateCardResponse {
    @JsonProperty("numeroCartao")
    String number;
    @JsonProperty("senha")
    String password;
    public CreateCardResponse(CardEntity createdCard) {
        this.number = createdCard.getNumber();
        this.password = createdCard.getPassword();
    }
}
