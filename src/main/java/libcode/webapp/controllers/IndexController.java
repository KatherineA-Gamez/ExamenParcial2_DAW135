package libcode.webapp.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;


@Named
@RequestScoped
public class IndexController{

    private List<Alumno> alumnosList = new ArrayList<>();

    private Alumno alumno = new Alumno();
    
   
    @EJB
    DataService servicio;

    @PostConstruct
    public void cargarAlumnos() {
        alumnosList = servicio.buscarAlumnos();
    }

    public void guardarAlumno(){
        if(alumno.getId()!=null){
            servicio.editarAlumno(alumno);
        }else{
            servicio.guardarAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }
    
    public void llenarFormEditar(Alumno alumno){
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }
    
    public void eliminarAlumno (Alumno alumno){
        servicio.eliminarAlumno(alumno);
        cargarAlumnos();
    }
  

    //**Getters and Setters**//
    
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
   
}


