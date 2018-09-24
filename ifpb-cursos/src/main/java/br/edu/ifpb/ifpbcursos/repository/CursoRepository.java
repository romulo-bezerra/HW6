package br.edu.ifpb.ifpbcursos.repository;

import br.edu.ifpb.ifpbcursos.domain.Curso;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Curso entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
