package br.edu.ifpb.ifpbcursos.service;

import br.edu.ifpb.ifpbcursos.domain.Disciplina;
import br.edu.ifpb.ifpbcursos.repository.DisciplinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Disciplina.
 */
@Service
@Transactional
public class DisciplinaService {

    private final Logger log = LoggerFactory.getLogger(DisciplinaService.class);

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    /**
     * Save a disciplina.
     *
     * @param disciplina the entity to save
     * @return the persisted entity
     */
    public Disciplina save(Disciplina disciplina) {
        log.debug("Request to save Disciplina : {}", disciplina);        return disciplinaRepository.save(disciplina);
    }

    /**
     * Get all the disciplinas.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Disciplina> findAll() {
        log.debug("Request to get all Disciplinas");
        return disciplinaRepository.findAll();
    }


    /**
     * Get one disciplina by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Disciplina> findOne(Long id) {
        log.debug("Request to get Disciplina : {}", id);
        return disciplinaRepository.findById(id);
    }

    /**
     * Delete the disciplina by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Disciplina : {}", id);
        disciplinaRepository.deleteById(id);
    }
}
