package br.edu.ifpb.ifpbcursos.service;

import br.edu.ifpb.ifpbcursos.domain.Unidade;
import br.edu.ifpb.ifpbcursos.repository.UnidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Unidade.
 */
@Service
@Transactional
public class UnidadeService {

    private final Logger log = LoggerFactory.getLogger(UnidadeService.class);

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    /**
     * Save a unidade.
     *
     * @param unidade the entity to save
     * @return the persisted entity
     */
    public Unidade save(Unidade unidade) {
        log.debug("Request to save Unidade : {}", unidade);        return unidadeRepository.save(unidade);
    }

    /**
     * Get all the unidades.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Unidade> findAll() {
        log.debug("Request to get all Unidades");
        return unidadeRepository.findAll();
    }


    /**
     * Get one unidade by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Unidade> findOne(Long id) {
        log.debug("Request to get Unidade : {}", id);
        return unidadeRepository.findById(id);
    }

    /**
     * Delete the unidade by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Unidade : {}", id);
        unidadeRepository.deleteById(id);
    }
}
