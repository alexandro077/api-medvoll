package med.voll.api.domain.DTOconsulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull Long id idConsulta,

        @NotNull MotivoCancelamento motivo) {

}
