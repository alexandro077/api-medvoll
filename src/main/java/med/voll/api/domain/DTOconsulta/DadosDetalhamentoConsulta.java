package med.voll.api.domain.DTOconsulta;

<<<<<<< HEAD
import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
=======
public record DadosDetalhamentoConsulta(Object o, Object o1, Object o2, Object o3) {
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
}
