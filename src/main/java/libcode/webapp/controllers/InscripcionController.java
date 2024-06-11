package libcode.webapp.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.time.LocalDate;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataServiceInscripcion;

import java.util.List;
import libcode.webapp.negocio.DataService;
import libcode.webapp.negocio.DataServiceMateria;

@Named
@RequestScoped
public class InscripcionController {

    private int idAlumno;
    private int idMateria;
    private int anio;
    private int ciclo;
    private LocalDate fecha;
    private List<Alumno> listaEstudiantes;
    private List<Materia> listaMaterias;
    private List<Inscripcion> listaInscripciones;

    @EJB
    DataService servicioAlumno;

    @EJB
    DataServiceMateria servicioMateria;

    @EJB
    DataServiceInscripcion servicioInscripcion;

    @PostConstruct
    public void init() {
        listaEstudiantes = servicioAlumno.buscarAlumnos();
        listaMaterias = servicioMateria.buscarMaterias();
        listaInscripciones = servicioInscripcion.buscarInscripciones();
    }

    public void guardarInscripcion() {
        Alumno alumno = new Alumno();
        alumno.setId(idAlumno);

        Materia materia = new Materia();
        materia.setId(idMateria);

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateria(materia);
        inscripcion.setAnio(anio);
        inscripcion.setCiclo(ciclo);
        LocalDate fechaActual = LocalDate.now();
        inscripcion.setFecha(fechaActual);

        servicioInscripcion.guardarInscripcion(inscripcion);
        listaInscripciones = servicioInscripcion.buscarInscripciones(); 
    }

    // Getters and Setters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
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

    public List<Alumno> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Alumno> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<Inscripcion> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }
}
