package med.voll.api.domain.DTOmedico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

<<<<<<< HEAD
    @Query()
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query()
    Boolean findAtivoById(Long id);

    Object escolherMedicoAleatorioLivreData(Especialidade especialidade, LocalDateTime proximaSegundaAs10);
=======
    @Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where
                c.data = :data
                and
                c.motivoCancelamento is null
            )
            order by rand()
            limit 1
        """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
}
