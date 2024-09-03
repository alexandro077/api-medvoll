package med.voll.api.domain.DTOpaciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
        Page<Paciente> findAllByAtivoTrue(Pageable pageable);
<<<<<<< HEAD
        Boolean findAtivoById(Long id);
=======
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
}
