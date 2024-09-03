package med.voll.api.domain.DTOconsulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.DTOconsulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia {
    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
