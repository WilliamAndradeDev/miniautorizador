package br.com.miniautorizador.application.entrypoint.http.controller.getcardbalance.v1;

import br.com.miniautorizador.application.entrypoint.http.controller.api.CardApi;
import br.com.miniautorizador.domain.usecase.GetCardBalanceUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(CardApi.URL_V1)
@Tag(name = CardApi.TAG_NAME)
public class GetCardBalanceController {

    private final GetCardBalanceUseCase getCardBalanceUseCase;

    public GetCardBalanceController(GetCardBalanceUseCase getCardBalanceUseCase) {
        this.getCardBalanceUseCase = getCardBalanceUseCase;
    }

    @GetMapping("/{numeroCartao}")
    public BigDecimal getCardBalance(@PathVariable("numeroCartao") final String cardNumber) {
        return getCardBalanceUseCase.execute(cardNumber);
    }
}
