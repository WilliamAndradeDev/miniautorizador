package br.com.miniautorizador.application.entrypoint.http.controller.createcard.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;

public record CreateCardRequest(
        @JsonProperty("numeroCartao")
        @Size(min = 16,max = 16)
        String number,
        @JsonProperty("senha")
        @Size(min = 5,max = 25)
        String password
){}