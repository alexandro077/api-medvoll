package med.voll.api.domain.DTOconsulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.DTOmedico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade) {
}
