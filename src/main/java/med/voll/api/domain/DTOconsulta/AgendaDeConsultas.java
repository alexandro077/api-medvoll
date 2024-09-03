package med.voll.api.domain.DTOconsulta;

<<<<<<< HEAD
import med.voll.api.domain.DTOconsulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.DTOconsulta.validacoes.ValidadorCancelamentoDeConsulta;
=======
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
import med.voll.api.domain.DTOmedico.Medico;
import med.voll.api.domain.DTOmedico.MedicoRepository;
import med.voll.api.domain.DTOpaciente.PacienteRepository;
import med.voll.api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {
=======

public class AgendaDeConsultas {
    @Autowired
    private AgendaDeConsultas agenda;
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

<<<<<<< HEAD
    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
=======

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }

<<<<<<< HEAD
        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if (medico == null) {
            throw new ValidacaoException("Não existe médico disponível nessa data!");
        }

        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }


    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
=======
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(Consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados){
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

<<<<<<< HEAD
}

=======



}
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
