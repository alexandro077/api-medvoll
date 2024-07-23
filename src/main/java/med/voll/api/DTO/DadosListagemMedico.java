package med.voll.api.DTO;

public record DadosListagemMedico(Long id,String nome, String crm, Especialidade especialidade, String email) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEmail());
    }
}