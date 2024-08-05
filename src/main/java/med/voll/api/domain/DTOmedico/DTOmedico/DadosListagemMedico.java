package med.voll.api.domain.DTOmedico.DTOmedico;

public record DadosListagemMedico(Long id, String nome, String crm, Especialidade especialidade, String email) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEmail());
    }
}
