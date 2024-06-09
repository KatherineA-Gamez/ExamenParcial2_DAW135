/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "alumno")
public class Alumno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_id_seq")
    @SequenceGenerator(name = "alumno_id_seq", sequenceName = "alumno_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id; 
    
    @Column(name = "nombre")
    private String name;
    
     @Column(name = "carnet")
    private String carnet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", name=" + name + ", carnet=" + carnet + '}';
    }

    public Alumno(Integer id) {
        this.id = id;
    }

    public Alumno(Integer id, String name, String carnet) {
        this.id = id;
        this.name = name;
        this.carnet = carnet;
    }
    
    public Alumno() {
       
    }

    public Alumno(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
