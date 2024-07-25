package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
<<<<<<< HEAD
import med.voll.api.DTOmedico.DadosCadastroMedico;
import med.voll.api.DTOmedico.Medico;
import med.voll.api.DTOmedico.MedicoRepository;
=======
import med.voll.api.DTO.DadosCadastroMedico;
import med.voll.api.DTO.Medico;
import med.voll.api.DTO.MedicoRepository;
import med.voll.api.DTO.DadosListagemMedico;
import med.voll.api.DTO.DadosAtualizacaoMedico;
>>>>>>> 0838e0aa119c9e4c377318f298d17f8708a428a5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody@Valid DadosCadastroMedico dados){
       repository.save(new Medico(dados));
    }
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
