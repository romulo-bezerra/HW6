package br.edu.ifpb.ifpbcursos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import br.edu.ifpb.ifpbcursos.domain.enumeration.TipoDisciplina;

/**
 * A Disciplina.
 */
@Entity
@Table(name = "disciplina")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "abreviacao")
    private String abreviacao;

    @Column(name = "periodo")
    private Integer periodo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoDisciplina tipo;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "aulas_semana")
    private Integer aulasSemana;

    @ManyToOne
    @JsonIgnoreProperties("disciplinas")
    private Curso curso;

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

    public Disciplina nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Disciplina abreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
        return this;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public Disciplina periodo(Integer periodo) {
        this.periodo = periodo;
        return this;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public Disciplina tipo(TipoDisciplina tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(TipoDisciplina tipo) {
        this.tipo = tipo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Disciplina cargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        return this;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getAulasSemana() {
        return aulasSemana;
    }

    public Disciplina aulasSemana(Integer aulasSemana) {
        this.aulasSemana = aulasSemana;
        return this;
    }

    public void setAulasSemana(Integer aulasSemana) {
        this.aulasSemana = aulasSemana;
    }

    public Curso getCurso() {
        return curso;
    }

    public Disciplina curso(Curso curso) {
        this.curso = curso;
        return this;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        Disciplina disciplina = (Disciplina) o;
        if (disciplina.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), disciplina.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Disciplina{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", abreviacao='" + getAbreviacao() + "'" +
            ", periodo=" + getPeriodo() +
            ", tipo='" + getTipo() + "'" +
            ", cargaHoraria=" + getCargaHoraria() +
            ", aulasSemana=" + getAulasSemana() +
            "}";
    }
}
