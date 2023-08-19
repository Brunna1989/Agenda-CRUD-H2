package br.com.brunnadornelles.Agenda.repositories;

import br.com.brunnadornelles.Agenda.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Contato, Long> {
}
