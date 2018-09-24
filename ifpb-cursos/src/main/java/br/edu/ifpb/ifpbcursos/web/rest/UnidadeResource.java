package br.edu.ifpb.ifpbcursos.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifpb.ifpbcursos.domain.Unidade;
import br.edu.ifpb.ifpbcursos.service.UnidadeService;
import br.edu.ifpb.ifpbcursos.web.rest.errors.BadRequestAlertException;
import br.edu.ifpb.ifpbcursos.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Unidade.
 */
@RestController
@RequestMapping("/api")
public class UnidadeResource {

    private final Logger log = LoggerFactory.getLogger(UnidadeResource.class);

    private static final String ENTITY_NAME = "ifpbcursosUnidade";

    private final UnidadeService unidadeService;

    public UnidadeResource(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    /**
     * POST  /unidades : Create a new unidade.
     *
     * @param unidade the unidade to create
     * @return the ResponseEntity with status 201 (Created) and with body the new unidade, or with status 400 (Bad Request) if the unidade has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/unidades")
    @Timed
    public ResponseEntity<Unidade> createUnidade(@RequestBody Unidade unidade) throws URISyntaxException {
        log.debug("REST request to save Unidade : {}", unidade);
        if (unidade.getId() != null) {
            throw new BadRequestAlertException("A new unidade cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Unidade result = unidadeService.save(unidade);
        return ResponseEntity.created(new URI("/api/unidades/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /unidades : Updates an existing unidade.
     *
     * @param unidade the unidade to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated unidade,
     * or with status 400 (Bad Request) if the unidade is not valid,
     * or with status 500 (Internal Server Error) if the unidade couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/unidades")
    @Timed
    public ResponseEntity<Unidade> updateUnidade(@RequestBody Unidade unidade) throws URISyntaxException {
        log.debug("REST request to update Unidade : {}", unidade);
        if (unidade.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Unidade result = unidadeService.save(unidade);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, unidade.getId().toString()))
            .body(result);
    }

    /**
     * GET  /unidades : get all the unidades.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of unidades in body
     */
    @GetMapping("/unidades")
    @Timed
    public List<Unidade> getAllUnidades() {
        log.debug("REST request to get all Unidades");
        return unidadeService.findAll();
    }

    /**
     * GET  /unidades/:id : get the "id" unidade.
     *
     * @param id the id of the unidade to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the unidade, or with status 404 (Not Found)
     */
    @GetMapping("/unidades/{id}")
    @Timed
    public ResponseEntity<Unidade> getUnidade(@PathVariable Long id) {
        log.debug("REST request to get Unidade : {}", id);
        Optional<Unidade> unidade = unidadeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(unidade);
    }

    /**
     * DELETE  /unidades/:id : delete the "id" unidade.
     *
     * @param id the id of the unidade to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/unidades/{id}")
    @Timed
    public ResponseEntity<Void> deleteUnidade(@PathVariable Long id) {
        log.debug("REST request to delete Unidade : {}", id);
        unidadeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
