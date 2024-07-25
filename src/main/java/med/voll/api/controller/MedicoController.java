package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.DTOmedico.DadosCadastroMedico;
import med.voll.api.DTOmedico.Medico;
import med.voll.api.DTOmedico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
