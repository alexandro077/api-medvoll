package med.voll.api.domain.DTOconsulta;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.time.LocalDateTime;

public interface ConsultaRepository  extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
=======
public interface ConsultaRepository  extends JpaRepository<Consulta, Long> {
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
}
