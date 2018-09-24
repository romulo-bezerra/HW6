package br.edu.ifpb.ifpbcursos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Curso.
 */
@Entity
@Table(name = "curso")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "abreviacao")
    private String abreviacao;

    @Column(name = "periodos")
    private Integer periodos;

    @Column(name = "pagina")
    private String pagina;

    @NotNull
    @Column(name = "grande_area_id", nullable = false)
    private String grandeAreaId;

    @OneToMany(mappedBy = "curso")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Disciplina> disciplinas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("")
    private Unidade unidade;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Curso nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Curso abreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
        return this;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Integer getPeriodos() {
        return periodos;
    }

    public Curso periodos(Integer periodos) {
        this.periodos = periodos;
        return this;
    }

    public void setPeriodos(Integer periodos) {
        this.periodos = periodos;
    }

    public String getPagina() {
        return pagina;
    }

    public Curso pagina(String pagina) {
        this.pagina = pagina;
        return this;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getGrandeAreaId() {
        return grandeAreaId;
    }

    public Curso grandeAreaId(String grandeAreaId) {
        this.grandeAreaId = grandeAreaId;
        return this;
    }

    public void setGrandeAreaId(String grandeAreaId) {
        this.grandeAreaId = grandeAreaId;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Curso disciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
        return this;
    }

    public Curso addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        disciplina.setCurso(this);
        return this;
    }

    public Curso removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
        disciplina.setCurso(null);
        return this;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public Curso unidade(Unidade unidade) {
        this.unidade = unidade;
        return this;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Curso curso = (Curso) o;
        if (curso.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), curso.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Curso{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", abreviacao='" + getAbreviacao() + "'" +
            ", periodos=" + getPeriodos() +
            ", pagina='" + getPagina() + "'" +
            ", grandeAreaId='" + getGrandeAreaId() + "'" +
            "}";
    }
}
