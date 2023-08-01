package br.com.miniautorizador.application.entrypoint.http.handler;

import br.com.miniautorizador.application.entrypoint.http.controller.createcard.v1.CreateCardResponse;
import br.com.miniautorizador.domain.exception.CardAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceConfig {

    @ExceptionHandler(CardAlreadyExistException.class)
    public ResponseEntity<CreateCardResponse> handleDuplicateEntriesError(
            CardAlreadyExistException cardAlreadyExistException
    ) {
        var createCardResponse = new CreateCardResponse(cardAlreadyExistException.getInvalidCard());
        return new ResponseEntity<>(createCardResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
