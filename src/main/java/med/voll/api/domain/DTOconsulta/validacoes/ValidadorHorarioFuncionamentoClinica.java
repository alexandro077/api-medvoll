package med.voll.api.domain.DTOconsulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.DTOconsulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo||antesDaAberturaDaClinica ||depoisDoEncerramentoDaClinica){
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
