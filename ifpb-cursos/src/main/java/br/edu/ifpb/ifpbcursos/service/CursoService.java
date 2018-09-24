package br.edu.ifpb.ifpbcursos.service;

import br.edu.ifpb.ifpbcursos.domain.Curso;
import br.edu.ifpb.ifpbcursos.repository.CursoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Curso.
 */
@Service
@Transactional
public class CursoService {

    private final Logger log = LoggerFactory.getLogger(CursoService.class);

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    /**
     * Save a curso.
     *
     * @param curso the entity to save
     * @return the persisted entity
     */
    public Curso save(Curso curso) {
        log.debug("Request to save Curso : {}", curso);        return cursoRepository.save(curso);
    }

    /**
     * Get all the cursos.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        log.debug("Request to get all Cursos");
        return cursoRepository.findAll();
    }


    /**
     * Get one curso by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Curso> findOne(Long id) {
        log.debug("Request to get Curso : {}", id);
        return cursoRepository.findById(id);
    }

    /**
     * Delete the curso by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Curso : {}", id);
        cursoRepository.deleteById(id);
    }
}
