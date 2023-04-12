package med.dan.api.medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico dados) {
        this(dados.getNome(), dados.getEmail(), dados.getCrm(), dados.getEspecialidade());
    }
}
