/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;

/**
 *
 * @author Alex
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alumno")
public class Recurso {
    @EJB DataService servicio;
    
    @GET
    public Response buscarAlumnos()
    {
       List<Alumno> alumnos = servicio.buscarAlumnos();
       
       return Response.ok(alumnos).build();
    }
    
    @POST
    public Response guardarAlumno(Alumno alumno)
    {
      servicio.guardarAlumno(alumno);
      return Response.ok("Alumno creado con exito.").build();
    }
    
    @PUT
    public Response editarAlumno(Alumno alumno)
    {
       servicio.editarAlumno(alumno);
       return Response.ok("Alumno editado con exito.").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response guardarAlumno(@PathParam("id") Integer id)
    {
       servicio.eliminarAlumno(new Alumno(id));
         return Response.ok("Alumno eliminado con exito.").build();
    }
    
}
