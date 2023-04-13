package med.dan.api.controller;

import jakarta.validation.Valid;
import med.dan.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 3, page = 0, sort = {"nome"}) Pageable pagination) {

        return ResponseEntity.ok(repository.findAllByAtivoTrue(pagination).map(DadosListagemMedico::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        return  ResponseEntity.ok(repository.save(new Medico(dados)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedico dados) {

        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok("atualizado");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.ok("medico excluido");
    }

}
