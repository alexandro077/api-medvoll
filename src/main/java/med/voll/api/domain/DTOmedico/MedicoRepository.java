package med.voll.api.domain.DTOmedico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query()
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query()
    Boolean findAtivoById(Long id);

    Object escolherMedicoAleatorioLivreData(Especialidade especialidade, LocalDateTime proximaSegundaAs10);
}
