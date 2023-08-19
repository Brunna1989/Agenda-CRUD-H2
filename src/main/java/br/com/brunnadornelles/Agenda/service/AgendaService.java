package br.com.brunnadornelles.Agenda.service;

import br.com.brunnadornelles.Agenda.entities.Contato;
import br.com.brunnadornelles.Agenda.repositories.AgendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Contato> listarContatos() {
        return agendaRepository.findAll();
    }

    public Optional<Contato> obterContatoPorId(Long id) {
        return agendaRepository.findById(id);
    }

    public Contato adicionarContato(Contato contato) {
        return agendaRepository.save(contato);
    }

    public Contato atualizarContato(Long id, Contato novoContato) {
        novoContato.setId(id);
        return agendaRepository.save(novoContato);
    }

    public void removerContato(Long id) {
        agendaRepository.deleteById(id);
    }
}
