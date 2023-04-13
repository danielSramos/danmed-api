package med.dan.api.medico;

import jakarta.validation.constraints.NotNull;
import med.dan.api.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
