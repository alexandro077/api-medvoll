package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.DTOconsulta.DadosAgendamentoConsulta;
import med.voll.api.domain.DTOconsulta.DadosCancelamentoConsulta;
import med.voll.api.domain.DTOconsulta.DadosDetalhamentoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }
}
