package br.com.brunnadornelles.Agenda.controller;

import br.com.brunnadornelles.Agenda.entities.Contato;
import br.com.brunnadornelles.Agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
        return ResponseEntity.ok(agendaService.listarContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> obterContatoPorId(@PathVariable Long id) {
        Optional<Contato> contato = agendaService.obterContatoPorId(id);
        return contato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contato> adicionarContato(@RequestBody Contato contato) {
        Contato novoContato = agendaService.adicionarContato(contato);
        return ResponseEntity.ok(novoContato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Contato> contatoExistente = agendaService.obterContatoPorId(id);
        if (contatoExistente.isPresent()) {
            Contato contatoAtualizado = agendaService.atualizarContato(id, contato);
            return ResponseEntity.ok(contatoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerContato(@PathVariable Long id) {
        agendaService.removerContato(id);
        return ResponseEntity.noContent().build();
    }
}
