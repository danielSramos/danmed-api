package med.dan.api.controller;

import jakarta.validation.Valid;
import med.dan.api.medico.DadosCadastroMedico;
import med.dan.api.medico.DadosListagemMedico;
import med.dan.api.medico.Medico;
import med.dan.api.medico.MedicoRepository;
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
    public ResponseEntity listar(@PageableDefault(size = 5, page = 0, sort = {"nome"}) Pageable pagination) {
        return ResponseEntity.ok(repository.findAll(pagination).map(DadosListagemMedico::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        return  ResponseEntity.ok(repository.save(new Medico(dados)));
    }

}
