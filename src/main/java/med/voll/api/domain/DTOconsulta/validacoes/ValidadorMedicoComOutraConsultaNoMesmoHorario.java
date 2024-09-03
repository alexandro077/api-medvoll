package med.voll.api.domain.DTOconsulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.DTOconsulta.ConsultaRepository;
import med.voll.api.domain.DTOconsulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidationException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
