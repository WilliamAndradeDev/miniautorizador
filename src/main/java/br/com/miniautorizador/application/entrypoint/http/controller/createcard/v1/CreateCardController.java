package br.com.miniautorizador.application.entrypoint.http.controller.createcard.v1;

import br.com.miniautorizador.application.entrypoint.http.controller.api.CardApi;
import br.com.miniautorizador.domain.usecase.CreateCardUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(CardApi.URL_V1)
@Tag(name = CardApi.TAG_NAME)
public class CreateCardController {

    private final CreateCardUseCase createCardUseCase;

    public CreateCardController(CreateCardUseCase createCardUseCase) {
        this.createCardUseCase = createCardUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateCardResponse> createCard(
            @Valid @RequestBody final CreateCardRequest createCardRequest,
            final UriComponentsBuilder uriBuilder
    ) {
        var createdCard = createCardUseCase.execute(createCardRequest.password(), createCardRequest.number());
        var uri = uriBuilder.path(CardApi.URL_V1+"/{number}").buildAndExpand(createdCard.getNumber()).toUri();
        return ResponseEntity.created(uri).body(new CreateCardResponse(createdCard));
    }
}
