package med.dan.api.controller;

import jakarta.validation.Valid;
import med.dan.api.medico.DadosCadastroMedico;
import med.dan.api.medico.Medico;
import med.dan.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    ResponseEntity getAll() {
        return null;
    }

    @PostMapping
    @Transactional
    ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
        return  null;
    }
}
