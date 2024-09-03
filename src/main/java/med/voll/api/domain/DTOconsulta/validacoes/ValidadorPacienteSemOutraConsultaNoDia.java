package med.voll.api.domain.DTOconsulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.DTOconsulta.ConsultaRepository;
import med.voll.api.domain.DTOconsulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossueOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossueOutraConsultaNoDia) {
            throw new ValidationException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
