package br.edu.ifpb.ifpbcursos.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifpb.ifpbcursos.domain.Curso;
import br.edu.ifpb.ifpbcursos.service.CursoService;
import br.edu.ifpb.ifpbcursos.web.rest.errors.BadRequestAlertException;
import br.edu.ifpb.ifpbcursos.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Curso.
 */
@RestController
@RequestMapping("/api")
public class CursoResource {

    private final Logger log = LoggerFactory.getLogger(CursoResource.class);

    private static final String ENTITY_NAME = "ifpbcursosCurso";

    private final CursoService cursoService;

    public CursoResource(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    /**
     * POST  /cursos : Create a new curso.
     *
     * @param curso the curso to create
     * @return the ResponseEntity with status 201 (Created) and with body the new curso, or with status 400 (Bad Request) if the curso has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/cursos")
    @Timed
    public ResponseEntity<Curso> createCurso(@Valid @RequestBody Curso curso) throws URISyntaxException {
        log.debug("REST request to save Curso : {}", curso);
        if (curso.getId() != null) {
            throw new BadRequestAlertException("A new curso cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Curso result = cursoService.save(curso);
        return ResponseEntity.created(new URI("/api/cursos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /cursos : Updates an existing curso.
     *
     * @param curso the curso to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated curso,
     * or with status 400 (Bad Request) if the curso is not valid,
     * or with status 500 (Internal Server Error) if the curso couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/cursos")
    @Timed
    public ResponseEntity<Curso> updateCurso(@Valid @RequestBody Curso curso) throws URISyntaxException {
        log.debug("REST request to update Curso : {}", curso);
        if (curso.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Curso result = cursoService.save(curso);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, curso.getId().toString()))
            .body(result);
    }

    /**
     * GET  /cursos : get all the cursos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of cursos in body
     */
    @GetMapping("/cursos")
    @Timed
    public List<Curso> getAllCursos() {
        log.debug("REST request to get all Cursos");
        return cursoService.findAll();
    }

    /**
     * GET  /cursos/:id : get the "id" curso.
     *
     * @param id the id of the curso to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the curso, or with status 404 (Not Found)
     */
    @GetMapping("/cursos/{id}")
    @Timed
    public ResponseEntity<Curso> getCurso(@PathVariable Long id) {
        log.debug("REST request to get Curso : {}", id);
        Optional<Curso> curso = cursoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(curso);
    }

    /**
     * DELETE  /cursos/:id : delete the "id" curso.
     *
     * @param id the id of the curso to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/cursos/{id}")
    @Timed
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        log.debug("REST request to delete Curso : {}", id);
        cursoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
