package med.voll.api.domain.DTOconsulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.DTOmedico.Medico;
import med.voll.api.domain.DTOpaciente.Paciente;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

<<<<<<< HEAD
    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public Consulta(Object o, Medico medico, Paciente paciente, LocalDateTime data) {

    }


    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }

=======
>>>>>>> c40286abc6c07a910bb7b2c423a5deda59cc80bf
}
