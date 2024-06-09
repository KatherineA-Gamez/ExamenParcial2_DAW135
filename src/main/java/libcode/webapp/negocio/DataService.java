/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Alumno;

@Stateless
public class DataService {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Alumno> buscarAlumnos()
    {
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }  
    
    @Transactional
    public  void guardarAlumno(Alumno alumno)
    {
    entityManager.persist(alumno);
    }
    
    @Transactional
    public void editarAlumno(Alumno alumno)
    {
        entityManager.merge(alumno);
    }
    
    @Transactional
    public void eliminarAlumno(Alumno alumno)
    {
      Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
      entityManager.remove(alumnoEliminar);
    }
}
