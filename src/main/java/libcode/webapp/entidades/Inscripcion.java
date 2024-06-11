package libcode.webapp.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

import java.util.Objects;

@Entity
@Table(name = "Inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IDALUMNO", referencedColumnName = "ID")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "IDMATERIA", referencedColumnName = "ID")
    private Materia materia;

    @Column(name = "ANIO")
    private Integer anio;

    @Column(name = "CICLO")
    private Integer ciclo;

    @Column(name = "FECHA")
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", anio=" + anio + ", ciclo=" + ciclo + ", fecha=" + fecha + '}';
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, Integer anio, Integer ciclo, LocalDate fecha) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.anio = anio;
        this.ciclo = ciclo;
        this.fecha = fecha;
    }

     public Inscripcion() {

    }
}
